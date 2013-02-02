package com.ahumellihuk.fuelprices;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class TanklaList extends ListFragment {
	
	TanklaAdapter adapter;
	MainActivity main;
	ListView listView;
	int[] logod = {R.drawable.alexela,R.drawable.eurooil,R.drawable.favora,R.drawable.neste,R.drawable.olerex,R.drawable.statoil,R.drawable.statoil123,R.drawable.fiveplus};
	Tankla[] tanklad;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		main = (MainActivity) getActivity();
		tanklad = new Tankla[72];
		//Alexela
		tanklad[0] = new Tankla("Alexela", "Ehitajate tee 101", logod[0]);
		tanklad[0].setServices(true,true,true,true,false,true);
		tanklad[0].setFuelTypes(true, true, true);
		tanklad[1] = new Tankla("Alexela", "Ehitajate tee 114c", logod[0]);
		tanklad[1].setServices(false,false,false,false,false,false);
		tanklad[1].setFuelTypes(true, true, true);
		tanklad[2] = new Tankla("Alexela", "Paldiski mnt 102", logod[0]);
		tanklad[2].setServices(false,false,false,false,false,false);
		tanklad[2].setFuelTypes(true,true,true);
		tanklad[3] = new Tankla("Alexela", "Mustamäe tee 46b", logod[0]);	
		tanklad[3].setServices(false,false,false,false,false,false);
		tanklad[3].setFuelTypes(true,true,true);
		tanklad[4] = new Tankla("Alexela", "Marja tn 3", logod[0]);	
		tanklad[4].setServices(false,false,false,false,false,false);
		tanklad[4].setFuelTypes(true,true,true);
		tanklad[5] = new Tankla("Alexela", "Tulika tn 33", logod[0]);
		tanklad[5].setServices(false,false,false,false,false,false);
		tanklad[5].setFuelTypes(true,true,true);
		tanklad[6] = new Tankla("Alexela", "Vana- Lõuna tn 30", logod[0]);
		tanklad[6].setServices(false,false,false,false,false,false);
		tanklad[6].setFuelTypes(true,true,true);
		tanklad[7] = new Tankla("Alexela", "Sõle tn 27a", logod[0]);
		tanklad[7].setServices(false,false,false,false,false,false);
		tanklad[7].setFuelTypes(true,true,true);
		tanklad[8] = new Tankla("Alexela", "Tartu mnt 87b", logod[0]);
		tanklad[8].setServices(false,false,false,false,false,false);
		tanklad[8].setFuelTypes(true,true,true);
		tanklad[9] = new Tankla("Alexela", "Vesse tn 2", logod[0]);
		tanklad[9].setServices(false,false,true,false,false,false);
		tanklad[9].setFuelTypes(true,true,true);
		tanklad[10] = new Tankla("Alexela", "Peterburi tee 77", logod[0]);
		tanklad[10].setServices(true,true,true,true,true,true);
		tanklad[10].setFuelTypes(true,true,true);
		tanklad[11] = new Tankla("Alexela", "Regati pst 1", logod[0]);
		tanklad[11].setServices(true,false,true,false,false,true);
		tanklad[11].setFuelTypes(true,true,true);
		//Statoil
		tanklad[12] = new Tankla("Statoil", "Tartu mnt 86", logod[5]);
		tanklad[12].setServices(true,true,true,true,true,true);
		tanklad[12].setFuelTypes(true,true,true);
		tanklad[13] = new Tankla("Statoil", "Katusepapi tee 37", logod[5]);
		tanklad[13].setServices(true,true,false,true,true,true);
		tanklad[13].setFuelTypes(true,true,true);
		tanklad[14] = new Tankla("Statoil", "Sütiste tee 1", logod[5]);
		tanklad[14].setServices(true,true,true,true,true,true);
		tanklad[14].setFuelTypes(true,true,true);
		tanklad[15] = new Tankla("Statoil", "Lootsi 1", logod[5]);
		tanklad[15].setServices(true,true,false,true,true,true);
		tanklad[15].setFuelTypes(true,true,true);
		tanklad[16] = new Tankla("Statoil", "Endla 43", logod[5]);
		tanklad[16].setServices(true,true,true,true,true,true);
		tanklad[16].setFuelTypes(true,true,true);
		tanklad[17] = new Tankla("Statoil", "Ülemiste 1", logod[5]);
		tanklad[17].setServices(true,true,false,true,true,true);
		tanklad[17].setFuelTypes(true,true,true);
		tanklad[18] = new Tankla("Statoil", "Põhja pst 33", logod[5]);
		tanklad[18].setServices(true,true,false,true,true,true);
		tanklad[18].setFuelTypes(true,true,true);
		tanklad[19] = new Tankla("Statoil", "Männiku tee 2/ Pärnu mnt", logod[5]);
		tanklad[19].setServices(true,true,true,true,true,true);
		tanklad[19].setFuelTypes(true,true,true);
		tanklad[20] = new Tankla("Statoil 1-2-3", "Õismäe tee 10a", logod[6]);
		tanklad[20].setServices(false,false,false,false,false,false);
		tanklad[20].setFuelTypes(true,true,true);
		tanklad[21] = new Tankla("Statoil", "Mahtra 29", logod[5]);
		tanklad[21].setServices(true,true,true,true,true,true);
		tanklad[21].setFuelTypes(true,true,true);
		tanklad[22] = new Tankla("Statoil", "Järvevana tee 2", logod[5]);
		tanklad[22].setServices(true,true,true,true,true,true);
		tanklad[22].setFuelTypes(true,true,true);
		tanklad[23] = new Tankla("Statoil 1-2-3", "Pärnu mnt 236", logod[6]);
		tanklad[23].setServices(false,false,false,false,false,false);
		tanklad[23].setFuelTypes(true,true,true);
		tanklad[24] = new Tankla("Statoil", "Sõpruse pst. 200B/ Sipelga 1", logod[5]);
		tanklad[24].setServices(true,true,true,true,true,true);
		tanklad[24].setFuelTypes(true,true,true);
		tanklad[25] = new Tankla("Statoil 1-2-3", "Vana-Rannamõisa tee 1", logod[6]);
		tanklad[25].setServices(false,false,false,false,false,false);
		tanklad[25].setFuelTypes(true,true,true);
		tanklad[26] = new Tankla("Statoil", "Paldiski mnt. 106", logod[5]);
		tanklad[26].setServices(true,true,true,true,true,true);
		tanklad[26].setFuelTypes(true,true,true);
		tanklad[27] = new Tankla("Statoil", "Võidujooksu 10", logod[5]);
		tanklad[27].setServices(true,true,true,true,true,true);
		tanklad[27].setFuelTypes(true,true,true);
		tanklad[28] = new Tankla("Statoil", "Paldiski mnt 44", logod[5]);
		tanklad[28].setServices(true,true,true,true,true,true);
		tanklad[28].setFuelTypes(true,true,true);
		tanklad[29] = new Tankla("Statoil", "Tammsaare tee 111", logod[5]);
		tanklad[29].setServices(true,true,true,true,true,true);
		tanklad[29].setFuelTypes(true,true,true);
		tanklad[30] = new Tankla("Statoil", "Pärnu mnt 180", logod[5]);
		tanklad[30].setServices(true,true,true,true,true,true);
		tanklad[30].setFuelTypes(true,true,true);
		tanklad[31] = new Tankla("Statoil", "Endla 52", logod[5]);
		tanklad[31].setServices(true,true,false,true,true,true);
		tanklad[31].setFuelTypes(true,true,true);
		tanklad[32] = new Tankla("Statoil 1-2-3", "Juhkentali 1B", logod[6]);
		tanklad[32].setServices(false,false,false,false,false,false);
		tanklad[32].setFuelTypes(true,true,true);
		tanklad[33] = new Tankla("Statoil", "Peterburi mnt 58a", logod[5]);
		tanklad[33].setServices(true,true,true,true,true,true);
		tanklad[33].setFuelTypes(true,true,true);
		tanklad[34] = new Tankla("Statoil", "Pärnu mnt 552", logod[5]);
		tanklad[34].setServices(true,true,true,true,true,true);
		tanklad[34].setFuelTypes(true,true,true);
		tanklad[35] = new Tankla("Statoil", "Petrooleumi 4", logod[5]);
		tanklad[35].setServices(true,false,false,true,true,true);
		tanklad[35].setFuelTypes(true,true,true);
		//Neste
		tanklad[36] = new Tankla("Neste", "Pärnu mnt 141A", logod[3]);
		tanklad[36].setServices(false,false,false,false,false,false);
		tanklad[36].setFuelTypes(true,true,true);
		tanklad[37] = new Tankla("Neste", "Paldiski mnt 98", logod[3]);
		tanklad[37].setServices(true,false,false,false,false,false);
		tanklad[37].setFuelTypes(true,true,true);
		tanklad[38] = new Tankla("Neste", "Pärnu mnt 453E", logod[3]);
		tanklad[38].setServices(true,false,false,false,false,false);
		tanklad[38].setFuelTypes(true,true,true);
		tanklad[39] = new Tankla("Neste", "Kadaka tee 60", logod[3]);
		tanklad[39].setServices(true,false,false,false,false,false);
		tanklad[39].setFuelTypes(true,true,true);
		tanklad[40] = new Tankla("Neste", "Peterburi tee 52", logod[3]);
		tanklad[40].setServices(true,false,false,false,false,false);
		tanklad[40].setFuelTypes(true,true,true);
		tanklad[41] = new Tankla("Neste", "Punane 43", logod[3]);
		tanklad[41].setServices(true,false,false,false,false,false);
		tanklad[41].setFuelTypes(true,true,true);
		tanklad[42] = new Tankla("Neste", "Sõle 25 A", logod[3]);
		tanklad[42].setServices(true,false,false,false,false,false);
		tanklad[42].setFuelTypes(true,true,true);
		tanklad[43] = new Tankla("Neste", "Mustamäe tee 22", logod[3]);
		tanklad[43].setServices(true,false,false,false,false,false);
		tanklad[43].setFuelTypes(true,true,true);
		tanklad[44] = new Tankla("Neste", "Läänemere tee 2B", logod[3]);
		tanklad[44].setServices(false,false,false,false,false,false);
		tanklad[44].setFuelTypes(true,true,true);
		tanklad[45] = new Tankla("Neste", "Rummu tee 2", logod[3]);
		tanklad[45].setServices(false,false,false,false,false,false);
		tanklad[45].setFuelTypes(true,true,true);
		tanklad[46] = new Tankla("Neste", "Peterburi tee 99", logod[3]);
		tanklad[46].setServices(false,false,false,false,false,false);
		tanklad[46].setFuelTypes(true,true,true);
		tanklad[47] = new Tankla("Neste", "Sõpruse pst 155", logod[3]);
		tanklad[47].setServices(false,false,false,false,false,false);
		tanklad[47].setFuelTypes(true,true,true);
		tanklad[48] = new Tankla("Neste", "Männiku 99", logod[3]);
		tanklad[48].setServices(false,false,false,false,false,false);
		tanklad[48].setFuelTypes(true,true,true);
		tanklad[49] = new Tankla("Neste", "Tammsaare tee 64A", logod[3]);
		tanklad[49].setServices(false,false,false,false,false,false);
		tanklad[49].setFuelTypes(true,true,true);
		tanklad[50] = new Tankla("Neste", "Suur-Ameerika 49/Koidu 47", logod[3]);
		tanklad[50].setServices(false,false,false,false,false,false);
		tanklad[50].setFuelTypes(true,true,true);
		tanklad[51] = new Tankla("Neste", "Mustamäe tee 39", logod[3]);
		tanklad[51].setServices(false,false,false,false,false,false);
		tanklad[51].setFuelTypes(true,true,true);
		tanklad[52] = new Tankla("Neste", "Juhkentali 37/39", logod[3]);
		tanklad[52].setServices(false,false,false,false,false,false);
		tanklad[52].setFuelTypes(true,true,true);
		tanklad[53] = new Tankla("Neste", "Paldiski mnt 54", logod[3]);
		tanklad[53].setServices(false,false,false,false,false,false);
		tanklad[53].setFuelTypes(true,true,true);
		tanklad[54] = new Tankla("Neste", "Põhja pst 17A/Soo tn 1", logod[3]);
		tanklad[54].setServices(false,false,false,false,false,false);
		tanklad[54].setFuelTypes(true,true,true);
		tanklad[55] = new Tankla("Neste", "Suur-Sõjamäe 4/2", logod[3]);
		tanklad[55].setServices(false,false,false,false,false,false);
		tanklad[55].setFuelTypes(true,true,true);
		tanklad[56] = new Tankla("Neste", "Ümera 35", logod[3]);
		tanklad[56].setServices(false,false,false,false,false,false);
		tanklad[56].setFuelTypes(true,true,true);
		tanklad[57] = new Tankla("Neste", "Suur-Sõjamäe 35C", logod[3]);
		tanklad[57].setServices(false,false,false,false,false,false);
		tanklad[57].setFuelTypes(true,true,true);
		tanklad[58] = new Tankla("Neste", "Sõpruse pst. 178", logod[3]);
		tanklad[58].setServices(false,false,false,false,false,false);
		tanklad[58].setFuelTypes(true,true,true);
		tanklad[59] = new Tankla("Neste", "Mustakivi tee 15", logod[3]);
		tanklad[59].setServices(false,false,false,false,false,false);
		tanklad[59].setFuelTypes(true,true,true);
		//Olerex
		tanklad[60] = new Tankla("Olerex", "Ahtri 6B", logod[4]);
		tanklad[60].setServices(true,true,true,true,true,true);
		tanklad[60].setFuelTypes(true,true,true);
		tanklad[61] = new Tankla("Olerex", "Betooni 3", logod[4]);
		tanklad[61].setServices(false,false,false,false,false,false);
		tanklad[61].setFuelTypes(true,false,true);
		tanklad[62] = new Tankla("Olerex", "Laagna tee 13", logod[4]);
		tanklad[62].setServices(true,true,false,true,true,false);
		tanklad[62].setFuelTypes(true,true,true);
		tanklad[63] = new Tankla("Olerex", "Laki 29", logod[4]);
		tanklad[63].setServices(false,false,false,false,false,false);
		tanklad[63].setFuelTypes(true,true,true);
		tanklad[64] = new Tankla("Olerex", "Lagedi tee 26", logod[4]);
		tanklad[64].setServices(false,false,false,false,false,false);
		tanklad[64].setFuelTypes(true,true,true);
		//Euro Oil
		tanklad[64] = new Tankla("Euro Oil", "Koorti 20", logod[1]);
		tanklad[64].setServices(false,false,false,false,false,false);
		tanklad[64].setFuelTypes(true,true,true);
		tanklad[65] = new Tankla("Euro Oil", "Männiku tee 98 F", logod[1]);
		tanklad[65].setServices(false,false,false,false,false,false);
		tanklad[65].setFuelTypes(true,true,true);
		tanklad[66] = new Tankla("Euro Oil", "Viljandi mnt 36 A", logod[1]);
		tanklad[66].setServices(false,false,false,false,false,false);
		tanklad[66].setFuelTypes(true,true,true);
		tanklad[67] = new Tankla("Euro Oil", "Sadama tn 21", logod[1]);
		tanklad[67].setServices(false,false,false,false,false,false);
		tanklad[67].setFuelTypes(true,false,true);
		tanklad[68] = new Tankla("Euro Oil", "Paldiski mnt.48A", logod[1]);
		tanklad[68].setServices(false,false,false,false,false,false);
		tanklad[68].setFuelTypes(true,false,true);
		tanklad[69] = new Tankla("Euro Oil", "Paldiski mnt. 108B", logod[1]);
		tanklad[69].setServices(false,false,false,false,false,false);
		tanklad[69].setFuelTypes(true,true,true);
		//Viis Pluss
		tanklad[70] = new Tankla("Viis Pluss", "Linnu tee 64", logod[7]);
		tanklad[70].setServices(true,false,true,false,false,true);
		tanklad[70].setFuelTypes(true,true,true);
		//Favora
		tanklad[71] = new Tankla("Favora", "Tondi 6", logod[2]);
		tanklad[71].setServices(true,false,true,true,true,true);
		tanklad[71].setFuelTypes(true,true,true);
		
		
		
		adapter = new TanklaAdapter(main, R.layout.tankla, tanklad);
		
		setListAdapter(adapter);
	}
	
	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		
	}
	
	
}
