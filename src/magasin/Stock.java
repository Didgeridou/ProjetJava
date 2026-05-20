package magasin;

import java.util.List;

public class Stock {

    private int idStock;
    private List<Produit> produits;

    public Stock(int idStock, List<Produit> produits){
        this.idStock = idStock;
        this.produits = produits;
    }

}
