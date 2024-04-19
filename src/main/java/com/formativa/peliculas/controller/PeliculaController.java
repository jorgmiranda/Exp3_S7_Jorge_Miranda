package com.formativa.peliculas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.formativa.peliculas.service.PeliculaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.formativa.peliculas.model.Pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public CollectionModel<EntityModel<Pelicula>> getAllPeliculas() {
        List<Pelicula> peliculas = peliculaService.getAllPeliculas();

        List<EntityModel<Pelicula>> peliculaResources = peliculas.stream()
                .map(pelicula -> EntityModel.of(pelicula,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculaByID(pelicula.getId())).withSelfRel()
                    ))
                .collect(Collectors.toList());
        
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas());
        CollectionModel<EntityModel<Pelicula>> resourses = CollectionModel.of(peliculaResources, linkTo.withRel("peliculas"));

        return resourses;

    }
    
    
    @GetMapping("/{id}")
    public EntityModel<Pelicula> getPeliculaByID(@PathVariable Long id){
        Optional<Pelicula> pelicula = peliculaService.getPeliculaByID(id);
        if (pelicula.isPresent()) {
            return EntityModel.of(pelicula.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculaByID(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas()).withRel("all-students"));
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        
    }
    ///Nuevos controladores CRUD

    @PostMapping
    public  EntityModel<Pelicula> crearPelicula(@RequestBody Pelicula pelicula) {
        Pelicula peliculaCreada = peliculaService.crearPelicula(pelicula);
            return EntityModel.of(peliculaCreada,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculaByID(peliculaCreada.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas()).withRel("all-students"));

    }

    @PutMapping("/{id}")
    public EntityModel<Pelicula> actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        Pelicula peliculaActualizada = peliculaService.actualizarPelicula(id, pelicula);
        return EntityModel.of(peliculaActualizada,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPeliculaByID(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPeliculas()).withRel("all-students"));

        
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id){
        peliculaService.eliminarPelicula(id);
    }
    

    
}
