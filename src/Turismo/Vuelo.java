package Turismo;

public class Vuelo extends Reserva {

    private static final double TARIFA_VUELO = 500; // Costo por cada 100 km

    public Vuelo(String nombrePasajero, String destino, String fechaSalida, double distancia, int numeroReserva) {
        super(nombrePasajero, destino, fechaSalida, numeroReserva);
        this.tipoTransporte = "Vuelo";
        this.distancia = distancia;
        calcularCosto();
    }

    @Override
    public void calcularCosto() {
        this.costo = (distancia / 100) * TARIFA_VUELO;
    }
}
