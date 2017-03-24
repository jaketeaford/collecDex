package com.appliction.collecdex_UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Search extends Activity {

  /** Called when the activity is first created. */
	SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        
        final EditText SearchTermsText = (EditText) findViewById(R.id.Name_Search_Box);
        final TextView SearchResultsLabel = (TextView) findViewById(R.id.SearchResultsLabel);
        final TextView SearchResults = (TextView) findViewById(R.id.SearchResultsText);
        final Button InitiateSearch = (Button) findViewById(R.id.Search_Go_Button);
        
        SearchResults.setText("");
        
        db = openOrCreateDatabase(
       		"TestingData.db" //name of database
       		, SQLiteDatabase.CREATE_IF_NECESSARY //something
       		, null //uhhh
      		);
        
        SearchTermsText.setOnKeyListener(new OnKeyListener()
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
        
        InitiateSearch.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
	    {
	    	@Override
			public void onClick(View R)
	    	{
	    		//retrieving names with a cursor
	            Cursor cur = db.rawQuery("SELECT * FROM tbl_items WHERE item_name = '" + SearchTermsText.getText().toString() + "';", null);
	            
	            
	            
	            //move all cursors to beginning of each
	            cur.moveToFirst();
	            
	            SearchResults.setText("");
	            
	            //make names column
	            while (cur.isAfterLast() == false) 
	            {	
	                SearchResults.append("Name: " + cur.getString(1) + "\n");
	                SearchResults.append("Manufacturer: " + cur.getString(2) + "\n");
	                SearchResults.append("Condition: " + cur.getString(3) + "\n\n");
	           	    cur.moveToNext();
	            }
	            
	            cur.close();
	    	}
	    });
    }
}