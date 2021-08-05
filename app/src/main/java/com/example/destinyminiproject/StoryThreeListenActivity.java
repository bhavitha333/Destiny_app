package com.example.destinyminiproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class StoryThreeListenActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private Button myButtonTop;
    private Button myButtonBottom;
    int myStoryIndex = 1;
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_three_listen);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Story Three");

        myButtonTop = (Button) findViewById(R.id.buttonListenTop);
        myButtonBottom = (Button) findViewById(R.id.buttonListenBottom);
        myTextView=(TextView) findViewById(R.id.textViewListen) ;

        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
                String toSpeak =getString(R.string.T31_Story);
                //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        myButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myStoryIndex==1){
                    String toSpeak =getString(R.string.T32_Story);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setText(R.string.T32_Ans1);
                    myButtonBottom.setText(R.string.T32_Ans2);
                    myStoryIndex=2;
                }else if(myStoryIndex==2){
                    String toSpeak =getString(R.string.T33_Story);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setText(R.string.T33_Ans1);
                    myButtonBottom.setText(R.string.T31_Ans2);
                    myStoryIndex=4;
                }else if (myStoryIndex==3||myStoryIndex==4){
                    myTextView.setText(R.string.end);
                    String toSpeak =getString(R.string.T33_Ans1_End);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }
            }
        });

        myButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myStoryIndex==1){
                    myTextView.setText(R.string.end);
                    String toSpeak =getString(R.string.T31_Ans1_End);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }else if (myStoryIndex==2){
                    String toSpeak =getString(R.string.T34_Story);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setText(R.string.T33_Ans1);
                    myButtonBottom.setText(R.string.T34_Ans2);
                    myStoryIndex=3;
                }else if(myStoryIndex==3){
                    myTextView.setText(R.string.end);
                    String toSpeak =getString(R.string.T34_Ans2_End);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);

                }else if(myStoryIndex==4){
                    myTextView.setText(R.string.end);
                    String toSpeak =getString(R.string.T31_Ans1_End);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
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
                Intent intent1=new Intent(StoryThreeListenActivity.this,SettingsActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}