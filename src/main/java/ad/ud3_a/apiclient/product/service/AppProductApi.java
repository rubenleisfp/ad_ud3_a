package ad.ud3_a.apiclient.product.service;

import ad.ud3_a.apiclient.product.domain.Category;
import ad.ud3_a.apiclient.product.domain.Product;
import ad.ud3_a.apiclient.product.domain.ProductPage;
import ad.ud3_a.apiclient.product.utils.MockUtils;

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
            System.out.println("Ha ocurrido un error técnico. Reinténtelo más tarde");
            //FIXME: Esta informacion no deberia mostrarse al usuario, debería volcarse a un fichero de log
            System.out.println(e.getMessage());
            System.out.println("StatusCode: " + e.getStatusCode());
            System.out.println("ResponseBody: " +e.getResponseBody());
        } catch (IOException | InterruptedException e) {
            //FIXME: Esta informacion no deberia mostrarse al usuario, debería volcarse a un fichero de log
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
            System.out.println("4. Obtener productos con parámetros paginados");
            System.out.println("5. Obtener todas las categorías de productos");
            System.out.println("6. Obtener productos de una categoría");
            System.out.println("7. Agregar un producto");
            System.out.println("8. Actualizar un producto");
            System.out.println("9. Eliminar un producto por ID");
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
                    System.out.print("Ingrese el límite de productos: ");
                    int limit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el número de elementos a omitir: ");
                    int skip = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese los campos a mostrar: ");
                    String selection = scanner.nextLine();
                    ProductPage productPage = apiCaller.getProducts(limit, skip, selection);
                    System.out.println(productPage);
                }
                case 5 -> {
                    List<Category> categoryList = apiCaller.getAllProductsCategories();
                    for (Category category : categoryList) {
                        System.out.println(category);
                    }
                }
                case 6 -> {
                    System.out.print("Ingrese la categoria de los productos que desea mostrar: ");
                    String category = scanner.nextLine();
                    ProductPage productPage = apiCaller.getProductsOfCategory(category);
                    System.out.println(productPage);
                }
                case 7 -> {
                    System.out.print("Ingresamos un producto mock: ");
                    apiCaller.addProduct(MockUtils.getMockProduct());
                }
                case 8 -> {
                    System.out.println("Ingrese el id del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    Product product = apiCaller.updateProduct(id, MockUtils.getMockProductWithoutId());
                    System.out.println(product);

                }
                case 9 -> {
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
