package ad.ud3_a.apiclient.product.domain;

import java.util.List;
import java.util.Objects;

/**
 * Clase envoltorio que contiene una lista de productos dentro con su paginacion
 */
public class ProductPage {

	private List<Product> products;

	private int total;
	private int skip;
	private int limit;


	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductPage that = (ProductPage) o;
		return total == that.total && skip == that.skip && limit == that.limit && Objects.equals(products, that.products);
	}

	@Override
	public int hashCode() {
		return Objects.hash(products, total, skip, limit);
	}

	@Override
	public String toString() {
		return "ProductPage{" +
				"products=" + products +
				", total=" + total +
				", skip=" + skip +
				", limit=" + limit +
				'}';
	}
}
