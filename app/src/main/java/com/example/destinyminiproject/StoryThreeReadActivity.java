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
import android.widget.TextView;

public class StoryThreeReadActivity extends AppCompatActivity {

    private TextView myStoryTextView;
    private Button myButtonTop;
    private Button myButtonBottom;
    int myStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_three_read);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Story Three");

        myStoryTextView = (TextView) findViewById(R.id.storyTextView);
        myButtonTop = (Button) findViewById(R.id.TopButton);
        myButtonBottom = (Button) findViewById(R.id.bottomButton);


        myButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myStoryIndex==1){
                    myStoryTextView.setText(R.string.T32_Story);
                    myButtonTop.setText(R.string.T32_Ans1);
                    myButtonBottom.setText(R.string.T32_Ans2);
                    myStoryIndex=2;
                }else if(myStoryIndex==2){
                    myStoryTextView.setText(R.string.T33_Story);
                    myButtonTop.setText(R.string.T33_Ans1);
                    myButtonBottom.setText(R.string.T31_Ans2);
                    myStoryIndex=4;
                }else if (myStoryIndex==3||myStoryIndex==4){
                    myStoryTextView.setText(R.string.T33_Ans1_End);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }
            }
        });

        myButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myStoryIndex==1){
                    myStoryTextView.setText(R.string.T31_Ans1_End);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);
                }else if (myStoryIndex==2){
                    myStoryTextView.setText(R.string.T34_Story);
                    myButtonTop.setText(R.string.T33_Ans1);
                    myButtonBottom.setText(R.string.T34_Ans2);
                    myStoryIndex=3;
                }else if(myStoryIndex==3){
                    myStoryTextView.setText(R.string.T34_Ans2_End);
                    myButtonTop.setVisibility(View.GONE);
                    myButtonBottom.setVisibility(View.GONE);

                }else if(myStoryIndex==4){
                    myStoryTextView.setText(R.string.T31_Ans1_End);
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
                Intent intent1=new Intent(StoryThreeReadActivity.this,SettingsActivity.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}