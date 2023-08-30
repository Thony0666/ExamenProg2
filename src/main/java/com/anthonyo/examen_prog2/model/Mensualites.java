package com.anthonyo.examen_prog2.model;


import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Mensualites {
    private int id_mois;
    private String mensualites;
    private LocalDate date_expiration;
};
