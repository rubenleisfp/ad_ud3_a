package ad.ud3_a.solid.singlereponsabilty.problem;

public class Vehicle {

	public int getWheelCount() {
		return 4;
	}
	
	public int getMaxSpeed() {
		return 200;
	}

	@Override
	public String toString() {
		return "Vehicle [getWheelCount()=" + getWheelCount() + ", getMaxSpeed()=" + getMaxSpeed() + "]";
	}
	
	public void print() {
		System.out.println(toString());
	}

}
