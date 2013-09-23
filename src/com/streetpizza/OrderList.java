package com.streetpizza;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.FeatureInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
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
import android.widget.TableRow.LayoutParams;
import android.widget.Toast;

public class OrderList extends Activity {

	String[] fetchArray;
	int Price=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_list);
		
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		  String name = preferences.getString("Order","");
		  if(!name.equalsIgnoreCase(""))
		  {
		    //name = name+"  Sethi";  /* Edit the value here*/
			  Log.e("Order", name);
			  fetchArray = name.split(",");
			  Log.e("lenght", fetchArray.length+"");
		  }
		  
		  

			ScrollView scrollview = (ScrollView) findViewById(R.id.scrollView1);

			TableLayout tableLayout = new TableLayout(getApplicationContext());
			
			//tableLayout.setStretchAllColumns(true);  
		    //tableLayout.setShrinkAllColumns(true);  
		    
			
			TableRow tableRow;
			TextView textView , textView1 , textView2 , textView3;
			
	       // tableRow = new TableRow(getApplicationContext());
			
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

			
			
			        //Adding the Header
			        tableRow = new TableRow(getApplicationContext());
		            

				    //Adding textviews "Item"
				    textView3 = new TextView(getApplicationContext());
				    textView3.setText("Item");
				    textView3.setPadding(1, 1, 1, 1);
				    textView3.setTypeface(null, Typeface.BOLD);
				    textView3.setTextColor(Color.BLACK);
			        tableRow.addView(textView3);
			        
		            //Adding textviews
			        textView = new TextView(getApplicationContext());
			        textView.setText("Description");
			        textView.setPadding(1, 1, 1, 1);
			        textView.setTypeface(null, Typeface.BOLD);
			        textView.setTextColor(Color.BLACK);
			        tableRow.addView(textView);
			        
			        //Adding textviews
			        textView1 = new TextView(getApplicationContext());
			        textView1.setText("Quantity");
			        textView1.setPadding(1, 1, 1, 1);
			        textView1.setTypeface(null, Typeface.BOLD);
			        textView1.setTextColor(Color.BLACK);
			        tableRow.addView(textView1);
			      
			      //Adding textviews
			        textView2 = new TextView(getApplicationContext());
			        textView2.setText("Price");
			        textView2.setPadding(20, 1, 1, 1);
			        textView2.setTypeface(null, Typeface.BOLD);
			        textView2.setTextColor(Color.BLACK);
			        tableRow.addView(textView2);
			        
			        tableLayout.addView(tableRow);

			   
			        if(!name.equalsIgnoreCase(""))
			        {
			        
			        int counter = 1;
			        //Adding the Order data list
			       for (int i = 0; i < fetchArray.length; i=i+3) 
			        {                               
			        tableRow = new TableRow(getApplicationContext());
		            
			        //Adding textviews "Item"
			        textView3 = new TextView(getApplicationContext());
			        textView3.setText(counter++ +"");
			        textView3.setPadding(1, 1, 1, 1);
			        tableRow.addView(textView3);
			        
			        
		            //Adding textviews "Item Name"
			        String segments[] = fetchArray[i].split("-");
			     // Grab the last segment
			        fetchArray[i] = segments[0];
			        
			        textView = new TextView(getApplicationContext());
			        textView.setText(fetchArray[i]);
			        textView.setPadding(1, 1, 1, 1);
			        tableRow.addView(textView);
			        
			        //Adding textviews "Quantity"
			        textView1 = new TextView(getApplicationContext());
			        textView1.setText(fetchArray[i+2]);
			        textView1.setPadding(1, 1, 1, 1);
			        tableRow.addView(textView1);
			      
			      //Adding textviews "Price"
			        int price = Integer.parseInt(fetchArray[i+2])*Integer.parseInt(fetchArray[i+1]);
			        textView2 = new TextView(getApplicationContext());
			        textView2.setText(price+"");
			        Price +=price;
			        textView2.setPadding(20, 1, 1, 1);
			        tableRow.addView(textView2);
			        
			        tableLayout.addView(tableRow);
			    }
			       
			       TextView tv1,tv2,tv3,tv_Total,tv_NetTotal,tv_SalesTax;
			       //Adding total cost

		            //Adding textviews
			       tableRow = new TableRow(getApplicationContext());
			        
			       tv1 = new TextView(getApplicationContext());
			        tv1.setText("NET TOTAL");
			        tv1.setPadding(1, 1, 1, 1);
			        tv1.setTextColor(Color.BLACK);
			        tv1.setGravity(Gravity.CENTER_HORIZONTAL);
			        tableRow.addView(tv1);
			        LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
				    tv1.setLayoutParams(params);
				       
				    //Adding textviews
				        tv_Total = new TextView(getApplicationContext());
				        tv_Total.setText(String.valueOf(Price-(Price*16)/100));
				        tv_Total.setPadding(1, 1, 1, 1);
				        tv_Total.setTextColor(Color.BLACK);
				        tv_Total.setLayoutParams(params);
				        tv_Total.setGravity(Gravity.CENTER_HORIZONTAL);
				        
				       tableRow.addView(tv_Total);
				       tableLayout.addView(tableRow);
			        
			      
			        
			        //Adding textviews
			        tableRow = new TableRow(getApplicationContext());
				       
			        tv2 = new TextView(getApplicationContext());
			        tv2.setText("SALES TAX 16%");
			        tv2.setPadding(1, 1, 1, 1);
			        tv2.setTextColor(Color.BLACK);
			        tv2.setGravity(Gravity.CENTER_HORIZONTAL);
			        
			        tv2.setLayoutParams(params);
				    tableRow.addView(tv2);
			        
				  //Adding textviews
			        tv_SalesTax = new TextView(getApplicationContext());
			        tv_SalesTax.setText(String.valueOf((Price*16)/100));
			        tv_SalesTax.setPadding(1, 1, 1, 1);
			        tv_SalesTax.setTextColor(Color.BLACK);
			        tv_SalesTax.setLayoutParams(params);
			        tv_SalesTax.setGravity(Gravity.CENTER_HORIZONTAL);
			    
				    tableRow.addView(tv_SalesTax);
				    tableLayout.addView(tableRow);
			   
			        
			      //Adding textviews
			        tableRow = new TableRow(getApplicationContext());
				       
			        tv3 = new TextView(getApplicationContext());
			        tv3.setText("TOTAL");
			        tv3.setPadding(20, 1, 1, 1);
			        tv3.setTextColor(Color.BLACK);
			        tv3.setLayoutParams(params);
			        tv3.setGravity(Gravity.CENTER_HORIZONTAL);
				    tableRow.addView(tv3);
			        
				  //Adding textviews
			        tv_Total = new TextView(getApplicationContext());
			        tv_Total.setText(String.valueOf(Price));
			        tv_Total.setPadding(1, 1, 1, 1);
			        tv_Total.setTextColor(Color.BLACK);
			        tv_Total.setLayoutParams(params);
			        tv_Total.setGravity(Gravity.CENTER_HORIZONTAL);
			    
				    tableRow.addView(tv_Total);
				    tableLayout.addView(tableRow);

				    //Apply check till there
			        }
			        
			        
			        
			       tableRow = new TableRow(getApplicationContext());
		           
			       //Adding Button to the table layout
			       Button btn = new Button(this);
			       btn.setId(50);
			       final int id_ = btn.getId();
			       //btn.setText("button " + id_);
			       //btn.setBackgroundColor(Color.rgb(70, 80, 90));
			       btn.setBackgroundResource(R.drawable.completeyourorder);
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
					
					if(Price>0)
					{
						Log.e("OrderListPriceValue", String.valueOf(Price));
						Intent myIntent1 = new Intent(OrderList.this, SignUp.class);
						myIntent1.putExtra("key", Price); //Optional parameters
						OrderList.this.startActivity(myIntent1);
			    		OrderList.this.finish();
						
					}
					else
					{
						 Toast.makeText(OrderList.this, "Kindly add some items first", Toast.LENGTH_SHORT).show();
				   	}
					
				}
			});
			

		  
		
	}//End of Oncreate 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.order_list, menu);
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
            Toast.makeText(OrderList.this, "Add Item is Selected", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(OrderList.this, SelectItem.class);
    		//myIntent.putExtra("key", value); //Optional parameters
    		OrderList.this.startActivity(myIntent);
    		OrderList.this.finish();
    		return true;
 
        

 
        default:
            return super.onOptionsItemSelected(item);
        }
    }    



}






