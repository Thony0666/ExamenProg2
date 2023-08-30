package com.anthonyo.examen_prog2.repository;

import com.anthonyo.examen_prog2.model.Etudiant;
import com.anthonyo.examen_prog2.model.FraisDeScolarite;
import com.anthonyo.examen_prog2.model.Mensualites;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class MensualitesRepository {
    private Connection connection;
    public Mensualites createNewInstance (ResultSet resultSet) throws SQLException {
        return new Mensualites(
        resultSet.getInt("id_mois"),
        resultSet.getString("mensualites"),
        resultSet.getDate("date_expiration").toLocalDate()
        );
    }

    public List<Mensualites> getAllmensualites() throws SQLException {
        String sql = "SELECT * FROM mensualites";
        List<Mensualites> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while(resultSet.next()){
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }

    public Mensualites getMoisById(int id_mois) throws SQLException {
        String sql = "SELECT * FROM mensualites where id_mois = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id_mois);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;    }


    public void createMois(Mensualites mensualites) throws SQLException {
        String sql = "INSERT INTO mensualites " +"VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, mensualites.getId_mois());
            statement.setString(2, mensualites.getMensualites());
            statement.setDate(3,Date.valueOf(mensualites.getDate_expiration()));
            statement.executeUpdate();
        }
    }

    public void updateMois(int id_mois,Mensualites mensualites) throws SQLException {
        String sql = "UPDATE mensualites SET mensualites = ?, date_expiration = ? WHERE id_mois = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mensualites.getMensualites());
            statement.setDate(2, Date.valueOf(mensualites.getDate_expiration()));
            statement.setInt(3, id_mois);
            statement.executeUpdate();
        }
    }

    public void deleteMois(int id_mois) throws SQLException {
        String sql = "DELETE FROM mensualites WHERE  id_mois = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_mois);
            statement.executeUpdate();
        }
    }
}
