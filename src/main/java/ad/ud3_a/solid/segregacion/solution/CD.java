package ad.ud3_a.solid.segregacion.solution;

public class CD implements Product {

	private String name;
	private int stock;
	private int numberOfDisks;
	private int releaseDate;
	
	public CD(String name, int stock, int numberOfDisks, int releaseDate) {
		this.name = name;
		this.stock = stock;
		this.numberOfDisks = numberOfDisks;
		this.releaseDate = releaseDate;
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



}
