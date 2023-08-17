package com.sakila_ex5.sakila_ex5.service;

import com.sakila_ex5.sakila_ex5.dto.FilmDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    private final JdbcTemplate jdbcTemplate;
    public FilmService (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<FilmDTO> getTopRentedFilms(){
        String sql = "Select film.film_id, film.title, count(payment.rental_id) AS rental_count " +
                "FROM film " +
                "JOIN inventory ON film.film_id = inventory.film_id " +
                "JOIN rental ON inventory.inventory_id = rental.inventory_id " +
                "JOIN payment ON rental.rental_id = payment.rental_id " +
                "GROUP BY film.film_id, film.title " +
                "ORDER BY rental_count DESC " +
                "LIMIT 5 ";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            FilmDTO filmDTO = new FilmDTO();
            filmDTO.setId(rs.getInt("film_id"));
            filmDTO.setTitle(rs.getString("title"));
            filmDTO.setRental_count(rs.getInt("rental_count"));
            return filmDTO;
        });
    }

}
