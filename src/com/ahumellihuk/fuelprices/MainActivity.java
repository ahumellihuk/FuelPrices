package com.ahumellihuk.fuelprices;

import java.text.DecimalFormat;
import java.util.Date;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
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
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;

public class MainActivity extends Activity implements StationClickCallback {

    private enum Tab {
        PRICES, MAP, STATIONS, PREFERENCES;
    }

    ActionBar actionBar;
    PricesFragment pricesFragment;
    FuelMapFragment mapFragment;
    StationList stationList;
    SettingsFragment settingsFragment;
    android.app.ActionBar.Tab pricesTab, mapTab, stationsTab, preferencesTab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        pricesFragment = new PricesFragment();
        settingsFragment = new SettingsFragment();
        stationList = new StationList(this);
        mapFragment = new FuelMapFragment();

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                Tab tag = (Tab) tab.getTag();
                switch (tag) {
                    case PRICES:
                        ft.replace(R.id.fragment1, pricesFragment);
                        break;
                    case MAP:
                        ft.replace(R.id.fragment1, mapFragment);
                        break;
                    case STATIONS:
                        ft.replace(R.id.fragment1, stationList);
                        break;
                    case PREFERENCES:
                        ft.replace(R.id.fragment1, settingsFragment);
                        break;
                }
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            }
        };

        pricesTab = actionBar.newTab().setText(getString(R.string.prices)).setTag(Tab.PRICES).setTabListener(tabListener);
        stationsTab = actionBar.newTab().setText(getString(R.string.stations)).setTag(Tab.STATIONS).setTabListener(tabListener);
        preferencesTab = actionBar.newTab().setText(getString(R.string.preferences)).setTag(Tab.PREFERENCES).setTabListener(tabListener);

        actionBar.addTab(pricesTab, true);
        try {
            MapsInitializer.initialize(MainActivity.this);
            mapTab = actionBar.newTab().setText(getString(R.string.map)).setTag(Tab.MAP).setTabListener(tabListener);
            actionBar.addTab(mapTab);
        } catch (GooglePlayServicesNotAvailableException e) {
            Toast.makeText(MainActivity.this, "Google Play Services are not installed. Map is disabled", Toast.LENGTH_LONG).show();
        }
        actionBar.addTab(stationsTab);
        actionBar.addTab(preferencesTab);
    }

    @Override
    public void onStationClick(GasStation station) {
        if (mapTab != null) {
            actionBar.selectTab(mapTab);
            mapFragment.selectStation(station);
        }
    }


}
