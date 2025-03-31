package json.utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
	/**
	 * Kopiert alle JSON-Dateien aus einem Quellordner in das Package-Verzeichnis
	 * und benennt sie ggf. in ".json" um.
	 *
	 * @param sourceFolder Der Pfad zum Quellordner mit den JSON-Dateien.
	 */
	public static void copyJsonFilesToPackage(String sourceFolder) {
		String projectPath = System.getProperty("user.dir"); // Eclipse-Projektverzeichnis
		String targetPath = Paths.get(projectPath, "src", "json", "files").toString();

		try {
			Files.createDirectories(Paths.get(targetPath)); // Zielverzeichnis erstellen

			try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(sourceFolder))) { // Alle Dateien im
																										// Quellordner
				for (Path file : stream) {
					if (Files.isRegularFile(file)) {
						Path targetFile = Paths.get(targetPath, file.getFileName().toString());

						// Kopieren der Datei
						Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Datei kopiert: " + targetFile);

						// Umbenennen in .json, wenn noch nicht vorhanden
						if (!targetFile.getFileName().toString().endsWith(".json")) {
							Path renamedFile = Paths.get(targetPath, targetFile.getFileName().toString() + ".json");
							Files.move(targetFile, renamedFile, StandardCopyOption.REPLACE_EXISTING);
							System.out.println("Datei umbenannt in: " + renamedFile);
						}
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Kopieren oder Umbenennen der Dateien: " + e.getMessage());
		}
	}

	/**
	 * Erstellt eine Liste von Dach-Objekten aus einer JSON-Datei.
	 *
	 * @param dateipfadDataDaecher Der Pfad zur JSON-Datei mit den Dachdaten.
	 * @return Eine Liste von Dach-Objekten.
	 */
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

	/**
	 * Erstellt eine Liste von Wand-Objekten aus einer JSON-Datei.
	 *
	 * @param dateipfadDataWaende Der Pfad zur JSON-Datei mit den Wanddaten.
	 * @return Eine Liste von Wand-Objekten.
	 */
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

	/**
	 * Erstellt eine Liste von Geschossdecken-Objekten aus einer JSON-Datei.
	 *
	 * @param dateipfadDataGeschossdecken Der Pfad zur JSON-Datei mit den
	 *                                    Geschossdeckendaten.
	 * @return Eine Liste von Geschossdecke-Objekten.
	 */
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
