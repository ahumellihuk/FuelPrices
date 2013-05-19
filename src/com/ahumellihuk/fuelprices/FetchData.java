package com.ahumellihuk.fuelprices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class FetchData extends AsyncTask<MainActivity, Void, String[]> {

	public static String TASK_FINISHED = "com.ahumellihuk.fuelprices.TASK_FINISHED";
	TextView[] table;
	MainActivity main;
	JSONParser jParser;
	protected String[] doInBackground(MainActivity... tables) {
		main = tables[0];
		table = main.table;		
		return fetch();
	}
	
	protected void onPostExecute(String [] prices) {
		double min95 = 0, min98 = 0, minD = 0, value;
		if (!prices[0].equals("false"))
		min95 = Double.parseDouble(prices[0]);
		if (!prices[7].equals("false"))
		min98 = Double.parseDouble(prices[7]);
		if (!prices[14].equals("false"))
		minD = Double.parseDouble(prices[14]);
		
		for (int i=1; i<7; i++) {
			if (!prices[i].equals("false")) { 
				if ((value = Double.parseDouble(prices[i]))<min95)
					min95 = value;
			}
		}
		for (int i=8; i<14; i++) {
			if (!prices[i].equals("false")) { 
				if ((value = Double.parseDouble(prices[i]))<min98)
					min98 = value;
			}
		}
		for (int i=15; i<21; i++) {
			if (!prices[i].equals("false")) { 
				if ((value = Double.parseDouble(prices[i]))<minD)
					minD = value;
			}
		}
		
		for (int i=0; i<21; i++) {			
			if (!prices[i].equals("false")){
				table[i].setText(prices[i]);
				if (((Double.parseDouble(prices[i])) == min95) && i<7) {
					table[i].setTypeface(null, Typeface.BOLD);
					table[i].setTextColor(Color.GREEN);
				}
				else if (((Double.parseDouble(prices[i])) == min98) && i>=7 && i<14) {
					table[i].setTypeface(null, Typeface.BOLD);
					table[i].setTextColor(Color.GREEN);
				}
				else if (((Double.parseDouble(prices[i])) == minD) && i>=14) {
					table[i].setTypeface(null, Typeface.BOLD);
					table[i].setTextColor(Color.GREEN);
				}
			}
			else table[i].setText("-");
		}
		Intent intent = new Intent();
		intent.setAction(TASK_FINISHED);
		intent.putExtra("result", 0);
		main.sendBroadcast(intent);
	}

	private String[] fetch() {
		String [] prices = new String[21];
		jParser = new JSONParser();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONArray json = jParser.makeHttpRequest("http://camoiloc.webuda.com/fetch_fuel_prices.php", "GET", params);

        try {
        	for (int i=0; i<21; i++) {
        		prices[i] = json.getString(i);
        		Log.v(""+i, prices[i]);
        	}            
        } catch (JSONException e) {
            e.printStackTrace();
        }
		return(prices);
	}
	
}
