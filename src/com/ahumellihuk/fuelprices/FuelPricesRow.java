package com.ahumellihuk.fuelprices;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class FuelPricesRow extends TableRow {

    TextView petrol95, petrol98, diesel;
    ImageView logo;
    Context context;
    Double petrol95Price, petrol98Price, dieselPrice;

    public FuelPricesRow(Context context) {
        super(context);
        this.context = context;
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setPadding(0,10,0,10);
        setMinimumHeight(40);

        petrol95 = new TextView(context);
        petrol95.setGravity(Gravity.CENTER);
        petrol95.setTypeface(Typeface.create("Serif", Typeface.NORMAL));
        petrol95.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        petrol98 = new TextView(context);
        petrol98.setGravity(Gravity.CENTER);
        petrol98.setTypeface(Typeface.create("Serif", Typeface.NORMAL));
        petrol98.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        diesel = new TextView(context);
        diesel.setGravity(Gravity.CENTER);
        diesel.setTypeface(Typeface.create("Serif", Typeface.NORMAL));
        diesel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        logo = new ImageView(context);

        addView(logo, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(petrol95);
        addView(petrol98);
        addView(diesel);
    }

    public FuelPricesRow setLogo(int resource) {
        logo.setImageResource(resource);
        return this;
    }

    public FuelPricesRow setPetrol95Price(Double price) {
        return setPetrol95Price(price, true);
    }

    public FuelPricesRow setPetrol98Price(Double price) {
        return setPetrol98Price(price, true);
    }

    public FuelPricesRow setDieselPrice(Double price) {
        return setDieselPrice(price, true);
    }

    public FuelPricesRow setPetrol95LowestPrice() {
        petrol95.setTypeface(Typeface.create("Serif", Typeface.BOLD));
        petrol95.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        return this;
    }

    public FuelPricesRow setPetrol98LowestPrice() {
        petrol98.setTypeface(Typeface.create("Serif", Typeface.BOLD));
        petrol98.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        return this;
    }

    public FuelPricesRow setDieselLowestPrice() {
        diesel.setTypeface(Typeface.create("Serif", Typeface.BOLD));
        diesel.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        return this;
    }

    public void resetPrices() {
        setPetrol95Price(petrol95Price, false);
        setPetrol98Price(petrol98Price, false);
        setDieselPrice(dieselPrice, false);
    }

    public void calculatePriceForLiters(Integer liters) {
        if (liters != null) {
            setPetrol95Price(petrol95Price != null ? petrol95Price*liters : null, false);
            setPetrol98Price(petrol98Price != null ? petrol98Price*liters : null, false);
            setDieselPrice(dieselPrice != null ? dieselPrice*liters : null, false);
        }
    }

    protected FuelPricesRow setPetrol95Price(Double price, boolean updatePrice) {
        if (price != null) {
            petrol95.setText(price.toString());
        } else {
            petrol95.setText("-");
        }
        if (updatePrice) {
            petrol95Price = price;
        }
        return this;
    }

    protected FuelPricesRow setPetrol98Price(Double price, boolean updatePrice) {
        if (price != null) {
            petrol98.setText(price.toString());
        } else {
            petrol98.setText("-");
        }
        if (updatePrice) {
            petrol98Price = price;
        }
        return this;
    }

    protected FuelPricesRow setDieselPrice(Double price, boolean updatePrice) {
        if (price != null) {
            diesel.setText(price.toString());
        } else {
            diesel.setText("-");
        }
        if (updatePrice) {
            dieselPrice = price;
        }
        return this;
    }
}
