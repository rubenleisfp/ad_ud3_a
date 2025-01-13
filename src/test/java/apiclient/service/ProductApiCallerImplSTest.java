package apiclient.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ad.ud3_a.apiclient.domain.Product;
import ad.ud3_a.apiclient.domain.ProductPage;
import ad.ud3_a.apiclient.service.ApiCallException;
import ad.ud3_a.apiclient.service.ProductApiCallerImplS;

public class ProductApiCallerImplSTest {

	private static final String BASE_PATH = "https://dummyjson.com/products";
	private ProductApiCallerImplS productApiCaller;

	@Before
	public void setUp() {
		productApiCaller = new ProductApiCallerImplS(BASE_PATH);
	}

	@Test
	public void testGetAllProducts() throws IOException, InterruptedException, ApiCallException {
		ProductPage productPage = productApiCaller.getAllProducts();
		assertNotNull(productPage);
		assertNotNull(productPage.getProducts());
		// Valida que devuelva 30 elementos
		assertEquals(30, productPage.getProducts().size());
		// Valida que el titulo del ultimo elememto sea Key Holder
		Product lastProduct = productPage.getProducts().get(29);
		assertEquals("Key Holder", lastProduct.getTitle());
	}

	@Test
	public void testGetProduct() throws IOException, InterruptedException, ApiCallException {
		// Definir los valores esperados del producto
		Product expectedProduct = new Product();
		expectedProduct.setId(1);
		expectedProduct.setTitle("iPhone 9");
		expectedProduct.setDescription("An apple mobile which is nothing like apple");
		expectedProduct.setPrice(549);
		expectedProduct.setDiscountPercentage(12.96);
		expectedProduct.setRating(4.69);
		expectedProduct.setStock(94);
		expectedProduct.setBrand("Apple");
		expectedProduct.setCategory("smartphones");
		expectedProduct.setThumbnail("https://cdn.dummyjson.com/product-images/1/thumbnail.jpg");
		expectedProduct.setImages(Arrays.asList("https://cdn.dummyjson.com/product-images/1/1.jpg",
				"https://cdn.dummyjson.com/product-images/1/2.jpg", "https://cdn.dummyjson.com/product-images/1/3.jpg",
				"https://cdn.dummyjson.com/product-images/1/4.jpg",
				"https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"));

		// Hacemos la llamada al api con el valor 1
		int productId = 1;
		Product actualProduct = productApiCaller.getProduct(productId);
		assertNotNull(actualProduct);
		assertEquals(productId, actualProduct.getId());
		// Validar que el producto obtenido sea igual al producto esperado
		assertEquals(expectedProduct, actualProduct);
	}

	@Test
	public void testSearchProducts() throws IOException, InterruptedException, ApiCallException {
		String searchWord = "phone";
		ProductPage productPage = productApiCaller.searchProducts(searchWord);
		assertNotNull(productPage);
		assertNotNull(productPage.getProducts());
		assertFalse(productPage.getProducts().isEmpty());

		for (Product p : productPage.getProducts()) {
			System.out.println(p);
			assertTrue("Product title or description should contain the search word", p.getTitle().toLowerCase().contains(searchWord)
					|| p.getDescription().toLowerCase().contains(searchWord));
		}

	}

	@Test
	public void testGetAllProductsCategories() throws IOException, InterruptedException, ApiCallException {
		List<String> categories = productApiCaller.getAllProductsCategories();
		assertNotNull(categories);
		assertEquals(20, categories.size());
	}

	@Test
	public void testGetProductsOfCategory() throws IOException, InterruptedException, ApiCallException {
		String category = "smartphones"; // Define tu categoría
		ProductPage productPage = productApiCaller.getProductsOfCategory(category);
		assertNotNull(productPage);
		assertNotNull(productPage.getProducts());
		assertEquals(5, productPage.getTotal());
		for (Product p : productPage.getProducts()) {
			assertEquals("Category smartphones","smartphones", p.getCategory());
		
		}
	}

	@Test
	public void testAddProduct() throws IOException, InterruptedException, ApiCallException {
		Product product = new Product();
		product.setTitle("Pencil");
		Product productAdded = productApiCaller.addProduct(product);
		assertEquals("Pencil", productAdded.getTitle());
	}
}