package com.example.fitness;


import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvExerciseDetails;
    private ImageView imgExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        tvExerciseDetails = findViewById(R.id.tvExerciseDetails);
        imgExercise = findViewById(R.id.imgExercise);


        String exerciseName = getIntent().getStringExtra("EXERCISE_NAME");
        if (exerciseName == null) {
            exerciseName = "Unknown Exercise";
        }


        tvExerciseDetails.setText(exerciseName);

        imgExercise.setImageResource(getExerciseImage(exerciseName));

        showCustomToast("You're viewing details for: " + exerciseName);
    }


    private int getExerciseImage(String exerciseName) {
        switch (exerciseName) {
            case "Push Up":
                return R.drawable.push_up_image;
            case "Sit Up":
                return R.drawable.sit_up_image;
            case "Squat":
                return R.drawable.squat_image;
            case "Plank":
                return R.drawable.plank_image;
            default:
                return R.drawable.ic_fitness;
        }
    }


    private void showCustomToast(String message) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toastText));

        TextView toastText = layout.findViewById(R.id.toastText);
        toastText.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
