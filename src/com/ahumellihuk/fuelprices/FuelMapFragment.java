package com.ahumellihuk.fuelprices;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FuelMapFragment extends Fragment {
	
	com.google.android.gms.maps.MapFragment fragMap;
	
	private static final LatLng TALLINN = new LatLng(59.43,24.75);
	MarkerOptions[] markers;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.map_layout, container, false);
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
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
	
	@Override
	public void onResume() {
		super.onResume();
		fragMap = ((com.google.android.gms.maps.MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map));
		GoogleMap map = fragMap.getMap();
		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(TALLINN, 11));
		for (int i=0; i<8; i++)
			map.addMarker(markers[i]);
	}
	
	@Override
	public void onDestroyView() {
		fragMap.onDestroyView();
		super.onDestroyView();
	}
}
