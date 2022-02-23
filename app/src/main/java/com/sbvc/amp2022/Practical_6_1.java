package com.sbvc.amp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Practical_6_1 extends AppCompatActivity {

    Button btnGetRatings;
    RatingBar ratingMain;
    float val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical61);


        ratingMain = findViewById(R.id.ratingMain);
        btnGetRatings = findViewById(R.id.btnGetRatings);

        ratingMain.setRating(5.0f);

        btnGetRatings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = ratingMain.getRating();

                if (val == 5.0) {
                    Toast.makeText(Practical_6_1.this, "Your application is interesting", Toast.LENGTH_SHORT).show();
                } else if (val > 3.0 && val < 5.0) {
                    Toast.makeText(Practical_6_1.this, "Your application is good", Toast.LENGTH_SHORT).show();
                } else if (val > 2.0 && val < 3.0) {
                    Toast.makeText(Practical_6_1.this, "Your application is average", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Practical_6_1.this, "Your application is not useful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}