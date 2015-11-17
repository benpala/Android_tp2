package ca.qc.cstj.android.androidtp2;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import ca.qc.cstj.android.androidtp2.adapters.CommentaireAdapter;
import ca.qc.cstj.android.androidtp2.models.Commentaire;
import ca.qc.cstj.android.androidtp2.models.Film;


public class detailFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String URL_HREF = "link";


    // TODO: Rename and change types of parameters
    private String href;
    private  Film monfilm;
    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static detailFragment newInstance(String href) {
        detailFragment fragment = new detailFragment();
        Bundle args = new Bundle();
        args.putString(URL_HREF, href);
        fragment.setArguments(args);
        return fragment;
    }

    public detailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final StringBuilder build = new StringBuilder();
        final View view = inflater.inflate(R.layout.fragment_detailfilm, container, false);

        final Context context = getActivity().getApplicationContext();
        String path = getArguments().getString("link");
        Ion.with(context).load(path)
                .asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
                monfilm = new Film(result.getAsJsonObject("film"));
                /*
                  private  String uuid;
                    private  String titre;
                    private  String pays;
                    private  String genre;
                    private  String classe;
                    private  String duree;
                    private  String urlImage;
                 */
                ((TextView)view.findViewById(R.id.lbltitle)).setText(monfilm.getTitre());
                ((TextView)view.findViewById(R.id.lblpays)).setText(monfilm.getPays());
                ((TextView)view.findViewById(R.id.lblclasse)).setText(monfilm.getClasse());
                ((TextView)view.findViewById(R.id.lblduree)).setText(monfilm.getDuree());
                 build.append((String)monfilm.getUuid());

                Ion.with(context).load(new StringBuilder().append(monfilm.getUrlImage()).append(".jpg").toString())
                        .withBitmap()
                        .intoImageView((ImageView)view.findViewById(R.id.lblimg));


                build.append("/commentaires");
                Ion.with(context).load(build.toString()).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        CommentaireAdapter commentaireAdapter = new CommentaireAdapter(context, Commentaire.createFromJSON(result));
                        ((ListView) view.findViewById(R.id.lstcommentaire)).setAdapter(commentaireAdapter);
                    }
                });
            }
        });
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        public void onFragmentInteraction(Uri uri);
    }

}
