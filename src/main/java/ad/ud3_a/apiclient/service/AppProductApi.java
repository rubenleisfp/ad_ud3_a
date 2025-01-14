package ad.ud3_a.apiclient.service;

import ad.ud3_a.apiclient.domain.Category;
import ad.ud3_a.apiclient.domain.Product;
import ad.ud3_a.apiclient.domain.ProductPage;
import ad.ud3_a.apiclient.utils.MockUtils;
import ad.ud3_a.playing.api_client.product.BasicProductApiClient;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AppProductApi {

    private final ProductApiCaller apiCaller = new ProductApiCallerImpl("https://dummyjson.com/products");

    public static void main(String[] args) {
        AppProductApi app = new AppProductApi();
        try {
            app.mostrarMenu();
        } catch (ApiCallException e) {
            //FIXME: Esta informacion no deberia mostrarse al usuario, debería volcarse a un fichero de log
            System.out.println("Ha ocurrido un error técnico. Reinténtelo más tarde");
            System.out.println(e.getMessage());
            System.out.println("StatusCode: " + e.getStatusCode());
            System.out.println("ResponseBody: " +e.getResponseBody());
        } catch (IOException | InterruptedException e) {
            System.out.println("Ha ocurrido un error técnico. Reinténtelo más tarde");
            System.out.println(e.getMessage());
        }
    }

    public void mostrarMenu() throws ApiCallException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Obtener todos los productos");
            System.out.println("2. Obtener producto por ID");
            System.out.println("3. Buscar producto por palabra clave");
            System.out.println("4. Obtener todas las categorías de productos");
            System.out.println("5. Agregar un producto");
            System.out.println("6. Actualizar un producto");
            System.out.println("7. Eliminar un producto por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> {
                    ProductPage productPage = apiCaller.getAllProducts();
                    System.out.println(productPage);
                }
                case 2 -> {
                    System.out.println("Ingrese el id del producto: ");
                    int idProducto = scanner.nextInt();
                    scanner.nextLine();
                    Product product = apiCaller.getProduct(idProducto);
                    System.out.println(product);
                }
                case 3 -> {
                    System.out.println("Ingrese el la palabra clave de búsqueda: ");
                    String keyword = scanner.nextLine();
                    ProductPage productPage = apiCaller.searchProducts(keyword);
                    System.out.println(productPage);
                }
                case 4 -> {
                    List<Category> categoryList = apiCaller.getAllProductsCategories();
                    for (Category category : categoryList) {
                        System.out.println(category);
                    }
                }
                case 5 -> {
                    System.out.print("Ingresamos un producto mock: ");
                    apiCaller.addProduct(MockUtils.getMockProduct());
                }
                case 6 -> {
                    System.out.println("Ingrese el id del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    Product product = apiCaller.updateProduct(id, MockUtils.getMockProductWithoutId());
                    System.out.println(product);

                }
                case 7 -> {
                    System.out.println("Ingrese el id del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    Product product = apiCaller.deleteProduct(id);
                    System.out.println(product);
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

}
