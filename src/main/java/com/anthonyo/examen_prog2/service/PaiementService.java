package com.anthonyo.examen_prog2.service;
import com.anthonyo.examen_prog2.model.Etudiant;
import com.anthonyo.examen_prog2.model.Paiements;
import com.anthonyo.examen_prog2.repository.PaiementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class PaiementService {
    private PaiementRepository paiementRepository;

    public List<Paiements> getAllPaiements(){
        try {
            return this.paiementRepository.getAllPaiements();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Paiements getPaiementsById(int id_paiements){
        try {
            return this.paiementRepository.getPaiementsById(id_paiements);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Paiements createPaiements(Paiements paiements){
        try {
            paiementRepository.createPaiements(paiements);
            return paiements;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Paiements updatePaiements(int id_paiements,Paiements paiements){
        try {
            paiements.setId_paiements(id_paiements);
            paiementRepository.updatePaiements(id_paiements ,paiements);
            return paiements;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deletePaiements(int id_paiements){
        try {
            paiementRepository.deletePaiements(id_paiements);
            return "Paiements numéro : "+id_paiements + " effacé avec succes";
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }



}
