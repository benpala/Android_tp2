package ca.qc.cstj.android.androidtp2.models;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 0949748 on 2015-10-27.
 */
public class Horaire {

    private String dateHeure;
    private String hrefcinema;

    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    private String titreFilm;
    public Horaire(JsonObject object)
    {

        this.dateHeure = object.getAsJsonPrimitive("dateHeure").getAsString();
        JsonObject ob = object.getAsJsonObject("film");
        this.titreFilm = ob.getAsJsonPrimitive("titre").getAsString();
        JsonObject j =  object.getAsJsonObject("cinema");
        this.hrefcinema = j.getAsJsonPrimitive("href").getAsString();
        JsonObject fl =  object.getAsJsonObject("film");
        this.hrefcinema = fl.getAsJsonPrimitive("href").getAsString();
    }

    public  static ArrayList<Horaire> createFromJSON(JsonArray jsonarray)
    {
        ArrayList<Horaire> Horaire_list = new ArrayList<Horaire>();
        for (JsonElement element: jsonarray)
        {
            Horaire_list.add(new Horaire(element.getAsJsonObject()));
        }
        return Horaire_list;
    }



    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }
}
