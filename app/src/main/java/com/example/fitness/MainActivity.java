package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvExercise;
    private Button btnPickExercise, btnMoreDetails;
    private String selectedExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvExercise = findViewById(R.id.tvExercise);
        btnPickExercise = findViewById(R.id.btnPickExercise);
        btnMoreDetails = findViewById(R.id.btnMoreDetails);

        final String[] exercises = {"Push Up", "Sit Up", "Squat", "Plank"};


        final String defaultText = "Pick an exercise!";


        btnPickExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int randomIndex = random.nextInt(exercises.length);
                selectedExercise = exercises[randomIndex];


                tvExercise.setText(selectedExercise);
            }
        });


        tvExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvExercise.setText(defaultText);
                selectedExercise = null;
            }
        });


        btnMoreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedExercise != null) {

                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra("EXERCISE_NAME", selectedExercise);
                    startActivity(intent);
                } else {

                    tvExercise.setText("Please pick an exercise first!");
                }
            }
        });
    }
}
