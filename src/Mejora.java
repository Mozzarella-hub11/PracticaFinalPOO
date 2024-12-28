public class Mejora {
    private String nombre;  // Nombre de la mejora
    private double porcentajeIncremento;  // Incremento como valor decimal (por ejemplo, 0.1 para 10%)

    // Constructor
    public Mejora(String nombre, double porcentajeIncremento) {
        if (porcentajeIncremento < 0) {
            throw new IllegalArgumentException("El porcentaje de incremento no puede ser negativo.");
        }
        this.nombre = nombre.trim();
        this.porcentajeIncremento = porcentajeIncremento;
    }

    // Métodos y validaciones son los mismos que en la versión anterior
    public double aplicarIncremento(double precioBase) {
        if (precioBase < 0) {
            throw new IllegalArgumentException("El precio base no puede ser negativo.");
        }
        return precioBase + (precioBase * porcentajeIncremento);
    }

    @Override
    public String toString() {
        return String.format("Mejora: %s (Incremento: %.2f%%)", nombre, porcentajeIncremento * 100);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public double getPorcentajeIncremento() {
        return porcentajeIncremento;
    }

    public void setPorcentajeIncremento(double porcentajeIncremento) {
        if (porcentajeIncremento < 0) {
            throw new IllegalArgumentException("El porcentaje de incremento no puede ser negativo.");
        }
        this.porcentajeIncremento = porcentajeIncremento;
    }
}
