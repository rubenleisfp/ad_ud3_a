package ad.ud3_a.apiclient.service;

import java.io.IOException;
import java.util.List;

import ad.ud3_a.apiclient.domain.Product;
import ad.ud3_a.apiclient.domain.ProductPage;

public class AppProduct {

	private ProductApiCaller productApiCaller = new ProductApiCallerImpl("https://dummyjson.com/products");

	// FIXMNE: Harcoding. Esta informacion la debería introducir el usuario
	private static final String OPERATION = "GET_DETAIL";
	private static final String SEARCH_WORD = "laptop";
	private static final String CATEGORY = "fragrances";
	private static final int PRODUCT_ID = 10000;

	public static void main(String[] args) {
		AppProduct app = new AppProduct();
		try {
			app.run();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private void run() throws IOException, InterruptedException {

		Product product = new Product();
		ProductPage productWrapper = new ProductPage();

		try {
			switch (OPERATION) {
			case "CREATE":
				System.out.println("CREATE:");
				product.setBrand("brand");
				productApiCaller.addProduct(product);
				System.out.println("Producto creado");
				break;

			case "DELETE":
				System.out.println("DELETE:" + PRODUCT_ID);

				productApiCaller.deleteProduct(PRODUCT_ID);

				System.out.println("Producto eliminado");
				break;

			case "GET_ALL":
				System.out.println("GET_ALL:");
				productWrapper = productApiCaller.getAllProducts();
				pintarProductos(productWrapper);
				break;

			case "GET_DETAIL":
				System.out.println("GET_DETAIL:" + PRODUCT_ID);
				product = productApiCaller.getProduct(PRODUCT_ID);
				if (product != null) {
					System.out.println("product: " + product);
				}
				break;

			case "SEARCH_PRODUCT":
				System.out.println("SEARCH_PRODUCT:" + SEARCH_WORD);
				productWrapper = productApiCaller.searchProducts(SEARCH_WORD);
				pintarProductos(productWrapper);
				break;

			case "GET_ALL_PRODUCT_CATEGORIES":
				System.out.println("GET_ALL_PRODUCT_CATEGORIES:");
				List<String> categories = productApiCaller.getAllProductsCategories();
				for (String c : categories) {
					System.out.println(c);
				}
				break;

			case "GET_PRODUCTS_OF_CATEGORY":
				System.out.println("GET_PRODUCTS_OF_CATEGORY:");
				productWrapper = productApiCaller.getProductsOfCategory(CATEGORY);
				pintarProductos(productWrapper);
				break;

			default:
				throw new IllegalArgumentException("Operacion no soportada");

			}
		} catch (IOException | InterruptedException ex) {
			System.out.println("Error al intentar establecer la comunicación con el  API");
		} catch (ApiCallException e) {
			System.out.println("Error durante la comunicación con el API");
			System.out.println("Message:" + e.getMessage());
			System.out.println("ResponseBody:" + e.getResponseBody());
			System.out.println("StatusCode:" + e.getStatusCode());
		}

	}

	private void pintarProductos(ProductPage productWrapper) {
		if (productWrapper != null && productWrapper.getProducts() != null) {
			System.out.println(productWrapper);
		}
	}

}
