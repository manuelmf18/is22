/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubdeportivopatrones;

import PatronFachada.Pantalla;

/**
 *
 * @author manue
 */
public class ClubDeportivoPatrones {
public static void main(String[] args) throws Exception {
		
		ClubDeportivoPatrones cdp = new ClubDeportivoPatrones();
		cdp.inicio();
		
	}
	
	private void inicio() throws Exception {

          //  Control c = new Control(ClubDeportivo.getSingletonInstance("Al fallo"));

            Pantalla p = new Pantalla();
            p.mostrarMenuPrincipal();      

                //System.out.println(p.ctrl.cD.toString());
            
		
	}

}
