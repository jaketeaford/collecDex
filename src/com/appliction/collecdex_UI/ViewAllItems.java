package com.appliction.collecdex_UI;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class ViewAllItems extends Activity {

  /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewitems);
        
        final TextView Text11 = (TextView) findViewById(R.id.TextView1);
        final TextView Text21 = (TextView) findViewById(R.id.TextView2);
        final TextView Text31 = (TextView) findViewById(R.id.TextView3);
        final TextView Text41 = (TextView) findViewById(R.id.TextView4);
        final ImageView Image12 = (ImageView) findViewById(R.id.ImageView1);
        final ImageView Image22 = (ImageView) findViewById(R.id.ImageView2);
        final ImageView Image32 = (ImageView) findViewById(R.id.ImageView3);
        final ImageView Image42 = (ImageView) findViewById(R.id.ImageView4);
        
        final TableLayout Table = (TableLayout) findViewById(R.id.TableLayout01);
        
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
        
        
	        if (cur.isAfterLast() == false) {
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

				else {
					Image12.setImageResource(R.drawable.noimage);
				}
				cur.moveToNext();
			}
	        
	        
	        
		if (cur.isAfterLast() == false) {
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
		
		
		
		if (cur.isAfterLast() == false) {
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
		
		
		
		if (cur.isAfterLast() == false) {
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
    }
}