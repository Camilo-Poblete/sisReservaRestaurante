/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.LReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camil
 */
public class DReserva {
    
    DConexion miConex = new DConexion();
    Connection con = miConex.conectarDB();
    
    public DefaultTableModel mostrarReservacion() {
         String[]titulos = {"Id","Nombre","Fecha","Hora","Telefono","Mesa para","Usuario","Estado"};
         DefaultTableModel miModelo = new DefaultTableModel(null,titulos);
         String datos []= new String[8];
         String sql = "SELECT * FROM tblreserva";
         java.sql.PreparedStatement pst;
         
         try {
            pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                datos[0] = rs.getString("IdReserva");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Fecha");
                datos[3] = rs.getString("Hora");
                datos[4] = rs.getString("Telefono");
                datos[5] = rs.getString("MesaPara");
                datos[6] = rs.getString("Usuario");
                datos[7] = rs.getString("Estado");
                
                miModelo.addRow(datos);
                
            }
            return miModelo;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
     
        
    }
    
    public String insertarReservacion(LReserva miReservacion){
       
        
    try {
            String sql = "INSERT INTO tblreserva(Nombre, Fecha, Hora, Telefono, MesaPara, Usuario, Estado) VALUES('"
                       +miReservacion.getNombre()+"','" +miReservacion.getFecha()+"','"+miReservacion.getHora()+"','"
                    +miReservacion.getTelefono()+"','"+ miReservacion.getMesaPara()+"','"+miReservacion.getUsuario()  
                    +"','"+miReservacion.getEstado()+"')";
                     Statement st = con.createStatement();
                     st.executeUpdate(sql);
                     return "Se registro de forma correcta";
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
              return "Ocurrio un problema al insertar registro";
        }
      
    
    }
    
    
        public String editarReservacion(LReserva miReservacion){
       
        
        
        try {
            String sql = "UPDATE tblreserva SET Nombre=?, Fecha=?, Hora=?, Telefono=?, MesaPara=?, Usuario=?, Estado=? WHERE IdReserva";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, miReservacion.getNombre());
            pst.setDate(2, miReservacion.getFecha());
            pst.setString(3, miReservacion.getHora());
            pst.setString(4, miReservacion.getTelefono());
            pst.setString(5, miReservacion.getMesaPara());
            pst.setString(6, miReservacion.getUsuario());
            pst.setString(7, miReservacion.getEstado());
            pst.setInt(8, miReservacion.getIdReserva());
            
            pst.executeUpdate();
            
            return "Se modifico de forma correcta";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ocurrio un problema al modificar";
        }
        
}
}