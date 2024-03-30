
package PatronSingleton;

import PatronObservador.*;
import logicaNegocio.*;

public interface IClubDeportivo extends ISujeto {

    void addComunicado(IComunicado comunicado);

    //CLIENTES:
    void añadirCliente(Cliente c);

    //INCIDENCIAS:
    void añadirIncidencia(Incidencia i);

    //RESERVA:
    void añadirReserva(Reserva r);

    void confirmaInscripcion(Grupo g);

    void consultarReserva(Reserva r);

    void eliminarCliente(Cliente c);

    void eliminarObservador(IObservador o);

    void eliminarReserva(Reserva r);

    void enviarComunicado(IComunicado comunicado);

    Cliente getCliente(String dni);

    String getDireccion();

    //Actividades:
    Grupo getGrupo(TipoActividad tA, TramoHorario tH);

    String getGrupoAct(TipoActividad tA);

    //Inicializacion ClubDeportivo (PATRON SINGLETON)
    String getNombre();

    Reserva getReserva(String id);

    String getTelefono();

    //DATOS INICIALES
    void inicializarDatosP();

    //COMUNICADOS (PATRON OBSERVER)
    void notificarObservadores();

    void registrarObservador(IObservador o);
    
}
