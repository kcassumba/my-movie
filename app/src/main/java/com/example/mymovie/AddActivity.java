package com.example.mymovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private EditText titlebox;
    private EditText directorbox;
  //  private EditText yearbox;
    private Button addmovie_button;
    private boolean add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        titlebox = findViewById(R.id.title);
        directorbox = findViewById(R.id.director);
      //  yearbox = findViewById(R.id.yearbox);
        addmovie_button = findViewById(R.id.addmovie_button);

        Intent i = getIntent();
         add = i.getBooleanExtra("ADD", true);
        if(add){
            //add a movie
            addmovie_button.setText("ADD MOVIE");
        }else{
            //edit a movie
            addmovie_button.setText("EDIT MOVIE");
            titlebox.setText(i.getStringExtra("TITLE"));
            directorbox.setText(i.getStringExtra("DIRECTOR"));

        }

    }

//ADD YEAR TO ALL ACTIVITIES IN ORDER FOR IT TO DISPLAY
    public void addMoviePressed(View v){
        String title = titlebox.getText().toString();
        String director = directorbox.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        if(add) {
            dbm.insert(title, director);
        }else{
            dbm.updateByTitle(title, director);
        }
        finish();

    }



    }
