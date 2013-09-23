package com.streetpizza;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TableRow.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Drinks extends Activity {

	String[][] itemList = {
			{"Apple Juice - Rs 60","60"},
			{"Coke 1.5L - Rs 100","100"},
			{"Coke 500ml - Rs 60","60"},
			{"Diet Coke 1.5L - Rs 100","100"},
			{"Diet Coke 500ml - Rs 65","65"},
			{"Fanta 1.5L - Rs 100","100"},
			{"Fanta 500ml - Rs 60","60"},
			{"Mango Juice - Rs 60","60"},
			{"Minute Maid Orange - Rs 60","60"},
			{"Minute Maid Tropical - Rs 60","60"},
			{"Orange Juice - Rs 60","60"},
			{"Peach Juice - Rs 60","60"},
			{"Pineapple Juice - Rs 60","60"},
			{"Red Bull - Rs 175","60"},
			{"Sprite 1.5L - Rs 100","60"},
			{"Sprite 500ml - Rs 60","60"},
			{"Sprite Zero 1.5L - Rs 100","60"},
			{"Water (500ml) - Rs 40","60"}
};

	SharedPreferences preferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drinks);
		 
		preferences = PreferenceManager.getDefaultSharedPreferences(this);
		
		
		ScrollView scrollview = (ScrollView) findViewById(R.id.scrollView1);

		TableLayout tableLayout = new TableLayout(getApplicationContext());
		    TableRow tableRow;
		        TextView textView;
		        CheckBox[] check = new CheckBox[20];

		        /*
		        tableRow = new TableRow(getApplicationContext());
			     //Adding textviews
			        textView = new TextView(getApplicationContext());
			        textView.setText("hello fdfdfdfd dfdfdfdf dfdfdfdfdd fdfdfdfdfd");
			        textView.setText(Html.fromHtml("Oncdcdcdddfdfdf " + "<br> "+ " at dsdsdsds"));
			        textView.setPadding(15, 15, 15, 15);
			        tableRow.addView(textView);
			        tableLayout.addView(tableRow);
		        */
		        

		       for (int i = 0; i < itemList.length; i++) 
		        {                               
		        tableRow = new TableRow(getApplicationContext());

		        //Adding Check boxes
		        check[i]= new CheckBox(this);  
	            tableRow.addView(check[i]);
	            
	            //Adding textviews
		        textView = new TextView(getApplicationContext());
		        textView.setText(itemList[i][0]);
		        textView.setPadding(15, 15, 15, 15);
		       
		        tableRow.addView(textView);
		        
		        //Adding Spinner
		        Spinner spinner = new Spinner(this);
		        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
		                this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.country_arrays));
		        spinnerArrayAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

		        //spinner = (Spinner) findViewById( R.id.spinner );
		        spinner.setAdapter(spinnerArrayAdapter);
		        spinner.setId(i);
		        spinner.setVisibility(View.GONE);
		        tableRow.addView(spinner);
		        

		        tableLayout.addView(tableRow);
		    }
		       
		       tableRow = new TableRow(getApplicationContext());

		       Button btn = new Button(this);
		       btn.setId(50);
		       final int id_ = btn.getId();
		       //btn.setText("button " + id_);
		       //btn.setBackgroundColor(Color.rgb(70, 80, 90));
		       btn.setBackgroundResource(R.drawable.addtoorder);
		      // btn.setMinimumHeight(150);
		      // btn.setMinimumWidth(250);
		       //LayoutParams lp = new TableRow.LayoutParams(android.widget.TableRow.LayoutParams.WRAP_CONTENT,android.widget.TableRow.LayoutParams.MATCH_PARENT);
		       //btn.setLayoutParams(lp);
		       //btn.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f));
		       LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
		       btn.setLayoutParams(params);
		       
		       tableRow.addView(btn);
		        tableLayout.addView(tableRow);
		       
		       
		scrollview.addView(tableLayout );
		
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Log.e("Button", "Button Clicked");
				
				
				String Temp = preferences.getString("Order","");
				
				for( int j=0;j< itemList.length;j++)
				{
					final int a =j;
					Spinner spinner = (Spinner) findViewById(j);
					if(spinner.getVisibility() == View.VISIBLE)
			    	{
			    	 //spinner.setVisibility(View.GONE);
					//SelectedItems.add(itemList[a]);
			    	Log.e("Selected Items", itemList[a][0] +" "+spinner.getSelectedItem().toString());
			    	Temp=Temp + itemList[a][0] + "," + itemList[a][1] + "," + spinner.getSelectedItem().toString() + ",";
			    	
			    	
			    	}
					
				}
				
				
				  SharedPreferences.Editor editor = preferences.edit();
				  editor.putString("Order",Temp);
				  editor.commit();
				
				
				
			}
		});
		
		 for (int i = 0; i < itemList.length; i++) 
	        {                               
			final int a =i;
		check[i].setOnClickListener(new OnClickListener()
		{
			
		    public void onClick(View v)
		    {
		        // your code to be executed on click :)
		    	Log.e("CheckValue", String.valueOf(a));
		    	
		    	
		    	 Spinner spinner = (Spinner) findViewById(a);
		    	 String Text = spinner.getSelectedItem().toString();
		    	 Log.e("Spinner Value", Text);
		    	if(spinner.getVisibility() == View.VISIBLE)
		    	{
		    	 spinner.setVisibility(View.GONE);
		    	}
		    	else
		    	{
		    		spinner.setVisibility(View.VISIBLE);
		    		
		    	}
		    	
		    }
		});
	       }//end of for loop
		

		
		
	}// End of Oncreate
 
		
		
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drinks, menu);
		return true;
	}
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item)
	    {
	         
	        switch (item.getItemId())
	        {
	        case R.id.AddItem:
	            // Single menu item is selected do something
	            // Ex: launching new activity/screen or show alert message
	            Toast.makeText(Drinks.this, "Add Item is Selected", Toast.LENGTH_SHORT).show();
	            Intent myIntent = new Intent(Drinks.this, SelectItem.class);
	    		//myIntent.putExtra("key", value); //Optional parameters
	    		Drinks.this.startActivity(myIntent);
	    		Drinks.this.finish();
	    		return true;
	 
	        case R.id.YourOrder:
	            Toast.makeText(Drinks.this, "Your Order is Selected", Toast.LENGTH_SHORT).show();
	            Intent myIntent1 = new Intent(Drinks.this, OrderList.class);
	    		//myIntent.putExtra("key", value); //Optional parameters
	    		Drinks.this.startActivity(myIntent1);
	    		Drinks.this.finish();
	            
	            return true;
	 

	 
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }    
	 

}
