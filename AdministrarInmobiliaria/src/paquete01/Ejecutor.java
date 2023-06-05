
package paquete01;

import java.util.Scanner;


public class Ejecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inmobiliaria inmobiliaria = new Inmobiliaria();

        int opcion;
        boolean archivosCargados = inmobiliaria.verificarArchivosCargados(); // Verificar si los archivos contienen información al inicio

        do {
            System.out.println("     MENU DE GESTION DE LA INMOBILIARIA");
            System.out.println("--------------------------------------------");
            System.out.println("[1]. Ingresar propietario");
            System.out.println("[2]. Ingresar barrio");
            System.out.println("[3]. Ingresar ciudad");
            System.out.println("[4]. Ingresar constructora");
            System.out.println("[5]. Ingresar casa");
            System.out.println("[6]. Ingresar departamento");

            // Verificar si los archivos están cargados antes de mostrar las opciones "Mostrar información" y "Borrar información"
            if (archivosCargados) {
                System.out.println("[7]. Mostrar información");
                System.out.println("[8]. Borrar información");
            }

            System.out.println("[9]. Salir");
            System.out.print("     Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    inmobiliaria.registrarPropietario(scanner);
                    archivosCargados = true; // Se ha registrado un propietario, se considera que los archivos están cargados
                    break;
                case 2:
                    inmobiliaria.registrarBarrio(scanner);
                    archivosCargados = true; // Se ha registrado un barrio, se considera que los archivos están cargados
                    break;
                case 3:
                    inmobiliaria.registrarCiudad(scanner);
                    archivosCargados = true; // Se ha registrado una ciudad, se considera que los archivos están cargados
                    break;
                case 4:
                    inmobiliaria.registrarConstructora(scanner);
                    archivosCargados = true; // Se ha registrado una constructora, se considera que los archivos están cargados
                    break;
                case 5:
                    inmobiliaria.registrarCasa(scanner);
                    archivosCargados = true; // Se ha registrado una casa, se considera que los archivos están cargados
                    break;
                case 6:
                    inmobiliaria.registrarDepartamento(scanner);
                    archivosCargados = true; // Se ha registrado un departamento, se considera que los archivos están cargados
                    break;
                case 7:
                    if (archivosCargados) {
                        inmobiliaria.mostrarInformacion();
                    } else {
                        System.out.println("No hay información para mostrar.");
                    }
                    break;
                case 8:
                    if (archivosCargados) {
                        inmobiliaria.borrarInformacion();
                    } else {
                        System.out.println("No hay información para borrar.");
                    }
                    break;
                case 9:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            System.out.println();
        } while (opcion != 9);

        scanner.close();
        inmobiliaria.mostrarPropietarios();
        inmobiliaria.mostrarBarrios();
        inmobiliaria.mostrarCiudades();
        inmobiliaria.mostrarConstructoras();
        inmobiliaria.mostrarCasas();
        inmobiliaria.mostrarDepartamentos();
    }
}