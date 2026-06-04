package magasin;


/****
 * Catégorie à laquelle appartient un produit
 */
public class Categorie {
    private int idCategorie;
    private String nom;
    private TypeCategorie type;


    /**Constructeur de la classe Categorie
     * 
     * @param idCategorie
     * @param nom
     * @param type
     */
    public Categorie(int idCategorie, String nom, TypeCategorie type) {
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.type = type;
    }

    /**
     * Obtenir l'id de la catégorie
     * @return id categorie
     */
    public int getIdCategorie() {
        return idCategorie;
    }

    /**
     * Mettre une valeur à l'identifiant de la catégorie
     * @param idCategorie
     */
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    /**
     * Obtenir le nom de la catégorie
     * @return nom de la catégorie
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mettre le nom de la catégorie
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir le type de la catégorie
     * @return type de la catégorie (Alimentaire ou non alimentaire)
     */
    public TypeCategorie getType() {
        return type;
    }

    /**
     * Mettre un type de catégorie
     * @param type
     */
    public void setType(TypeCategorie type) {
        this.type = type;
    }
    

    /**
     * @return nom de la catégorie
     */
    @Override
    public String toString() {
        return nom;
    }

}

