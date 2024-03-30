
package logicaNegocio;

public class Participante {
    
    private String dni;

    public Participante(String dni) {
        this.dni = dni;
    }

    public Participante() {
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String toString() {
        return "Participante ->" + "dni:" + dni ;
    }

    
    
}
