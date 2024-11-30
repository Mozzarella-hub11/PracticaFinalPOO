import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
    private String dni;
    private String nombre;
    private String telefono;
    private boolean recibePublicidad;

    // Lista estática para gestionar todos los clientes
    private static List<Cliente> clientes = new ArrayList<>();

    // Constructor
    public Cliente(String dni, String nombre, String telefono, boolean recibePublicidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.recibePublicidad = recibePublicidad;
    }

    // Metodos de gestión
    public static void altaDeCliente(String dni, String nombre, String telefono, boolean recibePublicidad) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println("El cliente con DNI " + dni + " ya está registrado.");
                return;
            }
        }
        Cliente nuevoCliente = new Cliente(dni, nombre, telefono, recibePublicidad);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente: " + nombre);
    }

    public static void mostrarCliente(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println(cliente);
                return;
            }
        }
        System.out.println("No se encontró un cliente con el DNI " + dni);
    }

    public static void mostrarTodosClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Cliente cliente : clientes) {
            System.out.println("DNI: " + cliente.getDni() + ", Nombre: " + cliente.getNombre());
        }
    }

    public static void mostrarClientesDispuestos() {
        boolean hayClientesDispuestos = false;
        for (Cliente cliente : clientes) {
            if (cliente.isRecibePublicidad()) {
                System.out.println("Nombre: " + cliente.getNombre() + ", Teléfono: " + cliente.getTelefono());
                hayClientesDispuestos = true;
            }
        }
        if (!hayClientesDispuestos) {
            System.out.println("No hay clientes dispuestos a recibir publicidad.");
        }
    }

    // Metodo toString para mostrar la información de un cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "DNI='" + dni + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Recibe Publicidad=" + (recibePublicidad ? "Sí" : "No") +
                '}';
    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isRecibePublicidad() {
        return recibePublicidad;
    }

    public void setRecibePublicidad(boolean recibePublicidad) {
        this.recibePublicidad = recibePublicidad;
    }
}
