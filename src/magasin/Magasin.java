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

    public Magasin(int idMagasin, String nom, Stock stock, Caisse caisse) {
        this.idMagasin = idMagasin;
        this.nom = nom;
        this.stock = stock;
        this.caisse = caisse;
    }

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Caisse getCaisse() {
        return caisse;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }

    
}

