/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo-Poblete
 */
public class DConexion {
   
  public DConexion(){
      
  }
  
  public Connection conectarDB(){
      Connection miconex = null;
      
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          miconex= DriverManager.getConnection("jdbc:mysql://localhost:3306/reserva?serverTimezone=UTC","root","");
         // JOptionPane.showMessageDialog(null, "Ya se conecto");
          
      } catch (ClassNotFoundException  | SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
      }
      return miconex;
  }
}
