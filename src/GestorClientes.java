import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    private List<Cliente> clientes;

    public GestorClientes() {
        this.clientes = new ArrayList<>();
    }

    // Método para dar de alta a un cliente
    public void altaDeCliente(Cliente nuevoCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(nuevoCliente.getDni())) {
                System.out.println("El cliente con DNI " + nuevoCliente.getDni() + " ya está registrado.");
                return;
            }
        }
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente: " + nuevoCliente.getNombre());
    }

    // Mostrar un cliente por DNI
    public void mostrarCliente(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                System.out.println(cliente);
                return;
            }
        }
        System.out.println("No se encontró un cliente con el DNI " + dni);
    }

    // Mostrar todos los clientes
    public void mostrarTodosClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            clientes.forEach(System.out::println);
        }
    }

    // Mostrar clientes dispuestos a recibir publicidad
    public void mostrarClientesDispuestos() {
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

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);  // Devolvemos una copia para evitar modificaciones externas
    }
}
