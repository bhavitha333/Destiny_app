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

public class MainActivity2 extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Destiny");

        buttonOne=(Button) findViewById(R.id.buttonOne);
        buttonTwo=(Button) findViewById(R.id.buttonTwo);
        buttonThree=(Button) findViewById(R.id.buttonThree);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenStoryOneReadActivity();
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenStoryTwoReadActivity();
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenStoryThreeReadActivity();
            }
        });



    }

    public void OpenStoryOneReadActivity(){
        Intent intent=new Intent(MainActivity2.this,StoryOneReadActivity.class);
        startActivity(intent);
    }

    public void OpenStoryTwoReadActivity(){
        Intent intent=new Intent(MainActivity2.this,StoryTwoReadActivity.class);
        startActivity(intent);
    }

    public void OpenStoryThreeReadActivity(){
        Intent intent=new Intent(MainActivity2.this,StoryThreeReadActivity.class);
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
//                Intent intent=new Intent(MainActivity2.this,SettingsActivity.class);
//                startActivity(intent);
//                return true;
            case R.id.setting:
                Intent intent1=new Intent(MainActivity2.this,SettingsActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}