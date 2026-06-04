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

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeCategorie getType() {
        return type;
    }

    public void setType(TypeCategorie type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}

