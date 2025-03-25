package model;

public class Geschossdecke {

	private String ifcID;
	private double dicke;
	private double nettoVolumen;
	private Material material;

	public Geschossdecke(String ifcID, double dicke, double nettoVolumen, Material material) {
		this.ifcID = ifcID;
		this.dicke = dicke;
		this.nettoVolumen = nettoVolumen;
		this.material = material;
	}

	public String getIfcID() {
		return ifcID;
	}

	public double getDicke() {
		return dicke;
	}

	public double getNettoVolumen() {
		return nettoVolumen;
	}

	public Material getMaterial() {
		return material;
	}

	@Override
	public String toString() {
		return "Geschossdecke:\n IFC ID: " + ifcID + "\n Dicke: " + dicke + "\n Netto Volumen: " + nettoVolumen
				+ "\n Material: " + material.getMaterialName();
	}

}
