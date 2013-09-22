package com.streetpizza;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class Pizza extends Activity {

	String[] itemList = {"Cheesy Bread - Rs 129",
						"Chicken Wings (BBQ) - Rs 229",
						"Chicken Wings (Crispy) - Rs 229",
						"Chicken Wings (Spicy) - Rs 229",
						"Chicky Bites (NonSpicy) - Rs 229",
						"Chicky Bites (Spicy) - Rs 229",
						"Garlic Bread - Rs 129",
						"Potato Skins - Rs 129",
						"Potato Wedges - Rs 129"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pizza);
		
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
		

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pizza, menu);
		return true;
	}

}
