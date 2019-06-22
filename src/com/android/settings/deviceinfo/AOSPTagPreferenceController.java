package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.text.TextUtils;

import com.android.settings.R;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

public class AOSPTagPreferenceController extends AbstractPreferenceController implements
        PreferenceControllerMixin {

    private static final String PROPERTY_AOSPTAG_VERSION = "ro.aosptag.id";
    private static final String KEY_AOSPTAG_VERSION = "aosptag_version";

    public AOSPTagPreferenceController(Context context) {
        super(context);
    }

    @Override
    public boolean isAvailable() {
        return !TextUtils.isEmpty(SystemProperties.get(PROPERTY_AOSPTAG_VERSION));
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final Preference pref = screen.findPreference(KEY_AOSPTAG_VERSION);
        if (pref != null) {
            String summary = SystemProperties.get(PROPERTY_AOSPTAG_VERSION);
            pref.setSummary(summary);
        }
    }

    @Override
    public String getPreferenceKey() {
        return KEY_AOSPTAG_VERSION;
    }
}

