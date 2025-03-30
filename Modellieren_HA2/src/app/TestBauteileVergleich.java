package app;

import model.Dach;
import model.Geschossdecke;
import model.Material;
import model.Wand;

public class TestBauteileVergleich {

	public static void main(String[] args) {

		Material beton = new Material("beton");
		Wand wand1 = new Wand("asdf", 2., 2., 2., 2., beton);
		Wand wand2 = new Wand("asdf", 2., 2., 2., 2., beton);

		System.out.println(wand1.equals(wand2));

		Dach dach1 = new Dach("adf", 20.);
		Dach dach2 = new Dach("adf", 20.);

		System.out.println(dach1.equals(dach2));

		Geschossdecke decke1 = new Geschossdecke("asdf", 2., 2., beton);
		Geschossdecke decke2 = new Geschossdecke("asdf", 2., 2., beton);

		System.out.println(decke1.equals(decke2));

		Material beton2 = new Material("beton");
		System.out.println(beton.equals(beton2));
	}

}
