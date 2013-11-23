package backend.core.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Andrzej
 */
public class Pracownik {
    
    private int id;
    private String nazwa;
    private String adres;

    public Pracownik() {
    }

    public Pracownik(String nazwa, String adres) {

        this.nazwa = nazwa;
        this.adres = adres;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Pracownik{" + "id=" + id + ", nazwa=" + nazwa + ", adres=" + adres + '}';
    }
    
}
