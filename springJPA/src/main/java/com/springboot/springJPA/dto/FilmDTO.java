package com.springboot.springJPA.dto;

import lombok.Data;

@Data
public class FilmDTO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "film_id") -- nếu dùng JPA thì mới phải select PK và FK
    private int id;

//    @Column(name = "title")
    private String title;

//    @Column(name = "rentalCount")
    private  int rental_count;

}
