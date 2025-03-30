package app;

import java.util.ArrayList;
import java.util.List;

import model.Dach;
import model.Geschossdecke;
import model.Material;
import model.Model;
import model.Wand;

public class ModelTest {

	public static void main(String[] args) {
		// Model 1
		Material beton1 = new Material("Beton C25/30");

		String ifcID1 = "asfhasdöf";

		Wand wand1 = new Wand(ifcID1, 1, 1, 1, 1, beton1);

		Geschossdecke decke1 = new Geschossdecke(ifcID1, 1, 1, beton1);

		Dach dach1 = new Dach(ifcID1, 30);

		List<Wand> wandliste1 = new ArrayList<>();
		wandliste1.add(wand1);

		List<Dach> dachliste1 = new ArrayList<>();
		dachliste1.add(dach1);

		List<Geschossdecke> geschossdeckenliste1 = new ArrayList<>();
		geschossdeckenliste1.add(decke1);

		Model model1 = new Model(wandliste1, geschossdeckenliste1, dachliste1);
//		System.out.println(model1);
//
//		System.out.println("-----------------------------");

		// Model2 gleich wie Model 1
		Material beton2 = new Material("Beton C25/30");

		String ifcID2 = "asfhasdöfs";

		Wand wand2 = new Wand(ifcID2, 1, 1, 1, 1, beton2);

		Geschossdecke decke2 = new Geschossdecke(ifcID2, 1, 1, beton2);

		Dach dach2 = new Dach(ifcID2, 30);

		List<Wand> wandliste2 = new ArrayList<>();
		wandliste2.add(wand2);

		List<Dach> dachliste2 = new ArrayList<>();
		dachliste2.add(dach2);

		List<Geschossdecke> geschossdeckenliste2 = new ArrayList<>();
		geschossdeckenliste2.add(decke2);
		Model model2 = new Model(wandliste2, geschossdeckenliste2, dachliste2);
//		System.out.println(model2);
//
//		System.out.println("-----------------------------");

//		model1.equals(model2);

	}

}
