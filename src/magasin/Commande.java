package magasin;

import java.util.List;

import java.util.ArrayList;
import java.util.List;


public class Commande {
    private int idCommande;
    private List<Produit> produits = new ArrayList<>();
    private double prixTotal;

    /***
     * Constructeur de la classe Commande
     * @param idCommande
     */
    public Commande(int idCommande) {
        this.idCommande = idCommande;
    }

    /**
     * Ajouter un produit dans la commande
     * @param p
     */
    public void ajouterProduit(Produit p) {
        produits.add(p);
        prixTotal += p.getPrix();
    }

    /**
     * Avoir le prix total de la commande
     * @return prix total de la commande
     */
    public double getPrixTotal() {
        return prixTotal;
    }

    /**
     * Obtenir les produits de la commande
     * @return produits de la commande
     */
    public List<Produit> getProduits() {
        return produits;
    }
}
