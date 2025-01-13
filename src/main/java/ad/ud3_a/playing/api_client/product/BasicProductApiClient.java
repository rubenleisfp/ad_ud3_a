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

	public void getAllProducts() {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products")).GET().build();

		try {
			HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(respuesta.body());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ProductPage getAllProductsV2() {
		Gson gson = new Gson();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products")).GET().build();

		try {
			HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
			ProductPage productWrapper = gson.fromJson(respuesta.body(), ProductPage.class);
			return productWrapper;
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void getProduct(int id) {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products/" + id)).GET().build();

		try {
			HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(respuesta.body());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void searchProducts(String keyword) {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products/search?q=" + keyword)).GET().build();

		try {
			HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(respuesta.body());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void getProducts(int limit, int skip, String selection) {
		//https://dummyjson.com/products?limit=10&skip=10&select=title,price
		String url = String.format("https://dummyjson.com/products?limit=%s&skip=%s&select=%s",limit, skip, selection);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		try {
			HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(respuesta.body());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void getAllProductsCategories() {
		String url = String.format("https://dummyjson.com/products/categories");
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		try {
			HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(respuesta.body());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void getProductsOfCategory(String category) {
		String url = String.format("https://dummyjson.com/products/category/%s", category);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		try {
			HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(respuesta.body());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void addProduct(String jsonProduct) throws IOException, InterruptedException {
	
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/products/add"))
				.header("Content-Type", "application/json").POST(BodyPublishers.ofString(jsonProduct)).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		int statusCode = response.statusCode();
		if (statusCode != 201) {
			throw new  IOException("Error al agregar un producto. StatusCode: " + statusCode);
		}
	}
	
	public void updateProduct(int productId, String jsonProduct) throws IOException, InterruptedException {
		String url = String.format("https://dummyjson.com/products/%s", productId);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
				.header("Content-Type", "application/json").PUT(BodyPublishers.ofString(jsonProduct)).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		int statusCode = response.statusCode();
		if (statusCode != 200) {
			throw new  IOException("Error al actualizar un producto. StatusCode: " + statusCode);
		}
		System.out.println(response.body());
	}
	
	
	public void delete(int productId) throws IOException, InterruptedException {
		String url = String.format("https://dummyjson.com/products/%s", productId);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
				.header("Content-Type", "application/json").DELETE().build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		int statusCode = response.statusCode();
		if (statusCode != 200) {
			throw new  IOException("Error al eliminar un producto. StatusCode: " + statusCode);
		}
		System.out.println(response.body());
	}

	
	
}
