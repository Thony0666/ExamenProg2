package com.anthonyo.examen_prog2.service;

import com.anthonyo.examen_prog2.model.Etudiant;
import com.anthonyo.examen_prog2.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantService {
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> getAllEtudiants(){
        try {
            return this.etudiantRepository.getAllEdutiants();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Etudiant getStudiantById(String id){
        try {
            return this.etudiantRepository.getEtudiantById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Etudiant createEtudiant(Etudiant etudiant){
        try {
            etudiantRepository.createEtudiant(etudiant);
            return etudiant;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Etudiant updateEtudiant(String std,Etudiant etudiant){
        try {
            etudiant.setStd(std);
            etudiantRepository.updateEtudiant(std ,etudiant);
            return etudiant;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteEtudiant(String std){
        try {
            etudiantRepository.deleteEtudiant(std);
            return "Etudiant effacé avec succes";
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
