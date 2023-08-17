package com.sakila_ex5.sakila_ex5.dto;

import lombok.Data;

@Data
public class FilmDTO {
    private int id;
    private String title;
    private int rental_count;
}
