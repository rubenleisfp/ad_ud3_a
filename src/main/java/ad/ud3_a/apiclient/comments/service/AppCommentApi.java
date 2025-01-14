package ad.ud3_a.apiclient.comments.service;

import ad.ud3_a.apiclient.comments.domain.Comment;
import ad.ud3_a.apiclient.comments.domain.CommentPage;
import ad.ud3_a.apiclient.comments.utils.MockUtils;

import java.io.IOException;
import java.util.Scanner;

public class AppCommentApi {

    private final CommentApiCaller apiCaller = new CommentApiCallerImpl("https://dummyjson.com/comments");

    public static void main(String[] args) {
        AppCommentApi app = new AppCommentApi();
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
            System.out.println("1. Obtener todos los comentarios");
            System.out.println("2. Obtener comentario por ID");
            System.out.println("4. Obtener comentarios con parámetros paginados");
            System.out.println("7. Agregar un comentario");
            System.out.println("8. Actualizar un comentario");
            System.out.println("9. Eliminar un comentario por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> {
                    CommentPage commentPage = apiCaller.getAllComments();
                    System.out.println(commentPage);
                }
                case 2 -> {
                    System.out.println("Ingrese el id del comentario: ");
                    int idcomentario = scanner.nextInt();
                    scanner.nextLine();
                    Comment comment = apiCaller.getComment(idcomentario);
                    System.out.println(comment);
                }
                case 4 -> {
                    System.out.print("Ingrese el límite de comentarios: ");
                    int limit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el número de elementos a omitir: ");
                    int skip = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese los campos a mostrar: ");
                    String selection = scanner.nextLine();
                    CommentPage commentPage = apiCaller.getComments(limit, skip, selection);
                    System.out.println(commentPage);
                }

                case 7 -> {
                    System.out.print("Ingresamos un comentario mock: ");
                    apiCaller.addComment(MockUtils.getMockNewComment());
                }
                case 8 -> {
                    System.out.println("Ingrese el id del comentario: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    Comment comment = apiCaller.updateComment(id, MockUtils.getMockCommentWithoutId());
                    System.out.println(comment);

                }
                case 9 -> {
                    System.out.println("Ingrese el id del comentario: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    Comment comment = apiCaller.getComment(id);
                    System.out.println(comment);
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

}
