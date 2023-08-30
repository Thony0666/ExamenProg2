package com.anthonyo.examen_prog2.repository;

import com.anthonyo.examen_prog2.model.Etudiant;
import com.anthonyo.examen_prog2.model.FraisDeScolarite;
import com.anthonyo.examen_prog2.model.Paiements;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Repository
public class PaiementRepository {
        private Connection connection;

        public Paiements createNewInstance(ResultSet resultSet) throws SQLException {
            return new Paiements(
                    resultSet.getInt("id_paiements"),
                    resultSet.getString("mode_de_paiements"),
                    resultSet.getDate("date_de_paiements").toLocalDate(),
                    resultSet.getFloat("sommes"),
                    resultSet.getBoolean("payer"),
                    resultSet.getString("std"),
                    resultSet.getInt("id_mois"));

        }


        public List<Paiements> getAllPaiements() throws SQLException {
            String sql = "SELECT * FROM paiements";
            List<Paiements> list = new ArrayList<>();
            ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                list.add(this.createNewInstance(resultSet));
            }
            return list;
        }



    public Paiements getPaiementsById(int id_paiements) throws SQLException {
        String sql = "SELECT * FROM paiements where id_paiements = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, id_paiements);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;
        }


    public void createPaiements(Paiements paiement) throws SQLException {
        String sql = "INSERT INTO paiements " +"VALUES (?, ?, ?, ?, ? ,?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, paiement.getId_paiements());
            statement.setString(2, paiement.getMode_de_paiment());
            statement.setDate(3, Date.valueOf(paiement.getDate_de_paiement()));
            statement.setFloat(4,paiement.getSommes());
            statement.setBoolean(5,paiement.isPayer());
            statement.setString(6, paiement.getStd());
            statement.setInt(7,paiement.getId_mois());

            statement.executeUpdate();
        }
    }

    public void updatePaiements(int id_paiements,Paiements paiement) throws SQLException {
        String sql = "UPDATE paiements SET mode_de_paiements = ?, date_de_paiements = ?, sommes = ?, payer = ?, std = ?, id_mois = ? WHERE id_paiements = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, paiement.getMode_de_paiment());
            statement.setDate(2, Date.valueOf(paiement.getDate_de_paiement()));
            statement.setFloat(3, paiement.getSommes());
            statement.setBoolean(4, paiement.isPayer());
            statement.setString(5, paiement.getStd());
            statement.setInt(6, paiement.getId_mois());
            statement.setInt(7, id_paiements);

            statement.executeUpdate();
        }
    }
    public void deletePaiements(int id_paiements) throws SQLException {
        String sql = "DELETE FROM paiements WHERE  id_paiements = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_paiements);
            statement.executeUpdate();
        }
    }

    public List<Paiements> getPaymentTracker() throws SQLException {
        String sql = "SELECT * FROM etudiants WHERE id_etudiant IN (SELECT id_etudiant FROM paiements WHERE date_paiement < date_echeance AND payer = false)";
        List<Paiements> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            list.add(this.createNewInstance(resultSet));
        }
        return list;
    }
}

