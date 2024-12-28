import java.io.*;

public class GestorDatos {

    // Método para guardar datos en un archivo
    public static void guardarDatos(Object datos, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(datos);
            System.out.println("Datos guardados correctamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    // Método para cargar datos desde un archivo
    public static Object cargarDatos(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + rutaArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
        return null;  // Devuelve null si no se pudieron cargar los datos
    }
}
