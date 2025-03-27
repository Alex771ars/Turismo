/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebasalgoritmo;

/**
 *
 * @author Alexis Arias
 */

import java.time.Duration;
import java.time.LocalDateTime;

public class ParqueaderoV3 {
    
    
   private static int espaciosDisponiblescarro = 2;
   private static int espaciosDisponiblesmoto = 1;
   private static int espaciosDisponibles = espaciosDisponiblescarro + espaciosDisponiblesmoto;
   public static Vehiculov1[] vehiculos = new Vehiculov1[espaciosDisponibles]; // 2 carros y 1 moto
    static int carrosCount = 0; // Contador de carros
    static int motosCount = 0; // Contador de motos
    
    public  boolean validarDisponibilidad(String tipo) {
    if (tipo.equals("Carro")) {
        if (carrosCount >= 2) {
            System.out.println("No hay espacios disponibles para carros.");
            return false; // No hay espacio para más carros
        } else {
            System.out.println("Hay espacios disponibles para carros.");
            return true; // Hay espacio para más carros
        }
    } else if (tipo.equals("Moto")) {
        if (motosCount >= 1) {
            System.out.println("No hay espacios disponibles para motos.");
            return false; // No hay espacio para más motos
        } else {
            System.out.println("Hay espacios disponibles para motos.");
            return true; // Hay espacio para más motos
        }
    } else {
        System.out.println("Tipo de vehículo no reconocido.");
        return false; // Tipo de vehículo no reconocido, por lo tanto no se puede realizar la validación
    }
}
    
    public void ingresarVehiculo(Vehiculov1 vehiculov1) {
        if (vehiculov1.getTipo().equals("Carro") && carrosCount < 2) {
            // Si es carro y no se ha alcanzado el límite de carros
            if (espaciosDisponiblescarro > 0) {
                for (int i = 0; i < vehiculos.length; i++) {
                    if (vehiculos[i] == null) {
                        vehiculos[i] = vehiculov1;
                        espaciosDisponiblescarro--;
                        carrosCount++; // Incrementar el contador de carros
                        System.out.println(vehiculov1.getTipo() + " ingresado exitosamente.");
                        return;
                    }
                }
            }
        } else if (vehiculov1.getTipo().equals("Moto") && motosCount < 1) {
            // Si es moto y no se ha alcanzado el límite de motos
            if (espaciosDisponiblesmoto > 0) {
                for (int i = 0; i < vehiculos.length; i++) {
                    if (vehiculos[i] == null) {
                        vehiculos[i] = vehiculov1;
                        espaciosDisponiblesmoto--;
                        motosCount++; // Incrementar el contador de motos
                        System.out.println(vehiculov1.getTipo() + " ingresado exitosamente.");
                        return;
                    }
                }
            }
        } //else {
            //System.out.println("No hay espacios disponibles o se ha alcanzado el limite de vehiculos del tipo especificado.");
        //}
    }

    // Método para registrar salida de un vehiculo
    public  void registrarSalida(String placa, String respuesta) {
        
        boolean placaEncontrada = false;
        
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null && vehiculos[i].getPlaca().equals(placa)) {
                placaEncontrada = true;
                
                // Calcular la duración del estacionamiento
                if (respuesta.equals("si")) { 
                Duration duracion = Duration.between(vehiculos[i].getFechaHora(), LocalDateTime.now());
                long horas = duracion.toHours();
                long minutos = duracion.toMinutes() % 60;
                long precio = vehiculos[i].getTipo().equals("Carro") ? horas * 1000 + (minutos > 0 ? 1000 : 0) : horas * 500 + (minutos > 0 ? 500 : 0);

                System.out.println("El vehiculo con placa " + placa + " ha estado estacionado por: " + horas + " horas y " + minutos + " minutos.");
                System.out.println("El precio de estacionamiento es: COP " + precio);

                // Liberar el espacio dependiendo del tipo del vehiculo
                //vehiculos[i] = null;
               // espaciosDisponibles++;
               
               if (vehiculos[i].getTipo().equals("Carro")) {
                    espaciosDisponiblescarro++; // Liberar espacio para carro
                    carrosCount--; // Decrementar el contador de carros
                } else if (vehiculos[i].getTipo().equals("Moto")) {
                    espaciosDisponiblesmoto++; // Liberar espacio para moto
                    motosCount--; // Decrementar el contador de motos
                }
               
                vehiculos[i] = null; // Eliminar el vehículo del arreglo
                System.out.println("El vehiculo con placa " + placa + " ha sido retirado.");
                } else {
                System.out.println("El vehiculo no sera retirado.");
            }
            return; // Salir del método después de procesar el vehículo
        }

                // Decrementar el contador según el tipo de vehículo
                //if (vehiculos[i] != null && vehiculos[i].getTipo().equals("Carro")) {
                   // carrosCount--;
                //} else if (vehiculos[i] != null && vehiculos[i].getTipo().equals("Moto")) {
                   // motosCount--;
                //}

             //   return;
            //} else {
               // System.out.println("El vehiculo no sera retirado.");
                //return; // No se realiza ninguna acción y termina el proceso si no se confirma la salida
               //}    
                
            //}
        }
       // if (!placaEncontrada) {
       // System.out.println("Placa no encontrada.");
       // }
    }

    // Método para mostrar todos los vehiculos
    public  void mostrarVehiculos() {
        System.out.println("Vehiculos en el parqueadero:");
        for (Vehiculov1 vehiculo : vehiculos) {
            if (vehiculo != null) {
                System.out.println(vehiculo);
            }
        }
    }
    
}
