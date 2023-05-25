import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GestionInventario {
    private final List<Producto> inventario;
    private final Scanner scanner;

    public GestionInventario() {
        inventario = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la cantidad disponible: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        Producto producto = new Producto(nombre, cantidad);
        inventario.add(producto);

        System.out.println("Producto agregado al inventario.");
        System.out.println();
    }

    public void buscarProducto() {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombre = scanner.nextLine();

        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Producto encontrado:");
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Cantidad: " + producto.getCantidad());
                System.out.println();
                return;
            }
        }

        System.out.println("Producto no encontrado.");
        System.out.println();
    }

    public void actualizarCantidad() {
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombre = scanner.nextLine();

        for (Producto producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Ingrese la nueva cantidad: ");
                int cantidad = Integer.parseInt(scanner.nextLine());
                producto.setCantidad(cantidad);

                System.out.println("Cantidad actualizada correctamente.");
                System.out.println();
                return;
            }
        }

        System.out.println("Producto no encontrado.");
        System.out.println();
    }

    public void generarReporte() {
        System.out.println("Reporte de inventario:");
        System.out.println(":::::::::::::::::::::::");
        for (Producto producto : inventario) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println();
        }
    }

    public void ejecutar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú de opciones ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Actualizar cantidad");
            System.out.println("4. Generar reporte");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción deseada: ");

            int opcion = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> buscarProducto();
                case 3 -> actualizarCantidad();
                case 4 -> generarReporte();
                case 5 -> {
                    salir = true;
                    System.out.println("¡Hasta luego!");
                }
                default -> {
                    System.out.println("Opción inválida. Intente nuevamente.");
                    System.out.println();
                }
            }
        }
    }
}
