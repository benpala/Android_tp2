package ca.qc.cstj.android.androidtp2;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import ca.qc.cstj.android.androidtp2.adapters.CinemaAdapter;
import ca.qc.cstj.android.androidtp2.adapters.HoraireAdapter;
import ca.qc.cstj.android.androidtp2.helpers.Services;
import ca.qc.cstj.android.androidtp2.models.Cinema;
import ca.qc.cstj.android.androidtp2.models.Horaire;

/**
 * Created by 0949748 on 2015-10-30.
 */
public class HoraireListFragment extends ListFragment {
    private OnFragmentInteractionListenerHoraire mListener;
    private static final String ARG_HREF = "mesHoraires";
    public static HoraireListFragment newInstance(String href)
    {
        HoraireListFragment fragment = new HoraireListFragment();
        Bundle args = new Bundle();
        href += "/horaires";
        args.putString(ARG_HREF, href);
        fragment.setArguments(args);
        return fragment;
    }
    public HoraireListFragment() {
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
        View view = inflater.inflate(R.layout.fragment_horaire, container, false);

        final Context context = getActivity().getApplicationContext();
        String path = getArguments().getString(ARG_HREF);
        Ion.with(context).load(path)
                         .asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                if(result == null) {
                    //Toast.makeText();
                }
                HoraireAdapter horaireAdapter = new HoraireAdapter(context, Horaire.createFromJSON(result));
                setListAdapter(horaireAdapter);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListenerHoraire) activity;
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
        Horaire unh = (Horaire)(getListAdapter().getItem(position));
        String newhref = unh.getHreffilm();
        mListener.OnFragmentInteractionListenerHoraire(newhref);
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
    public interface OnFragmentInteractionListenerHoraire {
        // TODO: Update argument type and name
        public void OnFragmentInteractionListenerHoraire(String position);
    }
}
