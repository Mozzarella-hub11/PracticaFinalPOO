import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private String id;  // Identificador único de la sección
    private String descripcion;  // Descripción de la sección
    private List<Coche> coches;  // Lista de coches en la sección

    // Constructor
    public Seccion(String id, String descripcion) {
        this.id = id.trim();  // Eliminamos espacios adicionales
        this.descripcion = descripcion.trim();
        this.coches = new ArrayList<>();
    }

    // Método para agregar un coche
    public void agregarCoche(Coche coche) {
        if (coche == null) {
            System.out.println("Error: El coche no puede ser nulo.");
            return;
        }
        if (!coches.contains(coche)) {
            coches.add(coche);
            System.out.println("Coche con ID " + coche.getId() + " añadido a la sección.");
        } else {
            System.out.println("El coche con ID " + coche.getId() + " ya está registrado en esta sección.");
        }
    }

    // Método para eliminar un coche usando removeIf
    public boolean eliminarCoche(String idCoche) {
        boolean eliminado = coches.removeIf(coche -> coche.getId().equals(idCoche));
        if (eliminado) {
            System.out.println("Coche con ID " + idCoche + " eliminado de la sección.");
        } else {
            System.out.println("Error: No se encontró el coche con ID " + idCoche + " en la sección.");
        }
        return eliminado;
    }

    // Mostrar la información básica de la sección
    public void mostrarSeccion() {
        System.out.println("Sección ID: " + id + ", Descripción: " + descripcion);
    }

    // Verificar si existe un coche por su ID
    public boolean existeCoche(String idCoche) {
        return coches.stream().anyMatch(coche -> coche.getId().equals(idCoche));
    }

    // Verificar si la sección tiene coches
    public boolean tieneCoches() {
        return !coches.isEmpty();
    }

    // Mostrar todos los coches de la sección
    public void mostrarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches disponibles en esta sección.");
        } else {
            System.out.println("Coches en la sección '" + id + "':");
            coches.forEach(coche -> System.out.println(coche));
        }
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Coche> getCoches() {
        return new ArrayList<>(coches);  // Devolvemos una copia para evitar modificaciones externas
    }

    // Setters con validaciones
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Error: El ID no puede estar vacío.");
            return;
        }
        this.id = id.trim();
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            System.out.println("Error: La descripción no puede estar vacía.");
            return;
        }
        this.descripcion = descripcion.trim();
    }
}
