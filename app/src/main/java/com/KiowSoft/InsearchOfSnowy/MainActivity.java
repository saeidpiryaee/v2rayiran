package com.KiowSoft.InsearchOfSnowy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int currentScore = 0;
    private TextView scoreTextView;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String SCORE_KEY = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.scoreTextView);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button centerButton = findViewById(R.id.centerButton);

        // Restore the saved score
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        currentScore = prefs.getInt(SCORE_KEY, 0);
        updateScore();

        // Set click listeners for buttons (you can add functionality to these buttons if needed)
        button1.setOnClickListener(v -> { });
        button2.setOnClickListener(v -> { });
        button3.setOnClickListener(v -> { });
        centerButton.setOnClickListener(v -> { });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Save the score when the app is closed
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putInt(SCORE_KEY, currentScore);
        editor.apply();
    }

    private void updateScore() {
        scoreTextView.setText("Score: " + currentScore);
    }

    // You can call this method whenever you want to increase the score
    private void increaseScore(int points) {
        currentScore += points;
        updateScore();
    }
}
