package com.example.destinyminiproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences;

        RadioButton defaultTheme, darkTheme;
        RadioGroup group;
        String themeName;

        sharedPreferences = getSharedPreferences("Theme", Context.MODE_PRIVATE);
        themeName = sharedPreferences.getString("ThemeName", "Default");

        if (themeName.equalsIgnoreCase("DarkTheme")) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            setTheme(R.style.ThemeLight);
        } else  {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            setTheme(R.style.ThemeDark);

        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
//
//        ss = (Switch) findViewById(R.id.switch2);
//
//        sharedPreferences=getSharedPreferences("AppSettingPrefs",0);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        valu=sharedPreferences.getBoolean("NightMode",false);
//
//        if(valu){
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
////            ss.setText("Disable Dark Mode");
//        }else{
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
////            ss.setText("Enable Dark Mode");
//        }
//
//
//        ss.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(valu){
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    editor.putBoolean("NightMode",false);
//                    editor.apply();
////                    ss.setText("Enable Dark Mode");
//                }else{
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    editor.putBoolean("NightMode",true);
//                    editor.apply();
////                    ss.setText("Disable Dark Mode");
//
//                }
//
//            }
//        });

        group = (RadioGroup) findViewById(R.id.group);
        defaultTheme = (RadioButton) findViewById(R.id.defaultTheme);
        darkTheme = (RadioButton) findViewById(R.id.darkTheme);



//
        if (themeName.equalsIgnoreCase("DarkTheme")) {
            darkTheme.setChecked(true);
//        } else if (themeName.equalsIgnoreCase("NoActionbar")) {
//            noActionBar.setChecked(true);
        } else  {
            defaultTheme.setChecked(true);
        }
        // Called when the checked radio button has changed.
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.defaultTheme) {
                    setTheme("Default");
                } else if (checkedId == R.id.darkTheme) {
                    setTheme("DarkTheme");
//                } else if (checkedId == R.id.noActionBar) {
//                    setTheme("NoActionbar");
                }

            }
//
        });


        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setTheme(String name) {
        // Create preference to store theme name
        SharedPreferences preferences = getSharedPreferences("Theme", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ThemeName", name);
        editor.apply();
        recreate();

        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(
                getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i); finish();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}