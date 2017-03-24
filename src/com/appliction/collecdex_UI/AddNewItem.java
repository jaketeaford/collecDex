package com.appliction.collecdex_UI;

import java.util.Locale;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewItem extends Activity {
    /** Called when the activity is first created. */
    String imagestring;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	Intent myIntent = this.getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);
        if (myIntent.getStringExtra("params") != null)
        {
        	imagestring = myIntent.getStringExtra("params");
        }
        
        final EditText NewItem_Name = (EditText) findViewById(R.id.additem_name);
        final EditText NewItem_Manf = (EditText) findViewById(R.id.additem_manf);
        final EditText NewItem_Cond = (EditText) findViewById(R.id.additem_cond);
        
        final Button TakePicture = (Button) findViewById(R.id.additem_takepicture_button);
        final Button AddToDB = (Button) findViewById(R.id.additem_add_button);
    
	    NewItem_Name.setOnKeyListener(new OnKeyListener()
	    {
	    	@Override
			public boolean onKey(View R, int keyCode, KeyEvent event)
	    	{
	    		if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
	    		{
	    			return true;
	    		}
	    		
	    		return false;
	    	}
	    });
	    
	    NewItem_Manf.setOnKeyListener(new OnKeyListener()
	    {
	    	@Override
			public boolean onKey(View R, int keyCode, KeyEvent event)
	    	{
	    		if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
	    		{
	    			return true;
	    		}
	    		
	    		return false;
	    	}
	    });
	    
	    NewItem_Cond.setOnKeyListener(new OnKeyListener()
	    {
	    	@Override
			public boolean onKey(View R, int keyCode, KeyEvent event)
	    	{
	    		if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
	    		{
	    			return true;
	    		}
	    		
	    		return false;
	    	}
	    });
	    
	    TakePicture.setOnClickListener(new OnClickListener()
	    {
	    	@Override
			public void onClick(View R)
	    	{
	    		Intent myIntent = new Intent(R.getContext(), TakePicture.class);
        		startActivityForResult(myIntent, 1);
	    	}
	    });
	    
	    AddToDB.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
	    {
	    	@Override
			public void onClick(View R)
	    	{
	    		//myDbHelper.AddNewItem(NewItem_Name.getText().toString(), NewItem_Manf.getText().toString(), NewItem_Cond.getText().toString());
	    		//SQLiteDatabase temp = myDbHelper.getReadableDatabase();
	    		//myDbHelper.close();
	    		
	    		SQLiteDatabase db; //create DB object
	    		
	    		db = openOrCreateDatabase( //open or create DB and store it in "db"
	    	       		"TestingData.db" //name of database
	    	       		, SQLiteDatabase.CREATE_IF_NECESSARY //something
	    	       		, null //uhhh
	    	      		);
	    	        
	    	    db.setVersion(1);
	    	    db.setLocale(Locale.getDefault());
	    	    db.setLockingEnabled(true);
	    		
	    		
	    	    String temp_add_query; 
	    		//adding items
	    		
	            ContentValues values = new ContentValues();
	            values.put("item_name", NewItem_Name.getText().toString());
	            values.put("item_manf", NewItem_Manf.getText().toString());
	            values.put("item_desc", NewItem_Cond.getText().toString());
	            
	            if (imagestring != null)
	            	values.put("imagelocation", imagestring);
//	            	temp_add_query = "INSERT INTO tbl_items (item_name, item_manf, item_desc, imagelocation) " +
//					"VALUES ('" + NewItem_Name.getText().toString() + "', '" + NewItem_Manf.getText().toString() + "', '" + NewItem_Cond.getText().toString() + "', 'NONE')";
	            	
	            else
	            	values.put("imagelocation", "NONE");
//	            	temp_add_query = "INSERT INTO tbl_items (item_name, item_manf, item_desc, imagelocation) " +
//					"VALUES ('" + NewItem_Name.getText().toString() + "', '" + NewItem_Manf.getText().toString() + "', '" + NewItem_Cond.getText().toString() + "',  '" + imagestring.toString() +"')";
//	            	
	            try 
	            {
	              db.insertOrThrow("tbl_items", null, values);
	            } 
	            
	            catch (SQLiteException e) 
	            {
	            	Toast.makeText(AddNewItem.this, e.getMessage(), Toast.LENGTH_LONG).show();
	            }
	    		Intent myIntent = new Intent(R.getContext(), Main.class);
        		startActivityForResult(myIntent, 0);	
	    	}
	    });
    }
}