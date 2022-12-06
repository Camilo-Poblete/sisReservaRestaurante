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

/**
 *
 * @author 56946
 */
public class DUsuarios {
    
    DConexion con = new DConexion();
    Connection cn = con.conectarDB();
    
    public ResultSet obtenerUsuarios(){
        try {
            
            String queryOb = "SELECT * FROM  tblusuarios";
            Statement st = cn.createStatement();
            return st.executeQuery(queryOb);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
            
        
    }
    
}
