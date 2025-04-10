package Turismo;

public abstract class Reserva {


    protected int numeroReserva;
    protected String nombrePasajero;
    protected String destino;
    protected String fechaSalida;
    protected String tipoTransporte;
    protected double distancia;
    protected double costo;

public Reserva(String nombrePasajero, String destino, String fechaSalida, int numeroReserva) {

        this.numeroReserva = numeroReserva;
        this.nombrePasajero = nombrePasajero;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
}

public abstract void calcularCosto();

public int getNumeroReserva () {
    return numeroReserva;
}

public String getNombrePasajero() {
    return nombrePasajero;
}

public String getDestino() {
    return destino;
}

public String getFechaSalida(){
    return fechaSalida;
}

public double getCosto() {
    return costo;
}

@Override
public String toString() {
    return " Reserva #" + numeroReserva + " Pasajero" + nombrePasajero +
            "Destino:" + destino + "Fecha de salida:" + fechaSalida +
            "Tipo de transporte:" + tipoTransporte + "Costo:$" + costo;
    }

}
