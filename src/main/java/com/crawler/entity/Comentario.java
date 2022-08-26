package com.crawler.entity;

public class Comentario {
    private String tituloComentario;
    private String autorComentario;
    private String comentario;
    private Double notaComentario;

    public String getTituloComentario() {
        return tituloComentario;
    }

    public void setTituloComentario(String tituloComentario) {
        this.tituloComentario = tituloComentario;
    }

    public String getAutorComentario() {
        return autorComentario;
    }

    public void setAutorComentario(String autorComentario) {
        this.autorComentario = autorComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getNotaComentario() {
        return notaComentario;
    }

    public void setNota(Double notaComentario) {
        this.notaComentario = notaComentario;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "tituloComentario='" + tituloComentario + '\'' +
                ", autorComentario='" + autorComentario + '\'' +
                ", comentario='" + comentario + '\'' +
                ", notaComentario=" + notaComentario +
                '}';
    }
}
