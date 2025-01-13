package ad.ud3_a.solid.liskov.solution;

public class Cat implements Animal,LightAnimal {

	@Override
	public void walk() {
		System.out.println("Soy un gato y camino con sigilo");
		
	}

	@Override
	public void jump() {
		System.out.println("Soy un perro y salto muchisimo!");
	}

}
