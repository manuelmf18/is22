package logicaNegocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    
    private String id_Reserva; // (dni)
    private LocalDate fecha;
    private Integer hora; // solo se pueden hacer reservas en hora entera (12:00,15:00,20:00)
    private Integer numParticipantes;
    private TipoPista tipoPista;
    public List <Participante> listaParticipantes = new ArrayList ();

    
    public Reserva(String id_Reserva, LocalDate fecha, Integer hora, Integer numParticipantes, TipoPista tipoPista) {
        this.id_Reserva = id_Reserva;
        this.fecha = fecha;
        this.hora = hora;
        this.numParticipantes = numParticipantes;
        this.tipoPista = tipoPista;
    }

    public Reserva() {
        
    }

    public String getId_Reserva() {
        return id_Reserva;
    }

    public void setId_Reserva(String id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public void setNumParticipantes(int numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    public TipoPista getTipoPista() {
        return tipoPista;
    }

    public void setTipoPista(TipoPista tipoPista) {
        this.tipoPista = tipoPista;
    }

    public List<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void addListaParticipantes(Participante participante) {
        this.listaParticipantes.add(participante);
    }

    @Override
    public String toString() {
        return "\n Reserva --> " + "id_Reserva: " + id_Reserva + ", fecha: " + fecha + ", hora: " + hora + ":00" + ", numParticipantes: " + numParticipantes + ", tipoPista: " + tipoPista + "\n\t\t ListaParticipantes: " + listaParticipantes;
    }


    
}