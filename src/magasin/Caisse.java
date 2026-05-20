package magasin;

public class Caisse {

    private int idCaisse;
    private Commande commande;
    private double montantCaisse;

    public Caisse(int idCaisse, Commande commande, double montantCaisse){
        this.idCaisse = idCaisse;
        this.commande = commande;
        this.montantCaisse = montantCaisse;
    }

}
