/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DUsuarios;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author 56946
 */
public class FrmLogin extends JFrame{
    
    
    private JLabel lblUsuario, lblClave,lblfondo,lblImagen;
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnIngresar,btnCancelar;
    
    public FrmLogin(){
        setTitle("Ingreso al sistema ...");
        setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
       // setResizable(false);
        setLocationRelativeTo(null);
        
        //iconos
        
         Image icon = new ImageIcon(getClass().getResource("/Imagenes/restaurante.png")).getImage();
         setIconImage(icon);
        
        ImageIcon imagenLogin = new ImageIcon(getClass().getResource("/Imagenes/comida.png"));
        
        
        
        //creamos componentes
        
        lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();
        lblClave = new JLabel("Contraseña:");
        txtClave = new JPasswordField();
        btnIngresar = new JButton("Ingresar");
        btnCancelar = new JButton("Cancelar");
        lblImagen = new JLabel();
        
        //asignar iconos
        
        lblImagen.setIcon(imagenLogin);
          
        //agregamos componentes
        
        add(lblUsuario);
        add(txtUsuario);
        add(lblClave);
        add(txtClave);
        add(btnIngresar);
        add(btnCancelar);
        add(lblImagen);
        
        
        //asignar posiciones
        lblImagen.setBounds(20, 20, 130, 130);
        lblUsuario.setBounds(200,50,100,25);
        txtUsuario.setBounds(300,50,150,25);
        
        lblClave.setBounds(200,90,100,25);
        txtClave.setBounds(300,90,150,25);
        
        btnIngresar.setBounds(200,130,100,25);
        btnCancelar.setBounds(310,130,100,25);
        
        
        btnIngresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                btnIngresarActionPerformed(evt);
            }
           
    });
        
        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                
                btnCancelarActionPerformed(evt);
            }
        });
    }
    
private void btnIngresarActionPerformed(ActionEvent evt){
    
    DUsuarios miusuario = new DUsuarios();
    String usuario = txtUsuario.getText();
    String Clave = new String(txtClave.getPassword());
    if(miusuario.validarLogin(usuario, Clave)== 1){
        this.dispose();
        
    MDIPrincipal miPrincipal = new MDIPrincipal();
    miPrincipal.setLocationRelativeTo(null);
    miPrincipal.setUsuario(usuario);
    miPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
    miPrincipal.setVisible(true);
        
    }else{
        
        JOptionPane.showMessageDialog(this, "Usuario y/o Clave incorrectos");
        txtUsuario.setText("");
        txtClave.setText("");
        txtUsuario.requestFocusInWindow();
    }
    
    
    
    /*MDIPrincipal miPrincipal = new MDIPrincipal();
    miPrincipal.setLocationRelativeTo(null);
    miPrincipal.setVisible(true);
    this.dispose();*/
    }

private void btnCancelarActionPerformed(ActionEvent evt){
    System.exit(0);
    }


}
