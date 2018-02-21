package com.example.maxwell.pitapp2018.fragments;

import android.os.Bundle;

import com.example.maxwell.pitapp2018.R;

public class PreferenceFragment extends android.preference.PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.prefs);
    }
}