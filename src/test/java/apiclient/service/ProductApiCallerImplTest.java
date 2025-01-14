package apiclient.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import ad.ud3_a.apiclient.product.domain.Category;
import ad.ud3_a.apiclient.product.domain.Product;
import ad.ud3_a.apiclient.product.domain.ProductPage;
import ad.ud3_a.apiclient.product.service.ProductApiCallerImpl;
import ad.ud3_a.apiclient.product.utils.MockUtils;
import org.junit.Before;
import org.junit.Test;

import ad.ud3_a.apiclient.product.service.ApiCallException;

public class ProductApiCallerImplTest {

	private static final String BASE_PATH = "https://dummyjson.com/products";
	private ProductApiCallerImpl productApiCaller;

	@Before
	public void setUp() {
		productApiCaller = new ProductApiCallerImpl(BASE_PATH);
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
		assertEquals("Kiwi", lastProduct.getTitle());
	}




	@Test
	public void testGetProduct() throws IOException, InterruptedException, ApiCallException {


		// Hacemos la llamada al api con el valor 1
		int productId = 1;
		Product actualProduct = productApiCaller.getProduct(productId);
		assertNotNull(actualProduct);
		assertEquals(productId, actualProduct.getId().intValue());
		// Validar que el producto obtenido sea igual al producto esperado
		assertEquals(MockUtils.getMockProduct(), actualProduct);
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
		List<Category> categories = productApiCaller.getAllProductsCategories();
		assertNotNull(categories);
		assertEquals(24, categories.size());
	}

	@Test
	public void testGetProductsOfCategory() throws IOException, InterruptedException, ApiCallException {
		String category = "smartphones"; // Define tu categoría
		ProductPage productPage = productApiCaller.getProductsOfCategory(category);
		assertNotNull(productPage);
		assertNotNull(productPage.getProducts());
		assertEquals(16, productPage.getTotal());
		for (Product p : productPage.getProducts()) {
			assertEquals("Category smartphones","smartphones", p.getCategory());
		
		}
	}

	@Test
	public void testAddProduct() throws IOException, InterruptedException, ApiCallException {
		Product productAdded = productApiCaller.addProduct(MockUtils.getMockProduct());
		assertEquals("Essence Mascara Lash Princess", productAdded.getTitle());
	}
}