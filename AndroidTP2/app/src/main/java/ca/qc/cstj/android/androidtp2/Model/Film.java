package ca.qc.cstj.android.androidtp2.Model;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by 0949748 on 2015-10-27.
 */
public class Film {

    private  String idFilm;
    private  String uuid;
    private  String titre;
    private  String pays;
    private  String genre;
    private  String classe;
    private  String duree;
    private  String urlImage;

    public Film(JsonObject object)
    {
        this.idFilm = object.getAsJsonPrimitive("idFilm").getAsString();
        this.uuid = object.getAsJsonPrimitive("uuid").getAsString();
        this.titre = object.getAsJsonPrimitive("titre").getAsString();
        this.pays = object.getAsJsonPrimitive("pays").getAsString();
        this.genre = object.getAsJsonPrimitive("genre").getAsString();
        this.classe = object.getAsJsonPrimitive("classe").getAsString();
        this.duree = object.getAsJsonPrimitive("duree").getAsString();
        this.urlImage = object.getAsJsonPrimitive("urlImage").getAsString();
    }

    public  static ArrayList<Film> createFromJSON(JsonArray jsonarray)
    {
        ArrayList<Film> Film_list = new ArrayList<>();
        for (JsonElement element: jsonarray)
        {
            Film_list.add(new Film(element.getAsJsonObject()));
        }
        return Film_list;
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
