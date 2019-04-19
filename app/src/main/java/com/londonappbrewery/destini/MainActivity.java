package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button topButton;
    private Button bottomButton;
    private TextView storyText;
    private int mStoryIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);
        storyText = findViewById(R.id.storyTextView);

        if(savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("IndexKey");
        }else{
            mStoryIndex = 1;
        }

        if(mStoryIndex == 5 || mStoryIndex == 6){
            topButton.setVisibility(View.GONE);
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mStoryIndex == 1 || mStoryIndex == 2){

                    Log.d("Destini","Top button clicked, showing T3");
                    storyText.setText(R.string.T3_Story);
                    topButton.setText(R.string.T3_Ans1);
                    bottomButton.setText(R.string.T3_Ans2);
                    mStoryIndex = 3;


                }else {

                    Log.d("Destini","Top button clicked, showing T6");
                    storyText.setText(R.string.T6_End);
                    topButton.setVisibility(View.GONE);
                    bottomButton.setText(R.string.Exit);
                    mStoryIndex = 6;
                }
            }
        });
        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mStoryIndex == 1) {

                    Log.d("Destini","Bottom button clicked, showing T2");
                    bottomButton.setText(R.string.T2_Ans2);
                    topButton.setText(R.string.T2_Ans1);
                    storyText.setText(R.string.T2_Story);
                    mStoryIndex = 2;

                } else if (mStoryIndex == 2) {

                    Log.d("Destini","Bottom button clicked, showing T4");
                    storyText.setText(R.string.T4_End);
                    topButton.setVisibility(View.GONE);
                    bottomButton.setText(R.string.Exit);
                    mStoryIndex = 4;

                } else if (mStoryIndex == 3) {

                    Log.d("Destini","Bottom button clicked, showing T5");
                    storyText.setText(R.string.T5_End);
                    topButton.setVisibility(View.GONE);
                    bottomButton.setText(R.string.Exit);
                    mStoryIndex = 5;

                } else{
                    finish();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outstate){

        super.onSaveInstanceState(outstate);
        outstate.putInt("IndexKey",mStoryIndex);

    }
}
