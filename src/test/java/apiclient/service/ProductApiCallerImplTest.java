package apiclient.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import ad.ud3_a.apiclient.domain.*;
import ad.ud3_a.apiclient.service.ProductApiCallerImpl;
import ad.ud3_a.apiclient.utils.MockUtils;
import org.junit.Before;
import org.junit.Test;

import ad.ud3_a.apiclient.service.ApiCallException;

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
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	@Test
	public void testSearchProducts() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	@Test
	public void testGetAllProductsCategories() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	@Test
	public void testGetProductsOfCategory() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}

	@Test
	public void testAddProduct() throws IOException, InterruptedException, ApiCallException {
		throw new UnsupportedOperationException("A implementar por el alumno");
	}
}