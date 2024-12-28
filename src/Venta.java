import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String id;  // Identificador único de la venta
    private Cliente cliente;  // Cliente que realiza la compra
    private Coche coche;  // Coche vendido
    private List<Mejora> mejorasAplicadas;  // Mejoras seleccionadas por el cliente
    private double precioFinal;  // Precio final con mejoras e IVA
    private LocalDate fechaVenta;  // Fecha de la venta

    // Constructor
    public Venta(String id, Cliente cliente, Coche coche, List<Mejora> mejorasAplicadas) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la venta no puede estar vacío.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        if (coche == null) {
            throw new IllegalArgumentException("El coche no puede ser nulo.");
        }
        this.id = id.trim();
        this.cliente = cliente;
        this.coche = coche;
        this.mejorasAplicadas = (mejorasAplicadas != null) ? mejorasAplicadas : new ArrayList<>();
        this.fechaVenta = LocalDate.now();  // Fecha actual por defecto
        this.precioFinal = calcularPrecioFinal();  // Calculamos el precio final
    }

    // Método para calcular el precio final
    private double calcularPrecioFinal() {
        double precioConMejoras = coche.getPrecioBase();
        for (Mejora mejora : mejorasAplicadas) {
            precioConMejoras += coche.getPrecioBase() * mejora.getPorcentajeIncremento();
        }
        return precioConMejoras * 1.21;  // Aplicamos el IVA del 21%
    }

    // Método toString para mostrar los detalles de la venta
    @Override
    public String toString() {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Venta ID: ").append(id).append("\n");
        detalles.append("Fecha: ").append(fechaVenta).append("\n");
        detalles.append("Cliente: ").append(cliente).append("\n");
        detalles.append("Coche: ").append(coche).append("\n");
        detalles.append("Mejoras aplicadas: ");
        if (mejorasAplicadas.isEmpty()) {
            detalles.append("Ninguna");
        } else {
            for (Mejora mejora : mejorasAplicadas) {
                detalles.append("\n  - ").append(mejora.getNombre()).append(" (").append(mejora.getPorcentajeIncremento() * 100).append("%)");
            }
        }
        detalles.append("\nPrecio final (con IVA): ").append(String.format("%.2f", precioFinal)).append(" €");
        return detalles.toString();
    }

    // Getters
    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Coche getCoche() {
        return coche;
    }

    public List<Mejora> getMejorasAplicadas() {
        return new ArrayList<>(mejorasAplicadas);  // Retornamos una copia para evitar modificaciones externas
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }
}
