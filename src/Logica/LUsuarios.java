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
public class LUsuarios {

   
        
    private int IdUsuarios;
    private String Nombre;
    private String APaterno;
    private String AMaterno;
    private String Usuarios;
    private String Clave;
    private String Perfil;
    
    
    
  
       
    
  public LUsuarios(int idUsuarios,String nombre,String aPaterno,String aMaterno,String usuarios,String clave,
    String perfil){
        
      
       IdUsuarios = idUsuarios;
       Nombre = nombre;
       APaterno = aPaterno;
       AMaterno = aMaterno;
       Usuarios = usuarios;
       Clave = clave;
       Perfil = perfil;
    }

    public LUsuarios() {
    }

  


    
     public int getIdUsuarios() {
        return IdUsuarios;
    }

    public void setIdUsuarios(int IdUsuarios) {
        this.IdUsuarios = IdUsuarios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAPaterno() {
        return APaterno;
    }

    public void setAPaterno(String APaterno) {
        this.APaterno = APaterno;
    }

    public String getAMaterno() {
        return AMaterno;
    }

    public void setAMaterno(String AMaterno) {
        this.AMaterno = AMaterno;
    }

    public String getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(String Usuarios) {
        this.Usuarios = Usuarios;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }
    
    
    
}
