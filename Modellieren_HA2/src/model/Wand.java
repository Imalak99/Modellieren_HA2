package model;

public class Wand {

	private String id;
	private double hoehe;
	private double dicke;
	private double anzahlFenster;
	private double nettoVolumen;
	private Material material;

	public Wand(String ifcID, double hoehe, double dicke, double anzahlFenster, double nettoVolumen,
			Material material) {
		this.id = ifcID;
		this.hoehe = hoehe;
		this.dicke = dicke;
		this.anzahlFenster = anzahlFenster;
		this.nettoVolumen = nettoVolumen;
		this.material = material;
	}

	public String ifcID() {
		return id;
	}

	public double getHoehe() {
		return hoehe;
	}

	public double getDicke() {
		return dicke;
	}

	public double getAnzahlFenster() {
		return anzahlFenster;
	}

	public double getNettoVolumen() {
		return nettoVolumen;
	}

	public Material getMaterial() {
		return material;
	}

	@Override
	public String toString() {
		return "Wand:\n IFC ID: " + id + "\n Höhe: " + hoehe + "\n Dicke: " + dicke + "\n Anzahl Fenster: "
				+ anzahlFenster + "\n Netto Volumen: " + nettoVolumen + "\n Material: " + material.getMaterialName();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Wand other = (Wand) obj;
		return Double.compare(hoehe, other.hoehe) == 0 && Double.compare(dicke, other.dicke) == 0
				&& Double.compare(anzahlFenster, other.anzahlFenster) == 0
				&& Double.compare(nettoVolumen, other.nettoVolumen) == 0 && id.equals(other.id)
				&& material.equals(other.material);
	}

}
