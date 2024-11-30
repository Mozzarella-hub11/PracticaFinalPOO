//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Concesionario concesionario = new Concesionario();
        Coche coche = new Coche();

        concesionario.altaSeccion("Deportivos","coches deportivos");
        concesionario.altaSeccion("Deportivos","Coches deportivos");


        concesionario.mostrarSecciones();
        concesionario.bajaSeccion("Deportivos");
        concesionario.mostrarSecciones();

        
    }
}