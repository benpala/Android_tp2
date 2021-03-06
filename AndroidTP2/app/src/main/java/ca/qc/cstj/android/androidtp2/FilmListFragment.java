package ca.qc.cstj.android.androidtp2;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;


import ca.qc.cstj.android.androidtp2.adapters.FilmAdapter;
import ca.qc.cstj.android.androidtp2.helpers.Services;

import ca.qc.cstj.android.androidtp2.models.Film;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FilmListFragment.OnFilmFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FilmListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilmListFragment extends ListFragment {

    private OnFilmFragmentInteractionListener mListener;
/**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FilmListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FilmListFragment newInstance() {
        FilmListFragment fragment = new FilmListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FilmListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film, container, false);

        final Context context = getActivity().getApplicationContext();
        Ion.with(context).load(Services.FILM_URL).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                FilmAdapter filmAdapter = new FilmAdapter(context, Film.createFromJSON(result));
                setListAdapter(filmAdapter);
            }
        });

            // Inflate the layout for this fragment
            return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Film film = (Film)(getListAdapter().getItem(position));
        String href = film.getUuid(); // get href-------------------
        mListener.onFilmFragmentInteraction(href);
        getListView().setItemChecked(position,true);
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFilmFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFilmFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFilmFragmentInteraction(String href);
    }

}
