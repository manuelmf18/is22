
package logicaNegocio;

public class Grupo {
   
    private int numInscritos = -1;
    private TramoHorario tHorario; 
    private TipoActividad tActividad;
    private int maxInscritos = 10;

    public Grupo(TipoActividad tActividad, TramoHorario tHorario) {

        this.tHorario = tHorario;
        this.tActividad = tActividad;
        setNumInscritos();
    }

    public Grupo() {
    }

    
    public int getNumInscritos() {
        return numInscritos;
    }

    public void setNumInscritos() {
        this.numInscritos ++;
    }

    public TramoHorario gettHorario() {
        return tHorario;
    }

    public void settHorario(TramoHorario tHorario) {
        this.tHorario = tHorario;
    }

    public TipoActividad gettActividad() {
        return tActividad;
    }

    public void settActividad(TipoActividad tActividad) {
        this.tActividad = tActividad;
    }

    public int getMaxInscritos() {
        return maxInscritos;
    }
    
    
    public String toString() {
        return "\n Grupo "+ tActividad + " / TramoHorario: " + tHorario +" con "+ numInscritos + " inscritos";
    }
    
    
}
