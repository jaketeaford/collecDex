package com.appliction.collecdex_UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class Remove_Choose extends Activity {

  /** Called when the activity is first created. */
	SQLiteDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removechoice);
        
        final TextView Text11 = (TextView) findViewById(R.id.TextView1);
        final TextView Text21 = (TextView) findViewById(R.id.TextView2);
        final TextView Text31 = (TextView) findViewById(R.id.TextView3);
        final TextView Text41 = (TextView) findViewById(R.id.TextView4);
        final ImageView Image12 = (ImageView) findViewById(R.id.ImageView1);
        final ImageView Image22 = (ImageView) findViewById(R.id.ImageView2);
        final ImageView Image32 = (ImageView) findViewById(R.id.ImageView3);
        final ImageView Image42 = (ImageView) findViewById(R.id.ImageView4);
        
        SQLiteDatabase db;
        db = openOrCreateDatabase(
       		"TestingData.db" //name of database
       		, SQLiteDatabase.CREATE_IF_NECESSARY //something
       		, null //uhhh
      		);
        
        //retrieving names with a cursor
        
        Cursor cur = db.query("tbl_items", 
               		null, null, null, null, null, null);
			cur.moveToFirst();
        
			final String buffertext11[] = {"", "", "", ""}; //= {cur.getString(1),cur.getString(2), cur.getString(3), cur.getString(4)}; //save db text into buffer
	        if (cur.isAfterLast() == false) 
	        {
	        	buffertext11[0] = cur.getString(1);
	        	buffertext11[1] = cur.getString(2);
	        	buffertext11[2] = cur.getString(3);
	        	buffertext11[3] = cur.getString(4);
	        	
				Text11.append("Name: " + cur.getString(1) + "\n");
				Text11.append("Manufacturer: " + cur.getString(2) + "\n");
				Text11.append("Condition: " + cur.getString(3) + "\n");
				if (cur.getString(4) != null) {
					String imagelocation = cur.getString(4);
					BitmapFactory.Options options = new BitmapFactory.Options();
					options.inSampleSize = 8;
					Bitmap bm = BitmapFactory
							.decodeFile(imagelocation, options);

					int w = bm.getWidth();
					int h = bm.getHeight();

					Matrix mtx = new Matrix();
					mtx.postRotate(90);

					Bitmap rotatedBMP = Bitmap.createBitmap(bm, 0, 0, w, h,
							mtx, true);

					Image12.setImageBitmap(rotatedBMP);
				}

				else 
				{
					Image12.setImageResource(R.drawable.noimage);
				}
				cur.moveToNext();
			}
		
	       final String buffertext21[] = {"", "", "", ""}; //save db text into buffer
       	if (cur.isAfterLast() == false) {
       		
       		buffertext21[0] = cur.getString(1);
        	buffertext21[1] = cur.getString(2);
        	buffertext21[2] = cur.getString(3);
        	buffertext21[3] = cur.getString(4);
       		
			Text21.append("Name: " + cur.getString(1) + "\n");
			Text21.append("Manufacturer: " + cur.getString(2) + "\n");
			Text21.append("Condition: " + cur.getString(3) + "\n");
			if (cur.getString(4) != null) {
				String imagelocation = cur.getString(4);
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 8;
				Bitmap bm = BitmapFactory.decodeFile(imagelocation, options);

				int w = bm.getWidth();
				int h = bm.getHeight();

				Matrix mtx = new Matrix();
				mtx.postRotate(90);

				Bitmap rotatedBMP = Bitmap.createBitmap(bm, 0, 0, w, h, mtx,
						true);

				Image22.setImageBitmap(rotatedBMP);
			}

			else {
				Image22.setImageResource(R.drawable.noimage);
			}
			cur.moveToNext();
		}
		final String buffertext31[] = {"", "", "", ""}; //save db text into buffer
        if (cur.isAfterLast() == false) {
        	
        	buffertext31[0] = cur.getString(1);
        	buffertext31[1] = cur.getString(2);
        	buffertext31[2] = cur.getString(3);
        	buffertext31[3] = cur.getString(4);
        	
			Text31.append("Name: " + cur.getString(1) + "\n");
			Text31.append("Manufacturer: " + cur.getString(2) + "\n");
			Text31.append("Condition: " + cur.getString(3) + "\n");
			if (cur.getString(4) != null) {
				String imagelocation = cur.getString(4);
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 8;
				Bitmap bm = BitmapFactory.decodeFile(imagelocation, options);

				int w = bm.getWidth();
				int h = bm.getHeight();

				Matrix mtx = new Matrix();
				mtx.postRotate(90);

				Bitmap rotatedBMP = Bitmap.createBitmap(bm, 0, 0, w, h, mtx,
						true);

				Image32.setImageBitmap(rotatedBMP);
			}

			else {
				Image32.setImageResource(R.drawable.noimage);
			}
			cur.moveToNext();
		}
		final String buffertext41[] = {"", "", "", ""}; //save db text into buffer
        if (cur.isAfterLast() == false) 
        {
        	buffertext41[0] = cur.getString(1);
        	buffertext41[1] = cur.getString(2);
        	buffertext41[2] = cur.getString(3);
        	buffertext41[3] = cur.getString(4);
        	
			Text41.append("Name: " + cur.getString(1) + "\n");
			Text41.append("Manufacturer: " + cur.getString(2) + "\n");
			Text41.append("Condition: " + cur.getString(3) + "\n");
			if (cur.getString(4) != null) {
				String imagelocation = cur.getString(4);
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 8;
				Bitmap bm = BitmapFactory.decodeFile(imagelocation, options);

				int w = bm.getWidth();
				int h = bm.getHeight();

				Matrix mtx = new Matrix();
				mtx.postRotate(90);

				Bitmap rotatedBMP = Bitmap.createBitmap(bm, 0, 0, w, h, mtx,
						true);

				Image42.setImageBitmap(rotatedBMP);
			}

			else {
				Image42.setImageResource(R.drawable.noimage);
			}
			cur.moveToNext();
		}
		cur.close();
        
        Text11.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
        {
        	@Override
			public void onClick(View R)
        	{
        		Intent myIntent = new Intent(R.getContext(), Remove_Confirm.class);
        		myIntent.putExtra("params", buffertext11);
        		startActivityForResult(myIntent, 0);
        	}
        });
        
        Text21.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
        {
        	@Override
			public void onClick(View R)
        	{
        		Intent myIntent = new Intent(R.getContext(), Remove_Confirm.class);
        		myIntent.putExtra("params", buffertext21);
        		startActivityForResult(myIntent, 0);
        	}
        });
        
        Text31.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
        {
        	@Override
			public void onClick(View R)
        	{
        		Intent myIntent = new Intent(R.getContext(), Remove_Confirm.class);
        		myIntent.putExtra("params", buffertext31);
        		startActivityForResult(myIntent, 0);
        	}
        });
        
        Text41.setOnClickListener(new OnClickListener() //listens for clicks from AddItem_Button
        {
        	@Override
			public void onClick(View R)
        	{
        		Intent myIntent = new Intent(R.getContext(), Remove_Confirm.class);
        		myIntent.putExtra("params", buffertext41);
        		startActivityForResult(myIntent, 0);
        	}
        });
        
    }
}
        