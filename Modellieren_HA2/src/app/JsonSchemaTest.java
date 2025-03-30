package app;

import json.utils.JsonValidator;

public class JsonSchemaTest {

	public static void main(String[] args) {

//			String jsonFilePath = "Z:\\pfad\\zu\\deiner\\wand.json";
		String schemaFilePathDaecher = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\schema\\JsonSchemaDaecher.json";
		String jsonFilePathDaecher = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataDaecherFzkHaus.json";

		String schemaFilePathWaende = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\schema\\JsonSchemaWaende.json";
		String jsonFilePathWaende = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataWaendeFzkHaus.json";

		String schemaFilePathGeschossdecken = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\schema\\JsonSchemaGeschossdecken.json";
		String jsonFilePathGeschossdecken = "Z:\\git\\Modellieren_HA2\\Modellieren_HA2\\src\\json\\files\\DataGeschossdeckenFzkHaus.json";

		JsonValidator.validateJson(jsonFilePathDaecher, schemaFilePathDaecher);
		JsonValidator.validateJson(jsonFilePathWaende, schemaFilePathWaende);
		JsonValidator.validateJson(jsonFilePathGeschossdecken, schemaFilePathGeschossdecken);

	}

}
