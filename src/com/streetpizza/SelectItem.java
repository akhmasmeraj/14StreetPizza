package com.streetpizza;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SelectItem extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_item);
	}
	
public void SideLinesClicked(View view) {
		
		Intent myIntent = new Intent(SelectItem.this, SideLines.class);
		//myIntent.putExtra("key", value); //Optional parameters
		SelectItem.this.startActivity(myIntent);
		
	 }


public void PizzaClicked(View view) {
		
		Intent myIntent = new Intent(SelectItem.this, Pizza.class);
		//myIntent.putExtra("key", value); //Optional parameters
		SelectItem.this.startActivity(myIntent);
		
	 }
	

public void DrinksClicked(View view) {
		
		Intent myIntent = new Intent(SelectItem.this, Drinks.class);
		//myIntent.putExtra("key", value); //Optional parameters
		SelectItem.this.startActivity(myIntent);
		
	 }


public void SweetSomethingClicked(View view) {
		
		Intent myIntent = new Intent(SelectItem.this, SweetSomethings.class);
		//myIntent.putExtra("key", value); //Optional parameters
		SelectItem.this.startActivity(myIntent);
		
	 }


public void DealsClicked(View view) {
		
		Intent myIntent = new Intent(SelectItem.this, Deals.class);
		//myIntent.putExtra("key", value); //Optional parameters
		SelectItem.this.startActivity(myIntent);
		
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_item, menu);
		return true;
	}

	 @Override
	    public boolean onOptionsItemSelected(MenuItem item)
	    {
	         
	        switch (item.getItemId())
	        {
	 
	        case R.id.YourOrder:
	            Toast.makeText(SelectItem.this, "Your Order is Selected", Toast.LENGTH_SHORT).show();
	            Intent myIntent1 = new Intent(SelectItem.this, OrderList.class);
	    		//myIntent.putExtra("key", value); //Optional parameters
	    		SelectItem.this.startActivity(myIntent1);
	    		SelectItem.this.finish();
	            
	            return true;
	 

	 
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }    
	 
	
}
