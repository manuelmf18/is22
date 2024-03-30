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
public class ReservaPadel extends Reserva{
    
    public ReservaPadel(String id_Reserva, LocalDate fecha, Integer hora, Integer numParticipantes) {
        super(id_Reserva, fecha, hora, numParticipantes, TipoPista.PADEL);
        setPrecio(aplicarPrecioPadel());
    }

    private Double aplicarPrecioPadel() {
        Double precioTotal = 0.0;
        precioTotal += this.getNumParticipantes()*3; //3 euros por persona precio de padel
        return precioTotal;
    }
}
