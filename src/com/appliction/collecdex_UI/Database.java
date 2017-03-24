package com.appliction.collecdex_UI;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase; 

public class Database extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //create the text box
        TextView view = (TextView) findViewById(R.id.TextView01);
        
        //create SQLite variable 'db'
        SQLiteDatabase db;
        db = openOrCreateDatabase(
       		"TestingData.db" //name of database
       		, SQLiteDatabase.CREATE_IF_NECESSARY //something
       		, null //uhhh
      		);
        
        db.setVersion(1);
        db.setLocale(Locale.getDefault());
        db.setLockingEnabled(true);
        //end database creating
        
        //creating tables TABLE IS ALREADY CREATED! THIS WILL CAUSE ERRORS IF UNCOMMENTED
//        final String CREATE_TABLE_ITEMS =
//        	"CREATE TABLE tbl_items ("
//        	+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
//        	+ "item_name TEXT,"
//        	+ "item_manf TEXT,"
//        	+ "item_desc TEXT);";
//        db.execSQL(CREATE_TABLE_ITEMS);
//        
       //adding items
        ContentValues values = new ContentValues();
        values.put("item_name", "OLDER BOOK");
        values.put("item_manf", "OLDER BOOK COMPANY");
        values.put("item_desc", "MINT");
        
        try {
            db.insertOrThrow("tbl_items", null, values);
        } catch (Exception e) {
            //catch code
        }

        //retrieving with a cursor
        Cursor cur = db.query("tbl_items", 
           		null, null, null, null, null, null);
        
        cur.moveToFirst();
        
        while (cur.isAfterLast() == false) 
        {	
            view.append("n" + cur.getString(1));
       	    cur.moveToNext();
        }
        
        cur.close();
    }
}