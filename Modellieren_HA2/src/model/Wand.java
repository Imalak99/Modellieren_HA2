package model;

public class Wand {

	private String ifcID;
	private double hoehe;
	private double dicke;
	private int anzahlFenster;
	private double nettoVolumen;
	private Material material;

	public Wand(String ifcID, double hoehe, double dicke, int anzahlFenster, double nettoVolumen, Material material) {
		this.ifcID = ifcID;
		this.hoehe = hoehe;
		this.dicke = dicke;
		this.anzahlFenster = anzahlFenster;
		this.nettoVolumen = nettoVolumen;
		this.material = material;
	}

	public String ifcID() {
		return ifcID;
	}

	public double getHoehe() {
		return hoehe;
	}

	public double getDicke() {
		return dicke;
	}

	public int getAnzahlFenster() {
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
		return "Wand:\n IFC ID: " + ifcID + "\n Höhe: " + hoehe + "\n Dicke: " + dicke + "\n Anzahl Fenster: "
				+ anzahlFenster + "\n Netto Volumen: " + nettoVolumen + "\n Material: " + material.getMaterialName();
	}

}
