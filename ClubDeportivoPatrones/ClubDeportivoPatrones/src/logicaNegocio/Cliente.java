package logicaNegocio;

import PatronObservador.IComunicado;
import PatronObservador.IObservador;
import java.util.ArrayList;

public class Cliente implements IObservador{
    
    private String dni;
    private String nombre;
    private int telefono;
    private boolean comPrioridadBaja;
    
    ArrayList <IComunicado> comunicados = new ArrayList();

    public Cliente(String dni, String nombre, int telefono, boolean comPrioridadBaja) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.comPrioridadBaja = comPrioridadBaja;
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

    public boolean getComPrioridadBaja() {
        return comPrioridadBaja;
    }

    public void setComPrioridadBaja(boolean comPrioridadBaja) {
        this.comPrioridadBaja = comPrioridadBaja;
    }

    public ArrayList<IComunicado> getComunicados() {
        return comunicados;
    }

    public void setComunicados(ArrayList<IComunicado> comunicados) {
        this.comunicados = comunicados;
    }

    @Override
    public String toString() {
        return "\n Cliente --> " + "dni=" + dni + ", nombre:" + nombre + ", telefono=" + telefono + "\n ¿Acepta comunicados prioridad baja? " + comPrioridadBaja + ", comunicados: " + comunicados + '}';
    }

    
//PATRON Observer
    @Override
    public void update(IComunicado comunicado) {
        
        comunicados.add(comunicado);
        
    }
    
}
