public class Cliente {
    private String dni;  // Identificador único del cliente
    private String nombre;
    private String telefono;
    private boolean recibePublicidad;

    // Constructor
    public Cliente(String dni, String nombre, String telefono, boolean recibePublicidad) {
        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        this.dni = dni.trim();
        this.nombre = nombre.trim();
        this.telefono = telefono.trim();
        this.recibePublicidad = recibePublicidad;
    }

    // Getters y Setters con validaciones
    public String getDni() {
        return dni;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        this.telefono = telefono.trim();
    }

    public boolean isRecibePublicidad() {
        return recibePublicidad;
    }

    public void setRecibePublicidad(boolean recibePublicidad) {
        this.recibePublicidad = recibePublicidad;
    }

    // Método toString para imprimir la información del cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "DNI='" + dni + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Recibe Publicidad=" + (recibePublicidad ? "Sí" : "No") +
                '}';
    }
}
