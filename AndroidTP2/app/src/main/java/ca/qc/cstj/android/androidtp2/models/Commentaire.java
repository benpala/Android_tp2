package ca.qc.cstj.android.androidtp2.models;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by 0949748 on 2015-10-27.
 */
public class Commentaire {
    private String idCommentaire;
    private String uuid;
    private String idFilm;
    private String texte;
    private String auteur;
    private String note;
    private String dateHeure;

    public Commentaire(JsonObject object)
    {
        this.idCommentaire = object.getAsJsonPrimitive("idCommentaire").getAsString();
        this.uuid = object.getAsJsonPrimitive("uuid").getAsString();
        this.idFilm = object.getAsJsonPrimitive("idFilm").getAsString();
        this.texte = object.getAsJsonPrimitive("texte").getAsString();
        this.auteur = object.getAsJsonPrimitive("auteur").getAsString();
        this.note = object.getAsJsonPrimitive("note").getAsString();
        this.dateHeure = object.getAsJsonPrimitive("dateHeure").getAsString();
    }

    public  static ArrayList<Commentaire> createFromJSON(JsonArray jsonarray)
    {
        ArrayList<Commentaire> commentaires_list = new ArrayList<Commentaire>();
        for (JsonElement element: jsonarray)
        {
            commentaires_list.add(new Commentaire(element.getAsJsonObject()));
        }
        return commentaires_list;
    }

    public String getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(String idCommentaire) {
        this.idCommentaire = idCommentaire;
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

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }
}
