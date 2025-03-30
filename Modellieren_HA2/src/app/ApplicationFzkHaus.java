package app;

import java.util.ArrayList;
import java.util.List;

import json.utils.JsonUtils;
import model.Dach;
import model.Geschossdecke;
import model.Model;
import model.Wand;

public class ApplicationFzkHaus {

	public static void main(String[] args) {

		// Kopiert JSON Dateien aus Lokalen Ordner in Projekt
		String sourcePathFzkHaus = "Z:\\ModellierenWiSe2425\\HA2\\JSON\\FZK Haus";
		JsonUtils.copyJsonFilesToPackage(sourcePathFzkHaus);

		// Erzeuge Model 1
		String dateipfadDataDaecher = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataDaecherFzkHaus.json";
		String dateipfadDataWaende = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataWaendeFzkHaus.json";
		String dateipfadDataGeschossdecken = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataGeschossdeckenFzkHaus.json";

		List<Dach> daecher = new ArrayList<>();
		List<Wand> waende = new ArrayList<>();
		List<Geschossdecke> geschossdecken = new ArrayList<>();

		daecher = JsonUtils.erzeugeDachListeAusJson(dateipfadDataDaecher);
		waende = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende);
		geschossdecken = JsonUtils.erzeugeGeschossdeckenListeAusJson(dateipfadDataGeschossdecken);

		Model model1 = new Model(waende, geschossdecken, daecher);

		// Erzeuge Model 2 mit Veränderung
		String dateipfadDataDaecher_veraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataDaecherFzkHaus_veraendert.json";
		String dateipfadDataWaende_veraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataWaendeFzkHaus_veraendert.json";
		String dateipfadDataGeschossdecken_veraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataGeschossdeckenFzkHaus_veraendert.json";

		List<Dach> daecher_veraendert = new ArrayList<>();
		List<Wand> waende_veraendert = new ArrayList<>();
		List<Geschossdecke> geschossdecken_veraendert = new ArrayList<>();

		daecher_veraendert = JsonUtils.erzeugeDachListeAusJson(dateipfadDataDaecher_veraendert);
		waende_veraendert = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende_veraendert);
		geschossdecken_veraendert = JsonUtils.erzeugeGeschossdeckenListeAusJson(dateipfadDataGeschossdecken_veraendert);

		Model model2 = new Model(waende_veraendert, geschossdecken_veraendert, daecher_veraendert);

		// Erzeuge Model 3 gleich wie Model1
		String dateipfadDataDaecher_unveraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataDaecherFzkHaus_unveraendert.json";
		String dateipfadDataWaende_unveraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataWaendeFzkHaus_unveraendert.json";
		String dateipfadDataGeschossdecken_unveraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataGeschossdeckenFzkHaus_unveraendert.json";

		List<Dach> daecher_unveraendert = new ArrayList<>();
		List<Wand> waende_unveraendert = new ArrayList<>();
		List<Geschossdecke> geschossdecken_unveraendert = new ArrayList<>();

		daecher_unveraendert = JsonUtils.erzeugeDachListeAusJson(dateipfadDataDaecher_unveraendert);
		waende_unveraendert = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende_unveraendert);
		geschossdecken_unveraendert = JsonUtils
				.erzeugeGeschossdeckenListeAusJson(dateipfadDataGeschossdecken_unveraendert);

		Model model3 = new Model(waende_unveraendert, geschossdecken_unveraendert, daecher_unveraendert);

		// Vergleich der Modelle
		model1.equals(model2);
		model1.equals(model3);
		model2.equals(model3);
	}

}
