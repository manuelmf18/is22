package PatronFachada;


import PatronObservador.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import logicaNegocio.*;
import poo.io.IO;

public class Pantalla {
    
    private Control ctrl;
    
    private Cliente c;
    private Reserva r;
    private Participante p;
    private Incidencia i;
    private Grupo g;

    public Pantalla(Control ctrl) {
		this.ctrl = ctrl;
	}
    
    public void mostrarMenuPrincipal() {
        
        Scanner s = new Scanner(System.in);
        
        int opc = -1;
        do {
            System.out.println("\n      Bienvenido a CD_UPO \n\n\tMenu Principal: \n");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de reservas");
            System.out.println("3. Notificar incidencias");
            System.out.println("4. Gestión actividades");
            System.out.println("5. Mostrar datos del club");
            System.out.println("6. Enviar comunicado a Clientes [PATRÓN]");
                
            System.out.print("\n");
            System.out.println("    0.Salir");
            System.out.println("\n\n--> Escoje una opción: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 6) {
                System.out.println("\n--> Introduzca una opcion valida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcion(opc);
            }
        } while (opc != 0);
    }

    private void realizarOpcion(int opc) {
        switch (opc) {
            case 1:
                pantallaMenuGestionClientes();
                break;
            case 2:
                pantallaMenuGestiónReservas();
                break;
            case 3:
                pantallaMenuNotificarIncidencias();
                break;
            case 4:
                pantallaMenuGestiónActividades();
                break;
            case 5:
                pantallaMenuVisualizacionDatos();
                break;
            case 6:
                pantallaMenuGestionComunicados();
        }
    }

    
//COMUNICADOS: (PATRON)
    
    
    private void pantallaMenuGestionComunicados() {
        
        Scanner s = new Scanner(System.in);
        int opc = -1;
        
        Comunicado co = new Comunicado();
        String salida;
        
        String tituloCom;
        String descripcionCom;
        String prioridad;

        System.out.println("Introduce el titulo del comunicado:");
        tituloCom = (String) IO.readLine();
        co.setTitulo(tituloCom);
        
        System.out.println("\nIntroduce la descripcion del comunicado:");
        descripcionCom = (String) IO.readLine();
        co.setDescp(descripcionCom);
        
        System.out.println("\n ¿Es un comunicado de prioridad alta?");
        prioridad = IO.readLine();
        
        if(prioridad.equalsIgnoreCase("si")){
            
            co.setPrioridad(PrioridadComunicado.ALTA);
        }else{
            
            co.setPrioridad(PrioridadComunicado.BAJA);
        }
        
        System.out.println("\nEl comunicado que vas a enviar es el siguiente:");
        System.out.println(co.toString());
        
        System.out.println("\n ¿ Deseas Enviarlo ?");
        salida = (String) IO.readLine();
        
        if(salida.equalsIgnoreCase("si")){
            
            ctrl.comunicado(co);
            
        }else{
            
            pantallaMenuGestionComunicados();
        }
    }

    
    
//CLIENTES:
    private void pantallaMenuGestionClientes() {
        Scanner s = new Scanner(System.in);
        int opc = -1;

        do {
            System.out.println("\nMenu de Gestion de Clientes:\n");
            System.out.println("    1. Alta de Cliente");
            System.out.println("    2. Baja de Cliente");
            System.out.println("    3. Modificar Cliente");
            System.out.print("\n");
            System.out.println("    0. Salir");
            System.out.println("\n\n--> Escoje una opcion: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 4) {
                System.out.println("--> Introduzca una opcion valida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcionGestionCliente(opc);
            }
        } while (opc != 0);
    }

    
    private void realizarOpcionGestionCliente(int opc) {
        System.out.print("Has elejido la opción: ");

        switch (opc) {
            case 1:
                System.out.println("Alta Cliente\n");
                mostrarAltaCliente();
                break;
            case 2:
                System.out.println("Baja Cliente\n");
                mostrarBajaCliente();
                break;
            case 3:
                System.out.println("Modificar Cliente\n");
                mostrarModificarCliente();
                break;
        }
    }

    private void mostrarAltaCliente() {
        
        String dni;
        boolean bPrioridad;
        
       do{
            System.out.println("Introduzca el dni del cliente a dar de Alta");
            System.out.println("Dni:");
            dni = (String) IO.readLine();
        
            this.c= ctrl.selecionarCliente(dni);
            if ( c != null){

                System.out.println("El dni introducido ya pertenece a un Cliente");
                
            }else 
                this.c = ctrl.selecionarCliente(dni);

        } while (this.c != null);
        
        System.out.println("Nombre:");
        String nombre = (String) IO.readLine();
        
        System.out.println("Teléfono:");
        int telefono = (int) IO.readNumber();
        
        System.out.println("¿Desea recibir comunicados de BAJA prioridad?");
        String prioridad = IO.readLine();
        
        if(prioridad.equalsIgnoreCase("si") || prioridad.equalsIgnoreCase("sí")){
            
            bPrioridad = true;
            
        }else{
            
            bPrioridad = false;
        }
        
        ctrl.introducirDatosCliente(dni, nombre, telefono,bPrioridad);

    }

    private void mostrarBajaCliente() {
       
        do{
            System.out.println("Introduzca el dni del cliente a Eliminar");
            System.out.println("Dni:");
            String dni = (String) IO.readLine();
        
            this.c= ctrl.selecionarCliente(dni);
            if ( c == null){

                System.out.println("El dni introducido no pertenece a ningun Cliente");

            }else
                this.c = ctrl.selecionarCliente(dni);

        } while (this.c == null);
        
        this.ctrl.confirmarBaja(c);
        
    }

    private void mostrarModificarCliente() {
      
        boolean bPrioridad;
        
        do{
            System.out.println("Introduzca el dni del cliente a Modificar:");

            System.out.println("Dni:");
            String dni = (String) IO.readLine();
        
            if (ctrl.selecionarCliente(dni) == null){

                System.out.println("El dni introducido no pertenece a ningun Cliente");

            }else
                this.c = ctrl.selecionarCliente(dni);

        } while (this.c == null);

        
        ctrl.confirmarBaja(this.c);
        
        System.out.println("Introduzca los nuevos datos del cliente:");
        
        System.out.println("Nombre:");
        String nuevoNombre = (String) IO.readLine();
        
        System.out.println("Teléfono:");
        int nuevoTelefono = (int) IO.readNumber();
      
        System.out.println("¿Desea recibir comunicados de BAJA prioridad?");
        String prioridad = IO.readLine();
        
        if(prioridad.equalsIgnoreCase("si") || prioridad.equalsIgnoreCase("sí")){
            
            bPrioridad = true;
            
        }else{
            
            bPrioridad = false;
        }
        
        ctrl.introducirDatosCliente(c.getDni(), nuevoNombre, nuevoTelefono,bPrioridad);
    
    }
    
//RESERVAS:
    
    private void pantallaMenuGestiónReservas() {
       Scanner s = new Scanner(System.in);
        int opc = -1;

        do {
            System.out.println("\nMenu de Gestion de Reservas:\n");
            System.out.println("    1. Realizar Reserva");
            System.out.println("    2. Cancelar Reserva");
            System.out.println("    3. Consultar Reserva");
            System.out.print("\n");
            System.out.println("    0. Salir");
            System.out.println("\n\n--> Escoje una opcion:");
            opc = s.nextInt();
            while (opc < 0 || opc > 4) {
                System.out.println("--> Introduzca una opcion valida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcionGestionReservas(opc);
            }
        } while (opc != 0);
    }
    
    private void realizarOpcionGestionReservas(int opc) {
        System.out.print("Has elejido la opción: ");

        switch (opc) {
            case 1:
                System.out.println("Realizar Reserva\n");
                mostrarRealizarReserva();
                break;
            case 2:
                System.out.println("Cancelar Reserva\n");
                mostrarCancelarReserva();
                break;
            case 3:
                System.out.println("Consultar Reserva\n");
                mostrarConsultarReserva();
                break;
        }
    }
    
    private void mostrarRealizarReserva() {

        String dniR;
        Scanner s = new Scanner(System.in);
        
        do{
        System.out.println("Introduzca el dni del cliente a Realizar la reserva");
        System.out.println("ID_Dni:");
        dniR = (String) IO.readLine();
        
        Reserva rTemp = ctrl.selecionarReserva(dniR);
        Cliente cTemp = ctrl.selecionarCliente(dniR);
        
            if (cTemp == null ){

                System.out.println("El dni introducido no pertenece a ningun Cliente.\n");

            }else if(rTemp != null){
                    System.out.println("El id introducido ya pertenece a una reserva.");
            } else{
                this.c = ctrl.selecionarCliente(dniR);
            }
        } while (this.c == null);
        
        System.out.println("Elija la Pista a Reservar");
        System.out.println("1.Fútbol \n2.Baloncesto \n3.Pádel");
        Integer pis = (int) IO.readNumber();
        
        while (pis < 0 || pis > 3) {
                System.out.println("--> Introduzca una opcion valida: ");
                pis = (int) IO.readNumber();
                System.out.println("\n");
            }
        TipoPista pista = ctrl.obtenerTipoPista(pis);
        
        System.out.println("Introduzca la fecha de la reserva (YYYY-MM-DD):");
        String fecha1 = s.next();
        LocalDate fecha = LocalDate.parse(fecha1);
        
        System.out.println("Introduzca la hora de la reserva:");
        Integer hora = (int) IO.readNumber();
        
        System.out.println("Introduzca el número de participantes:");
        Integer numP = (int) IO.readNumber();
        
        this.r = ctrl.introducePista(dniR,fecha,hora,numP,pista);
        
        for (int i = 1; i < numP+1; i++) {
            
            System.out.println("Introduzca el dni del participante " + i + ":");
            String dni = (String) IO.readLine();
            Participante p = ctrl.introducirDatosParticipante(dni);
            this.r.addListaParticipantes(p);
            
        }
        
        System.out.println(r.toString());

    }

    private void mostrarCancelarReserva() {
        
        String dniR;
        
        do{
        System.out.println("Introduzca el dni del cliente a Cancelar la reserva");
        System.out.println("ID_Dni:");
        dniR = (String) IO.readLine();
        
        this.r = ctrl.selecionarReserva(dniR) ;
        
            if(r == null){
                    System.out.println("El id introducido no pertenece a ninguna reserva.");
                    this.c = ctrl.selecionarCliente(dniR);
            } 
            this.c = ctrl.selecionarCliente(dniR);
            
        } while (this.c == null);
        
        System.out.println(r.toString());
        
        ctrl.confirmarCancelacion(r);
    }

    private void mostrarConsultarReserva() {
        
        String dniR;
        
        do{
        System.out.println("Introduzca el dni del cliente a Consultar la reserva");
        System.out.println("ID_Dni:");
        dniR = (String) IO.readLine();
        
        this.r = ctrl.selecionarReserva(dniR) ;
            if(r == null){
                    System.out.println("El id introducido no pertenece a ninguna reserva.");
                    this.c = ctrl.selecionarCliente(dniR);
            } 
            this.c = ctrl.selecionarCliente(dniR);
            
        } while (this.c == null);

        ctrl.confirmaConsulta(r);
    }
    
    
//INCIDENCIAS:
    
    private void pantallaMenuNotificarIncidencias() {
        Scanner s = new Scanner(System.in);
        int opc = -1;

        do {
            System.out.println("\nMenu de Notificación de Incidencias\n");
            System.out.println("    1. Notificar Incidencia");
            System.out.print("\n");
            System.out.println("    0. Salir");
            System.out.println("\n\n--> Escoje una opcion: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 2) {
                System.out.println("--> Introduzca una opcion valida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcionNotificarIncidencia(opc);
            }
        } while (opc != 0);
    }

    private void realizarOpcionNotificarIncidencia(int opc) {
        System.out.print("Has elejido la opción: ");

        switch (opc) {
            case 1:
                System.out.println("Notificar Incidencia\n");
                mostrarNotificarIncidencia();
                break;

        }
    }
    
    private void mostrarNotificarIncidencia() {
        
        do{
        System.out.println("Introduzca el dni del cliente a Notificar la Incidencia");
        System.out.println("Dni:");
        String dniR = (String) IO.readLine();
        
        c = ctrl.selecionarCliente(dniR);
        } while (c == null);
        
        System.out.println("Elija la Pista donde ha sucedido la Incidencia");
        System.out.println("1.Fútbol \n2.Baloncesto \n3.Pádel");
        Integer pis = (int) IO.readNumber();
        
        while (pis < 0 || pis > 3) {
                System.out.println("--> Introduzca una opcion valida: ");
                pis = (int) IO.readNumber();
                System.out.println("\n");
            }
        TipoPista pista = ctrl.obtenerTipoPista(pis);
        
        System.out.println("Introduzca la Incidencia sucedida:");
        String inci = IO.readLine();
        
        ctrl.introducirIncidencia(pista, inci);
        
    }
    

// ACTIVIDADES:
    
    private void pantallaMenuGestiónActividades() {
       Scanner s = new Scanner(System.in);
        int opc = -1;

        do {
            System.out.println("\nMenu de Gestion de Actividades:\n");
            System.out.println("    1. Realizar Inscripción");
            System.out.println("    2. Consultar Actividad");
            System.out.print("\n");
            System.out.println("    0. Salir");
            System.out.println("\n\n--> Escoje una opcion: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 2) {
                System.out.println("--> Introduzca una opcion valida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcionGestiónActividades(opc);
            }
        } while (opc != 0);
    }
    
    private void realizarOpcionGestiónActividades(int opc) {
        
        System.out.print("Has elejido la opción: ");

        switch (opc) {
            case 1:
                System.out.println("Realizar Inscripción\n");
                mostrarRealizarInscripción();
                break;
            case 2:
                System.out.println("Consultar Actividad\n");
                mostrarConsultarActividad();
                break;
        }
        
    }
    
    private void mostrarRealizarInscripción() {
        
        String dniR;
        TipoActividad actividad;
        TramoHorario tramo;
        
        do{
        System.out.println("Introduzca el dni del cliente a Incribirse a Actividad");
        System.out.println("ID_Dni:");
        dniR = (String) IO.readLine();
        
            if (ctrl.selecionarCliente(dniR) == null ){

                System.out.println("El dni introducido no pertenece a ningun Cliente.\n");

            }else{
                 this.c = ctrl.selecionarCliente(dniR);
            }
        } while (this.c == null);
        
            
        System.out.println("Elija la actividad a la que se quiere Incribir:");
        System.out.println("1.Aeróbic \n2.Pilates \n3.Spinning \n4.Yoga");
        Integer act = (int) IO.readNumber();
        while (act < 0 || act > 4) {
                System.out.println("--> Introduzca una opcion valida: ");
                act = (int) IO.readNumber();
                System.out.println("\n");
            }
        actividad = ctrl.obtenerTipoActividad(act);
        
        System.out.println("Elija el Tramo Horario a la que quiere atender:");
        System.out.println("1.Mañana \n2.Tarde \n3.Noche");
        Integer tH = (int) IO.readNumber();
        tramo = ctrl.obtenerTramoHorario(tH);
        
        if(ctrl.grupoLleno(actividad,tramo) == false){
        
            ctrl.añadirActividad(actividad,tramo);
            
        }
        
    }

    private void mostrarConsultarActividad() {
       
        TipoActividad actividad;
        
        System.out.println("Elija la actividad a a consultar:");
        System.out.println("1.Aeróbic \n2.Pilates \n3.Spinning \n4.Yoga");
        Integer act = (int) IO.readNumber();
        while (act < 0 || act > 4) {
                System.out.println("--> Introduzca una opcion valida: ");
                act = (int) IO.readNumber();
                System.out.println("\n");
            }
        actividad = ctrl.obtenerTipoActividad(act);
        
        ctrl.mostrarActDisp(actividad);
        
    }

  
//VISUALIZAR:
    private void pantallaMenuVisualizacionDatos() {
        
        System.out.println(ctrl.toString());
        
    }
 
}