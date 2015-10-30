package ca.qc.cstj.android.androidtp2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ca.qc.cstj.android.androidtp2.R;
import ca.qc.cstj.android.androidtp2.models.Horaire;

/**
 * Created by 0949748 on 2015-10-30.
 */
public class HoraireAdapter extends ArrayAdapter<Horaire> {
    private static class ViewHolder
    {
        TextView datehoraire;
    }
    public HoraireAdapter(Context context, ArrayList<Horaire> cinema)
    {
        super(context, 0, cinema);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Horaire cinema = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listitem_cinema,parent, false);

            viewHolder.datehoraire = (TextView)convertView.findViewById(R.id.lbldate);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.datehoraire.setText(cinema.getDateHeure());

        return  convertView;
    }
}
