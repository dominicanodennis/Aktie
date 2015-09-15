package com.example.dennis.aktie;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class AktienlisteFragment extends Fragment {

    public AktienlisteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_aktienlistefragment,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_daten_aktualisieren) {
            Toast.makeText(getActivity(), "Aktualisieren gedrückt!", Toast.LENGTH_LONG).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String LOG_TAG = AktienlisteFragment.class.getSimpleName();

        Log.v(LOG_TAG, "verbose     - Meldung");
        Log.d(LOG_TAG, "debug       - Meldung");
        Log.i(LOG_TAG, "information - Meldung");
        Log.w(LOG_TAG, "warning     - Meldung");
        Log.e(LOG_TAG, "error       - Meldung");

        String[] aktienlisteArray = {
                "Adidas - Kurs: 73,45 €",
                "Allianz - Kurs: 145,12 €",
                "BASF - Kurs: 84,27 €",
                "Bayer - Kurs: 128,60 €",
                "Beiersdorf - Kurs: 80,55 €",
                "BMW St. - Kurs: 104,11 €",
                "Commerzbank - Kurs: 12,47 €",
                "Continental - Kurs: 209,94 €",
                "Daimler - Kurs: 84,33 €",
                "Intel - Kurs: 123,23"
        };

        List<String> aktienListe = new ArrayList<>(Arrays.asList(aktienlisteArray));

        ArrayAdapter<String> aktienlisteAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.list_item_aktienliste, R.id.list_item_aktienliste_textview, aktienListe);

        View rootView = inflater.inflate(R.layout.fragment_aktienliste, container, false);

        ListView aktienlisteListView = (ListView) rootView.findViewById(R.id.listview_aktienliste);
        aktienlisteListView.setAdapter(aktienlisteAdapter);

        return rootView;
    }


}
