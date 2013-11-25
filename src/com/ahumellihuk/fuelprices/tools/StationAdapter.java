package com.ahumellihuk.fuelprices.tools;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahumellihuk.fuelprices.GasStation;
import com.ahumellihuk.fuelprices.R;

public class StationAdapter extends ArrayAdapter<GasStation> {
	
	Activity activity;
    int layoutResourceId;    
    GasStation stations[] = null;

	public StationAdapter(Activity activity, int layoutResourceId,
                          GasStation[] stations) {
		super(activity, layoutResourceId, stations);
		this.activity = activity;
		this.layoutResourceId = layoutResourceId;
		this.stations = stations;
	}
	
	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	        StationHolder holder = null;
	        
	        if(convertView == null) {
	            LayoutInflater inflater = activity.getLayoutInflater();
                convertView = inflater.inflate(layoutResourceId, parent, false);
	            
	            holder = new StationHolder();
	            holder.address = (TextView)convertView.findViewById(R.id.address);
	            holder.logo = (ImageView)convertView.findViewById(R.id.logo);
	            holder.service1 = (ImageView)convertView.findViewById(R.id.service1);
	            holder.service2 = (ImageView)convertView.findViewById(R.id.service2);
	            holder.service3 = (ImageView)convertView.findViewById(R.id.service3);
	            holder.service4 = (ImageView)convertView.findViewById(R.id.service4);
	            holder.service5 = (ImageView)convertView.findViewById(R.id.service5);
	            holder.service6 = (ImageView)convertView.findViewById(R.id.service6);
	            holder.sign95 = (TextView)convertView.findViewById(R.id.sign95);
	            holder.sign98 = (TextView)convertView.findViewById(R.id.sign98);
	            holder.signD = (TextView)convertView.findViewById(R.id.signD);

                convertView.setTag(holder);
	        } else {
	            holder = (StationHolder)convertView.getTag();
	        }
	        
	        GasStation gasStation = stations[position];
	        holder.address.setText(gasStation.getAddress());
	        holder.logo.setImageResource(gasStation.getLogo());
	        if (gasStation.petrol95)
	        	holder.sign95.setVisibility(TextView.VISIBLE);
	        else holder.sign95.setVisibility(TextView.INVISIBLE);
	        if (gasStation.petrol98)
	        	holder.sign98.setVisibility(TextView.VISIBLE);
	        else holder.sign98.setVisibility(TextView.INVISIBLE);
	        if (gasStation.diesel)
	        	holder.signD.setVisibility(TextView.VISIBLE);
	        else holder.signD.setVisibility(TextView.INVISIBLE);
	        if (gasStation.waterAir)
	        	holder.service6.setImageResource(R.drawable.air);
	        else holder.service6.setImageDrawable(null);
	        if (gasStation.fastFood)
	        	holder.service5.setImageResource(R.drawable.fastfood);
	        else holder.service5.setImageDrawable(null);
	        if (gasStation.hotDrink)
	        	holder.service4.setImageResource(R.drawable.hotdrinks);
	        else holder.service4.setImageDrawable(null);
	        if (gasStation.gas)
	        	holder.service3.setImageResource(R.drawable.gaas);
	        else holder.service3.setImageDrawable(null);
	        if (gasStation.insurance)
	        	holder.service2.setImageResource(R.drawable.insurance);
	        else holder.service2.setImageDrawable(null);
	        if (gasStation.shop)
	        	holder.service1.setImageResource(R.drawable.pood);
	        else holder.service1.setImageDrawable(null);
	        
	        return convertView;
	    }

	 static class StationHolder
	    {
		 	TextView address,sign95,sign98,signD;
		 	ImageView logo,service1,service2,service3,service4,service5,service6;
	    }
}
