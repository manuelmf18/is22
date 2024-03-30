package PatronSingleton;

import PatronFactoria.PistaFactoria;
import PatronObservador.*;
import java.time.LocalDate;
import java.util.*;
import logicaNegocio.*;

public class ClubDeportivo implements ISujeto{
    
    private static ClubDeportivo clubDeporUnico;

    //ATRIBUTOS:    
    private String nombre;
    private int telefono;
    private String direccion;

    //LISTAS:
    ArrayList <Cliente> listaClientes;
    ArrayList <Reserva> listaReservas;
    ArrayList <Incidencia> listaIncidencias;
    ArrayList <Grupo> listaGrupos;
    
    ArrayList <IObservador> observadores;
    List <IComunicado> comunicados;
    
//OBJETOS:
    Cliente c;
    Reserva r;
    Participante p;
    Grupo g;
    PistaFactoria factoria;
    

    public ClubDeportivo(String nombre,int telefono ,String direccion) {
        
        this.nombre = nombre;
        this.telefono = 123456789;
        this.direccion = direccion;
        
        this.listaClientes = new ArrayList();
        this.listaReservas = new ArrayList();
        this.listaIncidencias = new ArrayList();
        this.listaGrupos = new ArrayList();
        
        this.observadores = new ArrayList();
        this.comunicados = new ArrayList();
        
        inicializarDatosP();
    }
    
    public static synchronized ClubDeportivo getInstanciaSingleton(String nombre,int telefono ,String direccion){
		
        if(clubDeporUnico == null){
			
            clubDeporUnico = new ClubDeportivo(nombre,telefono,direccion);
        
        } else{
			
            System.out.println("\n ¡¡¡ERROR!!! No se puede crear el parque de atracciones; ya que ya existe uno");
	}
		
        return clubDeporUnico;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

    
//COMUNICADOS (PATRON OBSERVER)
    
    public void notificarObservadores(){
        
       for(IObservador o:observadores){
           
           o.update(comunicados.get(comunicados.size() - 1)); 
       } 
    }
    
    public void registrarObservador(IObservador o){
        
        this.observadores.add(o);
    }
    
    public void eliminarObservador(IObservador o){
        
        this.observadores.remove(o);
    }
    
    public void addComunicado(IComunicado comunicado){
        
        this.comunicados.add(comunicado); 
        this.notificarObservadores();
    }
    
    @Override
    public void enviarComunicado(IComunicado comunicado) {
    
 
        for (Cliente cliente : listaClientes) {

            if (comunicado.getPrioridad() == PrioridadComunicado.BAJA && cliente.getComPrioridadBaja() == true) {
                System.out.println("\nEnviando comunicado de prioridad baja a cliente permitido: " + cliente.getNombre());
                System.out.println(comunicado);

            } else if(comunicado.getPrioridad() == PrioridadComunicado.ALTA){
                System.out.println("\nEnviando comunicado a " + cliente.getNombre() + "...");
                System.out.println(comunicado);
            }
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
        
        listaClientes.add(new Cliente("12345678R","LOLITO",123456781,true));
        listaClientes.add(new Cliente("12345678A","Carlos",123456781,true));
        listaClientes.add(new Cliente("12345678B","Pepe",123456782,false));
        listaClientes.add(new Cliente("12345678D","Roberto",123456784,false));
        
        LocalDate fecha = LocalDate.parse("2022-06-12");
        
        factoria = new PistaFactoria();
        
        Reserva r1 = factoria.crearReserva("12345678A",fecha,14,2, TipoPista.BALONCESTO);

        Reserva r2 = factoria.crearReserva("12345678D",fecha,14,2,TipoPista.FUTBOL);
        
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
