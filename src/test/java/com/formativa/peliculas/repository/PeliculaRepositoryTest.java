package com.formativa.peliculas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.formativa.peliculas.model.Pelicula;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaRepositoryTest {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Test
    public void crearPeliculaTest(){
        //Arrange
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Testing");
        pelicula.setYear(1997);
        pelicula.setGenero("test");
        pelicula.setSinopsis("Es una prueba");
        pelicula.setDirector("Prueba");

        //Act
        Pelicula resultado = peliculaRepository.save(pelicula);

        //Assert
        assertNotNull(resultado.getId());
        assertEquals("Testing", resultado.getTitulo());
        assertEquals(1997, resultado.getYear());
        assertEquals("test", resultado.getGenero());
        assertEquals("Es una prueba", resultado.getSinopsis());
        assertEquals("Prueba", resultado.getDirector());
    }
    
}
