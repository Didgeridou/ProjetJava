package magasin;

import java.util.List;

public class Commande {

    private int idCommande;
    private List<Produit> produits;
    private double prix;

    public Commande(int idCommande, List<Produit> produits, double prix){
        this.idCommande = idCommande;
        this.produits = produits;
        this.prix = prix;
    }
    

}
