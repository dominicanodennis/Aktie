package com.example.dennis.aktie;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

/**
 * Created by dennis on 13.11.15.
 */
public class EinstellungenActivity extends PreferenceActivity
        implements Preference.OnPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "Einstellungen-Activity gestartet", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Zurück mit Back-Button", Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }
}

