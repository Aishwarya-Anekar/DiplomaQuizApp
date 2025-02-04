package com.ayowainc.quizbox.User;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.ayowainc.quizbox.R;

public class ratings extends AppCompatActivity {
    RatingBar ratingBar;
    Button button;
    EditText commentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratings);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick() {
        ratingBar = findViewById(R.id.ratingBar);
        button = findViewById(R.id.button);
        commentEditText = findViewById(R.id.comment);

        //Performing action on Button Click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Getting the rating and displaying it on the toast
                String rating = String.valueOf(ratingBar.getRating());
                String commentData = commentEditText.getText().toString();

                Toast.makeText(getApplicationContext(), "Thank you for rating us", Toast.LENGTH_LONG).show();

                // Clearing the comment and rating
                commentEditText.setText("");
                ratingBar.setRating(0);
            }
        });
    }
}

