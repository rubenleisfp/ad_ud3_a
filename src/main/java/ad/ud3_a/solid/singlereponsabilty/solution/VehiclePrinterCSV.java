package ad.ud3_a.solid.singlereponsabilty.solution;

public class VehiclePrinterCSV {
	
	public void print(Vehicle vehicle) {
		System.out.println("MaxSpeed"+ "; " + "WheelCount");;
		System.out.println(vehicle.getMaxSpeed() + "; " + vehicle.getWheelCount());;
	}

}
