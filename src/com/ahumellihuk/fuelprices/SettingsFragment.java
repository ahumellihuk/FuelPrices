package com.ahumellihuk.fuelprices;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsFragment extends Fragment {

	CheckBox useLocalData;
	RadioGroup radioFuelTypeGroup;
	Button saveSettings;
	SharedPreferences sharedPref;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.settings_layout, container, false);
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		useLocalData = (CheckBox) getView().findViewById(R.id.useLocalData);
		radioFuelTypeGroup = (RadioGroup) getView().findViewById(R.id.radioFuelTypeGroup);
		saveSettings = (Button) getView().findViewById(R.id.saveSettings);

        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		
		if (sharedPref.contains("fuelTypeId")) {
			int id = sharedPref.getInt("fuelTypeId", 0);
			radioFuelTypeGroup.check(id);
		}
		if (sharedPref.getBoolean("useLocalData", false)) {
			useLocalData.setChecked(true);
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		saveSettings.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {				
				SharedPreferences.Editor editor = sharedPref.edit();
				
				int fuelTypeId = radioFuelTypeGroup.getCheckedRadioButtonId();
				RadioButton fuelType = (RadioButton) getView().findViewById(fuelTypeId);
				editor.putInt("fuelTypeId", fuelTypeId);
				editor.putString("fuelType", (String)fuelType.getText());
				
				editor.putBoolean("useLocalData", useLocalData.isChecked());
				
				editor.commit(); 
				
				Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Preferences Saved", Toast.LENGTH_SHORT);
				toast.show();
			}
			
		});
	}
}
