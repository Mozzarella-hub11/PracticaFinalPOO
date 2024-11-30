import java.util.List;

public class Seccion {
    private String id;
    private String descripcion;
    private List<Coche> coches;


    public Seccion(String descripcion, String id, List<Coche> coches) {
        this.descripcion = descripcion;
        this.id = id;
        this.coches = coches;
    }

    public void agregarCoche(Coche coche) {


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
