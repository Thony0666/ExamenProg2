package com.anthonyo.examen_prog2.repository;

import com.anthonyo.examen_prog2.model.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class EtudiantRepository {
    private Connection connection;
    public Etudiant createNewInstance(ResultSet resultSet) throws  SQLException{
        return new Etudiant(
            resultSet.getString("std"),
            resultSet.getString("nom"),
            resultSet.getString("prenom"),
            resultSet.getString("adress"),
            resultSet.getString("email"),
            resultSet.getString("numero"));
    }

    public void createEtudiant(Etudiant etudiant) throws SQLException {
        String sql = "INSERT INTO etudiants (std, nom, prenom,adress, email, numero) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, etudiant.getStd());
            statement.setString(2, etudiant.getNom());
            statement.setString(3, etudiant.getPrenom());
            statement.setString(4, etudiant.getAdress());
            statement.setString(5, etudiant.getEmail());
            statement.setString(6, etudiant.getNumero());
            statement.executeUpdate();
        }
    }
    public List<Etudiant> getAllEdutiants() throws SQLException {
        String sql = "SELECT * FROM etudiants";
        List<Etudiant> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }


    public Etudiant getEtudiantById(String id) throws SQLException {
        String sql = "SELECT * FROM etudiants where std = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;    }

    public void updateEtudiant(String std,Etudiant etudiant) throws SQLException {
        String sql = "UPDATE etudiants SET nom = ?, prenom = ?, " +
                "adress = ?, email = ?, numero = ? WHERE std = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getAdress());
            statement.setString(4, etudiant.getEmail());
            statement.setString(5, etudiant.getNumero());
            statement.setString(6, std);

            statement.executeUpdate();
        }
    }

    public void deleteEtudiant(String std) throws SQLException {
        String sql = "DELETE FROM etudiants WHERE std = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, std);
            statement.executeUpdate();
        }
    }

}