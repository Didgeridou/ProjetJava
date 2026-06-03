package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import magasin.Categorie;
import magasin.Produit;
import magasin.TypeCategorie;

public class ProduitDAO {

    public void ajouterProduit(Produit p) throws SQLException {
        String sql = "INSERT INTO produit(nom, prix, quantite, code_produit, id_categorie) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getQuantite());
            ps.setString(4, p.getCodeProduit());
            ps.setInt(5, p.getCategorie().getIdCategorie());
            ps.executeUpdate();
        }
    }

    public void modifierProduit(Produit p) throws SQLException {
        String sql = "UPDATE produit SET nom=?, prix=?, quantite=?, code_produit=?, id_categorie=? WHERE id_produit=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getQuantite());
            ps.setString(4, p.getCodeProduit());
            ps.setInt(5, p.getCategorie().getIdCategorie());
            ps.setInt(6, p.getIdProduit());
            ps.executeUpdate();
        }
    }

    public void supprimerProduit(int idProduit) throws SQLException {
        String sql = "DELETE FROM produit WHERE id_produit=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProduit);
            ps.executeUpdate();
        }
    }

    public List<Produit> listerTous() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT p.*, c.id_categorie, c.nom AS nom_cat, c.type FROM produit p " +
                     "JOIN categorie c ON p.id_categorie = c.id_categorie";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categorie cat = new Categorie(
                        rs.getInt("id_categorie"),
                        rs.getString("nom_cat"),
                        TypeCategorie.valueOf(rs.getString("type"))
                );
                Produit p = new Produit(
                        rs.getInt("id_produit"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getInt("quantite"),
                        rs.getString("code_produit"),
                        cat
                );
                produits.add(p);
            }
        }
        return produits;
    }

    public List<Produit> rechercher(String motCle) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT p.*, c.id_categorie, c.nom AS nom_cat, c.type " +
                     "FROM produit p JOIN categorie c ON p.id_categorie = c.id_categorie " +
                     "WHERE p.nom LIKE ? OR p.code_produit LIKE ? OR c.nom LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String pattern = "%" + motCle + "%";
            ps.setString(1, pattern);
            ps.setString(2, pattern);
            ps.setString(3, pattern);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Categorie cat = new Categorie(
                            rs.getInt("id_categorie"),
                            rs.getString("nom_cat"),
                            TypeCategorie.valueOf(rs.getString("type"))
                    );
                    Produit p = new Produit(
                            rs.getInt("id_produit"),
                            rs.getString("nom"),
                            rs.getDouble("prix"),
                            rs.getInt("quantite"),
                            rs.getString("code_produit"),
                            cat
                    );
                    produits.add(p);
                }
            }
        }
        return produits;
    }

    public List<Produit> produitsFaibleStock(int seuil) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT p.*, c.id_categorie, c.nom AS nom_cat, c.type " +
                     "FROM produit p JOIN categorie c ON p.id_categorie = c.id_categorie " +
                     "WHERE p.quantite <= ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, seuil);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Categorie cat = new Categorie(
                            rs.getInt("id_categorie"),
                            rs.getString("nom_cat"),
                            TypeCategorie.valueOf(rs.getString("type"))
                    );
                    Produit p = new Produit(
                            rs.getInt("id_produit"),
                            rs.getString("nom"),
                            rs.getDouble("prix"),
                            rs.getInt("quantite"),
                            rs.getString("code_produit"),
                            cat
                    );
                    produits.add(p);
                }
            }
        }
        return produits;
    }
}
