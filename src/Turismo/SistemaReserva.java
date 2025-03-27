/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turismo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SistemaReserva {
    
    private List<Reserva> reservas = new ArrayList<>();
    private String[] DESTINOS = {
        "Pasto", "Cali", "Cartagena", "Bogota", "Barranquilla", "Bucaramanga", "Cucuta"
    };
    private double[] DISTANCIAS = {860, 415, 610, 415, 690, 390, 590};
    private int contadorReservas = 1; // Contador no estático

    public static void main(String[] args) {
        SistemaReserva sistemaReserva = new SistemaReserva();
        sistemaReserva.iniciarSistema();
    }

    public void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*** Menu de Reservas ***");
            System.out.println(" 1. Hacer una reserva");
            System.out.println(" 2. Cancelar una reserva");
            System.out.println(" 3. Consultar reserva por numero");
            System.out.println(" Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después de la opción

            switch (opcion) {
                case 1:
                    hacerReserva(scanner);
                    break;
                case 2:
                    cancelarReserva(scanner);
                    break;
                case 3:
                    consultarReserva(scanner);
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el sistema de reservas!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    public void hacerReserva(Scanner scanner) {
        System.out.print("Ingrese el nombre del pasajero: ");
        String nombre = scanner.nextLine();

        System.out.println("Destinos disponibles:");
        for (int i = 0; i < DESTINOS.length; i++) {
            System.out.println((i + 1) + ". " + DESTINOS[i]);
        }
        System.out.print("Seleccione un destino (1-7): ");
        int destinoIndex = scanner.nextInt() - 1;

        if (destinoIndex < 0 || destinoIndex >= DESTINOS.length) {
            System.out.println("Destino no valido.");
            return;
        }

        System.out.print("Ingrese la fecha de salida (formato: dd/mm/aaaa): ");
        String fecha = scanner.next();

        System.out.println("Seleccione el tipo de transporte:");
        System.out.println("1. Vuelo ");
        System.out.println("2. Tren ");
        System.out.println("3. Autobus ");
        System.out.print("Seleccione una opcion: ");
        int tipoTransporte = scanner.nextInt();

        Reserva reserva = crearReserva(nombre, DESTINOS[destinoIndex], fecha, tipoTransporte, DISTANCIAS[destinoIndex]);

        reservas.add(reserva);
        contadorReservas++; // Aumentar el contador de reservas
        System.out.println("Reserva realizada con exito.");
        System.out.println(reserva);
    }

    private Reserva crearReserva(String nombrePasajero, String destino, String fechaSalida, int tipoTransporte, double distancia) {
        switch (tipoTransporte) {
            case 1:
                return new Vuelo(nombrePasajero, destino, fechaSalida, distancia, contadorReservas);
            case 2:
                return new Tren(nombrePasajero, destino, fechaSalida, distancia, contadorReservas);
            case 3:
                return new Autobus(nombrePasajero, destino, fechaSalida, distancia, contadorReservas);
            default:
                System.out.println("Opcion de transporte no valida.");
                return null;
        }
    }

    public void cancelarReserva(Scanner scanner) {
        System.out.print("Ingrese el numero de reserva a cancelar: ");
        int numeroReserva = scanner.nextInt();
        
        reservas.stream()
            .filter(reserva -> reserva.getNumeroReserva() == numeroReserva)
            .findFirst()
            .ifPresentOrElse(reserva -> {
                System.out.println("Reserva encontrada: " + reserva);
                System.out.print("¿Seguro que desea cancelar esta reserva? (si/no): ");
                scanner.nextLine(); // Consumir el salto de línea restante
                String respuesta = scanner.nextLine();
                if ("si".equalsIgnoreCase(respuesta)) {
                    reservas.remove(reserva);
                    System.out.println("Reserva #" + numeroReserva + " cancelada exitosamente.");
                } else {
                    System.out.println("La reserva no ha sido cancelada.");
                }
            }, () -> System.out.println("Reserva no encontrada."));
    }

    public void consultarReserva(Scanner scanner) {
        System.out.print("Ingrese el numero de reserva a consultar: ");
        int numeroReserva = scanner.nextInt();
        
        reservas.stream()
            .filter(reserva -> reserva.getNumeroReserva() == numeroReserva)
            .findFirst()
            .ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Reserva no encontrada.")
            );
    }
    
}
