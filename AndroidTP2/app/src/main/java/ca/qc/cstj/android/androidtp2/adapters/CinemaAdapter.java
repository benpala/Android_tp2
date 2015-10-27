package ca.qc.cstj.android.androidtp2.adapters;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Locale;

import ca.qc.cstj.android.androidtp2.MainActivity;
import ca.qc.cstj.android.androidtp2.models.Cinema;
import ca.qc.cstj.android.androidtp2.R;

/**
 * Created by 0949748 on 2015-10-27.
 */
public class CinemaAdapter extends ArrayAdapter<Cinema> {
    private static class ViewHolder
    {
        TextView lblnom;
        TextView lbladresse;
    }
    public CinemaAdapter(Context context, ArrayList<Cinema> cinema)
    {
        super(context, 0, cinema);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Cinema cinema = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listitem_cinema,parent, false);

            viewHolder.lblnom = (TextView)convertView.findViewById(R.id.lblnom);
            viewHolder.lbladresse = (TextView)convertView.findViewById(R.id.lblAdresse);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.lblnom.setText(cinema.getNom());
        viewHolder.lbladresse.setText(cinema.getAdresse());
        return  convertView;
    }

}
