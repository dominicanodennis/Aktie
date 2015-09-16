package com.example.dennis.aktie;

import android.app.Fragment;
import android.os.AsyncTask;
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

    ArrayAdapter<String> mAktienlisteAdapter;

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
        inflater.inflate(R.menu.menu_aktienlistefragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_daten_aktualisieren) {
            // Toast.makeText(getActivity(), "Aktualisieren gedrückt!", Toast.LENGTH_LONG).show();
            // Erzeugen einer Instanz von HoleDatenTask und starten des asynchronen Tasks
            HoleDatenTask holeDatenTask = new HoleDatenTask();
            holeDatenTask.execute("Aktie");

            // Den Benutzer informieren, dass neue Aktiendaten im Hintergrund abgefragt werden
            Toast.makeText(getActivity(), "Aktiendaten werden abgefragt!",
                    Toast.LENGTH_SHORT).show();

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

        mAktienlisteAdapter =
                new ArrayAdapter<>(
                        getActivity(),
                        R.layout.list_item_aktienliste, R.id.list_item_aktienliste_textview, aktienListe);

        View rootView = inflater.inflate(R.layout.fragment_aktienliste, container, false);

        ListView aktienlisteListView = (ListView) rootView.findViewById(R.id.listview_aktienliste);
        aktienlisteListView.setAdapter(mAktienlisteAdapter);

        return rootView;
    }

    // Innere Klasse HoleDatenTask führt den asynchronen Task auf eigenem Arbeitsthread aus
    public class HoleDatenTask extends AsyncTask<String, Integer, String[]> {

        private final String LOG_TAG = HoleDatenTask.class.getSimpleName();

        @Override
        protected String[] doInBackground(String... strings) {

            String[] ergebnisArray = new String[20];

            for (int i = 0; i < 20; i++) {

                // Den StringArray füllen wir mit Beispieldaten
                ergebnisArray[i] = strings[0] + "_" + (i + 1);

                // Alle 5 Elemente geben wir den aktuellen Fortschritt bekannt
                if (i % 5 == 4) {
                    publishProgress(i + 1, 20);
                }

                // Mit Thread.sleep(600) simulieren wir eine Wartezeit von 600 ms
                try {
                    Thread.sleep(600);
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Error ", e);
                }
            }

            return ergebnisArray;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            // Auf dem Bildschirm geben wir eine Statusmeldung aus, immer wenn
            // publishProgress(int...) in doInBackground(String...) aufgerufen wird
            Toast.makeText(getActivity(), values[0] + " von " + values[1] + " geladen",
                    Toast.LENGTH_SHORT).show();

        }

        @Override
        protected void onPostExecute(String[] strings) {

            // Wir löschen den Inhalt des ArrayAdapters und fügen den neuen Inhalt ein
            // Der neue Inhalt ist der Rückgabewert von doInBackground(String...) also
            // der StringArray gefüllt mit Beispieldaten
            if (strings != null) {
                mAktienlisteAdapter.clear();
                for (String aktienString : strings) {
                    mAktienlisteAdapter.add(aktienString);
                }
            }

            // Hintergrundberechnungen sind jetzt beendet, darüber informieren wir den Benutzer
            Toast.makeText(getActivity(), "Aktiendaten vollständig geladen!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
