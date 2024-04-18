package com.formativa.peliculas.service;

import java.util.List;
import java.util.Optional;
import com.formativa.peliculas.model.Pelicula;

public interface PeliculaService {
    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculaByID(Long id);
    //Metodos para el insertar, editar y eliminar
    Pelicula crearPelicula(Pelicula pelicula);
    Pelicula actualizarPelicula(Long id, Pelicula pelicula);
    void eliminarPelicula(Long id);
    
}  