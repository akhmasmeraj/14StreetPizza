package com.streetpizza;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends Activity {

	int intValue;
	
	// Progress Dialog
    private ProgressDialog pDialog;
 
	
    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    
    //php login script
    
    //localhost :  
    //testing on your device
    //put your local ip instead,  on windows, run CMD > ipconfig
    //or in mac's terminal type ifconfig and look for the ip under en0 or en1
   // private static final String LOGIN_URL = "http://xxx.xxx.x.x:1234/webservice/register.php";
    
    //testing on Emulator:
    private static final String LOGIN_URL = "http://10.0.2.2/webservice/register.php";
    //http://10.0.2.2/mad1/login.php
  //testing from a real server:
    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/register.php";
    
    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
	
    SharedPreferences preferences;
    String Order;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
		
		preferences = PreferenceManager.getDefaultSharedPreferences(this);
		  
		
		TextView name= (TextView) findViewById(R.id.Name);
		
		 Intent mIntent = getIntent();
		 intValue = mIntent.getIntExtra("key", 0);
		 Log.e("Key Value", String.valueOf(intValue));
		
	}

public void PlaceOrder(View view) {
		
	
	EditText name= (EditText) findViewById(R.id.Name);
	EditText email= (EditText) findViewById(R.id.Email);
	EditText phone= (EditText) findViewById(R.id.Phone);
	EditText address= (EditText) findViewById(R.id.Adress);
	
	
		
	Log.e("Name", name.getText().toString());
	Log.e("email", email.getText().toString());
	
	if(intValue==0)
	{
	
	if((name.getText().toString().trim().equals("") || email.getText().toString().trim().equals("") || phone.getText().toString().trim().equals("") || address.getText().toString().trim().equals("")))
	{
		new AlertDialog.Builder(this)
	    .setTitle("ERROR")
	    .setMessage("Kindly fill all the given fields")
	    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            // continue with delete
	        }
	     })
	     .show();
		
	}
	else
	{
		//Add JSON here
		
		
		
		
		new AlertDialog.Builder(this)
	    .setTitle("Thanks")
	    .setMessage("Your Hunger Emergencies will be served!")
	    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	            // continue with delete
	        	
	        	//Intent myIntent = new Intent(SignUp.this, MainActivity.class);
	    		//myIntent.putExtra("key", value); //Optional parameters
	    		//SignUp.this.startActivity(myIntent);
	    		//SignUp.this.finish();
	    	
	        	
	        }
	     })
	     .show();
		
		
	}
	
	}//End of upper if  check
	
	else
	{
		

		if((name.getText().toString().trim().equals("") || email.getText().toString().trim().equals("") || phone.getText().toString().trim().equals("") || address.getText().toString().trim().equals("")))
		{
			new AlertDialog.Builder(this)
		    .setTitle("ERROR")
		    .setMessage("Kindly fill all the given fields")
		    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        }
		     })
		     .show();
			
		}
		else
		{
			//Add JSON here
			
			new CreateOrder().execute();
			
			 SharedPreferences settings =  PreferenceManager.getDefaultSharedPreferences(getBaseContext());                          
			 int OrderNumber = settings.getInt("OrderNumber", 0);
			 
			 SharedPreferences.Editor editor = settings.edit();
		     OrderNumber++;  
			editor.putInt("OrderNumber", OrderNumber);
			//editor.clear();  
			editor.commit();
			
			
			new AlertDialog.Builder(this)
		    .setTitle("Thanks")
		    .setMessage("Your Ordre Has Been Placed Successfully!")
		    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        	
		        	//Intent myIntent = new Intent(SignUp.this, MainActivity.class);
		    		//myIntent.putExtra("key", value); //Optional parameters
		    		//SignUp.this.startActivity(myIntent);
		    		//SignUp.this.finish();
		    	
		        	
		        }
		     })
		     .show();
			
			
		}
		

		
		
		
	}//end of else
	
		//Intent myIntent = new Intent(MainActivity.this, SignUp.class);
		//myIntent.putExtra("key", value); //Optional parameters
		//MainActivity.this.startActivity(myIntent);
		
	 }//end of oncreate


class CreateOrder extends AsyncTask<String, String, String> {

	 /**
    * Before starting background thread Show Progress Dialog
    * */
	
	EditText name= (EditText) findViewById(R.id.Name);
	EditText email= (EditText) findViewById(R.id.Email);
	EditText phone= (EditText) findViewById(R.id.Phone);
	EditText address= (EditText) findViewById(R.id.Adress);
	
	
	boolean failure = false;
	
   @Override
   protected void onPreExecute() {
       super.onPreExecute();
       //pDialog = new ProgressDialog(SignUp.this);
       //pDialog.setMessage("Creating User...");
       //pDialog.setIndeterminate(false);
       //pDialog.setCancelable(true);
       //pDialog.show();
   }
	
	@Override
	protected String doInBackground(String... args) {
		// TODO Auto-generated method stub
		 // Check for success tag
       int success;
       //String username = user.getText().toString();
       //String password = pass.getText().toString();
       
		
       
       try {
    	   Order = preferences.getString("Order","");
    	   Log.e("orderInAsyn", Order);
           // Building Parameters
           List<NameValuePair> params = new ArrayList<NameValuePair>();
           params.add(new BasicNameValuePair("order", Order));
           params.add(new BasicNameValuePair("name", name.getText().toString()));
           params.add(new BasicNameValuePair("email", email.getText().toString()));
           params.add(new BasicNameValuePair("phone", phone.getText().toString()));
           params.add(new BasicNameValuePair("address", address.getText().toString()));

           Log.d("request!", "starting");
           
           //Posting user data to script 
           JSONObject json = JSONParser.makeHttpRequest(
                  LOGIN_URL, "POST", params);

           // full json response
           Log.d("Login attempt", json.toString());

           // json success element
           success = json.getInt(TAG_SUCCESS);
           if (success == 1) {
           	Log.d("User Created!", json.toString());              	
           	finish();
           	return json.getString(TAG_MESSAGE);
           }else{
           	Log.d("Login Failure!", json.getString(TAG_MESSAGE));
           	return json.getString(TAG_MESSAGE);
           	
           }
       } catch (JSONException e) {
           e.printStackTrace();
       }

       return null;
		
	}
	/**
    * After completing background task Dismiss the progress dialog
    * **/
   protected void onPostExecute(String file_url) {
       // dismiss the dialog once product deleted
       //pDialog.dismiss();
       if (file_url != null){
       	//Toast.makeText(SignUp.this, file_url, Toast.LENGTH_LONG).show();
       }

   }

}
	
	


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

}
