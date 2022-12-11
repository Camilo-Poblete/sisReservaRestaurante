/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camil
 */
public class FrmReservacion extends JInternalFrame{
    
    private JLabel lblId,lblNombre,lblFecha,lblHora, lblTelefono,lblMesaP,lblEstado,lblUsuario;
    private JTextField txtId, txtNombre,txtHora,txtTelefono,txtMesaP,txtBuscar;
    private JComboBox cmdEstado;
    String estado[]={"--Seleccione una opcion.--","Reservado","Libre"};
    private JButton btnNuevo, btnEditar, btnCancelar, btnGuardar, btnBuscar, btnEliminar;
    private JDateChooser txtFecha;
    
   private String[]titulos = {"Id","Nombre","Fecha","Hora","Telefono","Mesa para","Estado","Usuario"};
   private JTable tblReserva;
   private JScrollPane scrReserva;
   private DefaultTableModel mimodelo;
   
    
    
    public FrmReservacion(){
        setTitle("Usuarios");
        setSize(900,600);
        setClosable(true);
        setIconifiable(true);
        setLayout(null);
        setVisible(true);
        
        //creamos componentes
        
        lblId = new JLabel("Id:");
        lblNombre = new JLabel("Nombre:");
        lblFecha = new JLabel("Fecha:");
        lblHora = new JLabel("Hora:");
        lblTelefono = new JLabel("Telefono:");
        lblMesaP = new JLabel("Mesa para:");
        lblEstado = new JLabel("Estado:");
        lblUsuario = new JLabel("Usuario:");
        
        
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtFecha = new JDateChooser();
        txtHora = new JTextField();
        txtTelefono = new JTextField();
        txtMesaP = new JTextField();
        txtBuscar = new JTextField();
        cmdEstado = new JComboBox(estado);
        
        
        btnNuevo = new JButton("Nuevo");
        btnEditar = new JButton("Editar");
        btnCancelar = new JButton("Cancelar");
        btnGuardar = new JButton("Guardar");
        btnBuscar = new JButton("Buscar");
        btnEliminar = new JButton("Eliminar");
        
        mimodelo = new DefaultTableModel(null,titulos);
        tblReserva = new JTable(mimodelo);
        scrReserva = new JScrollPane(tblReserva);
        
        
        //agregamos componentes
       
       add(lblId );
       add(lblNombre);
       add(lblFecha);
       add(lblHora);
       add (lblTelefono);
       add(lblMesaP);
       add(lblEstado);
       add(lblUsuario);
       
       add(txtId);
       add(txtNombre);
       add(txtFecha);
       add(txtHora);
       add (txtTelefono);
       add(txtMesaP);
       add(cmdEstado);
       
       add(btnNuevo);
       add(btnEditar);
       add(btnCancelar);
       add (btnGuardar);
       add(btnBuscar);
       add(btnEliminar);
       add(txtBuscar);
       
       add(scrReserva);
       
       
       //posicionar componentes
       
            
        lblId.setBounds(70, 40, 100, 25);
        lblNombre.setBounds(70, 70, 100, 25);
        lblFecha.setBounds(70, 100, 100, 25);
        lblHora.setBounds(70, 130, 100, 25);
        lblTelefono.setBounds(70, 150, 100, 25);
        lblMesaP.setBounds(70, 190, 100, 25);
        lblEstado.setBounds(70, 220, 100, 25);
        lblUsuario.setBounds(680, 15, 100, 25);
        
        
        txtId.setBounds(160, 40, 100, 25);
        txtNombre.setBounds(160, 70, 200, 25);
        txtFecha.setBounds(160, 100, 150, 25);
        txtHora.setBounds(160, 130, 100, 25);
        txtTelefono.setBounds(160, 160, 100, 25);
        txtMesaP.setBounds(160, 190, 150, 25);
        cmdEstado.setBounds(160, 220, 200, 25);
        
        
        btnNuevo.setBounds(70, 300, 100, 25);
        btnEditar.setBounds(200, 300, 100, 25);
        btnCancelar.setBounds(330, 300, 100, 25);
        btnGuardar.setBounds(460, 300, 100, 25);
        btnBuscar.setBounds(590, 300, 100, 25);
        btnEliminar.setBounds(590, 300, 100, 25);
        
        txtBuscar.setBounds(40, 350, 190, 25);
        
        btnBuscar.setBounds(280, 350, 100, 25);
        scrReserva.setBounds(40, 380, 800, 180);
        deshabilitar();
        
        
        btnNuevo.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent evt){
              btnNuevoActionPerformed(evt);
          }
        
        });
        
        btnEditar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent evt){
              btnEditarActionPerformed(evt);
          }
        
        });
         
        btnCancelar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent evt){
              btnCancelarActionPerformed(evt);
          }
        
        });
        
        
         btnGuardar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent evt){
             btnGuardarActionPerformed(evt);
          }
        
        });
         
         
         
         
         btnEliminar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent evt){
             btnEliminarActionPerformed(evt);
          }
        
        });
    }
    
    
    
    
    
    public void deshabilitar(){
             
        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtMesaP.setEnabled(false);
        cmdEstado.setEnabled(false);
        
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnBuscar.setEnabled(true);
    }
    
    private void btnNuevoActionPerformed(ActionEvent evt){
        
        txtId.setEnabled(false);
        txtNombre.setEnabled(true);
        txtFecha.setEnabled(true);
        txtHora.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtMesaP.setEnabled(true);
        cmdEstado.setEnabled(true);
        
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(false);
    }
    
    
     private void btnEditarActionPerformed(ActionEvent evt){
        
        txtId.setEnabled(false);
        txtNombre.setEnabled(true);
        txtFecha.setEnabled(true);
        txtHora.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtMesaP.setEnabled(true);
        cmdEstado.setEnabled(true);
        
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(false);
    }
     
     
     private void btnCancelarActionPerformed(ActionEvent evt){
        
        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtMesaP.setEnabled(false);
        cmdEstado.setEnabled(false);
        
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnBuscar.setEnabled(true);
    }
     
     
        private void btnGuardarActionPerformed(ActionEvent evt){
        
        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtMesaP.setEnabled(false);
        cmdEstado.setEnabled(false);
        
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnBuscar.setEnabled(true);
    }
        
        
        private void btnEliminarActionPerformed(ActionEvent evt){
       
    }
}