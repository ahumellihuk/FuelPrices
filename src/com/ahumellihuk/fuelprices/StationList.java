package com.ahumellihuk.fuelprices;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import com.ahumellihuk.fuelprices.GasStation.Vendor;
import com.ahumellihuk.fuelprices.tools.StationAdapter;

public class StationList extends ListFragment {

	static List<GasStation> stations = new ArrayList<GasStation>();
    private final StationClickCallback callback;

    public StationList(StationClickCallback callback) {
        this.callback = callback;
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new StationAdapter(getActivity(), R.layout.tankla, stations.toArray(new GasStation[stations.size()])));
	}

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        callback.onStationClick(stations.get(position));
    }

    static {
        stations.add(new GasStation(Vendor.ALEXELA, "Ehitajate tee 101").setServices(true,true,true,true,false,true).setFuelTypes(true,true,true).setLatLng(59.4124878,24.6613155).setReferenceStation());
        stations.add(new GasStation(Vendor.ALEXELA, "Ehitajate tee 114c").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4145448,24.6589261));
        stations.add(new GasStation(Vendor.ALEXELA, "Paldiski mnt 102").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4327791,24.7145367));
        stations.add(new GasStation(Vendor.ALEXELA, "Mustamäe tee 46b").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4166053,24.6922371));
        stations.add(new GasStation(Vendor.ALEXELA, "Marja tn 3").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4232460,24.6957743));
        stations.add(new GasStation(Vendor.ALEXELA, "Tulika tn 33").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4260648,24.7231436));
        stations.add(new GasStation(Vendor.ALEXELA, "Vana- Lõuna tn 30").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4200913,24.7424662));
        stations.add(new GasStation(Vendor.ALEXELA, "Sõle tn 27a").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4384586,24.7079247));
        stations.add(new GasStation(Vendor.ALEXELA, "Tartu mnt 87b").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4304,24.7704));
        stations.add(new GasStation(Vendor.ALEXELA, "Vesse tn 2").setServices(false,false,true,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4283267,24.8326957));
        stations.add(new GasStation(Vendor.ALEXELA, "Peterburi tee 77").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4320475,24.8495496));
        stations.add(new GasStation(Vendor.ALEXELA, "Regati pst 1").setServices(true,false,true,false,false,true).setFuelTypes(true,true,true).setLatLng(59.4667484,24.8226106));
        stations.add(new GasStation(Vendor.STATOIL, "Tartu mnt 86").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4304,24.7704));
        stations.add(new GasStation(Vendor.STATOIL, "Katusepapi tee 37").setServices(true,true,false,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4253007,24.7929025));
        stations.add(new GasStation(Vendor.STATOIL, "Sütiste tee 1").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4009102,24.6956634));
        stations.add(new GasStation(Vendor.STATOIL, "Lootsi 1").setServices(true,true,false,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4400610,24.7646700));
        stations.add(new GasStation(Vendor.STATOIL, "Endla 43").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4274522,24.7242984));
        stations.add(new GasStation(Vendor.STATOIL, "Ülemiste 1").setServices(true,true,false,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4309002,24.8445903));
        stations.add(new GasStation(Vendor.STATOIL, "Põhja pst 33").setServices(true,true,false,true,true,true).setFuelTypes(true,true,true).setLatLng(59.440012,24.7041292));
        stations.add(new GasStation(Vendor.STATOIL, "Männiku tee 2/ Pärnu mnt").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.3919260,24.7218570));
        stations.add(new GasStation(Vendor.STATOIL123, "Õismäe tee 10a").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4128666,24.6519307));
        stations.add(new GasStation(Vendor.STATOIL, "Mahtra 29").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4423153,24.8754358));
        stations.add(new GasStation(Vendor.STATOIL, "Järvevana tee 2").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4228023,24.7863819));
        stations.add(new GasStation(Vendor.STATOIL123, "Pärnu mnt 236").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.3927915,24.7228072));
        stations.add(new GasStation(Vendor.STATOIL, "Sõpruse pst. 200B/ Sipelga 1").setServices(true,true,true,true,true,true).setFuelTypes(true, true, true).setLatLng(59.4056320, 24.7000980).setReferenceStation());
        stations.add(new GasStation(Vendor.STATOIL123, "Vana-Rannamõisa tee 1").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4276548,24.6287895));
        stations.add(new GasStation(Vendor.STATOIL, "Paldiski mnt. 106").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4327791,24.7145367));
        stations.add(new GasStation(Vendor.STATOIL, "Võidujooksu 10").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4357299,24.8107972));
        stations.add(new GasStation(Vendor.STATOIL, "Paldiski mnt 44").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4327791,24.7145367));
        stations.add(new GasStation(Vendor.STATOIL, "Tammsaare tee 111").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4084856,24.6866318));
        stations.add(new GasStation(Vendor.STATOIL, "Pärnu mnt 180").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4025141,24.7281671));
        stations.add(new GasStation(Vendor.STATOIL, "Endla 52").setServices(true,true,false,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4278982,24.7193623));
        stations.add(new GasStation(Vendor.STATOIL123, "Juhkentali 1B").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4294883,24.7589933));
        stations.add(new GasStation(Vendor.STATOIL, "Peterburi mnt 58a").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4293364,24.8376953));
        stations.add(new GasStation(Vendor.STATOIL, "Pärnu mnt 552").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.3547983,24.6296285));
        stations.add(new GasStation(Vendor.STATOIL, "Petrooleumi 4").setServices(true,false,false,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4404467,24.7763364));
        stations.add(new GasStation(Vendor.NESTE, "Pärnu mnt 141A").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4021089,24.7299825));
        stations.add(new GasStation(Vendor.NESTE, "Paldiski mnt 98").setServices(true,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4327791,24.7145367));
        stations.add(new GasStation(Vendor.NESTE, "Pärnu mnt 453E").setServices(true,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.3600766,24.6311317));
        stations.add(new GasStation(Vendor.NESTE, "Kadaka tee 60").setServices(true,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4116871,24.6646885));
        stations.add(new GasStation(Vendor.NESTE, "Peterburi tee 52").setServices(true,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.426728,24.8230024));
        stations.add(new GasStation(Vendor.NESTE, "Punane 43").setServices(true,false,false,false,false,false).setFuelTypes(true, true, true).setLatLng(59.434629, 24.832231).setReferenceStation());
        stations.add(new GasStation(Vendor.NESTE, "Sõle 25 A").setServices(true,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4381040,24.7082720));
        stations.add(new GasStation(Vendor.NESTE, "Mustamäe tee 22").setServices(true,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4189373,24.6937477));
        stations.add(new GasStation(Vendor.NESTE, "Läänemere tee 2B").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4508116,24.8610901));
        stations.add(new GasStation(Vendor.NESTE, "Rummu tee 2").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.462519,24.8265301));
        stations.add(new GasStation(Vendor.NESTE, "Peterburi tee 99").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4372036,24.8742748));
        stations.add(new GasStation(Vendor.NESTE, "Sõpruse pst 155").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.3988,24.6857));
        stations.add(new GasStation(Vendor.NESTE, "Männiku 99").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.3754270,24.7183410));
        stations.add(new GasStation(Vendor.NESTE, "Tammsaare tee 64A").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4027057,24.7127164));
        stations.add(new GasStation(Vendor.NESTE, "Suur-Ameerika 49/Koidu 47").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4281480,24.7314780));
        stations.add(new GasStation(Vendor.NESTE, "Mustamäe tee 39").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4224804,24.6997055));
        stations.add(new GasStation(Vendor.NESTE, "Juhkentali 37/39").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4272932,24.7706227));
        stations.add(new GasStation(Vendor.NESTE, "Paldiski mnt 54").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4327791,24.7145367));
        stations.add(new GasStation(Vendor.NESTE, "Põhja pst 17A/Soo tn 1").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4400120,24.7041290));
        stations.add(new GasStation(Vendor.NESTE, "Suur-Sõjamäe 4/2").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4219071,24.7944225));
        stations.add(new GasStation(Vendor.NESTE, "Ümera 35").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4459956,24.8972718));
        stations.add(new GasStation(Vendor.NESTE, "Suur-Sõjamäe 35C").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4171625,24.8674661));
        stations.add(new GasStation(Vendor.NESTE, "Sõpruse pst. 178").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.3988,24.6857));
        stations.add(new GasStation(Vendor.NESTE, "Mustakivi tee 15").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4430582,24.8650809));
        stations.add(new GasStation(Vendor.OLEREX, "Ahtri 6B").setServices(true,true,true,true,true,true).setFuelTypes(true,true,true).setLatLng(59.4396864,24.7594245));
        stations.add(new GasStation(Vendor.OLEREX, "Betooni 3").setServices(false,false,false,false,false,false).setFuelTypes(true,false,true).setLatLng(59.4243549,24.8533791));
        stations.add(new GasStation(Vendor.OLEREX, "Laagna tee 13").setServices(true,true,false,true,true,false).setFuelTypes(true,true,true).setLatLng(59.4362574,24.8093691));
        stations.add(new GasStation(Vendor.OLEREX, "Laki 29").setServices(false,false,false,false,false,false).setFuelTypes(true, true, true).setLatLng(59.4099976, 24.6755292).setReferenceStation());
        stations.add(new GasStation(Vendor.OLEREX, "Lagedi tee 26").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4315236,24.9176766));
        stations.add(new GasStation(Vendor.EUROOIL, "Koorti 20").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.4401389,24.830443));
        stations.add(new GasStation(Vendor.EUROOIL, "Männiku tee 98 F").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.3717724,24.7166807));
        stations.add(new GasStation(Vendor.EUROOIL, "Viljandi mnt 36 A").setServices(false,false,false,false,false,false).setFuelTypes(true,true,true).setLatLng(59.362151,24.7638394));
        stations.add(new GasStation(Vendor.EUROOIL, "Sadama tn 21").setServices(false,false,false,false,false,false).setFuelTypes(true,false,true).setLatLng(59.4445620,24.7590460));
        stations.add(new GasStation(Vendor.EUROOIL, "Paldiski mnt.48A").setServices(false,false,false,false,false,false).setFuelTypes(true,false,true).setLatLng(59.4327791,24.7145367));
        stations.add(new GasStation(Vendor.EUROOIL, "Paldiski mnt. 108B").setServices(false,false,false,false,false,false).setFuelTypes(true, true, true).setLatLng(59.4327791, 24.7145367).setReferenceStation());
        stations.add(new GasStation(Vendor.FIVEPLUS, "Linnu tee 64").setServices(true,false,true,false,false,true).setFuelTypes(true, true, true).setLatLng(59.4128266, 24.7088119).setReferenceStation());
        stations.add(new GasStation(Vendor.FAVORA, "Tondi 6").setServices(true,false,true,true,true,true).setFuelTypes(true, true, true).setLatLng(59.4148032, 24.738686).setReferenceStation());
    }
}
