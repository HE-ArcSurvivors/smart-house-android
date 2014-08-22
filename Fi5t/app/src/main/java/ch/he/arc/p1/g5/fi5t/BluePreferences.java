package ch.he.arc.p1.g5.fi5t;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class BluePreferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.blue_preferences);
    }

}

