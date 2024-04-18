package com.formativa.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formativa.peliculas.model.Pelicula;
import com.formativa.peliculas.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getAllPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> getPeliculaByID(Long id) {
       return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula actualizarPelicula(Long id, Pelicula pelicula) {
        if(peliculaRepository.existsById(id)){
            pelicula.setId(id);
            return peliculaRepository.save(pelicula);
        }else{
            return null;
        }
    }

    @Override
    public void eliminarPelicula(Long id) {
       peliculaRepository.deleteById(id);
    }

    
    
}
