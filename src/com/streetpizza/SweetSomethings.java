package com.streetpizza;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableRow.LayoutParams;

public class SweetSomethings extends Activity {

	String[] itemList = {"Chocolate Cake (Full) - Rs 2099",
			"Chocolate Cake (Slice) - Rs 249"
};

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sweet_somethings);
	
		
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
		        textView.setText(itemList[i]);
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
		getMenuInflater().inflate(R.menu.sweet_somethings, menu);
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
	            Toast.makeText(SweetSomethings.this, "Add Item is Selected", Toast.LENGTH_SHORT).show();
	            Intent myIntent = new Intent(SweetSomethings.this, SelectItem.class);
	    		//myIntent.putExtra("key", value); //Optional parameters
	    		SweetSomethings.this.startActivity(myIntent);
	    		SweetSomethings.this.finish();
	    		return true;
	 
	        case R.id.YourOrder:
	            Toast.makeText(SweetSomethings.this, "Your Order is Selected", Toast.LENGTH_SHORT).show();
	            Intent myIntent1 = new Intent(SweetSomethings.this, OrderList.class);
	    		//myIntent.putExtra("key", value); //Optional parameters
	    		SweetSomethings.this.startActivity(myIntent1);
	    		SweetSomethings.this.finish();
	            
	            return true;
	 

	 
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }    

	
	
}
