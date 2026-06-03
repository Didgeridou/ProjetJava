package magasin;

public class Produit {
    private int idProduit;
    private String nom;
    private double prix;
    private int quantite;
    private String codeProduit;
    private Categorie categorie;

    public Produit(int idProduit, String nom, double prix, int quantite,
                   String codeProduit, Categorie categorie) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.codeProduit = codeProduit;
        this.categorie = categorie;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public Categorie getCategorie() {
        return categorie;
    }
    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    @Override
    public String toString() {
        return nom + " (" + codeProduit + ") - " + prix + " €";
    }
}
