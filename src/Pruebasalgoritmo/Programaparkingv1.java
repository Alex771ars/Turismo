/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebasalgoritmo;

/**
 *
 * @author Alexis Arias
 */

import java.util.Scanner;
import java.time.LocalDateTime;

public class Programaparkingv1 {
    static ParqueaderoV3 parqueaderoV3;
    public Programaparkingv1 (){
        
    }
    
    
    public static void main(String[] args) {
       // Programaparkingv1 programaparkingv1 = new Programaparkingv1();
       parqueaderoV3 = new ParqueaderoV3();
        
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println("Opciones generales:");
            System.out.println("1. Ingresar un carro");
            System.out.println("2. Ingresar una moto");
            System.out.println("3. Mostrar vehiculos en el parqueadero");
            System.out.println("4. Registrar salida de un vehiculo");
            System.out.println("5. Salir");
            System.out.print("Por favor elija una opcion para continuar: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea sobrante

            switch (opcion) {
                case 1:
                    ingresarVehiculo(scanner, "Carro");
                    break;
                case 2:
                    ingresarVehiculo(scanner, "Moto");
                    break;
                case 3:
                    parqueaderoV3.mostrarVehiculos();
                    break;
                case 4:
                    registrarSalida(scanner);
                    break;
                case 5:
                    System.out.println("Gracias por utilizar el servicio");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    
    private static void ingresarVehiculo(Scanner scanner, String tipo) {
        boolean resultado = parqueaderoV3.validarDisponibilidad(tipo);
        
       // parqueaderoV3.validarDisponibilidad(tipo);
  //  if ((tipo.equals("Carro") && parqueaderoV3.carrosCount < 2) || (tipo.equals("Moto") && parqueaderoV3.motosCount < 1)) {
        if (resultado){
             
        System.out.print("Ingrese la placa del " + tipo.toLowerCase() + ": ");
        String placa = scanner.nextLine();

        // Obtener la fecha y hora actuales
        LocalDateTime fechaHora = LocalDateTime.now();

        // Crear un objeto Vehiculo
        Vehiculov1 vehiculo = new Vehiculov1(placa, tipo, fechaHora);

        // Llamar al método para ingresar el vehículo
        parqueaderoV3.ingresarVehiculo(vehiculo);
     }
    }

    private static void registrarSalida(Scanner scanner) {
        System.out.print("Ingrese la placa del vehiculo que desea retirar: ");
        String placa = scanner.nextLine();
        
         // Verificar si el vehículo con la placa ingresada existe en el parqueadero
    boolean vehiculoEncontrado = false;
    for (int i = 0; i < parqueaderoV3.vehiculos.length; i++) {
        if (parqueaderoV3.vehiculos[i] != null && ParqueaderoV3.vehiculos[i].getPlaca().equals(placa)) {
            vehiculoEncontrado = true;
            break;
        }
    }

    if (!vehiculoEncontrado) {
        System.out.println("La placa ingresada no se encuentra en el parqueadero.");
        return; // Terminar el proceso si la placa no existe
    }
        
        
        System.out.print("Desea retirar el vehiculo?: si/no : ");
        String respuesta = scanner.nextLine();
        // Leer la respuesta y convertirla a minúsculas

        // Llamar al método para registrar la salida
        parqueaderoV3.registrarSalida(placa, respuesta);
    }
    
}
