package magasin;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int idCommande;
    private List<Produit> produits = new ArrayList<>();
    private double prixTotal;

    public Commande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void ajouterProduit(Produit p) {
        produits.add(p);
        prixTotal += p.getPrix();
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public List<Produit> getProduits() {
        return produits;
    }
}
