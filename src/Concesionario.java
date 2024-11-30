import java.util.ArrayList;
import java.util.List;

public class Concesionario {

    private List<Seccion> secciones;


    public Concesionario() {
        this.secciones = new ArrayList<Seccion>();
    }

    public void altaSeccion(String nombre, String descripcion) {
        for (Seccion seccion : secciones) {
            if(seccion.getId().equalsIgnoreCase(nombre)) {
                System.out.println("Error, ya existe una seccion con ese ID");
                return;

            }
        }
        secciones.add(new Seccion(nombre, descripcion));
        System.out.println("Seccion almacenada con ID " + nombre);
    }


    public void bajaSeccion(String nombre) {
        for (Seccion seccion : secciones) {
            if(seccion.getId().equalsIgnoreCase(nombre)) {
                if(seccion.tieneCoches()){
                    System.out.println("Error, no se puede eliminar la seccion, pues contiene coches");
                }else{
                    secciones.remove(seccion);
                    System.out.println("Seccion eliminada con ID " + nombre);
                }
                return;
            }
        }
        System.out.println("Error, no existe una seccion con ese ID");
    }

    public void mostrarSecciones() {
        if (secciones.isEmpty()) {
            System.out.println("No existen Secciones");
        }else{
            for (Seccion seccion : secciones) {
                seccion.mostrarSeccion();
            }
        }
    }

}
