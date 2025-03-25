package model;

import java.util.List;

public class Model {

	private List<Wand> wandListe;
	private List<Geschossdecke> geschossdeckenListe;
	private List<Dach> dachListe;

	public Model(List<Wand> wandListe, List<Geschossdecke> geschossdeckenListe, List<Dach> dachListe) {
		this.wandListe = wandListe;
		this.geschossdeckenListe = geschossdeckenListe;
		this.dachListe = dachListe;
	}

	public List<Wand> getWandListe() {
		return wandListe;
	}

	public List<Geschossdecke> getGeschossdeckenListe() {
		return geschossdeckenListe;
	}

	public List<Dach> getDachListe() {
		return dachListe;
	}

	@Override
	public String toString() {
		return "Gebäudemodel: \n Wandliste: " + this.wandListe;
	}

}
