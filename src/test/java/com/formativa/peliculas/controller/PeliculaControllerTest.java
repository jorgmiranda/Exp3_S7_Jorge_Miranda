package com.formativa.peliculas.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.formativa.peliculas.model.Pelicula;
import com.formativa.peliculas.service.PeliculaServiceImpl;

@WebMvcTest(PeliculaController.class)
public class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculaServiceImpl peliculaServiceImpl;

    @Test
    public void obtenerTodoTest() throws Exception{
        //Arrange
        //Creación de peliculas
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("El Viaje Misterioso");
        pelicula1.setYear(2021);
        pelicula1.setGenero("aventura");
        pelicula1.setSinopsis("Una aventura épica llena de misterio y descubrimiento.");
        pelicula1.setDirector("Juan García");

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("El Amor Eterno");
        pelicula2.setYear(2019);
        pelicula2.setGenero("romance");
        pelicula2.setSinopsis("Una historia de amor que trasciende el tiempo y el espacio.");
        pelicula2.setDirector("María Fernández");

        List<Pelicula> peliculas = Arrays.asList(pelicula1, pelicula2);
        when(peliculaServiceImpl.getAllPeliculas()).thenReturn(peliculas);

        // ACT & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/peliculas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.aMapWithSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculaList[0].titulo", Matchers.is("El Viaje Misterioso")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculaList[1].titulo", Matchers.is("El Amor Eterno")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculaList[0].year", Matchers.is(2021)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculaList[1].year", Matchers.is(2019)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculaList[0].director", Matchers.is("Juan García")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculaList[1].director", Matchers.is("María Fernández")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculaList[0].genero", Matchers.is("aventura")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculaList[1].genero", Matchers.is("romance")));
    }
    
}
