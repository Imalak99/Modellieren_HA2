package json.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dach;
import model.Geschossdecke;
import model.Material;
import model.Wand;

public class JsonUtils {

	public static void copyJsonToPackage(String sourcePath, String targetPackage) throws IOException {
		// Zielpfad innerhalb des Projekts definieren
		String projectPath = System.getProperty("user.dir"); // Root-Verzeichnis des Projekts
		String targetPath = projectPath + "/src/" + targetPackage.replace(".", "/") + "/DataDaecher.json";

		// Datei kopieren
		Files.copy(Paths.get(sourcePath), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);

		System.out.println("Datei erfolgreich kopiert nach: " + targetPath);
	}

//	public static boolean jsonValidator(String jsonFilePath) {
//		ObjectMapper objectMapper = new ObjectMapper();
//
//		try {
//			// Versuche, das JSON in eine Map<String, Dach> zu deserialisieren
//			Map<String, Dach> dacher = objectMapper.readValue(new File(jsonFilePath),
//					new TypeReference<Map<String, Dach>>() {
//					});
//
//			// Durch die Map iterieren und jedes Dach-Objekt validieren
//			for (Map.Entry<String, Dach> entry : dacher.entrySet()) {
//				Dach dach = entry.getValue();
//				System.out.println("JSON validiert! ID: " + dach.getID() + ", Neigung: " + dach.getNeigung());
//			}
//
//			return true; // JSON ist gültig
//		} catch (IOException e) {
//			System.out.println("Fehler beim Lesen oder Verarbeiten der Datei: " + e.getMessage());
//		}
//
//		return false; // JSON ist ungültig
//	}

	public static ArrayList<Dach> erzeugeDachListeAusJson(String dateipfadDataDaecher) {
		ArrayList<Dach> dachListe = new ArrayList<>();
		try {
			// Die Datei in einen String einlesen
			String json = new String(Files.readAllBytes(Paths.get(dateipfadDataDaecher)));

			// Jackson ObjectMapper zum Deserialisieren der JSON verwenden
			ObjectMapper objectMapper = new ObjectMapper();

			// JSON in JsonNode umwandeln
			JsonNode rootNode = objectMapper.readTree(json);

			// Durch alle Dacheinträge in der JSON iterieren
			Iterator<Entry<String, JsonNode>> fields = rootNode.fields();
			while (fields.hasNext()) {
				Entry<String, JsonNode> field = fields.next();
				JsonNode dachNode = field.getValue();
				// Daten extrahieren
				String id = dachNode.get("ID").asText();
				double neigung = dachNode.get("Neigung").asDouble();

				// Dach-Objekt erstellen und zur Liste hinzufügen
				dachListe.add(new Dach(id, neigung));
			}
		} catch (IOException e) {
			// Fehler behandeln, z. B. Fehlermeldung ausgeben
			e.printStackTrace();
		}
		return dachListe;
	}

	public static List<Wand> erzeugeWandListeAusJson(String dateipfadDataWaende) {
		ArrayList<Wand> wandListe = new ArrayList<>();
		try {
			// Die Datei in einen String einlesen
			String json = new String(Files.readAllBytes(Paths.get(dateipfadDataWaende)));

			// Jackson ObjectMapper zum Deserialisieren der JSON verwenden
			ObjectMapper objectMapper = new ObjectMapper();

			// JSON in JsonNode umwandeln
			JsonNode rootNode = objectMapper.readTree(json);

			// Durch alle Wandeinträge in der JSON iterieren
			Iterator<Entry<String, JsonNode>> fields = rootNode.fields();
			while (fields.hasNext()) {
				Entry<String, JsonNode> field = fields.next();
				JsonNode wandNode = field.getValue();

				// Daten extrahieren
				Material ifcMaterial = new Material(wandNode.get("Ifc Material").asText());
				String id = wandNode.get("ID").asText();
				double dicke = wandNode.get("Dicke").asDouble();
				double anzahlFenster = wandNode.get("Anzahl der Fenster").asDouble();
				double nettoVolumen = wandNode.get("Volumen").asDouble();
				double hoehe = wandNode.get("Volumen").asDouble();

				wandListe.add(new Wand(id, hoehe, dicke, anzahlFenster, nettoVolumen, ifcMaterial));
			}
		} catch (IOException e) {
			// Fehler behandeln, z. B. Fehlermeldung ausgeben
			e.printStackTrace();
		}

		return wandListe;
	}

	public static List<Geschossdecke> erzeugeGeschossdeckenListeAusJson(String dateipfadDataGeschossdecken) {
		ArrayList<Geschossdecke> geschossdeckenListe = new ArrayList<>();
		try {
			// Die Datei in einen String einlesen
			String json = new String(Files.readAllBytes(Paths.get(dateipfadDataGeschossdecken)));

			// Jackson ObjectMapper zum Deserialisieren der JSON verwenden
			ObjectMapper objectMapper = new ObjectMapper();

			// JSON in JsonNode umwandeln
			JsonNode rootNode = objectMapper.readTree(json);

			// Durch alle Wandeinträge in der JSON iterieren
			Iterator<Entry<String, JsonNode>> fields = rootNode.fields();
			while (fields.hasNext()) {
				Entry<String, JsonNode> field = fields.next();
				JsonNode geschossdeckeNode = field.getValue();

				// Daten extrahieren
				Material ifcMaterial = new Material(geschossdeckeNode.get("Ifc Material").asText());
				String id = geschossdeckeNode.get("ID").asText();
				double dicke = geschossdeckeNode.get("Dicke").asDouble();
				double Volumen = geschossdeckeNode.get("Volumen").asDouble();

				geschossdeckenListe.add(new Geschossdecke(id, dicke, Volumen, ifcMaterial));
			}
		} catch (IOException e) {
			// Fehler behandeln, z. B. Fehlermeldung ausgeben
			e.printStackTrace();
		}

		return geschossdeckenListe;
	}

}
