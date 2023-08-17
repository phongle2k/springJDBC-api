package com.sakila_ex5.sakila_ex5.controller;

import com.sakila_ex5.sakila_ex5.dto.FilmDTO;
import com.sakila_ex5.sakila_ex5.service.FilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {
    private final FilmService filmService;
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }
    @GetMapping("/top-rented")
    public List<FilmDTO> getTopRentalFilms(){
        return filmService.getTopRentedFilms();
    }
}
