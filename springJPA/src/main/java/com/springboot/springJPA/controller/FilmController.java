package com.springboot.springJPA.controller;

import com.springboot.springJPA.dto.FilmDTO;
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
    public List<FilmDTO> getTopRentedFilm(){
        return filmService.getTopRentedFilm();
    }

}
