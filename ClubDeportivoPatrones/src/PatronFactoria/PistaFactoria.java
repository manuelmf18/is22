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
public class PistaFactoria {
    
    public PistaFactoria() {
        
    }
    
    public Reserva crearReserva(String id_Reserva, LocalDate fecha, Integer hora, Integer numParticipantes, TipoPista tipoPista) {
        Reserva res = null;
        
        switch (tipoPista) {
            case BALONCESTO:
                res = new ReservaBaloncesto(id_Reserva, fecha, hora, numParticipantes);
                break;
            case FUTBOL:
                res = new ReservaFutbol(id_Reserva, fecha, hora, numParticipantes);
                break;
            case PADEL:
                res = new ReservaPadel(id_Reserva, fecha, hora, numParticipantes);
                break;
            default:
                res = null;
                break;
        }
        
        return res;
    }
}
