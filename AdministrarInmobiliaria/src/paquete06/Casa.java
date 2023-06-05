
package paquete06;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

public class Casa {
    private Propietario propietario;
    private Barrio barrio;
    private Ciudad ciudad;
    private Constructora constructora;
    private int numeroCuartos;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double costoFinal;

    public Casa(Propietario propietario, Barrio barrio, Ciudad ciudad, Constructora constructora, int numeroCuartos, double precioMetroCuadrado, double numeroMetrosCuadrados, double costoFinal) {
        this.propietario = propietario;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.constructora = constructora;
        this.numeroCuartos = numeroCuartos;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numeroMetrosCuadrados = numeroMetrosCuadrados;
        this.costoFinal = costoFinal;
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

    public int getNumeroCuartos() {
        return numeroCuartos;
    }
    
    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public double getNumeroMetrosCuadrados() {
        return numeroMetrosCuadrados;
    }

    public double getCostoFinal() {
        return costoFinal;
    }
    

    @Override
    public String toString() {
        return "Casa: Propietario: " + propietario.getNombre() +
                ", Barrio: " + barrio.getNombre() +
                ", Ciudad: " + ciudad.getNombre() +
                ", Constructora: " + constructora.getNombre() +
                ", Numero de cuartos: " + numeroCuartos+
                ", Precio por metro cuadrado: " + precioMetroCuadrado +
                ", Número de metros cuadrados: " + numeroMetrosCuadrados +
                ", Costo final: " + costoFinal;
    }
}