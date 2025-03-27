/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turismo;

public abstract class Reserva {
    
    protected int numeroReserva;  
    protected String nombrePasajero;  
    protected String destino;  
    protected String fechaSalida;  
    protected String tipoTransporte;  
    protected double distancia;  
    protected double costo; 

    // Constructor para inicializar los datos básicos de la reserva.
    public Reserva(String nombrePasajero, String destino, String fechaSalida, int numeroReserva) {
        this.numeroReserva = numeroReserva;  
        this.nombrePasajero = nombrePasajero;  
        this.destino = destino;  
        this.fechaSalida = fechaSalida;  
    }

    // Método abstracto para calcular el costo de la reserva, que debe ser implementado en las subclases.
    public abstract void calcularCosto();

    // Métodos getter para obtener los valores de las propiedades.
    public int getNumeroReserva() {
        return numeroReserva;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public String getDestino() {
        return destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public double getCosto() {
        return costo;
    }

    // Método toString para mostrar información legible de la reserva.
    @Override
    public String toString() {
        return "  Reserva #" + numeroReserva + "  Pasajero: " + nombrePasajero +
                "  Destino: " + destino + "  Fecha de salida: " + fechaSalida +
                "  Tipo de transporte: " + tipoTransporte + " Costo: $" + costo;
    }
    
}
