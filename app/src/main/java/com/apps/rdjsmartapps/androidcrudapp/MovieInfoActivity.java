package com.apps.rdjsmartapps.androidcrudapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MovieInfoActivity extends AppCompatActivity {

    private TextView movieName;
    private RatingBar ratingBar;
    private ImageView movieImage;
    private Button update, delete;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        // Set back button in action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movieName = (TextView) findViewById(R.id.movieName);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        movieImage = (ImageView)  findViewById(R.id.movieImage);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);

        // Fetch current item values

        Bundle inBundle = getIntent().getExtras();
        String movie_name = inBundle.get("movie_name").toString();
        String rating = inBundle.get("rating").toString();
        int imageId = Integer.valueOf(inBundle.get("imageId").toString());
        id = inBundle.get("id").toString();

        // Set values in text view

        movieName.setText(movie_name);
        ratingBar.setRating(Float.valueOf(rating));
        movieImage.setImageResource(imageId);


        // Setting alert dialogue for delete button

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete confirmation!");
        builder.setMessage("You are about to delete the record. Do you really want to proceed ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(), "You've choosen to delete record", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've changed your mind to delete record", Toast.LENGTH_SHORT).show();
            }
        });

        // handling delete button click

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.show();
            }
        });

        // handling update button click

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked on update button", Toast.LENGTH_SHORT).show();

                Intent updateIntent = new Intent(getApplicationContext(), UpdateActivity.class);
                startActivity(updateIntent);
            }
        });


    }
}
