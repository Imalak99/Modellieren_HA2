package app;

import java.util.ArrayList;
import java.util.List;

import json.utils.JsonUtils;
import model.Dach;
import model.Geschossdecke;
import model.Model;
import model.Wand;

public class JsonTest {

	public static void main(String[] args) {

		// Erzeuge Model 1
		String dateipfadDataDaecher = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataDaecher.json";
		String dateipfadDataWaende = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataWaende.json";
		String dateipfadDataGeschossdecken = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataGeschossdecken.json";

		List<Dach> daecher = new ArrayList<>();
		List<Wand> waende = new ArrayList<>();
		List<Geschossdecke> geschossdecken = new ArrayList<>();

		daecher = JsonUtils.erzeugeDachListeAusJson(dateipfadDataDaecher);
		waende = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende);
		geschossdecken = JsonUtils.erzeugeGeschossdeckenListeAusJson(dateipfadDataGeschossdecken);

//		System.out.println(waende);
//		System.out.println("----------------------");
//		System.out.println(daecher);
//		System.out.println("----------------------");
//		System.out.println(geschossdecken);

		Model modelFZKHaus = new Model(waende, geschossdecken, daecher);
		System.out.println(modelFZKHaus);

	}

}
