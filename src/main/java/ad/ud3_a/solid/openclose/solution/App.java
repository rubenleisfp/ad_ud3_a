package ad.ud3_a.solid.openclose.solution;

public class App {

	public static void main(String[] args) {

		App app = new App();
		app.run();
	}

	public void run() {
		Vehicle v1 = new Car();
		Vehicle v2 = new Motorbike();

		v1.draw();
		v2.draw();

	}

}
