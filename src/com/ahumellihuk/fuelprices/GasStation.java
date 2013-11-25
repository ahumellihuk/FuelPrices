package com.ahumellihuk.fuelprices;

import com.google.android.gms.maps.model.LatLng;

public class GasStation {

    public enum Vendor {
        STATOIL("Statoil", R.drawable.statoil, R.drawable.map_statoil, R.drawable.map_reference_statoil),
        STATOIL123("Statoil 1-2-3", R.drawable.statoil123, R.drawable.map_statoil, R.drawable.map_reference_statoil),
        ALEXELA("Alexela", R.drawable.alexela, R.drawable.map_alexela, R.drawable.map_reference_alexela),
        NESTE("Neste", R.drawable.neste, R.drawable.map_neste, R.drawable.map_reference_neste),
        KROONING("Krooning", R.drawable.krooning, R.drawable.map_krooning, R.drawable.map_reference_krooning),
        FAVORA("Favora", R.drawable.favora, R.drawable.map_favora, R.drawable.map_reference_favora),
        FIVEPLUS("5+", R.drawable.fiveplus, R.drawable.map_fiveplus, R.drawable.map_reference_fiveplus),
        OLEREX("Olerex", R.drawable.olerex, R.drawable.map_olerex, R.drawable.map_reference_olerex),
        EUROOIL("Euro Oil", R.drawable.eurooil, R.drawable.map_eurooil, R.drawable.map_reference_eurooil);

        private final int mapReferenceMarker;
        private final String name;
        private final int logo;
        private final int mapMarker;

        Vendor(String name, int logo, int mapMarker, int mapReferenceMarker) {
            this.name = name;
            this.logo = logo;
            this.mapMarker = mapMarker;
            this.mapReferenceMarker = mapReferenceMarker;
        }

        public String getName() {
            return name;
        }

        public int getLogo() {
            return logo;
        }

        public int getMapMarker() {
            return mapMarker;
        }

        public int getMapReferenceMarker() {
            return mapReferenceMarker;
        }
    }

	private String address;
    private LatLng latLng;
    private boolean isReferenceStation;
	public boolean petrol95, petrol98, diesel, shop, insurance, gas, hotDrink, fastFood, waterAir;
    private Vendor vendor;
    private int id;
	
	public GasStation(Vendor vendor, String address) {
        this.vendor = vendor;
		this.address = address;
		shop = false;
		insurance = false;
		gas = false;
		hotDrink = false;
		fastFood = false;
		waterAir = false;
		petrol95 = false;
		petrol98 = false;
		diesel = false;
	}
	
	public GasStation setServices(boolean shop, boolean insurance, boolean gas, boolean hotDrink, boolean fastFood, boolean waterAir) {
		this.shop = shop;
		this.insurance = insurance;
		this.gas = gas;
		this.fastFood = fastFood;
		this.hotDrink = hotDrink;
		this.waterAir = waterAir;
        return this;
	}
	
	public GasStation setFuelTypes(boolean petrol95, boolean petrol98, boolean diesel) {
		this.petrol95 = petrol95;
		this.petrol98 = petrol98;
		this.diesel = diesel;
        return this;
	}

    public GasStation setLatLng(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public GasStation setLatLng(double lat, double lng) {
        this.latLng = new LatLng(lat, lng);
        return this;
    }

    public GasStation setReferenceStation() {
        this.isReferenceStation = true;
        return this;
    }

	public String getAddress() {
		return address;
	}
	
	public String getName() {
		return vendor.getName();
	}

    public LatLng getLatLng() {
        return latLng;
    }

    public int getLogo() {
        return vendor.getLogo();
    }

    public int getMapMarker() {
        return isReferenceStation?vendor.getMapReferenceMarker():vendor.getMapMarker();
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
