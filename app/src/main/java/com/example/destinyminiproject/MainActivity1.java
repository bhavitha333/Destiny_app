package com.example.destinyminiproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {

    Button buttonRead;
    Button buttonListen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main1);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Destiny");

        buttonRead=(Button) findViewById(R.id.buttonRead);
        buttonListen=(Button) findViewById(R.id.buttonListen);

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMainActivityTwo();
            }
        });

        buttonListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMainActivityThree();
            }
        });


    }



    public void OpenMainActivityTwo(){
        Intent intent=new Intent(MainActivity1.this,MainActivity2.class);
        startActivity(intent);
    }
    public void OpenMainActivityThree(){
        Intent intent=new Intent(MainActivity1.this,MainActivity3.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
//            case R.id.about:
//                Intent intent=new Intent(MainActivity1.this,SettingsActivity.class);
//                startActivity(intent);
//                return true;
            case R.id.setting:
                Intent intent1=new Intent(MainActivity1.this,SettingsActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
