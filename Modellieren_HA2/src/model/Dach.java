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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Dach other = (Dach) obj;
		return Double.compare(this.neigung, other.neigung) == 0 &&
			   this.id.equals(other.id);
	}

}
