
package paquete05;

public class Constructora {
    private String nombre;
    private String idEmpresa;

    public Constructora(String nombre, String idEmpresa) {
        this.nombre = nombre;
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    @Override
    public String toString() {
        return "Constructora: " + nombre + ", ID Empresa: " + idEmpresa;
    }
}