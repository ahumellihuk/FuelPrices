package com.ahumellihuk.fuelprices;

import java.text.DecimalFormat;
import java.util.Date;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends Activity {
	
	private static final LatLng TALLINN = new LatLng(59.43,24.75);
	protected static final String MAP_LOADED = "com.ahumellihuk.fuelprices.MAP_LOADED";
	String pricesTab, mapTab, preferencesTab;
	SharedPreferences sharedPref;
	ProgressDialog progress;
	TextView [] table;
	ActionBar actionBar;
	PricesFragment pricesFragment;
	MapFragment mapFragment;
	TanklaList tanklaList;
	MarkerOptions[] markers;
	SettingsFragment settingsFragment;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        sharedPref = this.getPreferences(Context.MODE_PRIVATE); 
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
        
        pricesFragment = new PricesFragment();
        settingsFragment = new SettingsFragment();
        tanklaList= new TanklaList();
        mapFragment = new MapFragment() {
        	
        	@Override
        	public void onActivityCreated(Bundle savedInstanceState) {
        		super.onActivityCreated(savedInstanceState);
        		Intent intent = new Intent();
        		intent.setAction(MAP_LOADED);
        		intent.putExtra("result", 0);
        		getActivity().sendBroadcast(intent);
        	}
        };
        
        pricesTab = getString(R.string.prices);
        mapTab = getString(R.string.map);
        preferencesTab = getString(R.string.preferences);
        
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            public void onTabSelected(ActionBar.Tab tab,
                    FragmentTransaction ft) {
            	String name = (String) tab.getText();
            	if (name.equals(pricesTab)) {
            		ft.replace(R.id.fragment1, pricesFragment);
            	}
            	else if (name.equals(mapTab)) {
            		
            		ft.replace(R.id.fragment1, mapFragment); 
            		
            	}
            	else if (name.equals(preferencesTab)) {
            		ft.replace(R.id.fragment1, settingsFragment);
            	}
            	else if (name.equals("Tanklad")) {
            		ft.replace(R.id.fragment1, tanklaList);
            	}
            	
            }

            public void onTabUnselected(ActionBar.Tab tab,
                    FragmentTransaction ft) { 
            	String name = (String) tab.getText();
            	if (name.equals(pricesTab)) {
            		ft.remove(pricesFragment);
            	}
            	else if (name.equals(mapTab)) {
            		ft.remove(mapFragment);
            	}
            	else if (name.equals(preferencesTab)) {
            		ft.remove(settingsFragment);
            	}
            	else if (name.equals("Tanklad")) {
            		ft.remove(tanklaList);
            	}
            }

            public void onTabReselected(ActionBar.Tab tab,
                    FragmentTransaction ft) { 
            	
            }
        };
        actionBar.addTab(actionBar.newTab().setText(pricesTab).setTabListener(tabListener), true);
        actionBar.addTab(actionBar.newTab().setText(mapTab).setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Tanklad").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText(preferencesTab).setTabListener(tabListener));
        
        IntentFilter filter = new IntentFilter();
        filter.addAction(FetchData.TASK_FINISHED);
        filter.addAction(MAP_LOADED);
    	registerReceiver(new BroadcastReceiver() {

			@Override
			public void onReceive(Context arg0, Intent intent) {
				if (intent.getAction().equals(MAP_LOADED)) {
					GoogleMap map = mapFragment.getMap();
            		map.setMyLocationEnabled(true);
            		map.moveCamera(CameraUpdateFactory.newLatLngZoom(TALLINN, 11));
            		for (int i=0; i<8; i++)
            			map.addMarker(markers[i]);
				}
				else if (intent.getAction().equals(FetchData.TASK_FINISHED)){
					progress.dismiss();
					Date date = new Date();
					SharedPreferences.Editor editor = sharedPref.edit();
		        	boolean match = true;
					for (int i=0; i<24; i++) {
						String text = sharedPref.getString("price"+0, null);
						int color = sharedPref.getInt("color"+i, -16777216);
						if (!((String)table[i].getText()).equals(text))
							match = false;
						if (table[i].getCurrentTextColor() != color)
							match = false;
					}		        	
		        	if (!match) {		        	
			        	
			        	for (int i=0; i<24; i++) {
			            	editor.putString("price"+i, (String) table[i].getText());
			            	editor.putInt("color"+i, table[i].getCurrentTextColor());            	           	
			            }        	
		        	} 
		        	editor.putInt("updateDay", date.getDate());
		        	editor.putInt("updateMonth", date.getMonth());
		        	editor.putInt("updateYear", date.getYear());
		        	editor.commit();    
				}
			}
    		
    	}, filter);
        
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment1, pricesFragment);
        ft.commit();
        
        
        
       markers = new MarkerOptions[8];
       markers[0] = new MarkerOptions().position(new LatLng(59.412179, 24.661662)).title("Alexela").snippet("Ehitajate tee 101");
       markers[1] = new MarkerOptions().position(new LatLng(59.419360, 24.638202)).title("Euro Oil").snippet("Paldiski mnt. 108");
       markers[2] = new MarkerOptions().position(new LatLng(59.414803,24.738686)).title("Favora").snippet("Tondi 6");
       markers[3] = new MarkerOptions().position(new LatLng(59.434629,24.832231)).title("Neste").snippet("Punane 43");
       markers[4] = new MarkerOptions().position(new LatLng(59.409998,24.675529)).title("Olerex").snippet("Laki 29");
       markers[5] = new MarkerOptions().position(new LatLng(59.405657,24.699949)).title("Statoil").snippet("Sopruse pst 200b");
       markers[6] = new MarkerOptions().position(new LatLng(59.42768,24.628742)).title("Statoil 1-2-3").snippet("Vana-Rannamoisa tee 1");
       markers[7] = new MarkerOptions().position(new LatLng(59.412827,24.708812)).title("5+").snippet("Linnu tee 64");
		       
    }
   
    public void pricesFragment() {        
        if (checkNetworkState()) {           	
        	FetchData task = new FetchData();
        	task.execute(this);
        	progress = new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);
        	progress.setIndeterminate(true);
        	progress.show();
        	
        }
        else {
        	AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        	alertDialog.setTitle("Alert");
        	alertDialog.setMessage("No Internet Access!");
        	alertDialog.show();
        }  
    }
    
    public void calculatePrices(View view) {
   	
    	for (int i=0; i<24; i++) {
    		EditText editText = (EditText)findViewById(R.id.liters);
    		int liters = Integer.parseInt(editText.getText().toString());
    		String value = sharedPref.getString("price"+i, null);  
    		double dValue = Double.parseDouble(value);
    		double newDValue = dValue * liters;
    		DecimalFormat df = new DecimalFormat("#.###");
    		String newValue = ""+df.format(newDValue)+"ˆ";
    		table[i].setText(newValue);
    	}
    }
    
    public void reset(View view) {
    	for (int i=0; i<24; i++) {
        	String value = sharedPref.getString("price"+i, null);    
        	if (value != null)
        		table[i].setText(value);
        }        	
    }
    
    public boolean checkNetworkState() {
    	ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    	if (networkInfo != null && networkInfo.isConnected()) 
    		return true;
    	else return false;
    }
}
