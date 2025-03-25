package app;

import java.util.ArrayList;
import java.util.List;

import model.Dach;
import model.Geschossdecke;
import model.Material;
import model.Model;
import model.Wand;

public class Test {

	public static void main(String[] args) {
		Material beton = new Material("Beton C25/30");
		System.out.println(beton);

		String ifcID = "asfhasdöf";

		Wand wand = new Wand(ifcID, 1, 1, 1, 1, beton);
		System.out.println(wand);

		Geschossdecke decke = new Geschossdecke(ifcID, 1, 1, beton);
		System.out.println(decke);

		Dach dach = new Dach(ifcID, 30);
		System.out.println(dach);

		List<Wand> wandliste = new ArrayList<>();
		wandliste.add(wand);

		List<Dach> dachliste = new ArrayList<>();
		dachliste.add(dach);

		List<Geschossdecke> geschossdeckenliste = new ArrayList<>();
		geschossdeckenliste.add(decke);

		Model model = new Model(wandliste, geschossdeckenliste, dachliste);
		System.out.println(model);

	}

}
