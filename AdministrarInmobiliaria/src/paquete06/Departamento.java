
package paquete06;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;


public class Departamento {
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double valorAlicuotaMensual;
    private double costoFinal;
    private String nombreEdificio;
    private String ubicacionEdificio;
    private Propietario propietario;
    private Barrio barrio;
    private Ciudad ciudad;
    private Constructora constructora;

    public Departamento(Propietario propietario, Barrio barrio, Ciudad ciudad, Constructora constructora,
                        double precioMetroCuadrado, double numeroMetrosCuadrados, double valorAlicuotaMensual,
                        double costoFinal, String nombreEdificio, String ubicacionEdificio) {
        this.propietario = propietario;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.constructora = constructora;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numeroMetrosCuadrados = numeroMetrosCuadrados;
        this.valorAlicuotaMensual = valorAlicuotaMensual;
        this.costoFinal = costoFinal;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionEdificio = ubicacionEdificio;
    }

    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public double getNumeroMetrosCuadrados() {
        return numeroMetrosCuadrados;
    }

    public double getValorAlicuotaMensual() {
        return valorAlicuotaMensual;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public String getUbicacionEdificio() {
        return ubicacionEdificio;
    }
    
    public Propietario getPropietario() {
        return propietario;
    }
    
    public Barrio getBarrio() {
        return barrio;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public Constructora getConstructora() {
        return constructora;
    }

    @Override
    public String toString() {
        return "Departamento: Propietario: " + propietario.getNombre() +
                ", Barrio: " + barrio.getNombre() +
                ", Ciudad: " + ciudad.getNombre() +
                ", Constructora: " + constructora.getNombre()+
                ", Precio por metro cuadrado: " + precioMetroCuadrado +
                ", Número de metros cuadrados: " + numeroMetrosCuadrados +
                ", Valor de la alicuota mensual: " + valorAlicuotaMensual +
                ", Costo final: " + costoFinal +
                ", Nombre de edificio: "+ nombreEdificio +
                ", Ubicacion del departamento en edificio: " + ubicacionEdificio;
                
    } 
    
}