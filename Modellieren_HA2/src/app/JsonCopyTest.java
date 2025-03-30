package app;

import json.utils.JsonUtils;

public class JsonCopyTest {

	public static void main(String[] args) {
		String sourcePathFzkHaus = "Z:\\ModellierenWiSe2425\\HA2\\JSON\\FZK Haus";
		String sourcePathOfficeBuilding = "Z:\\ModellierenWiSe2425\\HA2\\JSON\\Office Building";

		// Kopiert Daten aus FZK Haus
		JsonUtils.copyJsonFilesToPackage(sourcePathFzkHaus);
		// Kopiert Daten aus FZK Haus
		JsonUtils.copyJsonFilesToPackage(sourcePathOfficeBuilding);

	}

}
