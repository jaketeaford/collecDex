package com.appliction.collecdex_UI;

import java.util.Locale;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;


public class Main extends Activity {
    /** Called when the activity is first created. */
        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ImageView Logo = (ImageView) findViewById(R.id.MainLogo);
        final Button AddItem_Button = (Button) findViewById(R.id.AddItemButton); //Creates "Add New Item" to home screen
        final Button ViewItems_Button = (Button) findViewById(R.id.ViewAllItemsButton);
        final Button RemoveItem_Button = (Button) findViewById(R.id.RemoveItemButton);
        final Button EditItem_Button = (Button) findViewById(R.id.EditItemButton);
        final Button SearchItems_Button = (Button) findViewById(R.id.SearchButton);
        final Button Sync_Button = (Button) findViewById(R.id.SyncButton);
        
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
        
//       try {
//		db.execSQL("DROP TABLE tbl_items");
//	} catch (SQLiteException e) {
//		// TODO Auto-generated catch block
//		Toast.makeText(Main.this, e.getMessage(), Toast.LENGTH_LONG).show();
//	}
        
        //creating tables TABLE IS ALREADY CREATED! THIS WILL CAUSE ERRORS IF UNCOMMENTED
//        final String CREATE_TABLE_ITEMS =
//        	"CREATE TABLE tbl_items ("
//        	+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
//        	+ "item_name TEXT,"
//        	+ "item_manf TEXT,"
//        	+ "item_desc TEXT,"
//        	+ "imagelocation TEXT);";
//        db.execSQL(CREATE_TABLE_ITEMS);
        
        
        AddItem_Button.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
        {
        	@Override
			public void onClick(View R)
        	{
        		Intent myIntent = new Intent(R.getContext(), AddNewItem.class);
        		startActivityForResult(myIntent, 0);
        	}
        });
        
        ViewItems_Button.setOnClickListener(new OnClickListener()
        {
        	@Override
			public void onClick(View R)
        	{
        		Intent myIntent = new Intent(R.getContext(), ViewAllItems.class);
        		startActivityForResult(myIntent, 1);
        	}
        });
        
        EditItem_Button.setOnClickListener(new OnClickListener() //listens for clicks from EditItem_Button
        {
        	@Override
			public void onClick(View R)
        	{
        		Intent myIntent = new Intent(R.getContext(), Edit_Choose.class);
        		startActivityForResult(myIntent, 2);
        	}
        });
        
        RemoveItem_Button.setOnClickListener(new OnClickListener() //listens for clicks from EditItem_Button
        {
        	@Override
			public void onClick(View R)
        	{
        		Intent myIntent = new Intent(R.getContext(), Remove_Choose.class);
        		startActivityForResult(myIntent, 3);
        	}
        });
        
        SearchItems_Button.setOnClickListener(new OnClickListener() //listens for clicks from SearchItems_Button
        {
        	@Override
			public void onClick(View R)
        	{
        		Intent myIntent = new Intent(R.getContext(), Search.class);
        		startActivityForResult(myIntent, 4);
        	}
        });
        
        Sync_Button.setOnClickListener(new OnClickListener() //listens for clicks from SearchItems_Button
        {
        	@Override
			public void onClick(View R)
        	{
        	}
        });
    }
}