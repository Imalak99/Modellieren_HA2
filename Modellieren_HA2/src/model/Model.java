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
		return "Gebäudemodel: \n Wandliste: " + this.wandListe + "\n Geschossdeckenliste: " + this.geschossdeckenListe
				+ "\n Dachliste: " + this.dachListe;
	}

	public boolean equals(Model other) {
		if (other == null) {
			System.out.println("Das Modell ist null");
			return false;
		}

		boolean check = this.wandListe.equals(other.wandListe)
				&& this.geschossdeckenListe.equals(other.geschossdeckenListe) && this.dachListe.equals(other.dachListe);
		if (check) {
			System.out.println("Die Modelle sind gleich");
		} else {
			System.out.println("Die Modelle sind nicht gleich");
			// hier könnte noch eine methode aufgerufen werden, welche die unterschiede
			// ausgibt.
		}
		return check;
	}

}
