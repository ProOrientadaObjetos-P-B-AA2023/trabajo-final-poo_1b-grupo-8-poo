
package paquete01;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import paquete06.Casa;
import paquete06.Departamento;


public class Inmobiliaria {
    private List<Propietario> propietarios;
    private List<Barrio> barrios;
    private List<Ciudad> ciudades;
    private List<Constructora> constructoras;
    private List<Casa> casas;
    private List<Departamento> departamentos;
    private static final String DATA_FOLDER = "datos/";

    private final String propietariosFile = "datos/propietarios.dat";
    private final String barriosFile = "datos/barrios.dat";
    private final String ciudadesFile = "datos/ciudades.dat";
    private final String constructorasFile = "datos/constructoras.dat";
    private final String casasFile = "datos/casas.dat";
    private final String departamentosFile = "datos/departamentos.dat";

    public Inmobiliaria() {
        propietarios = new ArrayList<>();
        barrios = new ArrayList<>();
        ciudades = new ArrayList<>();
        constructoras = new ArrayList<>();
        casas = new ArrayList<>();
        departamentos = new ArrayList<>();
    }


    public void registrarPropietario(Scanner scanner) {
    System.out.println("Ingrese los datos del propietario:");
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Apellido: ");
    String apellido = scanner.nextLine();
    System.out.print("Identificación: ");
    String identificacion = scanner.nextLine();

    Propietario propietario = new Propietario(nombre, apellido, identificacion);
    propietarios.add(propietario);
    guardarPropietarios();

    System.out.println("Propietario registrado exitosamente.");
}

public void registrarBarrio(Scanner scanner) {
    System.out.println("Ingrese los datos del barrio:");
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Referencia: ");
    String referencia = scanner.nextLine();

    Barrio barrio = new Barrio(nombre, referencia);
    barrios.add(barrio);
    guardarBarrios();

    System.out.println("Barrio registrado exitosamente.");
}

public void registrarCiudad(Scanner scanner) {
    System.out.println("Ingrese los datos de la ciudad:");
    System.out.print("Nombre de la ciudad: ");
    String nombreCiudad = scanner.nextLine();
    System.out.print("Nombre de la provincia: ");
    String nombreProvincia = scanner.nextLine();

    Ciudad ciudad = new Ciudad(nombreCiudad, nombreProvincia);
    ciudades.add(ciudad);
    guardarCiudades();

    System.out.println("Ciudad registrada exitosamente.");
}

public void registrarConstructora(Scanner scanner) {
    System.out.println("Ingrese los datos de la constructora:");
    System.out.print("Nombre de la constructora: ");
    String nombreConstructora = scanner.nextLine();
    System.out.print("ID de la empresa: ");
    String idEmpresa = scanner.nextLine();

    Constructora constructora = new Constructora(nombreConstructora, idEmpresa);
    constructoras.add(constructora);
    guardarConstructoras();

    System.out.println("Constructora registrada exitosamente.");
}

public void registrarCasa(Scanner scanner) {
    System.out.println("Ingrese los datos de la casa:");
    System.out.print("Identificación del propietario: ");
    String identificacionPropietario = scanner.nextLine();
    System.out.print("Nombre del barrio: ");
    String nombreBarrio = scanner.nextLine();
    System.out.print("Nombre de la ciudad: ");
    String nombreCiudad = scanner.nextLine();
    System.out.print("ID de la empresa constructora: ");
    String idEmpresaConstructora = scanner.nextLine();
    System.out.print("Numero de cuartos: ");
    int numeroCuartos = scanner.nextInt();
    System.out.print("Precio por metro cuadrado: ");
    double precioMetroCuadrado = scanner.nextDouble();
    System.out.print("Número de metros cuadrados: ");
    double numeroMetrosCuadrados = scanner.nextDouble();
    scanner.nextLine(); // Consumir salto de línea

    Propietario propietario = buscarPropietario(identificacionPropietario);
    Barrio barrio = buscarBarrio(nombreBarrio);
    Ciudad ciudad = buscarCiudad(nombreCiudad);
    Constructora constructora = buscarConstructora(idEmpresaConstructora);

    if (propietario == null) {
        System.out.println("No se encontró el propietario con la identificación proporcionada.");
        return;
    }

    if (barrio == null) {
        System.out.println("No se encontró el barrio con el nombre proporcionado.");
        return;
    }

    if (ciudad == null) {
        System.out.println("No se encontró la ciudad con el nombre proporcionado.");
        return;
    }

    if (constructora == null) {
        System.out.println("No se encontró la constructora con el ID proporcionado.");
        return;
    }

    double costoFinal = numeroMetrosCuadrados * precioMetroCuadrado;

    Casa casa = new Casa(propietario, barrio, ciudad, constructora, numeroCuartos,precioMetroCuadrado,
            numeroMetrosCuadrados, costoFinal);
    casas.add(casa);
    guardarCasas();

    System.out.println("Casa registrada exitosamente.");
}

public void registrarDepartamento(Scanner scanner) {
    System.out.println("Ingrese los datos del departamento:");
    System.out.print("Identificación del propietario: ");
    String identificacionPropietario = scanner.nextLine();
    System.out.print("Nombre del barrio: ");
    String nombreBarrio = scanner.nextLine();
    System.out.print("Nombre de la ciudad: ");
    String nombreCiudad = scanner.nextLine();
    System.out.print("ID de la empresa constructora: ");
    String idEmpresaConstructora = scanner.nextLine();
    System.out.print("Precio por metro cuadrado: ");
    double precioMetroCuadrado = scanner.nextDouble();
    System.out.print("Número de metros cuadrados: ");
    double numeroMetrosCuadrados = scanner.nextDouble();
    System.out.print("Valor de la alícuota mensual: ");
    double valorAlicuotaMensual = scanner.nextDouble();
    scanner.nextLine();// Consumir salto de línea
    System.out.print("NombreEdificio: ");
    String nombreEdificio = scanner.nextLine();
    System.out.print("Ubicación del departamento en edificio: ");
    String ubicacionEdificio = scanner.nextLine();

    Propietario propietario = buscarPropietario(identificacionPropietario);
    Barrio barrio = buscarBarrio(nombreBarrio);
    Ciudad ciudad = buscarCiudad(nombreCiudad);
    Constructora constructora = buscarConstructora(idEmpresaConstructora);

    if (propietario == null) {
        System.out.println("No se encontró el propietario con la identificación proporcionada.");
        return;
    }

    if (barrio == null) {
        System.out.println("No se encontró el barrio con el nombre proporcionado.");
        return;
    }

    if (ciudad == null) {
        System.out.println("No se encontró la ciudad con el nombre proporcionado.");
        return;
    }

    if (constructora == null) {
        System.out.println("No se encontró la constructora con el ID proporcionado.");
        return;
    }

    double costoFinal = (numeroMetrosCuadrados * precioMetroCuadrado) + (valorAlicuotaMensual * 12);

   Departamento departamento = new Departamento(propietario, barrio, ciudad, constructora, precioMetroCuadrado,
           numeroMetrosCuadrados, valorAlicuotaMensual, costoFinal, nombreEdificio, ubicacionEdificio);
    
    departamentos.add(departamento);
    guardarDepartamentos();

    System.out.println("Departamento registrado exitosamente.");
}

public boolean validarInformacion() {
    Path propietariosPath = Paths.get(DATA_FOLDER + "propietarios.txt");
    Path barriosPath = Paths.get(DATA_FOLDER + "barrios.txt");
    Path ciudadesPath = Paths.get(DATA_FOLDER + "ciudades.txt");
    Path constructorasPath = Paths.get(DATA_FOLDER + "constructoras.txt");
    Path casasPath = Paths.get(DATA_FOLDER + "casas.txt");
    Path departamentosPath = Paths.get(DATA_FOLDER + "departamentos.txt");

    try {
        return Files.exists(propietariosPath) && Files.size(propietariosPath) > 0 ||
                Files.exists(barriosPath) && Files.size(barriosPath) > 0 ||
                Files.exists(ciudadesPath) && Files.size(ciudadesPath) > 0 ||
                Files.exists(constructorasPath) && Files.size(constructorasPath) > 0 ||
                Files.exists(casasPath) && Files.size(casasPath) > 0 ||
                Files.exists(departamentosPath) && Files.size(departamentosPath) > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

public boolean verificarArchivosCargados() {
    return validarInformacion();
}

     public void mostrarPropietarios() {
        if (propietarios.isEmpty()) {
            System.out.println("No se han registrado propietarios.");
        } else {
            System.out.println("Propietarios registrados:");
            for (Propietario propietario : propietarios) {
                System.out.println(propietario);
            }
        }
    }

    public void mostrarBarrios() {
        if (barrios.isEmpty()) {
            System.out.println("No se han registrado barrios.");
        } else {
            System.out.println("Barrios registrados:");
            for (Barrio barrio : barrios) {
                System.out.println(barrio);
            }
        }
    }

    public void mostrarCiudades() {
        if (ciudades.isEmpty()) {
            System.out.println("No se han registrado ciudades.");
        } else {
            System.out.println("Ciudades registradas:");
            for (Ciudad ciudad : ciudades) {
                System.out.println(ciudad);
            }
        }
    }

    public void mostrarConstructoras() {
        if (constructoras.isEmpty()) {
            System.out.println("No se han registrado constructoras.");
        } else {
            System.out.println("Constructoras registradas:");
            for (Constructora constructora : constructoras) {
                System.out.println(constructora);
            }
        }
    }

    public void mostrarCasas() {
        if (casas.isEmpty()) {
            System.out.println("No se han registrado casas.");
        } else {
            System.out.println("Casas registradas:");
            for (Casa casa : casas) {
                System.out.println(casa);
            }
        }
    }

    public void mostrarDepartamentos() {
        if (departamentos.isEmpty()) {
            System.out.println("No se han registrado departamentos.");
        } else {
            System.out.println("Departamentos registrados:");
            for (Departamento departamento : departamentos) {
                System.out.println(departamento);
            }
        }
    }

    public void mostrarInformacion() {
        mostrarPropietarios();
        mostrarBarrios();
        mostrarCiudades();
        mostrarConstructoras();
        mostrarCasas();
        mostrarDepartamentos();
    }

    public void borrarInformacion() {
        propietarios.clear();
        barrios.clear();
        ciudades.clear();
        constructoras.clear();
        casas.clear();
        departamentos.clear();

        eliminarArchivo(propietariosFile);
        eliminarArchivo(barriosFile);
        eliminarArchivo(ciudadesFile);
        eliminarArchivo(constructorasFile);
        eliminarArchivo(casasFile);
        eliminarArchivo(departamentosFile);

        System.out.println("Toda la información ha sido eliminada.");
    }

     private Propietario buscarPropietario(String identificacion) {
        for (Propietario propietario : propietarios) {
            if (propietario.getIdentificacion().equals(identificacion)) {
                return propietario;
            }
        }
        return null;
    }

    private Barrio buscarBarrio(String nombre) {
        for (Barrio barrio : barrios) {
            if (barrio.getNombre().equals(nombre)) {
                return barrio;
            }
        }
        return null;
    }

    private Ciudad buscarCiudad(String nombre) {
        for (Ciudad ciudad : ciudades) {
            if (ciudad.getNombre().equals(nombre)) {
                return ciudad;
            }
        }
        return null;
    }

    private Constructora buscarConstructora(String idEmpresa) {
        for (Constructora constructora : constructoras) {
            if (constructora.getIdEmpresa().equals(idEmpresa)) {
                return constructora;
            }
        }
        return null;
    }

    private void guardarPropietarios() {
        try {
            FileWriter writer = new FileWriter(propietariosFile,true);
            for (Propietario propietario : propietarios) {
                writer.write(propietario.getNombre() + "," + propietario.getApellido() + ","
                        + propietario.getIdentificacion() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los propietarios en el archivo.");
        }
    }

    private void guardarBarrios() {
        try {
            FileWriter writer = new FileWriter(barriosFile,true);
            for (Barrio barrio : barrios) {
                writer.write(barrio.getNombre() + "," + barrio.getreferencia()+ "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los barrios en el archivo.");
        }
    }

    private void guardarCiudades() {
        try {
            FileWriter writer = new FileWriter(ciudadesFile,true);
            for (Ciudad ciudad : ciudades) {
                writer.write(ciudad.getNombre() + "," + ciudad.getNombreProvincia() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar las ciudades en el archivo.");
        }
    }

    private void guardarConstructoras() {
        try {
            FileWriter writer = new FileWriter(constructorasFile,true);
            for (Constructora constructora : constructoras) {
                writer.write(constructora.getNombre() + "," + constructora.getIdEmpresa()+ "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar las constructoras en el archivo.");
        }
    }

    private void guardarCasas() {
        try {
            FileWriter writer = new FileWriter(casasFile,true);
            for (Casa casa : casas) {
                writer.write(casa.getPropietario().getIdentificacion() + "," + casa.getBarrio().getNombre() + ","
                        + casa.getCiudad().getNombre() + "," + casa.getConstructora().getNombre() + ","
                        + casa.getNumeroCuartos() + "," +
                        + casa.getPrecioMetroCuadrado() + "," + casa.getNumeroMetrosCuadrados() + ","
                        + casa.getCostoFinal() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar las casas en el archivo.");
        }
    }

    private void guardarDepartamentos() {
        try {
            FileWriter writer = new FileWriter(departamentosFile,true);
            for (Departamento departamento : departamentos) {
                writer.write(departamento.getPropietario().getIdentificacion() + ","
                        + departamento.getBarrio().getNombre() + "," + departamento.getCiudad().getNombre() + ","
                        + departamento.getConstructora().getNombre() + "," + departamento.getPrecioMetroCuadrado()
                        + "," + departamento.getNumeroMetrosCuadrados() + "," + departamento.getValorAlicuotaMensual()
                        + "," + departamento.getCostoFinal() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los departamentos en el archivo.");
        }
    }

    private void cargarPropietarios() {
        try {
            File file = new File(propietariosFile);
            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Propietario propietario = new Propietario(parts[0], parts[1], parts[2]);
                    propietarios.add(propietario);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al cargar los propietarios del archivo.");
        }
    }

    private void cargarBarrios() {
        try {
            File file = new File(barriosFile);
            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Barrio barrio = new Barrio(parts[0], parts[1]);
                    barrios.add(barrio);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al cargar los barrios del archivo.");
        }
    }

    private void cargarCiudades() {
        try {
            File file = new File(ciudadesFile);
            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Ciudad ciudad = new Ciudad(parts[0], parts[1]);
                    ciudades.add(ciudad);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al cargar las ciudades del archivo.");
        }
    }

    private void cargarConstructoras() {
        try {
            File file = new File(constructorasFile);
            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Constructora constructora = new Constructora(parts[0], parts[1]);
                    constructoras.add(constructora);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al cargar las constructoras del archivo.");
        }
    }

    private void cargarCasas() {
        try {
            File file = new File(casasFile);
            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    Propietario propietario = buscarPropietario(parts[0]);
                    Barrio barrio = buscarBarrio(parts[1]);
                    Ciudad ciudad = buscarCiudad(parts[2]);
                    Constructora constructora = buscarConstructora(parts[3]);
                    int numeroCuartos = Integer.parseInt(parts[4]);
                    double precioMetroCuadrado = Double.parseDouble(parts[5]);
                    double numeroMetrosCuadrados = Double.parseDouble(parts[6]);
                    double costoFinal = Double.parseDouble(parts[7]);
                    Casa casa = new Casa(propietario, barrio, ciudad, constructora, numeroCuartos,precioMetroCuadrado,
                            numeroMetrosCuadrados, costoFinal);
                    casas.add(casa);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al cargar las casas del archivo.");
        }
    }

    private void cargarDepartamentos() {
        try {
            File file = new File(departamentosFile);
            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 10) {
                    Propietario propietario = buscarPropietario(parts[0]);
                    Barrio barrio = buscarBarrio(parts[1]);
                    Ciudad ciudad = buscarCiudad(parts[2]);
                    Constructora constructora = buscarConstructora(parts[3]);
                    double precioMetroCuadrado = Double.parseDouble(parts[4]);
                    double numeroMetrosCuadrados = Double.parseDouble(parts[5]);
                    double valorAlicuotaMensual = Double.parseDouble(parts[6]);
                    double costoFinal = Double.parseDouble(parts[7]);
                    String nombreEdificio = parts[8];
                    String ubicacionEdificio = parts[9];
                    Departamento departamento = new Departamento(propietario, barrio, ciudad, constructora,
                            precioMetroCuadrado, numeroMetrosCuadrados, valorAlicuotaMensual, costoFinal,nombreEdificio,ubicacionEdificio);
                    
                    departamentos.add(departamento);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al cargar los departamentos del archivo.");
        }
    }

    private void eliminarArchivo(String archivo) {
        File file = new File(archivo);
        if (file.exists()) {
            file.delete();
        }
    }
}