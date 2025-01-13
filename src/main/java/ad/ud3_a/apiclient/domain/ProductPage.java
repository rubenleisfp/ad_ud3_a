package ad.ud3_a.apiclient.domain;

import java.util.List;

/**
 * Clase envoltorio que contiene una lista de productos dentro con su paginacion
 */
public class ProductPage {

	private List<Product> products;

	private int total;
	private int skip;
	private int limit;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductWrapper [products=" + products + ", total=" + total + ", skip=" + skip + ", limit=" + limit
				+ "]";
	}



}
