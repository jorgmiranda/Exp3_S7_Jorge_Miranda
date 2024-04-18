package com.formativa.peliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formativa.peliculas.model.Pelicula;

public interface PeliculaRepository  extends JpaRepository<Pelicula, Long>{
    
}
