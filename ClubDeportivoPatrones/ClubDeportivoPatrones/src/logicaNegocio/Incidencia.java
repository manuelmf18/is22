
package logicaNegocio;


public class Incidencia {
    
    private String incidencia;
    private TipoPista tipoPista;

    public Incidencia(TipoPista tipoPista, String incidencia) {
        this.incidencia = incidencia;
        this.tipoPista = tipoPista;
    }

    public Incidencia() {
    }


    
    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia= incidencia;
    }

    public TipoPista getTipoPista() {
        return tipoPista;
    }

    public void setTipoPista(TipoPista tipoPista) {
        this.tipoPista = tipoPista;
    }


    public String toString() {
        return "\n Incidencia --> " + "Incidencia: " + incidencia + "; en la pista de " + tipoPista ;
    }

    
    
}
