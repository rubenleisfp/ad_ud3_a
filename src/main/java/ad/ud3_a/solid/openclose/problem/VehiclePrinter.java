package ad.ud3_a.solid.openclose.problem;

public class VehiclePrinter {

	public void draw(Vehicle vehicle) {
		switch (vehicle.getType()) {

		case CAR:
			drawCar(vehicle);
			break;
		case MOTORBIKE:
			drawMotorbike();
			break;
		}
	}

	private void drawMotorbike() {
		System.out.println("Soy una moto y tengo 2 ruedas");
	}

	private void drawCar(Vehicle vehicle) {
		System.out.println("Soy un coche y tengo 4 ruedas");
	}
}
