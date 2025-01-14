package ad.ud3_a.playing.api_client.product;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import ad.ud3_a.apiclient.domain.ProductPage;

public class BasicProductApiClient {

	public String getAllProducts() {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
	
	public ProductPage getAllProductsV2() {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
	
	public String getProduct(int id) {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}

	public String searchProducts(String keyword) {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
	
	public String getProducts(int limit, int skip, String selection) {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
	
	public String getAllProductsCategories() {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
	
	public String getProductsOfCategory(String category) {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
	
	public String addProduct(String jsonProduct) throws IOException, InterruptedException {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
	
	public String updateProduct(int productId, String jsonProduct) throws IOException, InterruptedException {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
	
	public String delete(int productId) throws IOException, InterruptedException {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
}
