package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button add_button;
    private Button view_button;
    private String title;
    private String director;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        add_button = findViewById(R.id.add_button);
        view_button = findViewById(R.id.view_button);
    }


    public void addPressed(View v){
        Intent i = new Intent(this, AddActivity.class);
       i.putExtra("ADD",true);
        //i.putExtra("DIRECTOR", director);
        startActivityForResult(i, 1);
    }

    //create variables display title and display director to differentiante ?
    public void viewPressed(View v){
        Intent i = new Intent(this, TitleViewActivity.class);
      //  i.putExtra("TITLE",title);
        //i.putExtra("DIRECTOR", director);
        startActivityForResult(i, 1);
    }

    /*public void onActivityResult (Intent data, String title, String director){
        title = data.getStringExtra(title);
        director = data.getStringExtra(director);
    }
*/





}
