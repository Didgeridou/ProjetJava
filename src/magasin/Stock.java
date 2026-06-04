package magasin;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private int idStock;
    private List<Produit> produits = new ArrayList<>();

    /**
     * Constructeur de la classe Stock
     * @param idStock
     */
    public Stock(int idStock) {
        this.idStock = idStock;
    }

    /**
     * Ajouter un produit au stock
     * @param p
     */
    public void ajouterProduit(Produit p) {
        produits.add(p);
    }

    /**
     * Enlever un produit du stock
     * @param p
     */
    public void supprimerProduit(Produit p) {
        produits.remove(p);
    }

    /**
     * Affiche le contenu du stock
     * @return produits
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * Affiche les produits dont la quantité est inférieur au seuil
     * @param seuil
     * @return produits dont la quantité est inférieur au seuil
     */
    public List<Produit> getProduitsFaibleStock(int seuil) {
        List<Produit> res = new ArrayList<>();
        for (Produit p : produits) {
            if (p.getQuantite() <= seuil) {
                res.add(p);
            }
        }
        return res;
    }
}
