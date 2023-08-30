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

public class Paiements {
    private  int id_paiements;
    private  String mode_de_paiment;
    private LocalDate date_de_paiement;
    private float sommes;
    private  boolean payer;
    private String std;
    private int id_mois;

}
