package ad.ud3_a.playing.api_client.product;

import java.io.IOException;
import java.util.Scanner;

public class App {

    private final BasicProductApiClient apiCaller = new BasicProductApiClient();

    public static void main(String[] args) {
        App app = new App();
        app.mostrarMenu();
    }

    public void mostrarMenu() {
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
                case 1 -> obtenerTodosLosProductos();
                case 2 -> {
                    System.out.println("Ingrese el id del producto: ");
                    int idProducto = scanner.nextInt();
                    scanner.nextLine();
                    obtenerProductoPorId(idProducto);

                }
                case 3 -> {
                    System.out.println("Ingrese el la palabra clave de búsqueda: ");
                    buscarProductoPorPalabra(scanner.nextLine());
                }
                case 4 -> {
                    System.out.print("Ingrese el límite de productos: ");
                    int limit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el número de página: ");
                    int page = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese los campos a mostrar: ");
                    String selection = scanner.nextLine();
                    obtenerProductosPaginados(limit, page, selection);
                }
                case 5 -> obtenerCategorias();
                case 6 -> {
                    System.out.print("Ingrese la categoria de los productos que desea mostrar: ");
                    String category = scanner.nextLine();
                    obtenerProductosDeCategoria(category);

                }
                case 7 -> {
                    System.out.print("Ingrese el producto como Json: ");
                    String productJson = scanner.nextLine();
                    agregarProducto(productJson);
                }
                case 8 -> {
                    System.out.println("Ingrese el id del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    actualizarProducto(id, scanner.nextLine());
                }
                case 9 ->
                {
                    System.out.println("Ingrese el id del producto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    eliminarProducto(id);
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private void obtenerTodosLosProductos() {
        apiCaller.getAllProducts();
    }

    private void obtenerProductoPorId(int id) {
        apiCaller.getProduct(id);
    }

    private void buscarProductoPorPalabra(String keyword) {
        apiCaller.searchProducts(keyword);
    }

    private void obtenerProductosPaginados(int limit, int page, String selection) {
        apiCaller.getProducts(limit, page, selection);
    }

    private void obtenerCategorias() {
        apiCaller.getAllProductsCategories();
    }

    private void obtenerProductosDeCategoria(String category) {
        apiCaller.getProductsOfCategory(category);
    }

    private void agregarProducto(String productDetails) {
        try {
            apiCaller.addProduct(productDetails);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
        }
    }

    private void actualizarProducto(int id, String updatedDetails) {
        try {
            apiCaller.updateProduct(id, updatedDetails);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        }
    }

    private void eliminarProducto(int id) {
        try {
            apiCaller.delete(id);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }
}
