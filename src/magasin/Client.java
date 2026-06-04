package magasin;

public class Client {
    private int idClient;
    private String nom;
    private Commande commande;


    /**
     * Constructeur de la classe Client
     * 
     * @param idClient
     * @param nom
     */
    public Client(int idClient, String nom) {
        this.idClient = idClient;
        this.nom = nom;
    }

    /**
     * Obtenir l'id du client
     * @return id client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Mettre une valeur à l'id client
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Obtenir le nom du client
     * @return nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mettre un nom au client
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir la commande du client
     * @return la commande du client
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     * Mettre une commande au client
     * @param commande
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    
}
