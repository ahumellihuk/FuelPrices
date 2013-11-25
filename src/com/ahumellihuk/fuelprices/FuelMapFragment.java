package com.ahumellihuk.fuelprices;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FuelMapFragment extends MapFragment {
	
	com.google.android.gms.maps.MapFragment fragMap;
	
	private static final LatLng TALLINN = new LatLng(59.43,24.75);
	List<MarkerOptions> markerOptions;
    Map<Integer, Marker> markers;
    private GasStation selectedStation;

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        markerOptions = new ArrayList<MarkerOptions>();
        for (GasStation station : StationList.stations) {
            markerOptions.add(new MarkerOptions().position(station.getLatLng()).title(station.getName()).snippet(station.getAddress()).icon(BitmapDescriptorFactory.fromResource(station.getMapMarker())));
        }
	}

	@Override
	public void onResume() {
		super.onResume();
		GoogleMap map = getMap();
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(TALLINN, 11));
        markers = new HashMap<Integer, Marker>();
        for (int i=0; i<markerOptions.size(); i++) {
            StationList.stations.get(i).setId(i);
            markers.put(i,map.addMarker(markerOptions.get(i)));
        }
        if (selectedStation != null) {
            Marker marker = markers.get(selectedStation.getId());
            if (marker != null) {
                LatLng latLng = marker.getPosition();
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
                marker.showInfoWindow();
            }
            selectedStation = null;
        }
	}

    public void selectStation(GasStation station) {
        selectedStation = station;
    }
}
