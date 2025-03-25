package model;

public class Material {

	private String materialName;

	public Material(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialName() {
		return materialName;
	}

	@Override
	public String toString() {
		return "Material: " + materialName;
	}

}
