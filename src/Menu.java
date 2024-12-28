import java.util.Scanner;

public class Menu {
    private Concesionario concesionario;  // Instancia del concesionario
    private final String rutaArchivo = "concesionario.dat";  // Ruta del archivo de datos

    // Constructor
    public Menu() {
        // Intentamos cargar los datos desde el archivo
        Object datosCargados = GestorDatos.cargarDatos(rutaArchivo);
        if (datosCargados instanceof Concesionario) {
            this.concesionario = (Concesionario) datosCargados;
            System.out.println("Datos cargados correctamente.");
        } else {
            this.concesionario = new Concesionario();  // Si no hay datos, creamos un concesionario nuevo
            System.out.println("No se encontraron datos previos. Se creó un nuevo concesionario.");
        }
    }

    // Mostrar el menú
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú del Concesionario ---");
            System.out.println("1. Gestionar Secciones");
            System.out.println("2. Gestionar Coches");
            System.out.println("3. Gestionar Clientes");
            System.out.println("4. Registrar Venta");
            System.out.println("5. Mostrar Datos");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1 -> gestionarSecciones(scanner);
                case 2 -> gestionarCoches(scanner);
                case 3 -> gestionarClientes(scanner);
                case 4 -> registrarVenta(scanner);
                case 5 -> mostrarDatos();
                case 6 -> salir();
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    // Métodos del menú
    private void gestionarSecciones(Scanner scanner) {
        System.out.println("\n--- Gestión de Secciones ---");
        System.out.println("1. Agregar nueva sección");
        System.out.println("2. Eliminar sección");
        System.out.println("3. Mostrar todas las secciones");
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingrese el nombre de la sección: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese la descripción de la sección: ");
                String descripcion = scanner.nextLine();
                concesionario.altaSeccion(nombre, descripcion);
            }
            case 2 -> {
                System.out.print("Ingrese el nombre de la sección a eliminar: ");
                String nombre = scanner.nextLine();
                concesionario.bajaSeccion(nombre);
            }
            case 3 -> concesionario.mostrarSecciones();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void gestionarCoches(Scanner scanner) {
        System.out.println("\n--- Gestión de Coches ---");
        System.out.println("1. Agregar nuevo coche");
        System.out.println("2. Mostrar coches de una sección");
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingrese el ID de la sección: ");
                String idSeccion = scanner.nextLine();
                System.out.print("Ingrese el modelo del coche: ");
                String modelo = scanner.nextLine();
                System.out.print("Ingrese el año de fabricación: ");
                int anio = scanner.nextInt();
                System.out.print("Ingrese el precio base del coche: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();  // Limpiar el buffer

                Seccion seccion = concesionario.obtenerSeccion(idSeccion);
                if (seccion != null) {
                    seccion.agregarCoche(new Coche(modelo + "-" + anio, precio, 1));
                } else {
                    System.out.println("La sección no existe.");
                }
            }
            case 2 -> {
                System.out.print("Ingrese el ID de la sección: ");
                String idSeccion = scanner.nextLine();
                Seccion seccion = concesionario.obtenerSeccion(idSeccion);
                if (seccion != null) {
                    seccion.mostrarCoches();
                } else {
                    System.out.println("La sección no existe.");
                }
            }
            default -> System.out.println("Opción no válida.");
        }
    }

    private void gestionarClientes(Scanner scanner) {
        System.out.println("\n--- Gestión de Clientes ---");
        GestorClientes gestorClientes = new GestorClientes();
        System.out.println("1. Agregar nuevo cliente");
        System.out.println("2. Mostrar cliente");
        System.out.println("3. Mostrar todos los clientes");
        System.out.println("4. Mostrar clientes dispuestos a recibir publicidad");
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingrese el DNI del cliente: ");
                String dni = scanner.nextLine();
                System.out.print("Ingrese el nombre del cliente: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el teléfono del cliente: ");
                String telefono = scanner.nextLine();
                System.out.print("¿Recibe publicidad? (true/false): ");
                boolean publicidad = scanner.nextBoolean();
                gestorClientes.altaDeCliente(new Cliente(dni, nombre, telefono, publicidad));
            }
            case 2 -> {
                System.out.print("Ingrese el DNI del cliente: ");
                String dni = scanner.nextLine();
                gestorClientes.mostrarCliente(dni);
            }
            case 3 -> gestorClientes.mostrarTodosClientes();
            case 4 -> gestorClientes.mostrarClientesDispuestos();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void registrarVenta(Scanner scanner) {
        System.out.println("\n--- Registrar Venta ---");
        // Implementar la lógica de registrar venta con cliente, coche, y mejoras aplicadas
        System.out.println("Funcionalidad por implementar.");
    }

    private void mostrarDatos() {
        System.out.println("\n--- Datos del Concesionario ---");
        concesionario.mostrarSecciones();
        // Puedes agregar más datos si es necesario, como clientes y ventas
    }

    private void salir() {
        GestorDatos.guardarDatos(concesionario, rutaArchivo);
        System.out.println("Datos guardados correctamente. ¡Hasta luego!");
    }
}
