/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Presentacion.FrmLogin;
import Presentacion.MDIPrincipal;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author 56946
 */
public class DPrincipal {
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
     
       
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(DPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch(InstantiationException ex){
        java.util.logging.Logger.getLogger(DPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        
    }catch(IllegalAccessException ex){
    java.util.logging.Logger.getLogger(DPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    
    }catch(javax.swing.UnsupportedLookAndFeelException ex){
    java.util.logging.Logger.getLogger(DPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    
    
}
        
        
        //DConexion miconexion = new DConexion();
        
       // MDIPrincipal miprincipal = new MDIPrincipal();
       // miprincipal.setVisible(true);
       
       
       FrmLogin miLogin = new FrmLogin();
       miLogin.setVisible(true);
    }
    
    
}
