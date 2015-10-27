package ca.qc.cstj.android.androidtp2.Model;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by 0949748 on 2015-10-27.
 */
public class Cinema {
    private String id;
    private String nom;
    private String adresse;
    private String ville;
    private String uiid;
    private String codePostal;
    private String telephone;

    public Cinema(JsonObject object)
    {
        this.id = object.getAsJsonPrimitive("idCinema").getAsString();
        this.uiid = object.getAsJsonPrimitive("uuid").getAsString();
        this.nom = object.getAsJsonPrimitive("nom").getAsString();
        this.adresse = object.getAsJsonPrimitive("adresse").getAsString();
        this.ville = object.getAsJsonPrimitive("ville").getAsString();
        this.codePostal = object.getAsJsonPrimitive("codePostal").getAsString();
        this.telephone = object.getAsJsonPrimitive("telephone").getAsString();
    }
    public ArrayList<Cinema> createFromJSON(JsonArray jsonArray)
    {
        ArrayList<Cinema> list_cinema = new ArrayList<>();
        for (JsonElement element: jsonArray)
        {
            list_cinema.add(new Cinema(element.getAsJsonObject()));
        }
        return list_cinema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getUiid() {
        return uiid;
    }

    public void setUiid(String uiid) {
        this.uiid = uiid;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
