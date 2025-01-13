package ad.ud3_a.solid.openclose.problem;

public class App {

	private VehiclePrinter printer = new VehiclePrinter();
	
	public static void main(String[] args) {
		
		App app = new App();
		app.run();
	}
	
	public void run() {
		Vehicle coche = new Vehicle("C");
		Vehicle moto = new Vehicle("M");
		
		printer.draw(coche);
		printer.draw(moto);
	}

}
