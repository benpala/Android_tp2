package ca.qc.cstj.android.androidtp2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ca.qc.cstj.android.androidtp2.R;

import ca.qc.cstj.android.androidtp2.models.Commentaire;
import ca.qc.cstj.android.androidtp2.models.Film;

/**
 * Created by 1266996 on 2015-11-06.
 */
public class CommentaireAdapter extends ArrayAdapter<Commentaire> {
    private static class ViewHolder {
        TextView lbbcommentaire;
        TextView lblauteur;
        TextView lblnote;
    }

    public CommentaireAdapter(Context context, ArrayList<Commentaire> commentaires)
    {
        super(context, 0, commentaires);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Commentaire commentaire= getItem(position);
        ViewHolder viewHolder;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listitem_film,parent, false);

            viewHolder.lbbcommentaire = (TextView)convertView.findViewById(R.id.lblcommentarie);
            viewHolder.lblauteur = (TextView)convertView.findViewById(R.id.lblauteur);
            viewHolder.lblnote = (TextView)convertView.findViewById(R.id.lblnote);



            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.lbbcommentaire.setText(commentaire.getTexte());
        viewHolder.lblauteur.setText(commentaire.getAuteur());
        viewHolder.lblnote.setText(commentaire.getNote());
        return  convertView;
    }
}
