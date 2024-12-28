import java.util.ArrayList;
import java.util.List;

public class Concesionario {

    private List<Seccion> secciones;

    // Constructor
    public Concesionario() {
        this.secciones = new ArrayList<>();
    }

    // Alta de una nueva sección
    public void altaSeccion(String nombre, String descripcion) {
        if (buscarSeccion(nombre) != null) {
            System.out.println("Error, ya existe una sección con ese ID.");
            return;
        }
        secciones.add(new Seccion(nombre.trim(), descripcion.trim()));
        System.out.println("Sección almacenada con ID: " + nombre);
    }

    // Baja de una sección
    public void bajaSeccion(String nombre) {
        Seccion seccion = buscarSeccion(nombre);
        if (seccion == null) {
            System.out.println("Error, no existe una sección con ese ID.");
            return;
        }

        if (seccion.tieneCoches()) {
            System.out.println("Error, no se puede eliminar la sección porque contiene coches.");
        } else {
            secciones.remove(seccion);
            System.out.println("Sección eliminada con ID: " + nombre);
        }
    }

    // Mostrar todas las secciones
    public void mostrarSecciones() {
        if (secciones.isEmpty()) {
            System.out.println("No existen secciones.");
        } else {
            System.out.println("Secciones disponibles:");
            for (Seccion seccion : secciones) {
                seccion.mostrarSeccion();
            }
        }
    }

    // Método privado para buscar una sección por su nombre
    private Seccion buscarSeccion(String nombre) {
        for (Seccion seccion : secciones) {
            if (seccion.getId().equalsIgnoreCase(nombre.trim())) {
                return seccion;
            }
        }
        return null;
    }

    public Seccion obtenerSeccion(String nombre) {
        Seccion seccion = buscarSeccion(nombre);
        if (seccion == null) {
            System.out.println("No se encontró la sección con el nombre: " + nombre);
        }
        return seccion;
    }

}
