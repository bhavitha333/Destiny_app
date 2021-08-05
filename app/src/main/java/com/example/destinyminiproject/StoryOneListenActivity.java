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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toast;

import java.util.Locale;

public class StoryOneListenActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private Button myButtonTop;
    private Button myButtonBottom;
    int myStoryIndex = 1;
    private TextView myTextView;
//    private SeekBar pitchSeekbar;
//    private SeekBar speedSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_one_listen);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Story One");

        myButtonTop = (Button) findViewById(R.id.buttonListenTop);
        myButtonBottom = (Button) findViewById(R.id.buttonListenBottom);
        myTextView=(TextView) findViewById(R.id.textViewListen) ;

//        pitchSeekbar=findViewById(R.id.pitchSeekbar);
//        speedSeekbar=findViewById(R.id.speedSeekbar);



        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
                String toSpeak =getString(R.string.T1_Story);
                //Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                //speak(toSpeak);
            }
        });


        myButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myStoryIndex == 1 || myStoryIndex == 2) {
                    myTextView.setText(R.string.listenStory);
                    String toSpeak =getString(R.string.T3_Story);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //speak(toSpeak);
                    myButtonTop.setText(R.string.T3_Ans1);
                    myButtonBottom.setText(R.string.T3_Ans2);
                    myStoryIndex = 3;
                } else if (myStoryIndex == 3){
                    myTextView.setText(R.string.end);
                    String toSpeak =getString(R.string.T6_End);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //speak(toSpeak);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }

            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        myButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myStoryIndex == 1){
                    myTextView.setText(R.string.listenStory);
                    String toSpeak =getString(R.string.T2_Story);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    //speak(toSpeak);
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setText(R.string.T2_Ans1);
                    myButtonBottom.setText(R.string.T2_Ans2);
                    myStoryIndex = 2;
                } else if (myStoryIndex == 3){
                    myTextView.setText(R.string.end);
                    String toSpeak =getString(R.string.T5_End);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //speak(toSpeak);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);

                } else {
                    myTextView.setText(R.string.end);
                    String toSpeak =getString(R.string.T4_End);
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    //speak(toSpeak);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }

            }
        });

    }

//    private void speak(String too){
//        float pitch = (float) 0.1;
//        float speed = (float) 0.1;
///*
//        if (pitch < 0.1){
//            pitch = 0.1f;
//        }
//
//        if (speed < 0.1) {
//            speed = 0.1f;
//        }
//        textToSpeech.setPitch(pitch);
//        textToSpeech.setSpeechRate(speed);
//*/
//        textToSpeech.speak(too, TextToSpeech.QUEUE_FLUSH, null);
//    }

    @Override
    protected void onDestroy() {

        if(textToSpeech!=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    public void onPause(){
        if(textToSpeech !=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
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
//                Intent intent=new Intent(StoryOneListenActivity.this,SettingsActivity.class);
//                startActivity(intent);
//                return true;
            case R.id.setting:
                Intent intent1=new Intent(StoryOneListenActivity.this,SettingsActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}