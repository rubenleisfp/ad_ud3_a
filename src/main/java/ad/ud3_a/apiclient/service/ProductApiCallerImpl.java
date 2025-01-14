package ad.ud3_a.apiclient.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.List;

import ad.ud3_a.apiclient.domain.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ad.ud3_a.apiclient.domain.Product;
import ad.ud3_a.apiclient.domain.ProductPage;

public class ProductApiCallerImpl implements ProductApiCaller {

	private String basePath;
	private Gson gson;

	// https://dummyjson.com/
	public ProductApiCallerImpl(String basePath) {
		this.basePath = basePath;
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}

	/**
	 * Obtiene todos los productos
	 *
	 * Ej. https://dummyjson.com/products
	 *
	 * GET
	 *
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public ProductPage getAllProducts() throws ApiCallException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		return getProductsPage(request);
	}

	/**
	 * Obtiene un producto a partir de su id
	 *
	 * GET
	 *
	 * Ej. https://dummyjson.com/product/1
	 *
	 * @param id
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public Product getProduct(int id) throws ApiCallException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath + "/" + id))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		Product product = getProduct(request);
		return product;
	}

	/**
	 * Hace la llamada de la request y devuelve un Product
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private Product getProduct(HttpRequest request) throws ApiCallException, IOException, InterruptedException {
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		handleResponse(response);
		Product product = gson.fromJson(response.body(), Product.class);
		return product;
	}

	/**
	 * Hace la llamada de la request y devuelve un ProductPage
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ApiCallException
	 */
	private ProductPage getProductsPage(HttpRequest request)
			throws IOException, InterruptedException, ApiCallException {
		HttpResponse<String> response = null;

		response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		handleResponse(response);
		ProductPage productPage = gson.fromJson(response.body(), ProductPage.class);
		return productPage;
	}

	/**
	 * Busca un producto con su categoria
	 *
	 * GET
	 *
	 * Ej: https://dummyjson.com/product/search?q=phone
	 *
	 * @param searchWord
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ApiCallException
	 */
	@Override
	public ProductPage searchProducts(String searchWord) throws IOException, InterruptedException, ApiCallException {
		String url = basePath + "/search?q=" + searchWord;
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		return getProductsPage(request);
	}

	/**
	 * Crea un nuevo producto
	 *
	 * POST
	 *
	 * @param product
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ApiCallException
	 */
	@Override
	public Product addProduct(Product product) throws IOException, InterruptedException, ApiCallException {
		String jsonProduct = gson.toJson(product);
		String url = basePath + "/add";
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json")
				.POST(BodyPublishers.ofString(jsonProduct)).build();
		return getProduct(request);
	}

	/**
	 * Actualiza un producto existe
	 *
	 * @param id             del producto a actualizar
	 * @param updatedProduct informacion del producto actualizado
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ApiCallException
	 */
	@Override
	public Product updateProduct(int id, Product updatedProduct)
			throws IOException, InterruptedException, ApiCallException {
		String jsonProduct = gson.toJson(updatedProduct);
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath + "/" + id))
				.header("Content-Type", "application/json").PUT(BodyPublishers.ofString(jsonProduct)).build();
		return getProduct(request);
	}

	@Override
	public Product deleteProduct(int id) throws ApiCallException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(basePath + "/" + id)).DELETE().build();
		return getProduct(request);
	}

	private void handleResponse(HttpResponse<String> response) throws ApiCallException {
		int statusCode = response.statusCode();
		if (statusCode != 200 && statusCode != 201) {
			handleError(response);
		}
	}

	private void handleError(HttpResponse<String> response) throws ApiCallException {

		String responseBody = response.body();

		switch (response.statusCode()) {
			case 404:
				throw new ApiCallException("El recurso no fue encontrado.", response.statusCode(), responseBody);
			case 400:
				throw new ApiCallException("Error en la solicitud del cliente.", response.statusCode(), responseBody);
			case 500:
				throw new ApiCallException("Error en el servidor.", response.statusCode(), responseBody);
			default:
				throw new ApiCallException("Error desconocido", response.statusCode(), responseBody);
		}
	}

	@Override
	public List<Category> getAllProductsCategories() throws IOException, InterruptedException, ApiCallException {
		String url = basePath + "/categories";
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		handleResponse(response);

		List<Category> categories = gson.fromJson(response.body(), new TypeToken<List<Category>>() {
		}.getType());
		return categories;
	}

	@Override
	public ProductPage getProductsOfCategory(String category) throws IOException, InterruptedException, ApiCallException {
		String url = basePath + "/category/" + category;
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		return getProductsPage(request);
	}

}
