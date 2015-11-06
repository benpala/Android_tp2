package ca.qc.cstj.android.androidtp2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ca.qc.cstj.android.androidtp2.R;

import ca.qc.cstj.android.androidtp2.models.Film;

/**
 * Created by 1266996 on 2015-11-06.
 */
public class FilmAdapter extends ArrayAdapter<Film> {
    private static class ViewHolder {
        TextView lblNomFilm;
    }

    public FilmAdapter(Context context, ArrayList<Film> films)
    {
        super(context, 0, films);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Film film= getItem(position);
        ViewHolder viewHolder;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listitem_film,parent, false);

            viewHolder.lblNomFilm = (TextView)convertView.findViewById(R.id.lblNomFilm);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.lblNomFilm.setText(film.getTitre());
        return  convertView;
    }
}
