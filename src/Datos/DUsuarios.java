/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


import Logica.LUsuarios;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 56946
 */
public class DUsuarios {
    
    DConexion con = new DConexion();
    Connection cn = con.conectarDB();
    
    
    public DefaultTableModel mostrarUsuarios() {
        try {
            DefaultTableModel mimodelo;
            String titulos []={"Id","Nombre","A/Paterno","A/Materno","Usuario","Clave","Perfil"};
            String datos[]= new String[7];
            mimodelo = new DefaultTableModel(null,titulos);
            String sql = "SELECT * FROM tblUsuarios";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rt = pst.executeQuery();
            while (rt.next()) {                
                datos[0] = rt.getString("IdUsuarios");
                datos[1] = rt.getString("Nombre");
                datos[2]=  rt.getString("Apaterno");
                datos[3]=  rt.getString("Amaterno");
                datos[4] = rt.getString("Usuario");
                datos[5] = rt.getString("Clave");
                datos[6] = rt.getString("Perfil");
                mimodelo.addRow(datos);
                        
       
        }
        return mimodelo;
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
        return null;
    }
    
    }
    

    
    public String agregarUsuarios(LUsuarios misUsuarios){
        try {
            String sql = "INSERT INTO tblusuarios(Nombre, Apaterno, Amaterno, Usuario, Clave, Perfil) VALUES('"
                       +misUsuarios.getNombre()+"','" +misUsuarios.getAPaterno()+"','"+misUsuarios.getAMaterno()+"','"
                    +misUsuarios.getUsuarios()+"','"+ misUsuarios.getClave()+"','"+misUsuarios.getPerfil()+"')";
                     Statement st = cn.createStatement();
                     st.executeUpdate(sql);
                     return "Se registro de forma correcta";
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
              return "Ocurrio un problema al insertar registro";
        }
      
    
    }
    
    
        public String editarUsuarios(LUsuarios misUsuarios){
        try {
            String sql = "UPDATE tblusuarios SET Nombre=?, Apaterno=?, Amaterno=?, Usuario=?, Clave=?, Perfil=? WHERE IdUsuarios=?";
                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.setString(1, misUsuarios.getNombre());
                    pst.setString(2, misUsuarios.getAPaterno());
                    pst.setString(3, misUsuarios.getAMaterno());
                    pst.setString(4, misUsuarios.getUsuarios());
                    pst.setString(5, misUsuarios.getClave());
                    pst.setString(6, misUsuarios.getPerfil());
                    pst.setInt(7, misUsuarios.getIdUsuarios());
                    pst.executeUpdate();
                     
                     
                     return "Se actualizo correcta";
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
              return "Ocurrio un problema al insertar registro";
        }
      
    
        }
        
        public String eliminarUsuarios(LUsuarios misUsuarios){
        try {
            String sql = "DELETE FROM tblusuarios  WHERE IdUsuarios=?";
                    PreparedStatement pst = cn.prepareStatement(sql);
                   
                    pst.setInt(1, misUsuarios.getIdUsuarios());
                    pst.executeUpdate();
                     
                     
                     return "Se Elimino de forma correcta";
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
              return "Ocurrio un problema al eliminar registro";
        }
}

        
        
        public DefaultTableModel buscarUsuarios(String buscar) {
        try {
            DefaultTableModel mimodelo;
            String titulos []={"Id","Nombre","A/Paterno","A/Materno","Usuario","Clave","Perfil"};
            String datos[]= new String[7];
            mimodelo = new DefaultTableModel(null,titulos);
            String sql = "SELECT * FROM tblUsuarios WHERE Usuario='"+buscar+"'";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rt = pst.executeQuery();
            while (rt.next()) {                
                datos[0] = rt.getString("IdUsuarios");
                datos[1] = rt.getString("Nombre");
                datos[2]=  rt.getString("Apaterno");
                datos[3]=  rt.getString("Amaterno");
                datos[4] = rt.getString("Usuario");
                datos[5] = rt.getString("Clave");
                datos[6] = rt.getString("Perfil");
                mimodelo.addRow(datos);
                        
       
        }
        return mimodelo;
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
        return null;
    }
    
    }
    

}













