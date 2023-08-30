package com.anthonyo.examen_prog2.service;

import com.anthonyo.examen_prog2.model.Etudiant;
import com.anthonyo.examen_prog2.model.Mensualites;
import com.anthonyo.examen_prog2.repository.EtudiantRepository;
import com.anthonyo.examen_prog2.repository.MensualitesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@AllArgsConstructor
@Service
public class MensualitesService {
    private MensualitesRepository mensualitesRepository;

    public List<Mensualites> getAllmensualites(){
        try {
            return this.mensualitesRepository.getAllmensualites();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Mensualites getMoisById(int id_mois){
        try {
            return this.mensualitesRepository.getMoisById(id_mois);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Mensualites createMois(Mensualites mensualites){
        try {
            mensualitesRepository.createMois(mensualites);
            return mensualites;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Mensualites updateMois(int id_mois,Mensualites mensualites){
        try {
            mensualites.setId_mois(id_mois);
            mensualitesRepository.updateMois(id_mois ,mensualites);
            return mensualites;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteMois(int id_mois){
        try {
            mensualitesRepository.deleteMois(id_mois);
            return "Mois "+ id_mois +" effacé avec succes" ;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
