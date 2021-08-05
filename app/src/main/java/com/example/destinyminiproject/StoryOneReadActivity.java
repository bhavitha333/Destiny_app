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
import android.widget.Toast;

import java.util.Locale;

public class StoryOneReadActivity extends AppCompatActivity {

    private TextView myStoryTextView;
    private Button myButtonTop;
    private Button myButtonBottom;
    int myStoryIndex = 1;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_one_read);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Story One");

        myStoryTextView = (TextView) findViewById(R.id.storyTextView);
        myButtonTop = (Button) findViewById(R.id.TopButton);
        myButtonBottom = (Button) findViewById(R.id.bottomButton);

        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
                String toSpeak = myStoryTextView.getText().toString();
                //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                //textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });





        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        myButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myStoryIndex == 1 || myStoryIndex == 2) {
                    myStoryTextView.setText(R.string.T3_Story);
                    //String toSpeak = myStoryTextView.getText().toString();
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    //textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setText(R.string.T3_Ans1);
                    myButtonBottom.setText(R.string.T3_Ans2);
                    myStoryIndex = 3;
                } else if (myStoryIndex == 3){
                    myStoryTextView.setText(R.string.T6_End);
                    String toSpeak = myStoryTextView.getText().toString();
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    //textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
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
                    myStoryTextView.setText(R.string.T2_Story);
                    String toSpeak = myStoryTextView.getText().toString();
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    //textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setText(R.string.T2_Ans1);
                    myButtonBottom.setText(R.string.T2_Ans2);
                    myStoryIndex = 2;
                } else if (myStoryIndex == 3){
                    myStoryTextView.setText(R.string.T5_End);
                    String toSpeak = myStoryTextView.getText().toString();
                   // Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    //textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);

                } else {
                    myStoryTextView.setText(R.string.T4_End);
                    String toSpeak = myStoryTextView.getText().toString();
                    //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                    //textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }

            }
        });
    }
    public void onPause() {
        if (textToSpeech != null) {
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
//                Intent intent=new Intent(StoryOneReadActivity.this,SettingsActivity.class);
//                startActivity(intent);
//                return true;
            case R.id.setting:
                Intent intent1=new Intent(StoryOneReadActivity.this,SettingsActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}