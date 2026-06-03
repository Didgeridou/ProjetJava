package magasin;

public class Client {
    private int idClient;
    private String nom;
    private Commande commande;

    public Client(int idClient, String nom) {
        this.idClient = idClient;
        this.nom = nom;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    
}
