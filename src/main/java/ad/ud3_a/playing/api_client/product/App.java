package ad.ud3_a.playing.api_client.product;

import java.io.IOException;

public class App {

	BasicProductApiClient apiCaller = new BasicProductApiClient();
	
	public static void main(String[] args) {

		App app = new App();
		app.procesar();
	}
	
	public void procesar() {
		apiCaller.getAllProducts();
		//apiCaller.getProduct(1);
		//apiCaller.searchProduct("phone");
		//apiCaller.getProducts(3, 1, "title,price");
		//apiCaller.getAllProductsCategories();
		apiCaller.getProductsOfCategory("fragrances");
		try {
			apiCaller.addProduct("{\r\n"
					+ "    \"BMW\": \"Pencil\"\r\n"
					+ "}");
			
			System.out.println("Update:");
			apiCaller.updateProduct(1, "{\r\n"
					+ "    \"title\": \"iPhone Galaxy +1\"\r\n"
					+ "}");
			apiCaller.delete(1);
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
