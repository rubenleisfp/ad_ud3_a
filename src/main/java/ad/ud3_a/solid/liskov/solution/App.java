package ad.ud3_a.solid.liskov.solution;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
	
		Dog dog = new Dog();
		Cat cat = new Cat();
		Elephant elephant = new Elephant();
		
		List<Animal> animales = new ArrayList<Animal>();
		animales.add(dog);
		animales.add(cat);
		animales.add(elephant);
		for (Animal a:  animales) {
			a.walk();
		}
		
		
		List<LightAnimal> animalesLigeros = new ArrayList<LightAnimal>();
		animalesLigeros.add(dog);
		animalesLigeros.add(cat);
		//animalesLigeros.add(elephant);
		for (LightAnimal a:  animalesLigeros) {
			a.jump();
		}
		
	}

}
