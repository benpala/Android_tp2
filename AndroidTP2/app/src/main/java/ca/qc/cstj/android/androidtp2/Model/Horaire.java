package ca.qc.cstj.android.androidtp2.Model;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by 0949748 on 2015-10-27.
 */
public class Horaire {
    private String idHoraire;
    private String uuid;
    private String idFilm;
    private String idCinema;
    private String dateHeure;

    public Horaire(JsonObject object)
    {
        this.idHoraire = object.getAsJsonPrimitive("idHoraire").getAsString();
        this.uuid = object.getAsJsonPrimitive("uuid").getAsString();
        this.idFilm = object.getAsJsonPrimitive("idFilm").getAsString();
        this.idCinema = object.getAsJsonPrimitive("idCinema").getAsString();
        this.dateHeure = object.getAsJsonPrimitive("dateHeure").getAsString();
    }

    public  static ArrayList<Horaire> createFromJSON(JsonArray jsonarray)
    {
        ArrayList<Horaire> Horaire_list = new ArrayList<>();
        for (JsonElement element: jsonarray)
        {
            Horaire_list.add(new Horaire(element.getAsJsonObject()));
        }
        return Horaire_list;
    }

    public String getIdHoraire() {
        return idHoraire;
    }

    public void setIdHoraire(String idHoraire) {
        this.idHoraire = idHoraire;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(String idCinema) {
        this.idCinema = idCinema;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }
}
