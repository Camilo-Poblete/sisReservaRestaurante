/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Presentacion.FrmLogin;
import Presentacion.MDIPrincipal;

/**
 *
 * @author 56946
 */
public class DPrincipal {
    
    public static void main(String[] args){
      //  FrmLogin miLogin = new FrmLogin();
        //miLogin.setVisible(true);
        
        DConexion miconexion = new DConexion();
        
        MDIPrincipal miprincipal = new MDIPrincipal();
        miprincipal.setVisible(true);
    }
    
    
}
