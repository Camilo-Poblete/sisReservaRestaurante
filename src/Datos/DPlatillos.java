/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.LPlatillos;


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
public class DPlatillos {
    
      DConexion miConex = new DConexion();
    Connection con = miConex.conectarDB();
    
    
   public DefaultTableModel buscarPlatillos(int id) {
         String[]titulos = {"Id","Nombre","Costos"};
         DefaultTableModel miModelo = new DefaultTableModel(null,titulos);
         String datos []= new String[3];
         String sql = "SELECT * FROM tblplatillos WHERE IdPlatillos='"+id+"'";
         java.sql.PreparedStatement pst;
         
         try {
            pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                datos[0] = rs.getString("IdPlatillos");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Costo");
              
                
                miModelo.addRow(datos);
                
            }
            return miModelo;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
     
        
    }
    
   
    
    public String insertarPlatillos(LPlatillos miPlatillo){
       
        
    try {
            String sql = "INSERT INTO tblplatillos (Nombre, Costo) VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, miPlatillo.getNombre());
            pst.setDouble(2, miPlatillo.getCosto());
            pst.executeUpdate();
            return "Se registro de forma correcta";
                    
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ocurrio un problema al insertar registro";
        }
      
    
    }
    
    
         
        public String editarPlatillo(LPlatillos miPlatillo){
       
        try {
            String sql = "UPDATE tblplatillos SET Nombre=?, Costo=? WHERE IdPlatillos=?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, miPlatillo.getNombre());
            pst.setDouble(2, miPlatillo.getCosto());
            pst.setInt(3, miPlatillo.getIdPlatillos());
           
            
            pst.executeUpdate();
            
            return "Se modifico de forma correcta";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ocurrio un problema al modificar";
        }
        
    }

         public DefaultTableModel mostrarPlatillos() {
             
         String[]titulos = {"Id","Nombre","Costos"};
         DefaultTableModel miModelo = new DefaultTableModel(null,titulos);
         String datos []= new String[3];
         String sql = "SELECT * FROM tblplatillos";
         java.sql.PreparedStatement pst;
         
         try {
            pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                datos[0] = rs.getString("IdPlatillos");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Costo");
                
                
                miModelo.addRow(datos);
                
            }
            return miModelo;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
     
        
    }
        
        
        
        

    
        public String eliminarPlatillo(LPlatillos miPlatillo) {
       
        try {
            String sql = "DELETE FROM tblplatillos WHERE IdPlatillos = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, miPlatillo.getIdPlatillos());
            pst.executeUpdate();
            return "Se elimino de forma correcta";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ocurrio un problema al eliminar";
        }
        
        }
        
}
          
        
    
    
