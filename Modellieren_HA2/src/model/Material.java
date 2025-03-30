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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Material other = (Material) obj;
		return this.materialName.equals(other.materialName);
	}
}
