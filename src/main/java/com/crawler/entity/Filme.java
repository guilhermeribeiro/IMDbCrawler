package com.crawler.entity;

import java.util.List;

public class Filme {
    private String tituloFilme;
    private Double nota;
    private List<String> elenco;
    private List<String> diretores;
    private Comentario comentario;
    private String linkFilme;

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public List<String> getElenco() {
        return elenco;
    }

    public void setElenco(List<String> elenco) {
        this.elenco = elenco;
    }

    public List<String> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<String> diretores) {
        this.diretores = diretores;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public String getLinkFilme() {
        return linkFilme;
    }

    public void setLinkFilme(String linkFilme) {
        this.linkFilme = linkFilme;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "tituloFilme='" + tituloFilme + '\'' +
                ", nota=" + nota +
                ", elenco=" + elenco +
                ", diretores=" + diretores +
                //", comentario=" + comentario +
                ", linkFilme='" + linkFilme + '\'' +
                '}';
    }
}
