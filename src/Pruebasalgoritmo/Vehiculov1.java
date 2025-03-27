/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebasalgoritmo;

/**
 *
 * @author Alexis Arias
 */

import java.time.LocalDateTime;

public class Vehiculov1 {
    
    private String placa;
    private String tipo;
    private String respuesta;
    private LocalDateTime fechaHora;

    public Vehiculov1(String placa, String tipo, LocalDateTime fechaHora) {
        this.placa = placa;
        this.tipo = tipo;
        this.respuesta = respuesta;
        this.fechaHora = fechaHora;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }
    
      public String getRespuesta() {
        return respuesta;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return placa + " - Tipo: " + tipo + " - Ingreso: " + fechaHora;
    }
          
    
}
