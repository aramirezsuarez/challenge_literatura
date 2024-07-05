package com.biblioteca.Desafio.model;

public class Libro {
    private Integer numeroDescargas;
    private String titulo;
    private String autores;

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "titulo=" + titulo +
                ", Autores='" + autores + '\'' +
                ", numero de descargas=" + numeroDescargas;
    }
}
