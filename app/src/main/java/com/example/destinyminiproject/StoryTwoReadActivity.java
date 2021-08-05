package com.example.destinyminiproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StoryTwoReadActivity extends AppCompatActivity {

    private TextView myStoryTextView;
    private Button myButtonTop;
    private Button myButtonBottom;
    int myStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_two_read);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Story Two");

        myStoryTextView = (TextView) findViewById(R.id.storyTextView);
        myButtonTop = (Button) findViewById(R.id.TopButton);
        myButtonBottom = (Button) findViewById(R.id.bottomButton);

        myButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myStoryIndex==1){
                    myStoryTextView.setText(R.string.T12_Story);
                    myButtonTop.setText(R.string.T12_Ans1);
                    myButtonBottom.setText(R.string.T12_Ans2);
                    myStoryIndex=2;
//                } else if(myStoryIndex==2) {
//                    myStoryTextView.setText(R.string.T12_Story);
//                    myButtonTop.setText(R.string.T12_Ans1);
//                    myButtonBottom.setText(R.string.T12_Ans2);
//                    myStoryIndex=0;
                }else if(myStoryIndex==3){
                    myStoryTextView.setText(R.string.T13_Ans1_End);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }
                else{
                    myStoryTextView.setText(R.string.T_11_12_End);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }

            }
        });

        myButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myStoryIndex==1){
                    myStoryTextView.setText(R.string.T_11_12_End);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }else if (myStoryIndex==2){
                    myStoryTextView.setText(R.string.T13_Story);
                    myButtonTop.setText(R.string.T13_Ans1);
                    myButtonBottom.setText(R.string.T13_Ans2);
                    myStoryIndex=3;
                }else if (myStoryIndex==3){
                    myStoryTextView.setText(R.string.T13_Ans2_End);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }else{
                    myStoryTextView.setText(R.string.T13_Ans2_End);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);

                }

            }

        });
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
//                Intent intent=new Intent(StoryTwoReadActivity.this,SettingsActivity.class);
//                startActivity(intent);
//                return true;
            case R.id.setting:
                Intent intent1=new Intent(StoryTwoReadActivity.this,SettingsActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}