package com.appliction.collecdex_UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class Remove_Confirm extends Activity {

  /** Called when the activity is first created. */
	SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	Intent myIntent = this.getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removeconfirm);
        
        db = openOrCreateDatabase(
           		"TestingData.db" //name of database
           		, SQLiteDatabase.CREATE_IF_NECESSARY //something
           		, null //uhhh
          		);
        
        final String record_to_delete[] = myIntent.getStringArrayExtra("params");
        
        final TextView record = (TextView) findViewById(R.id.RecordToRemove);
        final ImageView record_image = (ImageView) findViewById(R.id.removeimageview);
        final Button YesButton = (Button) findViewById(R.id.RemoveYesButton);
        final Button NoButton = (Button) findViewById(R.id.RemoveNoButton);
        
        record.append("Name: " + record_to_delete[0] + "\n");
        record.append("Manufacturer: " + record_to_delete[1] + "\n");
        record.append("Condition: " + record_to_delete[2] + "\n");
        
        String imagelocation = record_to_delete[3];
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap bm = BitmapFactory.decodeFile(imagelocation, options);
        
        int w = bm.getWidth();
        int h = bm.getHeight();
        
        Matrix mtx = new Matrix();
        mtx.postRotate(90);
        
        Bitmap rotatedBMP = Bitmap.createBitmap(bm, 0, 0, w, h, mtx, true);
        
        record_image.setImageBitmap(rotatedBMP);
        
        YesButton.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
	    {
	    	@Override
			public void onClick(View R)
	    	{
	    		db.execSQL("DELETE FROM tbl_items WHERE item_name = '" + record_to_delete[0] + "';");
	    		Toast.makeText(Remove_Confirm.this, "Record Deleted.", Toast.LENGTH_LONG).show();
	    		
	    		Intent myIntent = new Intent(R.getContext(), Remove_Choose.class);
        		startActivityForResult(myIntent, 0);
	    	}
	    });
        
        NoButton.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
	    {
	    	@Override
			public void onClick(View R)
	    	{
	    		Intent myIntent = new Intent(R.getContext(), Remove_Choose.class);
        		startActivityForResult(myIntent, 0);
	    	}
	    });
        
    }
}