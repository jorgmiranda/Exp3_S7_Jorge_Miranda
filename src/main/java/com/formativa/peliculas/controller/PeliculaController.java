package com.formativa.peliculas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.formativa.peliculas.service.PeliculaService;

import java.util.List;
import java.util.Optional;

import com.formativa.peliculas.model.Pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<Pelicula> getPeliculaByID(@PathVariable Long id){
        return peliculaService.getPeliculaByID(id);
    }
    ///Nuevos controladores CRUD

    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.crearPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        return peliculaService.actualizarPelicula(id, pelicula);
        
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id){
        peliculaService.eliminarPelicula(id);
    }
    

    
}
