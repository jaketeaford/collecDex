package com.appliction.collecdex_UI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.AbsoluteLayout;

public class TakePicture extends Activity 
{
	 private static final String TAG = "CameraDemo";
	  Preview preview; // <1>
	  Button buttonClick; // <2>
	  String imagelocation;
	  Intent myIntent;

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) 
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.takepicture);

	    preview = new Preview(this); // <3>
	    ((AbsoluteLayout) findViewById(R.id.preview)).addView(preview); // <4>
	    View v = findViewById(R.id.preview);
	    
	    myIntent = new Intent(v.getContext(), AddNewItem.class);
	    buttonClick = (Button) findViewById(R.id.buttonClick);
	    buttonClick.bringToFront();
	    buttonClick.setOnClickListener(new OnClickListener() 
	    {
	    	@Override
			public void onClick(View v) 
	    	{ // <5>
	    		preview.camera.takePicture(shutterCallback, rawCallback, jpegCallback);
	    	}
	    });

	    Log.d(TAG, "onCreate'd");
	  }

	  // Called when shutter is opened
	  ShutterCallback shutterCallback = new ShutterCallback() 
	  { // <6>
		    @Override
			public void onShutter() 
		    {
		    	Log.d(TAG, "onShutter'd");
		    }
	  };

	  // Handles data for raw picture
	  PictureCallback rawCallback = new PictureCallback() 
	  { // <7>
		  @Override
		public void onPictureTaken(byte[] data, Camera camera) 
		  {
			  Log.d(TAG, "onPictureTaken - raw");
		  }
	  };

	  // Handles data for jpeg picture
	  PictureCallback jpegCallback = new PictureCallback() 
	  { // <8>
	    @Override
		public void onPictureTaken(byte[] data, Camera camera) 
	    {
		      FileOutputStream outStream = null;
		      try 
		      {
			        // Write to SD Card
		    	    imagelocation = String.format("/sdcard/collecdex_images/%d.jpg", System.currentTimeMillis());
			        outStream = new FileOutputStream(imagelocation); // <9>
			        outStream.write(data);
			        outStream.close();
			        Log.d(TAG, "onPictureTaken - wrote bytes: " + data.length);
		      } 
		      
		      catch (FileNotFoundException e) 
		      { // <10>
		       	
		      } 
		      
		      catch (IOException e) 
		      {
		    	  e.printStackTrace();
		      } 
		      
		      finally 
		      {
		      }
		      
		      Log.d(TAG, "onPictureTaken - jpeg");
		      
		      myIntent.putExtra("params", imagelocation);
	    	startActivityForResult(myIntent, 0);
	    }
	  };
}