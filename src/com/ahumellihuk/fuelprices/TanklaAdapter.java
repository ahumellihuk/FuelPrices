package com.ahumellihuk.fuelprices;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TanklaAdapter extends ArrayAdapter<Tankla> {
	
	Context context; 
    int layoutResourceId;    
    Tankla tanklad[] = null;

	public TanklaAdapter(Context context, int layoutResourceId,
			Tankla[] tanklad) {
		super(context, layoutResourceId, tanklad);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.tanklad = tanklad;
	}
	
	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	        View row = convertView;
	        TanklaHolder holder = null;
	        
	        if(row == null)
	        {
	            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
	            row = inflater.inflate(layoutResourceId, parent, false);
	            
	            holder = new TanklaHolder();
	            holder.address = (TextView)row.findViewById(R.id.address);
	            holder.logo = (ImageView)row.findViewById(R.id.logo);
	            holder.service1 = (ImageView)row.findViewById(R.id.service1);
	            holder.service2 = (ImageView)row.findViewById(R.id.service2);
	            holder.service3 = (ImageView)row.findViewById(R.id.service3);
	            holder.service4 = (ImageView)row.findViewById(R.id.service4);
	            holder.service5 = (ImageView)row.findViewById(R.id.service5);
	            holder.service6 = (ImageView)row.findViewById(R.id.service6);
	            holder.sign95 = (TextView)row.findViewById(R.id.sign95);
	            holder.sign98 = (TextView)row.findViewById(R.id.sign98);
	            holder.signD = (TextView)row.findViewById(R.id.signD);
	            
	            row.setTag(holder);
	        }
	        else
	        {
	            holder = (TanklaHolder)row.getTag();
	        }
	        
	        Tankla tankla = tanklad[position];
	        holder.address.setText(tankla.address);
	        holder.logo.setImageResource(tankla.logo);
	        if (tankla.bens95)
	        	holder.sign95.setVisibility(TextView.VISIBLE);
	        else holder.sign95.setVisibility(TextView.INVISIBLE);
	        if (tankla.bens98)
	        	holder.sign98.setVisibility(TextView.VISIBLE);
	        else holder.sign98.setVisibility(TextView.INVISIBLE);
	        if (tankla.diisel)
	        	holder.signD.setVisibility(TextView.VISIBLE);
	        else holder.signD.setVisibility(TextView.INVISIBLE);
	        if (tankla.vesiohk)
	        	holder.service6.setImageResource(R.drawable.air);
	        else holder.service6.setImageDrawable(null);
	        if (tankla.kiirtoit)
	        	holder.service5.setImageResource(R.drawable.fastfood);
	        else holder.service5.setImageDrawable(null);
	        if (tankla.kuumjook)
	        	holder.service4.setImageResource(R.drawable.hotdrinks);
	        else holder.service4.setImageDrawable(null);
	        if (tankla.gaas)
	        	holder.service3.setImageResource(R.drawable.gaas);
	        else holder.service3.setImageDrawable(null);
	        if (tankla.kindlustus)
	        	holder.service2.setImageResource(R.drawable.insurance);
	        else holder.service2.setImageDrawable(null);
	        if (tankla.pood)
	        	holder.service1.setImageResource(R.drawable.pood);
	        else holder.service1.setImageDrawable(null);
	        
	        return row;
	    }

	 static class TanklaHolder
	    {
		 	TextView address,sign95,sign98,signD;
		 	ImageView logo,service1,service2,service3,service4,service5,service6;
	    }
}
