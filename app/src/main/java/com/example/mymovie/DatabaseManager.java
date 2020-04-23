package com.example.mymovie;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {


public DatabaseManager(Context context){

    super(context, "MoviesDB", null,1);
}

public void onCreate(SQLiteDatabase db){
    String sql = " create table MovieTable(";
    sql += "id integer primary key autoincrement, ";
    sql += "title text, director text)";

    db.execSQL(sql);

}

public void insert(String movieName, String directorName){
    SQLiteDatabase db = getWritableDatabase();
    String sql = "insert into MovieTable values(";
    sql += "null, '"+movieName+"', '"+directorName+"')";
    db.execSQL(sql);
    db.close();
}

public void updateByTitle(String title, String director){
    //given a title and a director it edits the name of the director
    SQLiteDatabase db = getWritableDatabase();
    String sql = "update MovieTable set director = '"+director+"' ";
    sql+= "where title = '"+title+"'";
    db.execSQL(sql);
    db.close();

}


public ArrayList<String> getTitles(){
    ArrayList<String> list = new ArrayList<String>();
    SQLiteDatabase db = getWritableDatabase();
    String sql = "select * from MovieTable";
    Cursor cursor = db.rawQuery(sql, null);
    while(cursor.moveToNext()){
        String title = cursor.getString(1);
        list.add(title);
    }
    db.close();
    return list;
}




public String[] get(String movieTitle){

    SQLiteDatabase db = getWritableDatabase();
    String sql = "select * from MovieTable where title = '"+movieTitle+"'";
    Cursor cursor = db.rawQuery(sql, null);
    String[] entry = new String[2];
    if(cursor.moveToFirst()){
        String title = cursor.getString(1);
        String director = cursor.getString(2);
        entry[0]=title;
        entry[1]=director;
    }
    db.close();
    return entry;
}

public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

}








}
