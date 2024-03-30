
package PatronObservador;

public interface IComunicado {

    String getDescp();

    String getTitulo();
 
    PrioridadComunicado getPrioridad();
    
    void setPrioridad(PrioridadComunicado prioridad);
    
    void setDescp(String descp);

    void setTitulo(String titulo);

    
}
