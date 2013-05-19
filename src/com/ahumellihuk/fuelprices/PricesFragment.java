package com.ahumellihuk.fuelprices;

import java.util.Date;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PricesFragment extends Fragment {
	
	TextView [] table;
	MainActivity main;
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.table_layout, container, false);
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		main = (MainActivity) getActivity();
		TextView[] views = table;
		initTable();
		if (main.sharedPref.getBoolean("useLocalData", false)) {
			Date date = new Date();
			boolean needToUpdate = false;
			if (main.sharedPref.getInt("updateYear", 0) < date.getYear())
				needToUpdate = true;
			else if (main.sharedPref.getInt("updateMonth", 0) < date.getMonth())
				needToUpdate = true;
			else if (main.sharedPref.getInt("updateDay", 0) < date.getDate())
				needToUpdate = true;
			
			if (needToUpdate) {
				main.table = this.table;
				main.pricesFragment();
			}
			else {
				boolean present = true;
				for (int i=0; i<21; i++) {
					if (main.sharedPref.getString("price"+0, null) == null)
							present = false;
					if (main.sharedPref.getInt("color"+i, 0) == 0)
							present = false;
				}	
				if (present) {
					for (int i=0; i<21; i++) {
						table[i].setText(main.sharedPref.getString("price"+i, null));
						table[i].setTextColor(main.sharedPref.getInt("color"+i, -16777216));
					}
					main.table = this.table;
				}
				else if (views != null) {
					for (int i=0; i<21; i++) {
						String text = (String) views[i].getText();
						int color = views[i].getCurrentTextColor();
						table[i].setText(text);
						table[i].setTextColor(color);
					}
				}
				else if (savedInstanceState != null) {
					for (int i=0; i<21; i++) {
						String text = savedInstanceState.getString("text"+i);
						int color = savedInstanceState.getInt("color"+i);
						table[i].setText(text);
						table[i].setTextColor(color);
					}
				}
				else {
					main.table = this.table;
					main.pricesFragment();
				}
			}
		}		
		else {
			main.table = this.table;
			main.pricesFragment();
		}
			
		
		
		
	}
	
	public void initTable() {
    	table = new TextView[21];
    	
    	table[0] = (TextView)getView().findViewById(R.id.bens95_1);
    	table[1] = (TextView)getView().findViewById(R.id.bens95_2);
    	table[2] = (TextView)getView().findViewById(R.id.bens95_3);
    	table[3] = (TextView)getView().findViewById(R.id.bens95_4);
    	table[4] = (TextView)getView().findViewById(R.id.bens95_5);
    	table[5] = (TextView)getView().findViewById(R.id.bens95_6);
    	table[6] = (TextView)getView().findViewById(R.id.bens95_7);
    	//table[7] = (TextView)getView().findViewById(R.id.bens95_8);
    	
    	table[7] = (TextView)getView().findViewById(R.id.bens98_1);
    	table[8] = (TextView)getView().findViewById(R.id.bens98_2);
    	table[9] = (TextView)getView().findViewById(R.id.bens98_3);
    	table[10] = (TextView)getView().findViewById(R.id.bens98_4);
    	table[11] = (TextView)getView().findViewById(R.id.bens98_5);
    	table[12] = (TextView)getView().findViewById(R.id.bens98_6);
    	table[13] = (TextView)getView().findViewById(R.id.bens98_7);
    	//table[15] = (TextView)getView().findViewById(R.id.bens98_8);
    	
    	table[14] = (TextView)getView().findViewById(R.id.diisel_1);
    	table[15] = (TextView)getView().findViewById(R.id.diisel_2);
    	table[16] = (TextView)getView().findViewById(R.id.diisel_3);
    	table[17] = (TextView)getView().findViewById(R.id.diisel_4);
    	table[18] = (TextView)getView().findViewById(R.id.diisel_5);
    	table[19] = (TextView)getView().findViewById(R.id.diisel_6);
    	table[20] = (TextView)getView().findViewById(R.id.diisel_7);
    	//table[23] = (TextView)getView().findViewById(R.id.diisel_8);
    }
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		for (int i=0; i<21; i++) {
			String text = (String) table[i].getText();
			int color = table[i].getCurrentTextColor();
			
			outState.putString("text"+i, text);
			outState.putInt("color"+i, color);
		}
		
	}
 
}
