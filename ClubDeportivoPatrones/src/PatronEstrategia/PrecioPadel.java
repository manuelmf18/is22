/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronEstrategia;

/**
 *
 * @author Jose
 */
public class PrecioPadel implements PrecioComportamiento{

    @Override
    public Double calcularPrecio(Double precio, Integer numParticipantes) {
        precio = numParticipantes*3.0;
        return precio;
    }

    
}
