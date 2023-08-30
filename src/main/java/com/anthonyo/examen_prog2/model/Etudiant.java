package com.anthonyo.examen_prog2.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Etudiant {
    private String std;
    private String nom;
    private String prenom;
    private String adress;
    private String email;
    private String numero;
}
