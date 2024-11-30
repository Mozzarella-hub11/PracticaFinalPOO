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

    public void eliminarCoche(Coche coche) {


    }

    public void mostrarCoches() {


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
