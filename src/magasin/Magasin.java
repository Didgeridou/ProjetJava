package magasin;

import java.util.List;

public class Magasin {

    private int idMagasin;
    private String nom;
    private List<Client> clients;
    private Stock stock;
    private Caisse caisse;

    public Magasin(int idMagasin, String nom, List<Client> clients, Stock stock, Caisse caisse){
        this.idMagasin = idMagasin;
        this.nom = nom;
        this.clients = clients;
        this.stock = stock;
        this.caisse = caisse;
        
    }
}
