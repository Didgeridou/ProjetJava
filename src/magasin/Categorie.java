package magasin;

public class Categorie {

    private int idCategorie;
    private Type type;

    public enum Type{
        ALIMENTAIRE,
        NON_ALIMENTAIRE
    }

    public Categorie(int idCategorie, Type type){
        this.idCategorie = idCategorie;
        this.type = type;
    }

}
