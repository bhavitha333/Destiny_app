package com.example.destinyminiproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Destiny");

        buttonSix=(Button) findViewById(R.id.buttonSix);
        buttonSeven=(Button) findViewById(R.id.buttonSeven);
        buttonEight=(Button) findViewById(R.id.buttonEight);


        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenStoryOneListenActivity();
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenStoryTwoListenActivity();
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenStoryThreeListenActivity();
            }
        });
    }
    public void OpenStoryOneListenActivity(){
        Intent intent=new Intent(MainActivity3.this,StoryOneListenActivity.class);
        startActivity(intent);
    }

    public void OpenStoryTwoListenActivity(){
        Intent intent=new Intent(MainActivity3.this,StoryTwoListenActivity.class);
        startActivity(intent);
    }

    public void OpenStoryThreeListenActivity(){
        Intent intent=new Intent(MainActivity3.this,StoryThreeListenActivity.class);
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
//                Intent intent=new Intent(MainActivity3.this,SettingsActivity.class);
//                startActivity(intent);
//                return true;
            case R.id.setting:
                Intent intent1=new Intent(MainActivity3.this,SettingsActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}