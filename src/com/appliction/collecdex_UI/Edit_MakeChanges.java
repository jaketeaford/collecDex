package com.appliction.collecdex_UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Edit_MakeChanges extends Activity {

  /** Called when the activity is first created. */
	SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	Intent myIntent = this.getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editchangespage);
        
        db = openOrCreateDatabase(
           		"TestingData.db" //name of database
           		, SQLiteDatabase.CREATE_IF_NECESSARY //something
           		, null //uhhh
          		);
        
        final String SQL_Queries[] = myIntent.getStringArrayExtra("params");
        
        String query = "SELECT * FROM tbl_items WHERE item_name = '" + SQL_Queries[0] + "' AND item_manf = '" + SQL_Queries[1] + "' AND item_desc = '" + SQL_Queries[2] + "';";
        
        final TextView CurItemLabel = (TextView) findViewById(R.id.RecordToEditBox);
        
        final CheckBox NameCheckBox = (CheckBox) findViewById(R.id.EditNameCheckbox);
        final CheckBox ManfCheckBox = (CheckBox) findViewById(R.id.EditManfCheckbox);
        final CheckBox DescCheckBox = (CheckBox) findViewById(R.id.EditDescCheckbox);
        
        final EditText NameTextBox = (EditText) findViewById(R.id.EditNameTextbox);
        final EditText ManfTextBox = (EditText) findViewById(R.id.EditManfTextbox);
        final EditText DescTextBox = (EditText) findViewById(R.id.EditDescTextbox);
        
        final Button DoEditButton = (Button) findViewById(R.id.DoEditButton);
        try 
        {
        	Cursor cur = db.rawQuery(query, null);
            
            cur.moveToFirst();
        
	        CurItemLabel.append("Name: " + cur.getString(1) + "\n");
	        CurItemLabel.append("Manufacturer: " + cur.getString(2) + "\n");
	        CurItemLabel.append("Condition: " + cur.getString(3) + "\n\n");
	        
	        cur.close();
        } 
        
        catch (Exception e) 
        {
        	Toast.makeText(Edit_MakeChanges.this, "SQL IS INVALID", Toast.LENGTH_SHORT).show();
        }
        
        NameTextBox.setOnKeyListener(new OnKeyListener()
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
        
        ManfTextBox.setOnKeyListener(new OnKeyListener()
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
        
        DescTextBox.setOnKeyListener(new OnKeyListener()
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
        
        DoEditButton.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
	    {
	    	@Override
			public void onClick(View R)
	    	{
	    		
	    		if (NameCheckBox.isChecked() == true)
	    		{
	    			String tempquery = "UPDATE tbl_items SET item_name = '" + NameTextBox.getText().toString() + "' WHERE item_name = '" + SQL_Queries[0] + "';";
	    			
	    			
	    			try 
	    		        {
	    		        db.execSQL(tempquery);
	    		        } 
	    	 	        
	    		        catch (Exception e) 
	    		        {
	    		        	Toast.makeText(Edit_MakeChanges.this, "SQL IS INVALID", Toast.LENGTH_SHORT).show();
	    		        }
	    			
	    		}
	    		
	    		if (ManfCheckBox.isChecked() == true)
	    		{
	    			String tempquery = "UPDATE tbl_items SET item_manf = '" + ManfTextBox.getText().toString() + "' WHERE item_name = '" + SQL_Queries[0] + "';";
	    			db.execSQL(tempquery);
	    		}
	    		
	    		if (DescCheckBox.isChecked() == true)
	    		{
	    			String tempquery = "UPDATE tbl_items SET item_desc = '" + DescTextBox.getText().toString() + "' WHERE item_name = '" + SQL_Queries[0] + "';";
	    			db.execSQL(tempquery);
	    		}
        
        		Intent myIntent = new Intent(R.getContext(), Main.class);
        		startActivityForResult(myIntent, 0);
	    	}
	    });
    }
}