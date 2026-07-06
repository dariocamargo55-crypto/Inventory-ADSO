package com.inventory.vista;

import com.inventory.dao.ProductoDAO;
import com.inventory.modelo.Producto;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal del sistema Inventory.
 * Contiene el menu de consola para interactuar con el CRUD de productos.
 * Esta es la clase que se ejecuta primero (contiene el metodo main).
 *
 * @author Angela Carvajal Ortiz y Dario Bustamante Camargo
 * @version 1.0
 * @since 2026
 * Ficha: 3186706 - SENA GA7-220501096-AA2-EV01
 */
public class Menu {

    /** Objeto DAO para operaciones con la base de datos */
    private static final ProductoDAO productoDAO = new ProductoDAO();

    /** Scanner para leer entradas del usuario desde consola */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Metodo principal - punto de entrada del programa.
     * Muestra el menu principal y procesa las opciones del usuario.
     *
     * @param args argumentos de linea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        mostrarBienvenida();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEnteroSeguro("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> verTodosLosProductos();
                case 3 -> actualizarProducto();
                case 4 -> eliminarProducto();
                case 0 -> System.out.println("\n  Gracias por usar Sistema Inventory. Hasta pronto!\n");
                default -> System.out.println("\n  Opcion no valida. Intente de nuevo.\n");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // ==================== OPCIONES DEL MENU ====================

    /**
     * Solicita datos al usuario e inserta un nuevo producto en la BD.
     */
    private static void agregarProducto() {
        System.out.println("\n  ===== AGREGAR NUEVO PRODUCTO =====");

        System.out.print("  Nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("  Descripcion: ");
        String descripcion = scanner.nextLine().trim();

        double precio = leerDecimalSeguro("  Precio: $");
        int stock = leerEnteroSeguro("  Cantidad en stock: ");

        Producto nuevoProducto = new Producto(0, nombre, descripcion, precio, stock);
        boolean resultado = productoDAO.insertar(nuevoProducto);

        if (resultado) {
            System.out.println("  Producto agregado exitosamente!");
        } else {
            System.out.println("  No se pudo agregar el producto. Verifique la conexion.");
        }
    }

    /**
     * Consulta y muestra todos los productos registrados en la BD.
     */
    private static void verTodosLosProductos() {
        System.out.println("\n  ===== LISTADO DE PRODUCTOS =====");

        List<Producto> productos = productoDAO.consultarTodos();

        if (productos.isEmpty()) {
            System.out.println("  No hay productos registrados en el inventario.");
        } else {
            System.out.println("  " + "-".repeat(80));
            for (Producto p : productos) {
                System.out.println("  " + p.toString());
            }
            System.out.println("  " + "-".repeat(80));
            System.out.println("  Total de productos: " + productos.size());
        }
    }

    /**
     * Solicita un ID y nuevos datos para actualizar un producto existente.
     */
    private static void actualizarProducto() {
        System.out.println("\n  ===== ACTUALIZAR PRODUCTO =====");

        int id = leerEnteroSeguro("  Ingrese el ID del producto a actualizar: ");

        Producto existente = productoDAO.consultarPorId(id);
        if (existente == null) {
            System.out.println("  No se encontro un producto con ID: " + id);
            return;
        }

        System.out.println("  Producto actual: " + existente.toString());
        System.out.println("  Ingrese los nuevos datos:");

        System.out.print("  Nuevo nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("  Nueva descripcion: ");
        String descripcion = scanner.nextLine().trim();

        double precio = leerDecimalSeguro("  Nuevo precio: $");
        int stock = leerEnteroSeguro("  Nuevo stock: ");

        Producto productoActualizado = new Producto(id, nombre, descripcion, precio, stock);
        boolean resultado = productoDAO.actualizar(productoActualizado);

        if (resultado) {
            System.out.println("  Producto actualizado exitosamente!");
        } else {
            System.out.println("  No se pudo actualizar. Verifique el ID ingresado.");
        }
    }

    /**
     * Solicita un ID y elimina el producto correspondiente de la BD.
     */
    private static void eliminarProducto() {
        System.out.println("\n  ===== ELIMINAR PRODUCTO =====");

        int id = leerEnteroSeguro("  Ingrese el ID del producto a eliminar: ");

        Producto existente = productoDAO.consultarPorId(id);
        if (existente == null) {
            System.out.println("  No se encontro un producto con ID: " + id);
            return;
        }

        System.out.println("  Producto a eliminar: " + existente.toString());
        System.out.print("  Esta seguro? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();

        if (confirmacion.equals("s")) {
            boolean resultado = productoDAO.eliminar(id);
            if (resultado) {
                System.out.println("  Producto eliminado exitosamente!");
            } else {
                System.out.println("  No se pudo eliminar. Intente de nuevo.");
            }
        } else {
            System.out.println("  Operacion cancelada.");
        }
    }

    // ==================== METODOS AUXILIARES ====================

    /**
     * Muestra el mensaje de bienvenida del sistema.
     */
    private static void mostrarBienvenida() {
        System.out.println("\n  ==========================================");
        System.out.println("       SISTEMA DE GESTION DE INVENTARIO    ");
        System.out.println("               INVENTORY v1.0              ");
        System.out.println("   Ficha 3186706 - SENA - ADSO 2026        ");
        System.out.println("  ==========================================\n");
    }

    /**
     * Muestra las opciones del menu principal.
     */
    private static void mostrarMenu() {
        System.out.println("\n  ------ MENU PRINCIPAL ------");
        System.out.println("  1. Agregar producto");
        System.out.println("  2. Ver todos los productos");
        System.out.println("  3. Actualizar producto");
        System.out.println("  4. Eliminar producto");
        System.out.println("  0. Salir");
        System.out.println("  ----------------------------");
    }

    /**
     * Lee un numero entero del usuario de forma segura, evitando errores
     * si el usuario ingresa texto en lugar de un numero.
     *
     * @param mensaje mensaje a mostrar antes de leer
     * @return el numero entero ingresado por el usuario
     */
    private static int leerEnteroSeguro(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = Integer.parseInt(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("  Por favor ingrese un numero valido.");
            }
        }
    }

    /**
     * Lee un numero decimal del usuario de forma segura.
     *
     * @param mensaje mensaje a mostrar antes de leer
     * @return el numero decimal ingresado por el usuario
     */
    private static double leerDecimalSeguro(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double valor = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("  Por favor ingrese un numero valido (use punto para decimales).");
            }
        }
    }
}
