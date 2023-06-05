
package paquete04;

public class Ciudad {
    private String nombre;
    private String nombreProvincia;

    public Ciudad(String nombre, String nombreProvincia) {
        this.nombre = nombre;
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    @Override
    public String toString() {
        return "Ciudad: " + nombre + ", Provincia: " + nombreProvincia;
    }
}