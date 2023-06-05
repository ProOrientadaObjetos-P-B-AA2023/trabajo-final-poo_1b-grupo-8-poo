
package paquete05;

public class Constructora {
    private String nombre;
    private String direccion;
    private String idEmpresa;

    public Constructora(String nombre, String idEmpresa) {
        this.nombre = nombre;
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Constructora: " + nombre + ", Dirección: " + direccion + ", ID Empresa: " + idEmpresa;
    }
}