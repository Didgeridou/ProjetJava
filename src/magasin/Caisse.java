package magasin;

public class Caisse {
    private int idCaisse;
    private double montantCaisse;

    public Caisse(int idCaisse) {
        this.idCaisse = idCaisse;
    }

    public void encaisser(Commande commande, double montantRecu) {
        double total = commande.getPrixTotal();
        if (montantRecu < total) {
            throw new IllegalArgumentException("Montant insuffisant");
        }
        montantCaisse += total;
        // gestion du rendu monnaie si besoin
    }

    public double getMontantCaisse() {
        return montantCaisse;
    }
}

