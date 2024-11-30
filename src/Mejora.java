import java.io.Serializable;

public class Mejora implements Serializable{
    private String nombre;
    private double porcentajeIncremento;

    //Constructores
    public Mejora(String nombre, double porcentajeIncremento) {
        this.nombre = nombre;
        this.porcentajeIncremento = porcentajeIncremento;
    }



    // Metodo para aplicar el incremento al precio base
    public double aplicarIncremento(double precioBase) {
        return precioBase + (precioBase * (porcentajeIncremento / 100));
    }

    // Metodo para mostrar los detalles de la mejora
    @Override
    public String toString() {
        return "Mejora{" +
                "nombre='" + nombre + '\'' +
                ", porcentajeIncremento=" + porcentajeIncremento +
                "%}";
    }




    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentajeIncremento() {
        return porcentajeIncremento;
    }

    public void setPorcentajeIncremento(double porcentajeIncremento) {
        this.porcentajeIncremento = porcentajeIncremento;
    }
}


