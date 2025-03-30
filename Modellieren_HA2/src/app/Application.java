package app;

import java.util.ArrayList;
import java.util.List;

import json.utils.JsonUtils;
import model.Dach;
import model.Geschossdecke;
import model.Model;
import model.Wand;

public class Application {

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

		Model model1 = new Model(waende, geschossdecken, daecher);

		// Erzeuge Model 2 mit Veränderung
		String dateipfadDataDaecher_veraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataDaecher_veraendert.json";
		String dateipfadDataWaende_veraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataWaende_veraendert.json";
		String dateipfadDataGeschossdecken_veraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataGeschossdecken_veraendert.json";

		List<Dach> daecher_veraendert = new ArrayList<>();
		List<Wand> waende_veraendert = new ArrayList<>();
		List<Geschossdecke> geschossdecken_veraendert = new ArrayList<>();

		daecher_veraendert = JsonUtils.erzeugeDachListeAusJson(dateipfadDataDaecher_veraendert);
		waende_veraendert = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende_veraendert);
		geschossdecken_veraendert = JsonUtils.erzeugeGeschossdeckenListeAusJson(dateipfadDataGeschossdecken_veraendert);

		Model model2 = new Model(waende_veraendert, geschossdecken_veraendert, daecher_veraendert);

		System.out.println(model1);
		System.out.println("------------------");
		System.out.println(model2);
	}

}
