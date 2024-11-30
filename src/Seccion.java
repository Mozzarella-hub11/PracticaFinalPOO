import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private String id;
    private String descripcion;
    private List<Coche> coches;


    public Seccion(String descripcion, String id) {
        this.descripcion = descripcion;
        this.id = id;
        this.coches = new ArrayList<Coche>();
    }

    public void agregarCoche(Coche coche) {
        if (!this.coches.contains(coche)) {
            this.coches.add(coche);

        }else{
            System.out.println("El coche ya esta registrado");
        }

    }

    public boolean eliminarCoche(String idCoche) {
        for (Coche coche : coches) {
            if (coche.getId().equals(idCoche)) {
                coches.remove(coche);
                System.out.println("Coche con ID " + idCoche + " eliminado de la sección.");
                return true;
            }
        }
        System.out.println("Error: No se encontró el coche con ID " + idCoche + " en la sección.");
        return false;
    }


    public void mostrarSeccion(){
        System.out.println("Sección ID: " + getId() + ", Descripción: " + getDescripcion());
    }

    public boolean existeCoche(String idCoche) {
        for (Coche coche : coches) {
            if (coche.getId().equals(idCoche)) {
                return true;  // El coche existe
            }
        }
        return false;  // El coche no existe
    }



    public void mostrarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches disponibles en esta sección.");
        } else {
            System.out.println("Coches en la sección '" + id + "':");
            for (Coche coche : coches) {
                System.out.println(coche);  // Se supone que la clase Coche tiene un método toString()
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }
}
