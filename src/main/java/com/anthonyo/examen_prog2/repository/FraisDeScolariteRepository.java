package com.anthonyo.examen_prog2.repository;

import com.anthonyo.examen_prog2.model.Etudiant;
import com.anthonyo.examen_prog2.model.FraisDeScolarite;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Repository
public class FraisDeScolariteRepository {
    private Connection connection;
    public FraisDeScolarite createNewInstance(ResultSet resultSet) throws SQLException {
        return new FraisDeScolarite(
                resultSet.getInt("id_FS"),
                resultSet.getString("annee_scolaoire"),
                resultSet.getInt("id_paiements"));
    }

    public List<FraisDeScolarite> getAllFrais() throws SQLException {
        String sql = "SELECT * FROM frais_de_scolarite";
        List<FraisDeScolarite> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }

    public FraisDeScolarite getFraisById(int id_FS) throws SQLException {
        String sql = "SELECT * FROM frais_de_scolarite where id_FS = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id_FS);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;    }


    public void createFrais(FraisDeScolarite fraisDeScolarite) throws SQLException {
        String sql = "INSERT INTO frais_de_scolarite " +"VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, fraisDeScolarite.getId_FS());
            statement.setString(2, fraisDeScolarite.getAnnee_scolaoire());
            statement.setInt(3, fraisDeScolarite.getId_paiements());
            statement.executeUpdate();
        }
    }

    public void updateFrais(int id_FS,FraisDeScolarite fraisDeScolarite) throws SQLException {
        String sql = "UPDATE frais_de_scolarite SET annee_scolaoire = ?, id_paiements = ? WHERE id_FS = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fraisDeScolarite.getAnnee_scolaoire());
            statement.setInt(2, fraisDeScolarite.getId_paiements());
            statement.setInt(3, id_FS);
            statement.executeUpdate();
        }
    }

    public void deleteFrais(int id_FS) throws SQLException {
        String sql = "DELETE FROM frais_de_scolarite WHERE  id_FS = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_FS);
            statement.executeUpdate();
        }
    }
}
