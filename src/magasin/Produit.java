package magasin;

public class Produit {

    private int idProduit;
    private Categorie categorie;
    private int quantite;
    private double prix;

    public Produit(int idProduit, Categorie categorie, int quantite, double prix){

        this.idProduit = idProduit;
        this.categorie = categorie;
        this.quantite = quantite;
        this.prix = prix;

    }

}
