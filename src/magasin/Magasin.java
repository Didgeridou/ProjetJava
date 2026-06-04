package magasin;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Magasin {
    private int idMagasin;
    private String nom;
    private List<Client> clients = new ArrayList<>();
    private Stock stock;
    private Caisse caisse;

    /**
     * Constructeur de la classe Magasin
     * @param idMagasin
     * @param nom
     * @param stock
     * @param caisse
     */
    public Magasin(int idMagasin, String nom, Stock stock, Caisse caisse) {
        this.idMagasin = idMagasin;
        this.nom = nom;
        this.stock = stock;
        this.caisse = caisse;
    }

    /**
     * Obtenir l'id du Magasin
     * @return l'id du magasin
     */
    public int getIdMagasin() {
        return idMagasin;
    }

    /**
     * Mettre une valeur à l'id du magasin
     * @param idMagasin
     */
    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    /**
     * Obtenir le nom du magasin
     * @return nom du magasin
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mettre un nom au magasin
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir les clients
     * @return les clients
     */
    public List<Client> getClients() {
        return clients;
    }
    
    /**
     * Mettre des clients dans le magasin
     * @param clients
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * Obtenir le stock du magasin
     * @return stock du magasin
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Mettre du stock dans le magasin
     * @param stock
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    /**
     * Obtenir la caisse du magasin
     * @return caisse
     */
    public Caisse getCaisse() {
        return caisse;
    }

    /**
     * Mettre une caisse dans le magasin
     * @param caisse
     */
    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }

}

