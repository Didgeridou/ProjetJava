package magasin;

/**
 * Caisse du magasin, représente le montant
 */
public class Caisse {
    private int idCaisse;
    private double montantCaisse;

    /***
     * Constructeur de la classe Caisse
     * 
     * @param idCaisse
     */
    public Caisse(int idCaisse) {
        this.idCaisse = idCaisse;
    }

    /**
     * ajouter le montant de la commande dans la caisse
     * 
     * @param commande
     * @param montantRecu
     */
    public void encaisser(Commande commande, double montantRecu) {
        double total = commande.getPrixTotal();
        if (montantRecu < total) {
            throw new IllegalArgumentException("Montant insuffisant");
        }
        montantCaisse += total;
    }

    /**
     * Obtenir le montant de la caisse
     * 
     * @return montant de la caisse
     */
    public double getMontantCaisse() {
        return montantCaisse;
    }
}

