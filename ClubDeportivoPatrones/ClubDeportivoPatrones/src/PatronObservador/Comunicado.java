
package PatronObservador;

public class Comunicado implements IComunicado {
    
    private String titulo;
    private String descp;
    
    private PrioridadComunicado prioridad;      //implementación adicional para los comunicados

    public Comunicado() {
        
    }

    public Comunicado(String titulo, String descp, PrioridadComunicado prioridad) {
        this.titulo = titulo;
        this.descp = descp;
        this.prioridad = prioridad;
    }
    

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getDescp() {
        return descp;
    }

    @Override
    public void setDescp(String descp) {
        this.descp = descp;
    }

    public PrioridadComunicado getPrioridad() {
        return prioridad;
    }


    public void setPrioridad(PrioridadComunicado prioridad) {
        this.prioridad = prioridad;
    }


    @Override
    public String toString() {
        return "Comunicado Oficial de prioridad  " + prioridad + ": \n" + titulo + ": \n" + descp ;
    }
   
    
}
