package com.crawler.service;

import com.crawler.entity.Filme;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class BuscaFilmes {

    private static String RANKING_URL = "https://www.imdb.com/chart/bottom";

    public static void main(String[] args) throws IOException {
        System.out.println("Realizando a captura das informações. Aguarde um momento...");

        BuscaFilmesService buscaFilmesService = new BuscaFilmesService();

        Document document = buscaFilmesService.carregarURL(RANKING_URL);

        List<Filme> filmes = buscaFilmesService.buscarTodosFilmes(document);

        for(Filme filme : filmes){
            filme = buscaFilmesService.buscarDiretoresAtoresFilme(filme);
            filme = buscaFilmesService.buscarComentario(filme);
        }

        filmes.sort(Comparator.comparing(Filme::getNota).reversed());

        System.out.println(" ");

        for (Filme filme: filmes){
            System.out.println("Título: " + filme.getTituloFilme());
            System.out.println("Nota: " + filme.getNota().toString());
            System.out.println("Elenco: " +filme.getElenco().toString());
            System.out.println("Diretor(es): " +filme.getDiretores().toString());
            System.out.println("Título comentário: " +filme.getComentario().getTituloComentario());
            System.out.println("Nota comentário: " +filme.getComentario().getNotaComentario().toString());
            System.out.println("Autor comentário: " +filme.getComentario().getAutorComentario());
            System.out.println("Comentário: " +filme.getComentario().getComentario());
            System.out.println("==============================================================================================================================");
            System.out.println(" ");
        }
    }



}
