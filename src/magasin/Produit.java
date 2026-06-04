package magasin;

public class Produit {
    private int idProduit;
    private String nom;
    private double prix;
    private int quantite;
    private String codeProduit;
    private Categorie categorie;

    /**
     * Constructeur de la classe Produit
     * @param idProduit
     * @param nom
     * @param prix
     * @param quantite
     * @param codeProduit
     * @param categorie
     */
    public Produit(int idProduit, String nom, double prix, int quantite,
                   String codeProduit, Categorie categorie) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.codeProduit = codeProduit;
        this.categorie = categorie;
    }

    /**
     * Obtenir l'id du produit
     * @return id produit
     */
    public int getIdProduit() {
        return idProduit;
    }

    /**
     * Mettre un id au produit
     * @param idProduit
     */
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    /**
     * Obtenir le nom du produit
     * @return nom du produit
     */
    public String getNom() {
        return nom;
    }

    /** 
     * Mettre un nom au produit
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir le prix du produit
     * @return prix du produit
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Mettre un prix au produit
     * @param prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Obtenir la quantité de produit
     * @return quantité du produit
     */
    public int getQuantite() {
        return quantite;
    }
    
    /**
     * Mettre une quantité au produit
     * @param quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Obtenir le code produit
     * @return code produit
     */
    public String getCodeProduit() {
        return codeProduit;
    }

    /**
     * Mettre un code au produit
     * @param codeProduit
     */
    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    /**
     * Obtenir la catégorie du produit
     * @return categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }
    
    /**
     * Mettre une catégorie au produit
     * @param categorie
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    @Override
    public String toString() {
        return nom + " (" + codeProduit + ") - " + prix + " €";
    }
}
