/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Date;

/**
 *
 * @author camil
 */
public class LReserva {
    int IdReserva;
    String Nombre;
    Date Fecha;
    String Hora;
    String Telefono;
    String MesaPara;
    String Usuario;
    String Estado;
  
    
    public LReserva(int idReserva, String nombre, Date fecha, String hora, String telefono, String mesaPara, 
            String usuario, String estado) {
        super();
        IdReserva = idReserva;
        Nombre = nombre;
        Fecha = fecha;
        Hora = hora;
        Telefono = telefono;
        MesaPara = mesaPara;
        Usuario = usuario;
        Estado = estado;
    }

    public LReserva() {
    }

    
    
    public int getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(int IdReserva) {
        this.IdReserva = IdReserva;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getMesaPara() {
        return MesaPara;
    }

    public void setMesaPara(String MesaPara) {
        this.MesaPara = MesaPara;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
  
}
