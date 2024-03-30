package PatronSingleton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logicaNegocio.*;


public class ClubDeportivo implements ISujeto{
    
//ATRIBUTOS:    
    private String nombre = "Club Deportivo UPO";
    private int telefono = 192345672;

    //LISTAS:
    ArrayList <Cliente> listaClientes = new ArrayList();
    ArrayList <Reserva> listaReservas = new ArrayList();
    ArrayList <Incidencia> listaIncidencias = new ArrayList();
    ArrayList <Grupo> listaGrupos = new ArrayList();
    
    ArrayList <IObservador> observadores;
    List <IComunicado> comunicados;
    
//OBJETOS:
    Cliente c;
    Reserva r;
    Participante p;
    Grupo g;
    

    public ClubDeportivo() {
        
        this.observadores = new ArrayList();
        this.comunicados = new ArrayList();
        
        inicializarDatosP();
    }

    
//COMUNICADOS (PATRON OBSERVER)
    
    @Override
    public void notificarObservadores(){
        
       for(IObservador o:observadores){
           
           o.update(comunicados.get(comunicados.size() - 1)); 
       } 
    }
    
    @Override
    public void registrarObservador(IObservador o){
        
        this.observadores.add(o);
    }
    
    @Override
    public void eliminarObservador(IObservador o){
        
        this.observadores.remove(o);
    }
    
    public void addComunicado(IComunicado comunicado){
        
        this.comunicados.add(comunicado); 
        this.notificarObservadores();
    }
    
    public void enviarComunicado(IComunicado comunicado) {
        // Imprimir el comunicado en cada cliente en la lista
        for (Cliente cliente : listaClientes) {
            System.out.println("Enviando comunicado a " + cliente.getNombre() + ":");
            System.out.println(comunicado);
        }
    }
    
    
//CLIENTES:
    
    public void añadirCliente (Cliente c){
        
        listaClientes.add(c);
    } 
    
    public void eliminarCliente (Cliente c){
        
        for (Iterator<Cliente> cl = listaClientes.iterator(); cl.hasNext();) {
            Cliente next = cl.next();
            
            if(next.equals(c)){
                cl.remove();
            }
        }
    }
    
    public Cliente getCliente(String dni){
        
        
        for (Iterator <Cliente> cl = listaClientes.iterator(); cl.hasNext();) {
            Cliente next = cl.next();
            
            if(next.getDni().equals(dni)){
                
                this.c = next;
            }
        }
        
        return this.c;
    }
    
//RESERVA:
    
    public void añadirReserva(Reserva r) {
        
        listaReservas.add(r);
        
    }
    
    public Reserva getReserva(String id){
        
        for (Iterator <Reserva> re = listaReservas.iterator(); re.hasNext();) {
            Reserva next = re.next();
            
            if(next.getId_Reserva().equals(id)){
                
                this.r = next;
            }
        }
        
        return this.r;
    }

    public void eliminarReserva (Reserva r){
        
        for (Iterator<Reserva> re = listaReservas.iterator(); re.hasNext();) {
            Reserva next = re.next();
            
            if(next.equals(r)){
                re.remove();
            }
        }
        
        System.out.println("Se ha eliminado la reserva correctamente.");
    }
    
    public void consultarReserva (Reserva r){
        
        for (Iterator<Reserva> re = listaReservas.iterator(); re.hasNext();) {
            Reserva next = re.next();
            
            if(next.equals(r)){
                System.out.println(next.toString());
            }
        }
        
    }
    
    
//INCIDENCIAS:
    
    
    public void añadirIncidencia (Incidencia i){
        
        listaIncidencias.add(i);
        
        System.out.println(i.toString());
    } 
    
//Actividades:
    
    public Grupo getGrupo(TipoActividad tA, TramoHorario tH) {

        for (Iterator <Grupo> gA = listaGrupos.iterator(); gA.hasNext();) {
            Grupo next = gA.next();
            
            if(next.gettActividad().equals(tA) && next.gettHorario().equals(tH)){
                
                this.g = next;
            }
        }
        
        return this.g;
    }

    public String getGrupoAct(TipoActividad tA) {

        ArrayList <Grupo> miniListaGrupo = new ArrayList();
        
        for (Iterator <Grupo> gA = listaGrupos.iterator(); gA.hasNext();) {
            Grupo next = gA.next();
            
            if(next.gettActividad().equals(tA)){
                
                this.g = next;
                
                if(this.g.getNumInscritos() != this.g.getMaxInscritos()){
                
                    miniListaGrupo.add(g);
                }
            }
        }
          return miniListaGrupo.toString();
    }
    
    public void confirmaInscripcion(Grupo g){
        
        g.setNumInscritos();
        
    }
    
//DATOS INICIALES
    
    public void inicializarDatosP(){
        
        listaClientes.add(new Cliente("12345678R","LOLITO",123456781));
        listaClientes.add(new Cliente("12345678A","Carlos",123456781));
        listaClientes.add(new Cliente("12345678B","Pepe",123456782));
        listaClientes.add(new Cliente("12345678D","Roberto",123456784));
        
        LocalDate fecha = LocalDate.parse("2022-06-12");
        Reserva r1 = new Reserva ("12345678A",fecha,14,2,TipoPista.FUTBOL);
        Reserva r2 = new Reserva("12345678D",fecha,14,2,TipoPista.FUTBOL);
        
        listaReservas.add(r1);
        listaReservas.add(r2);
        
        Participante p1 = new Participante ("12345612S");
        r1.addListaParticipantes(p1);
        Participante p2 = new Participante ("123456098L");
        r1.addListaParticipantes(p2);
        
        Participante p3 = new Participante ("12345677E");
        r2.addListaParticipantes(p3);
        Participante p4 = new Participante ("123456634R");
        r2.addListaParticipantes(p4);
        
        
        listaIncidencias.add(new Incidencia (TipoPista.FUTBOL,"la red de la porteria tiene un agujero"));
        listaIncidencias.add(new Incidencia (TipoPista.PADEL,"el cesped de la pista esta con holguras"));
        
        listaGrupos.add(new Grupo (TipoActividad.AEROBIC, TramoHorario.MAÑANA));
        listaGrupos.add(new Grupo (TipoActividad.AEROBIC, TramoHorario.TARDE));
        listaGrupos.add(new Grupo (TipoActividad.AEROBIC, TramoHorario.NOCHE));
        listaGrupos.add(new Grupo (TipoActividad.PILATES, TramoHorario.MAÑANA));
        listaGrupos.add(new Grupo (TipoActividad.PILATES, TramoHorario.TARDE));
        listaGrupos.add(new Grupo (TipoActividad.PILATES, TramoHorario.NOCHE));
        listaGrupos.add(new Grupo (TipoActividad.SPINNING, TramoHorario.MAÑANA));
        listaGrupos.add(new Grupo (TipoActividad.SPINNING, TramoHorario.TARDE));
        listaGrupos.add(new Grupo (TipoActividad.SPINNING, TramoHorario.NOCHE));
           
    }
    
    
    public String toString() {
        return "\nClubDeportivo: \n \n" + "nombre: " + nombre + "\ntelefono: " + telefono
                                      + "\n\nListaClientes:" + listaClientes 
                                      + "\n\nListaReservas:" + listaReservas
                                      + "\n\nListaIncidencias:" + listaIncidencias
                                      + "\n\nListaGrupos:" + listaGrupos;
    }

}
