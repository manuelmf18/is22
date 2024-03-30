package PatronFachada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
import java.util.Date;
import clubdeportivo.Futbol;

public class Control {
    
    public ClubDeportivo cD = new ClubDeportivo();
    
    Cliente c;
    Reserva r;
    Participante p;
    Incidencia i;
    Grupo g;
    

    public Control() {
    }
    
    
//CLIENTES:
    
    public void introducirDatosCliente(String dni,String nombre,int telefono){
        
        this.c = new Cliente(dni,nombre,telefono);
        System.out.println(this.c.toString());
        
        this.cD.añadirCliente(c);
        
    }
    
    public Cliente selecionarCliente(String dni){
        
        this.c =  this.cD.getCliente(dni);
        
        return this.c;
    }
    
    
    public void confirmarBaja(Cliente c){
        
        this.cD.eliminarCliente(c);
        
    }
    
    
//RESERVAS:
    
    public Participante introducirDatosParticipante(String dni){
        
        this.p = new Participante(dni);
        
        return p;
    }

    
    public Reserva introducePista(String id_R,LocalDate fecha, int hora, int numParticipantes, TipoPista tipoPista){

        this.r = new Reserva (id_R,fecha,hora,numParticipantes,tipoPista);
        
        this.cD.añadirReserva(r);
        return this.r;
    }
    
    
    public Reserva selecionarReserva(String id){
        
        this.r =  this.cD.getReserva(id);
                
        return this.r;
    }
    
    
    public void confirmarCancelacion(Reserva r){
        
        this.cD.eliminarReserva(r);
        
    }
    
    public void confirmaConsulta (Reserva r){
        
        this.cD.consultarReserva(r);
        
    }
    
//INCIDENCIAS:   
    
    public void introducirIncidencia (TipoPista tipoPista, String incidencia){
        
        this.i = new Incidencia(tipoPista, incidencia);
        
        cD.añadirIncidencia(i);

    }


//ACTIVIDADES:
    
    public boolean grupoLleno(TipoActividad tA, TramoHorario tH){
        
        this.g = this.cD.getGrupo(tA,tH);
                
        if (g.getNumInscritos() == g.getMaxInscritos()){
            
            System.out.println("El grupo está lleno.");
            return true;
            
        }else return false;
    }
    
    public void mostrarActDisp(TipoActividad tA){
      
            System.out.println(this.cD.getGrupoAct(tA)); 

    }
    
    public void añadirActividad(TipoActividad tA, TramoHorario tH) {
        
        this.g = cD.getGrupo(tA,tH);
        
        this.cD.confirmaInscripcion(g);
        
    }
    
  
    
//ENUMS:
    
    public TipoActividad obtenerTipoActividad (Integer opc){
        
        TipoActividad a = null;
        
        if (opc == 1){
            a = TipoActividad.AEROBIC;
            
        }else if (opc == 2){
            a = TipoActividad.PILATES;
                    
        }else if (opc == 3){
            a = TipoActividad.SPINNING;
            
        }else if (opc == 4){
            a = TipoActividad.YOGA;
        }
        
        return a;
    }
    
    public TramoHorario obtenerTramoHorario (Integer opc){
        
        TramoHorario h = null;
        
        if (opc == 1){
            h = TramoHorario.MAÑANA;
            
        }else if (opc == 2){
            h = TramoHorario.TARDE;
                    
        }else if (opc == 3){
            h = TramoHorario.NOCHE; 
        }
        
        return h;
    }
    
    //tipo pista
    public TipoPista obtenerTipoPista (Integer opc){
        
        TipoPista p = null;
        
        if (opc == 1){
            p = cD.futbol;
            
        }else if (opc == 2){
            p = cD.baloncesto;
                    
        }else if (opc == 3){
            p = cD.padel;
        }
        
        return p;
    }

}