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
public class ReservaBaloncesto extends Reserva{
    
    public ReservaBaloncesto(String id_Reserva, LocalDate fecha, Integer hora, Integer numParticipantes) {
        super(id_Reserva, fecha, hora, numParticipantes, TipoPista.BALONCESTO);
        setPrecio(aplicarPrecioBaloncesto());
    }

    private Double aplicarPrecioBaloncesto() {
        Double precioTotal = 0.0;
        precioTotal += this.getNumParticipantes()*2; //Precio de la pista de baloncesto por participante 2 euros
        return precioTotal;
    }
}
