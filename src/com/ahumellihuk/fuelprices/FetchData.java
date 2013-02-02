package com.ahumellihuk.fuelprices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
	protected String[] doInBackground(MainActivity... tables) {
		main = tables[0];
		table = main.table;		
		return fetch();
	}
	
	protected void onPostExecute(String [] prices) {
		double min95 = Double.parseDouble(prices[0]);
		double min98 = Double.parseDouble(prices[8]);
		double minD = Double.parseDouble(prices[16]);
		double value;
		for (int i=1; i<8; i++) {
			if ((value = Double.parseDouble(prices[i]))<min95)
				min95 = value;
		}
		for (int i=9; i<16; i++) {
			if ((value = Double.parseDouble(prices[i]))<min98)
				min98 = value;
		}
		for (int i=17; i<24; i++) {
			if ((value = Double.parseDouble(prices[i]))<minD)
				minD = value;
		}
		
		for (int i=0; i<24; i++) {
			table[i].setText(prices[i]);
			if (((Double.parseDouble(prices[i])) == min95) && i<8) {
				table[i].setTypeface(null, Typeface.BOLD);
				table[i].setTextColor(Color.GREEN);
			}
			else if (((Double.parseDouble(prices[i])) == min98) && i>=8 && i<16) {
				table[i].setTypeface(null, Typeface.BOLD);
				table[i].setTextColor(Color.GREEN);
			}
			else if (((Double.parseDouble(prices[i])) == minD) && i>=16) {
				table[i].setTypeface(null, Typeface.BOLD);
				table[i].setTextColor(Color.GREEN);
			}
		}
		Intent intent = new Intent();
		intent.setAction(TASK_FINISHED);
		intent.putExtra("result", 0);
		main.sendBroadcast(intent);
	}

	private String[] fetch() {
		String [] prices = new String[24];
		try {
		    URL url = new URL("http://www.1181.ee/kytusehinnad/Area/1");
		    URLConnection connect = url.openConnection();
		    BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
		    String inputLine;
		    while ((inputLine = in.readLine()) != null) {
		    	if (inputLine.matches("                <td align=\"center\">95</td>")) {
		    		in.readLine();
		    		for (int i=0; i<8; i++) {		    			
		    			inputLine = in.readLine();
		    			inputLine = inputLine.replaceAll(" ", "");
		    			if (inputLine.charAt(17) == '>' && inputLine.charAt(23) == '<') {
		    				inputLine = inputLine.substring(18,23);
		    			}
		    			else inputLine = inputLine.substring(55,60);
		    			
		    			prices[i] = inputLine;
		    			Log.d("print", inputLine);
		    		}		            				
		    	}
		    	else if (inputLine.matches("                <td align=\"center\">98</td>")) {
		    		in.readLine();
		    		for (int i=0; i<8; i++) {
		    			inputLine = in.readLine();
		    			inputLine = inputLine.replaceAll(" ", "");
		    			if (inputLine.charAt(17) == '>' && inputLine.charAt(23) == '<') {
		    				inputLine = inputLine.substring(18,23);
		    			}
		    			else inputLine = inputLine.substring(55,60);
		    			prices[i+8] = inputLine;
		    			Log.d("print", inputLine);
		    		}	
		    	}
		    	else if (inputLine.matches("                <td align=\"center\">Diisel</td>")) {
		    		in.readLine();
		    		for (int i=0; i<8; i++) {
		    			inputLine = in.readLine();
		    			inputLine = inputLine.replaceAll(" ", "");
		    			if (inputLine.charAt(17) == '>' && inputLine.charAt(23) == '<') {
		    				inputLine = inputLine.substring(18,23);
		    			}
		    			else inputLine = inputLine.substring(55,60);
		    			prices[i+16] = inputLine;
		    			Log.d("print", inputLine);
		    		}	
		    	}
		       
		
		    }
		    in.close();
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return(prices);
	}
	
}
