package Turismo;

public class Autobus extends Reserva{

    private static final double TARIFA_AUTOBUS = 100; // Costo por cada 100 km

    public Autobus(String nombrePasajero, String destino, String fechaSalida, double distancia, int numeroReserva) {
        super(nombrePasajero, destino, fechaSalida, numeroReserva);
        this.tipoTransporte = "Autobus";
        this.distancia = distancia;
        calcularCosto();
    }

    @Override
    public void calcularCosto() {
        this.costo = (distancia / 100) * TARIFA_AUTOBUS;
    }

}
