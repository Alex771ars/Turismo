package Turismo;

public class Tren extends Reserva {

    private static final double TARIFA_TREN = 200; // Costo por cada 100 km

    public Tren(String nombrePasajero, String destino, String fechaSalida, double distancia, int numeroReserva) {
        super(nombrePasajero, destino, fechaSalida, numeroReserva);
        this.tipoTransporte = "Tren";
        this.distancia = distancia;
        calcularCosto();
    }

    @Override
    public void calcularCosto() {
        this.costo = (distancia / 100) * TARIFA_TREN;
    }

}
