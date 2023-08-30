package com.anthonyo.examen_prog2.service;

import com.anthonyo.examen_prog2.model.Etudiant;
import com.anthonyo.examen_prog2.model.FraisDeScolarite;
import com.anthonyo.examen_prog2.repository.EtudiantRepository;
import com.anthonyo.examen_prog2.repository.FraisDeScolariteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@AllArgsConstructor
@Service
public class FraisDeScolariteService {
    private FraisDeScolariteRepository fraisDeScolariteRepository;

    public List<FraisDeScolarite> getAllFrais() {
        try {
            return this.fraisDeScolariteRepository.getAllFrais();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public FraisDeScolarite getFraisById(int id_FS) {
        try {
            return this.fraisDeScolariteRepository.getFraisById(id_FS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public FraisDeScolarite createFrais(FraisDeScolarite fraisDeScolarite) {
        try {
            fraisDeScolariteRepository.createFrais(fraisDeScolarite);
            return fraisDeScolarite;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public FraisDeScolarite updateFrais(int id_FS, FraisDeScolarite fraisDeScolarite) {
        try {
            fraisDeScolarite.setId_FS(id_FS);
            fraisDeScolariteRepository.updateFrais(id_FS, fraisDeScolarite);
            return fraisDeScolarite;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteFrais(int id_FS) {
        try {
            fraisDeScolariteRepository.deleteFrais(id_FS);
            return "Frais effacé avec succes";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
