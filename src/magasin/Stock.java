package magasin;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private int idStock;
    private List<Produit> produits = new ArrayList<>();

    public Stock(int idStock) {
        this.idStock = idStock;
    }

    public void ajouterProduit(Produit p) {
        produits.add(p);
    }

    public void supprimerProduit(Produit p) {
        produits.remove(p);
    }

    public List<Produit> getProduits() {
        return produits;
    }

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
