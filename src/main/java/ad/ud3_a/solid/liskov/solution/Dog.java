package ad.ud3_a.solid.liskov.solution;

public class Dog implements Animal,LightAnimal {

	@Override
	public void walk() {
		System.out.println("Soy un perro y camino a 4 patas");
		
	}

	@Override
	public void jump() {
		System.out.println("Soy un perro y salto con mis patas traseras");
	}

}
