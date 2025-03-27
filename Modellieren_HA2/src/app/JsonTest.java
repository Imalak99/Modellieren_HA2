package app;

import java.util.ArrayList;
import java.util.List;

import json.JsonUtils;
import model.Wand;

public class JsonTest {

	public static void main(String[] args) {

//		String dateipfadDataDaecher = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\DataDaecher.json";
//		String dateipfadDataWaende = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\DataWaende.json";
//		String dateipfadDataGeschossdecken = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\DataGeschossdecken.json";
//
//		List<Dach> daecher = new ArrayList<>();
//		List<Wand> waende = new ArrayList<>();
//		List<Geschossdecke> geschossdecken = new ArrayList<>();
//
//		daecher = JsonUtils.erzeugeDachListeAusJson(dateipfadDataDaecher);
//		waende = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende);
//		geschossdecken = JsonUtils.erzeugeGeschossdeckenListeAusJson(dateipfadDataGeschossdecken);
//

		String dateipfadDataWaende = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\DataWaende2.json";

		List<Wand> waende = new ArrayList<>();

		waende = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende);

		System.out.println(waende);

	}

}
