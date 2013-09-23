package com.streetpizza;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Html;
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
import android.widget.Toast;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class Pizza extends Activity {

	String[][] itemList = {
						{"Slice (Rs 299)","299"},
						{"Half (Rs 999)","999"},
						{"Split the half (Rs 999)","999"},
						{"Half & Half (Rs 1799)","1799"},
						{"Full (Rs 1799)","1799"}
	};
	
	SharedPreferences preferences;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pizza);
		
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

		        tableRow = new TableRow(getApplicationContext());

		        
	            //Adding textviews
		        textView = new TextView(getApplicationContext());
		        textView.setText("SIZE");
		        textView.setPadding(15, 15, 15, 15);
		        LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
			    textView.setLayoutParams(params);
			    
		        tableRow.addView(textView);
		        tableLayout.addView(tableRow);

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
		       
		       //adding sauce
		        tableRow = new TableRow(getApplicationContext());

		        //Adding textviews
		        textView = new TextView(getApplicationContext());
		        textView.setText("SAUCE");
		        textView.setPadding(15, 15, 15, 15);
		       // LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
			    textView.setLayoutParams(params);
			    tableRow.addView(textView);
		        tableLayout.addView(tableRow);

		        
		        tableRow = new TableRow(getApplicationContext());
		        final CheckBox[] check1 = new CheckBox[3];
		        check1[0]= new CheckBox(this);  
		        check1[0].setText("Mild");
		        check1[0].setLayoutParams(params);
	            tableRow.addView(check1[0]);
	            tableLayout.addView(tableRow);
	            
	            tableRow = new TableRow(getApplicationContext());
		        check1[1]= new CheckBox(this);  
		        check1[1].setText("Hot");
		        check1[1].setLayoutParams(params);
	            tableRow.addView(check1[1]);
	            tableLayout.addView(tableRow);
	            
	            tableRow = new TableRow(getApplicationContext());
		        check1[2]= new CheckBox(this);  
		        check1[2].setText("Extra Hot");
		        check1[2].setLayoutParams(params);
	            tableRow.addView(check1[2]);
		        tableLayout.addView(tableRow);


		      //adding sauce
		        tableRow = new TableRow(getApplicationContext());

		        //Adding textviews
		        textView = new TextView(getApplicationContext());
		        textView.setText("FLAVOR");
		        textView.setPadding(15, 15, 15, 15);
		       // LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
			    textView.setLayoutParams(params);
			    tableRow.addView(textView);
		        tableLayout.addView(tableRow);

		        
		        tableRow = new TableRow(getApplicationContext());
		        final CheckBox[] check2 = new CheckBox[7];
		        check2[0]= new CheckBox(this);  
		        check2[0].setText("Cheese");
		        check2[0].setLayoutParams(params);
	            tableRow.addView(check2[0]);
	            tableLayout.addView(tableRow);
	            
	            tableRow = new TableRow(getApplicationContext());
		        check2[1]= new CheckBox(this);  
		        check2[1].setText("Chicken Fajita");
		        check2[1].setLayoutParams(params);
	            tableRow.addView(check2[1]);
	            tableLayout.addView(tableRow);
	            
	            tableRow = new TableRow(getApplicationContext());
		        check2[2]= new CheckBox(this);  
		        check2[2].setText("Chicken Tikka");
		        check2[2].setLayoutParams(params);
	            tableRow.addView(check2[2]);
		        tableLayout.addView(tableRow);

	            tableRow = new TableRow(getApplicationContext());
		        check2[3]= new CheckBox(this);  
		        check2[3].setText("Ground Beef");
		        check2[3].setLayoutParams(params);
	            tableRow.addView(check2[3]);
		        tableLayout.addView(tableRow);

	            tableRow = new TableRow(getApplicationContext());
		        check2[4]= new CheckBox(this);  
		        check2[4].setText("Pepperoni");
		        check2[4].setLayoutParams(params);
	            tableRow.addView(check2[4]);
		        tableLayout.addView(tableRow);

	            tableRow = new TableRow(getApplicationContext());
		        check2[5]= new CheckBox(this);  
		        check2[5].setText("Turkey Chunks");
		        check2[5].setLayoutParams(params);
	            tableRow.addView(check2[5]);
		        tableLayout.addView(tableRow);

	            tableRow = new TableRow(getApplicationContext());
		        check2[6]= new CheckBox(this);  
		        check2[6].setText("Vegetarian");
		        check2[6].setLayoutParams(params);
	            tableRow.addView(check2[6]);
		        tableLayout.addView(tableRow);

		        
		       
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
		       
		       //LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
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
				int check_sauce=0,check_flavor=0;
				
				for( int j=0;j< itemList.length;j++)
				{
					final int a =j;
					String sauce="";
					String flavor="";
					
					for(int x=0;x<3;x++)
					{
						if(check1[x].isChecked())
						{
							sauce= check1[x].getText().toString();
							check_sauce=1;
						}
					}
					
					for(int x=0;x<7;x++)
					{
						if(check2[x].isChecked())
						{
							flavor= check2[x].getText().toString();
							check_flavor=1;
						}
					}
					
					
					Spinner spinner = (Spinner) findViewById(j);
					if(spinner.getVisibility() == View.VISIBLE)
			    	{
			    	 //spinner.setVisibility(View.GONE);
					//SelectedItems.add(itemList[a]);
			    	Log.e("Selected Items", itemList[a][0] +" "+spinner.getSelectedItem().toString());
			    	Temp=Temp + itemList[a][0] +"-"+ sauce +"-"+ flavor + "," + itemList[a][1] + "," + spinner.getSelectedItem().toString() + ",";
			    	
			    	
			    	}
					
				}
				
				if(check_flavor==1 && check_sauce==1)
				{
				  SharedPreferences.Editor editor = preferences.edit();
				  editor.putString("Order",Temp);
				  editor.commit();
					Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_LONG).show();

				}
				else
				{
					Toast.makeText(getApplicationContext(), "Kindly select sauce and flavor", Toast.LENGTH_LONG).show();
				}
				
				
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
		
		 for (int i = 0; i < 3; i++) 
	        {                               
			final int a =i;
			//check1[i].setChecked(false);
		check1[i].setOnClickListener(new OnClickListener()
		{
			
		    public void onClick(View v)
		    {
		        // your code to be executed on click :)
		    	Log.e("CheckValue", String.valueOf(a));
		    	//check1[a].setChecked(true);
		    	for(int j =0;j<3;j++)
		    	{
		    		if(j!=a)
		    		{
		    			check1[j].setChecked(false);
		    		}
		    	}
		    	 
		    	
		    }
		});
	       }//end of for loop
		 
		 for (int i = 0; i < 7; i++) 
	        {                               
			final int a =i;
			//check1[i].setChecked(false);
		check2[i].setOnClickListener(new OnClickListener()
		{
			
		    public void onClick(View v)
		    {
		        // your code to be executed on click :)
		    	Log.e("CheckValue", String.valueOf(a));
		    	//check1[a].setChecked(true);
		    	for(int j =0;j<3;j++)
		    	{
		    		if(j!=a)
		    		{
		    			check2[j].setChecked(false);
		    		}
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

	@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
        case R.id.AddItem:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(Pizza.this, "Add Item is Selected", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(Pizza.this, SelectItem.class);
    		//myIntent.putExtra("key", value); //Optional parameters
            Pizza.this.startActivity(myIntent);
    		Pizza.this.finish();
    		return true;
 
        case R.id.YourOrder:
            Toast.makeText(Pizza.this, "Your Order is Selected", Toast.LENGTH_SHORT).show();
            Intent myIntent1 = new Intent(Pizza.this, OrderList.class);
    		//myIntent.putExtra("key", value); //Optional parameters
            Pizza.this.startActivity(myIntent1);
    		Pizza.this.finish();
            
            return true;
 

 
        default:
            return super.onOptionsItemSelected(item);
        }
    }    

	
}
