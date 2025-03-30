package json.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

public class JsonValidator {

	public static boolean validateJson(String jsonFilePath, String schemaFilePath) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			// JSON und Schema laden
			String jsonData = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
			String schemaData = new String(Files.readAllBytes(Paths.get(schemaFilePath)));

			JsonNode jsonNode = objectMapper.readTree(jsonData);
			JsonNode schemaNode = objectMapper.readTree(schemaData);

			// Schema erstellen (Draft-07 nutzen)
			JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
			JsonSchema schema = factory.getSchema(schemaNode);

			// Validierung durchführen
			Set<ValidationMessage> validationResult = schema.validate(jsonNode);

			// Fehler ausgeben, falls vorhanden
			if (!validationResult.isEmpty()) {
				validationResult.forEach(msg -> System.out.println("Validierungsfehler: " + msg.getMessage()));
				return false;
			}

			System.out.println("JSON ist gültig!");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
