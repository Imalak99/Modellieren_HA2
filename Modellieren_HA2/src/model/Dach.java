package model;

public class Dach {

	private String ifcID;
	private double neigung;

	public Dach(String ifcID, double neigung) {
		this.ifcID = ifcID;
		this.neigung = neigung;
	}

	public String getIfcID() {
		return ifcID;
	}

	public double getNeigung() {
		return neigung;
	}

	@Override
	public String toString() {
		return "Dach \n IFC ID: " + ifcID + "\n Neigung: " + neigung;
	}

}
