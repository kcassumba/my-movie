package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleViewActivity extends AppCompatActivity {
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_view);

        scrollView = findViewById(R.id.scrollView);
        scrollView.removeAllViews();
        DatabaseManager dbm = new DatabaseManager(this);
        ArrayList<String> list = dbm.getTitles();
        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(1);
        grid.setRowCount(list.size());

        for(String title: list){
            TextView text = new TextView(this);
            text.setText(title);
            text.setTextSize(35);
            text.setClickable(true);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), ViewActivity.class);
                    i.putExtra("TITLE",((TextView)view).getText().toString());
                    startActivity(i);
                }
            });
            grid.addView(text);
        }

        scrollView.addView(grid);
    }






}
