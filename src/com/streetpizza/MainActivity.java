package com.streetpizza;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	SharedPreferences preferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 SharedPreferences settings =  PreferenceManager.getDefaultSharedPreferences(getBaseContext());                          
	     
		 int OrderNumbr = settings.getInt("OrderNumber", 0);
		 if(OrderNumbr>=7)
		 {
			 Button PanicBtn = (Button) findViewById(R.id.PanicButton);
			 PanicBtn.setVisibility(View.VISIBLE);
		 }
		 else
		 {
			 Button PanicBtn = (Button) findViewById(R.id.PanicButton);
			 PanicBtn.setVisibility(View.GONE);
			 
		 }
		
		 SharedPreferences.Editor editor = settings.edit();
	     editor.putString("Order","");
		 //editor.clear();  
		 editor.commit();
		
		
		//Button CreatePizza= (Button) findViewById(R.id.StartOrder);
		
	
	
	}

	public void StartOrderClicked(View view) {
	    
		Intent myIntent = new Intent(MainActivity.this, SelectItem.class);
		//myIntent.putExtra("key", value); //Optional parameters
		MainActivity.this.startActivity(myIntent);
		
	 }
	
	public void PanicButtonClicked(View view) {
		
		Intent myIntent = new Intent(MainActivity.this, SignUp.class);
		//myIntent.putExtra("key", value); //Optional parameters
		MainActivity.this.startActivity(myIntent);
		MainActivity.this.finish();
	 }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
