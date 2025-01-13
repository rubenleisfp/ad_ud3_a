package ad.ud3_a.solid.segregacion.solution;

public class DVD implements Product, AgeAware {

	private String name;
	private int stock;
	private int numberOfDisks;
	private int releaseDate;
	private int recomendedAge;
	
	public DVD(String name, int stock, int numberOfDisks, int releaseDate, int recomendedAge) {
		this.name = name;
		this.stock = stock;
		this.numberOfDisks = numberOfDisks;
		this.releaseDate = releaseDate;
		this.recomendedAge = recomendedAge;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getStock() {
		return this.stock;
	}

	@Override
	public int getNumberOfDisks() {
		return this.numberOfDisks;
	}

	@Override
	public int getReleaseDate() {
		return this.releaseDate;
	}

	@Override
	public int getRecomendedAge() {
		return this.recomendedAge;
	}

}
