package ca.qc.cstj.android.androidtp2;

import android.app.Activity;

import android.app.ListFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;


import ca.qc.cstj.android.androidtp2.helpers.Services;
import ca.qc.cstj.android.androidtp2.models.Cinema;
import ca.qc.cstj.android.androidtp2.adapters.CinemaAdapter;

/**
 * Created by 0949748 on 2015-10-27.
 */
public class CinemaListFragment extends ListFragment {
    private OnFragmentInteractionListener mListener;

    public static CinemaListFragment newInstance()
    {
        CinemaListFragment fragment = new CinemaListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public CinemaListFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cinema, container, false);

        final Context context = getActivity().getApplicationContext();
        Ion.with(context).load(Services.CINEMAS_URL).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                CinemaAdapter cinemaAdapter = new CinemaAdapter(context, Cinema.createFromJSON(result));
                setListAdapter(cinemaAdapter);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
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

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Cinema uncinema = (Cinema)(getListAdapter().getItem(position));
        String href = uncinema.getHref();
        mListener.onFragmentInteraction(href);
        getListView().setItemChecked(position,true);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String href);
    }
}
