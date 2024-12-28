import java.util.ArrayList;
import java.util.List;

public class Coche {

    private String id;  // Identificador único, formado por "modelo-año"
    private double precioBase;  // Precio base del coche
    private int stock;  // Cantidad de unidades disponibles
    private List<Mejora> mejoras;  // Lista de mejoras aplicadas al coche

    // Constructor
    public Coche(String id, double precioBase, int stock) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor a cero.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.id = id;
        this.precioBase = precioBase;
        this.stock = stock;
        this.mejoras = new ArrayList<>();
    }

    // Getters y Setters con validaciones
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío.");
        }
        this.id = id.trim();
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor a cero.");
        }
        this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    public List<Mejora> getMejoras() {
        return new ArrayList<>(mejoras);  // Retornamos una copia para evitar modificaciones externas
    }

    // Métodos para manipular las mejoras
    public void agregarMejora(Mejora mejora) {
        if (mejora == null) {
            System.out.println("Error: La mejora no puede ser nula.");
            return;
        }
        if (!mejoras.contains(mejora)) {
            mejoras.add(mejora);
            System.out.println("Mejora '" + mejora.getNombre() + "' añadida al coche con ID " + id + ".");
        } else {
            System.out.println("La mejora '" + mejora.getNombre() + "' ya está aplicada al coche.");
        }
    }

    public void eliminarMejora(Mejora mejora) {
        if (mejoras.remove(mejora)) {
            System.out.println("Mejora '" + mejora.getNombre() + "' eliminada del coche con ID " + id + ".");
        } else {
            System.out.println("La mejora no está aplicada al coche.");
        }
    }

    // Método para calcular el precio final del coche (incluye mejoras e IVA)
    public double calcularPrecioFinal() {
        double precioFinal = precioBase;
        for (Mejora mejora : mejoras) {
            precioFinal += precioBase * mejora.getPorcentajeIncremento();
        }
        precioFinal += precioFinal * 0.21;  // Aplicamos el 21% de IVA
        return precioFinal;
    }

    // Método toString para imprimir el coche
    @Override
    public String toString() {
        return "Coche{" +
                "ID='" + id + '\'' +
                ", Precio Base=" + precioBase +
                ", Stock=" + stock +
                ", Mejoras=" + mejoras +
                '}';
    }
}
