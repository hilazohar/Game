package com.example.game;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Main game screen that tracks button click scores for the blue and red players
 * and sends the results to the results screen.
 *
 * @author hila zohar (hz8414@bs.amalnet.k12.il)
 * @version 1.0
 * @since 21/11/2026
 */

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private Button btnBlue, btnRed, btnResults;
    private int blueScore = 0;
    private int redScore = 0;

    /**
     * Initializes the activity, connects UI elements, and sets up click listeners
     * for the game buttons and the results screen navigation.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *                           being shut down, this Bundle contains the most recent data.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBlue = findViewById(R.id.btnBlue);
        btnRed = findViewById(R.id.btnRed);
        btnResults = findViewById(R.id.btnResults);


        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blueScore += 1;
            }
        });


        btnRed.setOnLongClickListener(this);


        btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                intent.putExtra("BLUE_SCORE", blueScore);
                intent.putExtra("RED_SCORE", redScore);
                startActivity(intent);
            }
        });
    }

    /**
     * Handles long clicks on the red button and increments the red player's score by 2.
     *
     * @param v The view that was clicked and held.
     * @return true to indicate the long click event was consumed.
     */

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.btnRed) {
            redScore += 2;
            return true;
        }
        return false;
    }
    /**
     * Resets both players' scores to zero whenever the screen returns to the foreground.
     */


    @Override
    protected void onResume() {
        super.onResume();
        blueScore = 0;
        redScore = 0;
    }
}