package com.ahumellihuk.fuelprices.tools;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TextView;

import com.ahumellihuk.fuelprices.PricesFragment;

public class FetchData extends AsyncTask<PricesFragment, Void, Double[][]> {

    public static String TASK_FINISHED = "TASK_FINISHED";
    PricesFragment fragment;
    JSONParser jParser;
    @Override
    protected Double[][] doInBackground(PricesFragment... fragments) {
        fragment = fragments[0];
        return fetch();
    }

    @Override
    protected void onPostExecute(Double[][] prices) {
        Intent intent = new Intent();
        intent.setAction(TASK_FINISHED);
        intent.putExtra("result", encode(prices));
        fragment.getActivity().sendBroadcast(intent);
    }

    private Double[][] fetch() {
        Double[][] prices = new Double[3][7];
        jParser = new JSONParser();
        JSONArray json = jParser.makeHttpRequest("http://fuel-prices.gopagoda.com/fetch_fuel_prices.php", "GET", new ArrayList<NameValuePair>());
        try {
            for (int i = 0; i < 21; i++) {
                String input = json.getString(i);
                if (input != null) {
                    try {
                        prices[(i/7)][i%7] = Double.parseDouble(input);
                    } catch (NumberFormatException nfe) {
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return prices;
    }

    public static String encode(Double[][] prices) {
        String output = "";
        for (Double[] fuelType : prices) {
            for (Double price : fuelType) {
                if (price != null) {
                    output += price.toString()+";";
                } else {
                    output += "null;";
                }
            }
        }
        return output;
    }

    public static Double[][] decode(String pricesString) {
        Double[][] output = new Double[3][7];
        String[] temp = pricesString.split(";");
        for (int i=0; i<3; i++) {
            for (int j=0; j<7; j++) {
                try {
                    int index = (i*7)+j;
                    output[i][j] = Double.parseDouble(temp[index]);
                } catch (NumberFormatException nfe) {
                    output[i][j] = null;
                }
            }
        }
        return output;
    }
}
