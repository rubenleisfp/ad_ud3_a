package ad.ud3_a.solid.openclose.problem;

public class Vehicle {

	private String  typeKey;
	
	public Vehicle(String typeKey) {
		this.typeKey= typeKey;
	}
	
	public VehicleType getType() {
		if (this.getTypeKey().equals("C")) {
			return VehicleType.CAR;
		} else if (this.getTypeKey().equals("M")) {
			return VehicleType.MOTORBIKE;
		} else {
			throw new IllegalArgumentException("Tipo de vehiculo no valido");
		}
	}
	
	public String getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}
	

}
