
package clubdeportivopatrones;

import PatronFachada.Control;
import PatronFachada.Pantalla;
import PatronSingleton.ClubDeportivo;

public class ClubDeportivoPatrones {

    public static void main(String[] args) throws Exception {
		
        ClubDeportivoPatrones cdp = new ClubDeportivoPatrones();
        cdp.inicio();
		
    }
	
	
    private void inicio() throws Exception {

        Control controladora = new Control(ClubDeportivo.getInstanciaSingleton("Club Deportivo UPO", 123456789, "Montequinto, Sevilla"));
        Pantalla p = new Pantalla(controladora);
        
        p.mostrarMenuPrincipal();      

            //System.out.println(p.controladora.cD.toString());
            
	
    }

}
