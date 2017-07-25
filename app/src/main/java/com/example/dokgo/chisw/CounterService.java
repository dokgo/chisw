package com.example.dokgo.chisw;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by dokgo on 26.07.17.
 */

class CounterService {
    private static final String COUNTER_NAME = "counter";
    private static SharedPreferences prefs;

    static void updateCounter(Context context) {
        setDefaultPreferences(context);

        int counter = prefs.getInt(COUNTER_NAME, 0);
        prefs.edit().putInt(COUNTER_NAME, ++counter).apply();
    }

    static int getCounter(Context context) {
        setDefaultPreferences(context);

        return prefs.getInt(COUNTER_NAME, -1);
    }

    private static void setDefaultPreferences(Context context) {
        if (prefs == null) {
            Log.e("TAGC", "Initialize counter");
            prefs = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }
}
