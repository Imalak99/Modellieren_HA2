package app;

import java.util.ArrayList;
import java.util.List;

import json.utils.JsonUtils;
import json.utils.JsonValidator;
import model.Dach;
import model.Geschossdecke;
import model.Model;
import model.Wand;

/**
 * Diese Klasse Importiert Json Dateien, die Daten aus dem IFC Modell Office
 * Building enthalten, validiert die Json Dateien anhand der entsprechenden
 * Schemata, erzeugt ein Gebäudemodel anhand der Daten und vergleicht drei
 * Gebäudemodelle miteinander.
 */
public class ApplicationOfficeBuilding {

	public static void main(String[] args) {

		// Kopiert JSON Dateien aus Lokalen Ordner in Projekt
		String sourcePathOfficeBuilding = "Z:\\ModellierenWiSe2425\\HA2\\JSON\\Office Building";
		JsonUtils.copyJsonFilesToPackage(sourcePathOfficeBuilding);

		// Erzeuge Model 1
		String dateipfadDataDaecher = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataDaecherOfficeBuilding.json";
		String dateipfadDataWaende = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataWaendeOfficeBuilding.json";
		String dateipfadDataGeschossdecken = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataGeschossdeckenOfficeBuilding.json";

		// Validierung der JSON Dateien
		String schemaFilePathDaecher = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\schema\\JsonSchemaDaecher.json";
		String schemaFilePathWaende = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\schema\\JsonSchemaWaende.json";
		String schemaFilePathGeschossdecken = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\schema\\JsonSchemaGeschossdecken.json";
		JsonValidator.validateJson(dateipfadDataDaecher, schemaFilePathDaecher);
		JsonValidator.validateJson(dateipfadDataWaende, schemaFilePathWaende);
		JsonValidator.validateJson(dateipfadDataGeschossdecken, schemaFilePathGeschossdecken);

		List<Dach> daecher = new ArrayList<>();
		List<Wand> waende = new ArrayList<>();
		List<Geschossdecke> geschossdecken = new ArrayList<>();

		daecher = JsonUtils.erzeugeDachListeAusJson(dateipfadDataDaecher);
		waende = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende);
		geschossdecken = JsonUtils.erzeugeGeschossdeckenListeAusJson(dateipfadDataGeschossdecken);

		Model model1 = new Model(waende, geschossdecken, daecher);
//		System.out.println(model1);

		// Erzeuge Model 2 mit Veränderung
		String dateipfadDataDaecher_veraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataDaecherOfficeBuilding_veraendert.json";
		String dateipfadDataWaende_veraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataWaendeOfficeBuilding_veraendert.json";
		String dateipfadDataGeschossdecken_veraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataGeschossdeckenOfficeBuilding_veraendert.json";

		// Validierung der JSON Dateien
		JsonValidator.validateJson(dateipfadDataDaecher_veraendert, schemaFilePathDaecher);
		JsonValidator.validateJson(dateipfadDataWaende_veraendert, schemaFilePathWaende);
		JsonValidator.validateJson(dateipfadDataGeschossdecken_veraendert, schemaFilePathGeschossdecken);

		List<Dach> daecher_veraendert = new ArrayList<>();
		List<Wand> waende_veraendert = new ArrayList<>();
		List<Geschossdecke> geschossdecken_veraendert = new ArrayList<>();

		daecher_veraendert = JsonUtils.erzeugeDachListeAusJson(dateipfadDataDaecher_veraendert);
		waende_veraendert = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende_veraendert);
		geschossdecken_veraendert = JsonUtils.erzeugeGeschossdeckenListeAusJson(dateipfadDataGeschossdecken_veraendert);
		Model model2 = new Model(waende_veraendert, geschossdecken_veraendert, daecher_veraendert);
//		System.out.println(model2);

		// Erzeuge Model 3 gleich wie Model1
		String dateipfadDataDaecher_unveraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataDaecherOfficeBuilding_unveraendert.json";
		String dateipfadDataWaende_unveraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataWaendeOfficeBuilding_unveraendert.json";
		String dateipfadDataGeschossdecken_unveraendert = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataGeschossdeckenOfficeBuilding_unveraendert.json";

		// Validierung der JSON Dateien
		JsonValidator.validateJson(dateipfadDataDaecher_unveraendert, schemaFilePathDaecher);
		JsonValidator.validateJson(dateipfadDataWaende_unveraendert, schemaFilePathWaende);
		JsonValidator.validateJson(dateipfadDataGeschossdecken_unveraendert, schemaFilePathGeschossdecken);

		List<Dach> daecher_unveraendert = new ArrayList<>();
		List<Wand> waende_unveraendert = new ArrayList<>();
		List<Geschossdecke> geschossdecken_unveraendert = new ArrayList<>();

		daecher_unveraendert = JsonUtils.erzeugeDachListeAusJson(dateipfadDataDaecher_unveraendert);
		waende_unveraendert = JsonUtils.erzeugeWandListeAusJson(dateipfadDataWaende_unveraendert);
		geschossdecken_unveraendert = JsonUtils
				.erzeugeGeschossdeckenListeAusJson(dateipfadDataGeschossdecken_unveraendert);

		Model model3 = new Model(waende_unveraendert, geschossdecken_unveraendert, daecher_unveraendert);

//		System.out.println(model1);
//		System.out.println("------------------");
//		System.out.println(model2);

		// Vergleich der Modelle
		model1.equals(model2);
		model1.equals(model3);
		model2.equals(model3);

	}

}
