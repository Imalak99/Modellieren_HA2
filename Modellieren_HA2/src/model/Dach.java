package model;

public class Dach {

	private String id;
	private double neigung;

	public Dach(String ifcID, double neigung) {
		this.id = ifcID;
		this.neigung = neigung;
	}

	public String getID() {
		return id;
	}

	public double getNeigung() {
		return neigung;
	}

	@Override
	public String toString() {
		return "Dach \n IFC ID: " + id + "\n Neigung: " + neigung;
	}

}
