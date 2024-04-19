package com.formativa.peliculas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.formativa.peliculas.model.Pelicula;
import com.formativa.peliculas.repository.PeliculaRepository;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceTest {
    @InjectMocks
    private PeliculaServiceImpl peliculaServiceImpl;

    @Mock
    private PeliculaRepository peliculaRepositoryMock;

    @Test
    public void crearPeliculaTest(){
         //Arrange
         Pelicula pelicula = new Pelicula();
         pelicula.setTitulo("Testing 2");
         pelicula.setYear(2000);
         pelicula.setGenero("comedia");
         pelicula.setSinopsis("Es una prueba 2");
         pelicula.setDirector("Prueba 2");

         when(peliculaRepositoryMock.save(any())).thenReturn(pelicula);

         //Act
         Pelicula resultado = peliculaServiceImpl.crearPelicula(pelicula);

         //Assert
         assertEquals("Testing 2", resultado.getTitulo());
         assertEquals(2000, resultado.getYear());
         assertEquals("comedia", resultado.getGenero());
         assertEquals("Es una prueba 2", resultado.getSinopsis());
         assertEquals("Prueba 2", resultado.getDirector());
 
    }
}
