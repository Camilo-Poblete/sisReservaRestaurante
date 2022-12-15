/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author camil
 */
public class LPlatillos {
    private int IdPlatillos;
    private String Nombre;
    private Double Costo;

    
           
    
  public LPlatillos(int idPlatillos,String nombre,Double costo){
        
      
       IdPlatillos = idPlatillos;
       Nombre = nombre;
       Costo = costo;
      
    }

    public int getIdPlatillos() {
        return IdPlatillos;
    }

    public void setIdPlatillos(int IdPlatillos) {
        this.IdPlatillos = IdPlatillos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double Costo) {
        this.Costo = Costo;
    }
    
    
    public LPlatillos() {
    }
    
    
    
}
