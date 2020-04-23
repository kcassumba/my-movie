package com.example.mymovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {
    private TextView display_title;
    private TextView display_director;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        display_title = findViewById(R.id.display_title);
        display_director = findViewById(R.id.display_director);

        DatabaseManager dbm = new DatabaseManager(this);
        Intent i =getIntent();
        String title = i.getStringExtra("TITLE");
        String[] entry = dbm.get(title);

        display_title.setText(entry[0]);
        display_director.setText(entry[1]);

    }

    public void editPressed(View v){
        Intent i = new Intent(this, AddActivity.class);
        i.putExtra("ADD", false);
        i.putExtra("TITLE",display_title.getText().toString());
        i.putExtra("DIRECTOR", display_director.getText().toString());
        startActivity(i);

    }

}
