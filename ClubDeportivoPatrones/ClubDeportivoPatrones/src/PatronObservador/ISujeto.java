
package PatronObservador;

public interface ISujeto {
    
    void notificarObservadores();

    void registrarObservador(IObservador o);

    void eliminarObservador(IObservador o);
    
    void enviarComunicado(IComunicado c);
}
