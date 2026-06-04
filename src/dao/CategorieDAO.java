package dao;

import db.DBConnection;
import magasin.Categorie;
import magasin.TypeCategorie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO {

    public List<Categorie> listerToutes() {
        List<Categorie> categories = new ArrayList<>();

        String sql = "SELECT id_categorie, nom, type FROM categorie";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categorie c = new Categorie(
                        rs.getInt("id_categorie"),
                        rs.getString("nom"),
                        TypeCategorie.valueOf(rs.getString("type"))
                );
                categories.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
