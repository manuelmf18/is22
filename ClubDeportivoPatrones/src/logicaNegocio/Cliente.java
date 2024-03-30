package logicaNegocio;

import java.util.ArrayList;

public class Cliente implements IObservador{
    
    private String dni;
    private String nombre;
    private int telefono;
    
    ArrayList <IComunicado> comunicados = new ArrayList();

    public Cliente(String dni, String nombre, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String toString() {
        return "\n Cliente --> " + "Dni: " + dni + ", Nombre: " + nombre + ", Telefono: " + telefono ;
    }

    
    //PATRON
    @Override
    public void update(IComunicado comunicado) {
        
        comunicados.add(comunicado);
    }

    
}
