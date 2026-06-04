package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.CategorieDAO;
import dao.ProduitDAO;
import magasin.Categorie;
import magasin.Produit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class GestionProduitsFrame extends JFrame {

    private ProduitDAO produitDAO = new ProduitDAO();
    private CategorieDAO categorieDAO = new CategorieDAO();

    private JTable tableProduits;
    private DefaultTableModel tableModel;

    private JTextField txtNom;
    private JTextField txtPrix;
    private JTextField txtQuantite;
    private JTextField txtCode;
    private JTextField txtRecherche;
    private JComboBox<Categorie> comboCategorie;

    public GestionProduitsFrame() {
        setTitle("Gestion des produits");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        chargerProduits();
        chargerCategories();
    }

    private void chargerCategories() {
    comboCategorie.removeAllItems();
    List<Categorie> categories = categorieDAO.listerToutes();

    for (Categorie c : categories) {
        comboCategorie.addItem(c);
    }
}


    private void initComponents() {
        // Haut : formulaire
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 5, 5));
        txtNom = new JTextField();
        txtPrix = new JTextField();
        txtQuantite = new JTextField();
        txtCode = new JTextField();
        comboCategorie = new JComboBox<>(); // à remplir depuis la BD

        panelForm.add(new JLabel("Nom :"));
        panelForm.add(txtNom);
        panelForm.add(new JLabel("Prix :"));
        panelForm.add(txtPrix);
        panelForm.add(new JLabel("Quantité :"));
        panelForm.add(txtQuantite);
        panelForm.add(new JLabel("Code produit :"));
        panelForm.add(txtCode);
        panelForm.add(new JLabel("Catégorie :"));
        panelForm.add(comboCategorie);

        // Centre : tableau
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nom", "Prix", "Quantité", "Code", "Catégorie"}, 0);
        tableProduits = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableProduits);

        // Bas : boutons + recherche
        JPanel panelBas = new JPanel(new BorderLayout());

        JPanel panelBoutons = new JPanel();
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnModifier = new JButton("Modifier");
        JButton btnSupprimer = new JButton("Supprimer");
        JButton btnFaibleStock = new JButton("Faible stock");

        panelBoutons.add(btnAjouter);
        panelBoutons.add(btnModifier);
        panelBoutons.add(btnSupprimer);
        panelBoutons.add(btnFaibleStock);

        JPanel panelRecherche = new JPanel();
        txtRecherche = new JTextField(20);
        JButton btnRecherche = new JButton("Rechercher");
        panelRecherche.add(new JLabel("Recherche :"));
        panelRecherche.add(txtRecherche);
        panelRecherche.add(btnRecherche);

        panelBas.add(panelBoutons, BorderLayout.WEST);
        panelBas.add(panelRecherche, BorderLayout.EAST);

        // Layout global
        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBas, BorderLayout.SOUTH);

        // Listeners
        btnAjouter.addActionListener(this::onAjouter);
        btnModifier.addActionListener(this::onModifier);
        btnSupprimer.addActionListener(this::onSupprimer);
        btnRecherche.addActionListener(this::onRecherche);
        btnFaibleStock.addActionListener(this::onFaibleStock);
    }

    private void chargerProduits() {
        try {
            List<Produit> produits = produitDAO.listerTous();
            remplirTable(produits);
        } catch (SQLException e) {
            afficherErreur(e.getMessage());
        }
    }

    private void remplirTable(List<Produit> produits) {
        tableModel.setRowCount(0);
        for (Produit p : produits) {
            tableModel.addRow(new Object[]{
                    p.getIdProduit(),
                    p.getNom(),
                    p.getPrix(),
                    p.getQuantite(),
                    p.getCodeProduit(),
                    p.getCategorie().getNom()
            });
        }
    }

    private void onAjouter(ActionEvent e) {
        try {
            String nom = txtNom.getText();
            double prix = Double.parseDouble(txtPrix.getText());
            int quantite = Integer.parseInt(txtQuantite.getText());
            String code = txtCode.getText();
            Categorie cat = (Categorie) comboCategorie.getSelectedItem();

            Produit p = new Produit(0, nom, prix, quantite, code, cat);
            produitDAO.ajouterProduit(p);
            chargerProduits();
            JOptionPane.showMessageDialog(this, "Produit ajouté");
        } catch (Exception ex) {
            afficherErreur(ex.getMessage());
        }
    }

    private void onModifier(ActionEvent e) {
        int row = tableProduits.getSelectedRow();
        if (row == -1) {
            afficherErreur("Sélectionnez un produit");
            return;
        }
        try {
            int id = (int) tableModel.getValueAt(row, 0);
            String nom = txtNom.getText();
            double prix = Double.parseDouble(txtPrix.getText());
            int quantite = Integer.parseInt(txtQuantite.getText());
            String code = txtCode.getText();
            Categorie cat = (Categorie) comboCategorie.getSelectedItem();

            Produit p = new Produit(id, nom, prix, quantite, code, cat);
            produitDAO.modifierProduit(p);
            chargerProduits();
            JOptionPane.showMessageDialog(this, "Produit modifié");
        } catch (Exception ex) {
            afficherErreur(ex.getMessage());
        }
    }

    private void onSupprimer(ActionEvent e) {
        int row = tableProduits.getSelectedRow();
        if (row == -1) {
            afficherErreur("Sélectionnez un produit");
            return;
        }
        int id = (int) tableModel.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Supprimer ce produit ?", "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                produitDAO.supprimerProduit(id);
                chargerProduits();
            } catch (SQLException ex) {
                afficherErreur(ex.getMessage());
            }
        }
    }

    private void onRecherche(ActionEvent e) {
        String motCle = txtRecherche.getText();
        try {
            List<Produit> produits = produitDAO.rechercher(motCle);
            remplirTable(produits);
        } catch (SQLException ex) {
            afficherErreur(ex.getMessage());
        }
    }

    private void onFaibleStock(ActionEvent e) {
        String seuilStr = JOptionPane.showInputDialog(this, "Seuil de stock :");
        if (seuilStr == null) return;
        try {
            int seuil = Integer.parseInt(seuilStr);
            List<Produit> produits = produitDAO.produitsFaibleStock(seuil);
            remplirTable(produits);
        } catch (Exception ex) {
            afficherErreur(ex.getMessage());
        }
    }

    private void afficherErreur(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }
}
