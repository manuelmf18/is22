/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronFactoria;
import java.time.LocalDate;
import logicaNegocio.*;

/**
 *
 * @author Jose
 */
public class ReservaFutbol extends Reserva{
    
    public ReservaFutbol(String id_Reserva, LocalDate fecha, Integer hora, Integer numParticipantes) {
        super(id_Reserva, fecha, hora, numParticipantes, TipoPista.FUTBOL);
        setPrecio(aplicarPrecioFutbol());
    }

    private Double aplicarPrecioFutbol() {
        Double precioTotal = 0.0;
        precioTotal += this.getNumParticipantes()*2.5; //2.5 euros precio por persona de la pista de futbol
        return precioTotal;
    }
}
