package com.formativa.peliculas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "year_pelicula")
    private int year;
    @Column(name = "director")
    private String director;
    @Column(name = "genero")
    private String genero;
    @Column(name = "sinopsis")
    private String sinopsis;


    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getYear() {
        return year;
    }
    public String getDirector() {
        return director;
    }
    public String getGenero() {
        return genero;
    }
    public String getSinopsis() {
        return sinopsis;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    
}
