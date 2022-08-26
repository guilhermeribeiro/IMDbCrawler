package com.crawler.service;

import com.crawler.entity.Comentario;
import com.crawler.entity.Filme;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuscaFilmesService {

    /*
    *
    *  Centralização das propriedades usadas nos métodos da classe BuscaFilmesService
    *
    * */
    private static String HOME_URL = "https://www.imdb.com";
    private static int QUANTIDADE_FILMES = 10;
    private static String LINK_TITULO_FILME = "td.titleColumn > a";
    private static String FILMES = "tbody.lister-list";
    private static String NOTA_FILME = "td.ratingColumn.imdbRating > strong";
    private static String DIRETORES_FILME = "ul.ipc-inline-list.ipc-inline-list--show-dividers.ipc-inline-list--inline.ipc-metadata-list-item__list-content.baseAlt";
    private static String ATORES_FILME = "div.ipc-shoveler.ipc-shoveler--base.ipc-shoveler--page0.title-cast__grid";
    private static String COMENTARIO_FILME = "div.lister-item.mode-detail.imdb-user-review.collapsable";
    private static String FILTRO_COMENTARIO =  "reviews?sort=userRating&dir=desc&ratingFilter=10";

    /**
     *
     * @param URL
     * @return html
     */
    public Document carregarURL(String URL){
        try {
            return Jsoup.connect(URL).get();

        } catch (IOException e) {
            System.err.println("Erro: " +  e.getMessage());
        }

        return null;
    }

    /**
     *
     * Busca os 10 filmes com a pior avaliação no IMDb
     * @param document
     * @return filmes
     *
     */
    public List<Filme> buscarTodosFilmes(Document document){

        List<Filme> filmes = new ArrayList<>();

        Elements elements = document.select(FILMES).select("tr");

        for(int i = 0; i < QUANTIDADE_FILMES; i++){
            Filme filme = new Filme();
            filme.setLinkFilme(elements.eq(i).select(LINK_TITULO_FILME).attr("href")); // link dos filmes
            filme.setTituloFilme(elements.eq(i).select(LINK_TITULO_FILME).first().text()); // titulo dos filmes
            filme.setNota(Double.parseDouble(elements.eq(i).select(NOTA_FILME).first().text())); // nota dos filmes

            filmes.add(filme);
        }

        return filmes;
    }

    /**
     *
     * Busca diretores e elenco de um filme na página de um filme
     * @param filme
     * @return filme
     *
     */
    public Filme buscarDiretoresAtoresFilme(Filme filme){
        List<String> diretores = new ArrayList<>();
        List<String> atores = new ArrayList<>();
        Elements elements;
        Document document;

        document = carregarURL(HOME_URL+filme.getLinkFilme());

        elements = document.select(DIRETORES_FILME).first().select("li");

        for(int i =0; i < elements.size(); i++){
            diretores.add(elements.eq(i).select("a").first().text());
        }

        filme.setDiretores(diretores);

        elements = document.select(ATORES_FILME).select("a").attr("data-testid", "title-cast-item__actor");

        for(int i=0; i < elements.size(); i++){
            if (!elements.eq(i).select("a").attr("aria-label").equals("")){
                atores.add(elements.eq(i).select("a").attr("aria-label"));
            }
        }

        filme.setElenco(atores);

        return filme;
    }


    /**
     *
     * Busca um comentário na página de um filme
     * @param filme
     * @return filme
     *
     */
    public Filme buscarComentario(Filme filme){
        Comentario comentario = new Comentario();
        Document document;

        document = carregarURL(HOME_URL+"/title/" + filme.getLinkFilme().split("/")[2] + "/" + FILTRO_COMENTARIO);

        comentario.setAutorComentario(document.select(COMENTARIO_FILME).first().select("span.display-name-link").text());
        comentario.setComentario(document.select(COMENTARIO_FILME).first().select("div.text.show-more__control").text());
        comentario.setTituloComentario(document.select(COMENTARIO_FILME).first().select("a.title").text());
        comentario.setNota(Double.parseDouble(document.select(COMENTARIO_FILME).first().select("span.rating-other-user-rating > span").first().text()));

        filme.setComentario(comentario);

        return filme;
    }
}
