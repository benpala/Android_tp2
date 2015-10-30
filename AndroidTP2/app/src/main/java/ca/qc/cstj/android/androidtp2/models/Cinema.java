package ca.qc.cstj.android.androidtp2.models;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by 0949748 on 2015-10-27.
 */
public class Cinema {

    private String nom;
    private String adresse;
    private String ville;
    private String href;
    private String codePostal;
    private String telephone;

    public Cinema(JsonObject object)
    {

        this.href = object.getAsJsonPrimitive("href").getAsString();
        this.nom = object.getAsJsonPrimitive("nom").getAsString();
        this.adresse = object.getAsJsonPrimitive("adresse").getAsString();
        this.ville = object.getAsJsonPrimitive("ville").getAsString();
        this.codePostal = object.getAsJsonPrimitive("codePostal").getAsString();
        this.telephone = object.getAsJsonPrimitive("telephone").getAsString();

    }
    public static ArrayList<Cinema> createFromJSON(JsonArray jsonArray)
    {
        ArrayList<Cinema> list_cinema = new ArrayList<Cinema>();
        for (JsonElement element: jsonArray)
        {
            list_cinema.add(new Cinema(element.getAsJsonObject()));
        }
        return list_cinema;
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

    public String getHref() {
        return href;
    }

    public void setHref(String uiid) {
        this.href = uiid;
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
