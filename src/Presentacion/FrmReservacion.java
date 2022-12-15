/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.DReserva;
import Datos.DUsuarios;
import Logica.LReserva;
import Logica.LUsuarios;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camil
 */
public class FrmReservacion extends JInternalFrame{
    
    private JLabel lblId,lblNombre,lblFecha,lblHora, lblTelefono,lblMesaP,lblUsuario,lblMUs,lblBuscar;
    private JTextField txtId, txtNombre,txtHora,txtTelefono,txtMesaP,txtBuscar;
    
   // private JComboBox cmdEstado;
    
   // String estado[]={"--Seleccione una opcion.--","Reservado","Cancelado"};
    private JButton btnNuevo, btnEditar, btnCancelar, btnGuardar, btnEliminar,btnCancelarR,btnBuscar;
    private JDateChooser txtFecha;
    
   private String[]titulos = {"Id","Nombre","Fecha","Hora","Telefono","Mesa para","Estado","Usuario"};
   
   private JTable tblReserva;
   private JScrollPane scrReserva;
   private DefaultTableModel mimodelo;
   
    
    
    public FrmReservacion() {
        setTitle("Reservaciones");
        setSize(900,600);
        setClosable(true);
        setIconifiable(true);
        setLayout(null);
        setVisible(true);
        
        //creamos componentes
       ImageIcon imNuevo = new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png"));
       ImageIcon imEditar = new ImageIcon(getClass().getResource("/Imagenes/editar.png"));
       ImageIcon imGuardar = new ImageIcon(getClass().getResource("/Imagenes/guardar.png"));
       ImageIcon imCancelar = new ImageIcon(getClass().getResource("/Imagenes/cancelar.png")); 
       ImageIcon imEliminar = new ImageIcon(getClass().getResource("/Imagenes/eliminar.png")); 
       ImageIcon imBuscar = new ImageIcon(getClass().getResource("/Imagenes/search.png")); 
       ImageIcon imCancelarR = new ImageIcon(getClass().getResource("/Imagenes/rechazar.png")); 
        
        
        
        lblId = new JLabel("Id:");
        lblNombre = new JLabel("Nombre:");
        lblFecha = new JLabel("Fecha:");
        lblHora = new JLabel("Hora:");
        lblTelefono = new JLabel("Telefono:");
        lblMesaP = new JLabel("Mesa para:");
       // lblEstado = new JLabel("Estado:");
        lblUsuario = new JLabel("Usuario:");
        lblMUs = new JLabel();
        
        lblBuscar = new JLabel();
        txtBuscar = new JTextField();
        
        
        
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtFecha = new JDateChooser();
        txtHora = new JTextField();
        txtTelefono = new JTextField();
        txtMesaP = new JTextField();
        txtBuscar = new JTextField();
       // cmdEstado = new JComboBox(estado);
        
        
        btnNuevo = new JButton("Nuevo");
        btnEditar = new JButton("Editar");
        btnCancelar = new JButton("Cancelar");
        btnGuardar = new JButton("Guardar");
       
        btnEliminar = new JButton("Eliminar");
        btnCancelarR = new JButton("Cancelar reserva");
        btnBuscar = new JButton("Buscar");
        
        btnBuscar.setIcon(imBuscar);
        btnNuevo.setIcon(imNuevo);
        btnEditar.setIcon(imEditar);
        btnCancelar.setIcon(imCancelar);
        btnGuardar.setIcon(imGuardar);
     
        btnEliminar.setIcon(imEliminar);
        btnCancelarR.setIcon(imCancelarR);
        
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
       //add(lblEstado);
       add(lblUsuario);
       add(lblMUs);
       add(lblBuscar);
       add(txtId);
       add(txtNombre);
       add(txtFecha);
       add(txtHora);
       add (txtTelefono);
       add(txtMesaP);
       add(txtBuscar);
       //add(cmdEstado);
       
       add(btnNuevo);
       add(btnEditar);
       add(btnCancelar);
       add (btnGuardar);
       add(btnBuscar);
       add(btnEliminar);
       
       add(btnCancelarR);
       add(scrReserva);
       
       
       //posicionar componentes
       
            
        lblId.setBounds(70, 40, 100, 25);
        lblNombre.setBounds(70, 70, 100, 25);
        lblFecha.setBounds(70, 100, 100, 25);
        lblHora.setBounds(70, 130, 100, 25);
        lblTelefono.setBounds(70, 150, 100, 25);
        lblMesaP.setBounds(70, 190, 100, 25);
       // lblEstado.setBounds(70, 220, 100, 25);
        lblUsuario.setBounds(680, 15, 100, 25);
        lblMUs.setBounds(745, 15, 100, 25);
        
        txtId.setBounds(160, 40, 100, 25);
        txtNombre.setBounds(160, 70, 200, 25);
        txtFecha.setBounds(160, 100, 150, 25);
        txtHora.setBounds(160, 130, 100, 25);
        txtTelefono.setBounds(160, 160, 100, 25);
        txtMesaP.setBounds(160, 190, 150, 25);
       // cmdEstado.setBounds(160, 220, 200, 25);
        
        
        btnNuevo.setBounds(40, 285, 120, 32);
        btnEditar.setBounds(170, 285, 100, 32);
        btnCancelar.setBounds(430, 285, 120, 32);
        btnGuardar.setBounds(300, 285, 120, 32);
        btnEliminar.setBounds(730, 285, 120, 32);
        
        btnCancelarR.setBounds(560, 285, 160, 32);
        
        //Buscar
        txtBuscar.setBounds(70, 340, 180, 25);
        
        btnBuscar.setBounds(255, 340, 100, 25);
        scrReserva.setBounds(40, 380, 810, 180);
        
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
         
         
              
         btnCancelarR.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent evt){
             btnCancelarRActionPerformed(evt);
          }

          
         });
         
         
         
        btnBuscar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent evt){
             btnBuscarActionPerformed(evt);
          }

            private void btnBuscarActionPerformed(ActionEvent evt) {
                DReserva miRes = new DReserva();
                mimodelo = miRes.buscarReservacion(Integer.parseInt(txtBuscar.getText()));
                tblReserva.setModel(mimodelo);
            }

          
         });
         
                 
         
         tblReserva.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent evt){
                 tblReservaMouseClicked(evt);
             }
             
       });
        
         
         
         
         
         
        mostrarReserva();
    }
    
    private void tblReservaMouseClicked(MouseEvent evt){
        int fila = tblReserva.rowAtPoint(evt.getPoint());
        
        
      txtId.setText(tblReserva.getValueAt(fila, 0).toString());
      txtNombre.setText(tblReserva.getValueAt(fila, 1).toString());
      txtFecha.setDate(Date.valueOf(tblReserva.getValueAt(fila, 2).toString()));
      txtHora.setText(tblReserva.getValueAt(fila, 3).toString());
      txtTelefono.setText(tblReserva.getValueAt(fila, 4).toString());
      txtMesaP.setText(tblReserva.getValueAt(fila, 5).toString());
      lblMUs.setText(tblReserva.getValueAt(fila,  6).toString());
    
    }
    
    
    
    
    public void mostrarReserva() {
        DReserva miRes = new DReserva();
        mimodelo = miRes.mostrarReservacion();
        tblReserva.setModel(mimodelo);
    }
    
    public void setUs(String usuario){
        lblMUs.setText(usuario);
    }
    
    
    public void deshabilitar(){
             
        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtMesaP.setEnabled(false);
    
        
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true); 
        btnCancelarR.setEnabled(true);
     
    }
    
    
    
    private void btnNuevoActionPerformed(ActionEvent evt){
        
        txtId.setText("");
        txtNombre.setText("");
        txtFecha.setDate(null);
        txtHora.setText("");
        txtTelefono.setText("");
        txtMesaP.setText("");
    //    cmdEstado.setSelectedIndex(1);
        
        txtId.setEnabled(false);
        txtNombre.setEnabled(true);
        txtFecha.setEnabled(true);
        txtHora.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtMesaP.setEnabled(true);
     //   cmdEstado.setEnabled(true);
        
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
       // btnBuscar.setEnabled(false);
        btnCancelarR.setEnabled(false);
    }
    
    
     private void btnEditarActionPerformed(ActionEvent evt){
        
        txtId.setEnabled(false);
        txtNombre.setEnabled(true);
        txtFecha.setEnabled(true);
        txtHora.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtMesaP.setEnabled(true);
      //  cmdEstado.setEnabled(true);
        
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
       // btnBuscar.setEnabled(false);
        btnCancelarR.setEnabled(false);        
    }
     
     
     private void btnCancelarActionPerformed(ActionEvent evt){
        
        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtMesaP.setEnabled(false);
     //   cmdEstado.setEnabled(false);
        
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true); 
        btnCancelarR.setEnabled(true);
       // btnBuscar.setEnabled(true);
    }
     
     
     
        private void btnGuardarActionPerformed(ActionEvent evt){
            
            if(txtNombre.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Falta ingresar el Nombre","Validacion",2);
                txtNombre.requestFocusInWindow();
                return;
                
            }
            
            
            if(txtFecha.getDate()== null){
                JOptionPane.showMessageDialog(this, "Falta ingresar la Fecha","Validacion",2);
                txtFecha.requestFocusInWindow();
                return;
                
            }
            
                 
            if(txtHora.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Falta ingresar la Hora","Validacion",2);
                txtHora.requestFocusInWindow();
                return;
                
            }
            
                      
            if(txtTelefono.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Falta ingresar el Telefono","Validacion",2);
                txtTelefono.requestFocusInWindow();
                return;
                
            }
            
            if(txtMesaP.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Falta ingresar el Numero de personas","Validacion",2);
                txtMesaP.requestFocusInWindow();
                return;
                
            }
            
             if(lblMUs.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Falta ingresar el Usuario","Validacion",2);
                lblMUs.requestFocusInWindow();
                return;
                
            }
            
            
            
            
             if(txtId.getText().equals("")){
                 DReserva fn = new DReserva();
                 LReserva dts = new LReserva();
                 
                 dts.setNombre(txtNombre.getText());
                 Calendar cal;
                 cal = txtFecha.getCalendar();
                 int d,m,a;
                 d = cal.get(Calendar.DAY_OF_MONTH);
                 m = cal.get(Calendar.MONTH);
                 a = cal.get(Calendar.YEAR) - 1900;
                 dts.setFecha(new Date(a,m,d));
                 dts.setHora(txtHora.getText());
                 dts.setTelefono(txtTelefono.getText());
                 dts.setMesaPara(txtMesaP.getText());
                 dts.setUsuario(lblMUs.getText());
                 
                // int seleccion = cmdEstado.getSelectedIndex();
               //  dts.setEstado((String) cmdEstado.getItemAt(seleccion));
                 //dts.setIdReserva(Integer.parseInt(txtId.getText()));
                 String msg = fn.insertarReservacion(dts);
                 JOptionPane.showMessageDialog(rootPane, msg);
                 
            }else{
                 
                DReserva fn = new DReserva();
                LReserva dts = new LReserva();
                 
                dts.setNombre(txtNombre.getText());
                Calendar cal;
                cal = txtFecha.getCalendar();
                int d,m,a;
                d = cal.get(Calendar.DAY_OF_MONTH);
                m = cal.get(Calendar.MONTH);
                a = cal.get(Calendar.YEAR) - 1900;
                dts.setFecha(new Date(a,m,d));
                dts.setHora(txtHora.getText());
                dts.setTelefono(txtTelefono.getText());
                dts.setMesaPara(txtMesaP.getText());
                dts.setUsuario(lblMUs.getText());
                 
              //  int seleccion = cmdEstado.getSelectedIndex();
              //  dts.setEstado((String) cmdEstado.getItemAt(seleccion));
                dts.setIdReserva(Integer.parseInt(txtId.getText()));
                String msg = fn.editarReservacion(dts);
                JOptionPane.showMessageDialog(rootPane, msg);
            }
            
            
         mostrarReserva();
        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtMesaP.setEnabled(false);
       // cmdEstado.setEnabled(false);
        
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true); 
        btnCancelarR.setEnabled(true);
        //btnBuscar.setEnabled(true);
    }
        
       
        
        private void btnEliminarActionPerformed(ActionEvent evt){
            //eliminarReserva
            if(!txtId.getText().equals("")){
               int confirmar = JOptionPane.showConfirmDialog(this, "En realidad deseas eliminar el registro?","Confrmar",2);
               if(confirmar == 0){
                   LReserva dts = new LReserva();
                   DReserva fun = new DReserva();
                   dts.setIdReserva(Integer.parseInt(txtId.getText()));
                   String mensaje = fun.eliminarReserva(dts);
                   JOptionPane.showMessageDialog(this, mensaje);
                   mostrarReserva();
               }
           }
            
        }
              private void btnCancelarRActionPerformed(ActionEvent evt) {
                if(!txtId.getText().equals("")){
               int confirmar = JOptionPane.showConfirmDialog(this, "En realidad deseas cancelar la reservacion?","Confrmar",
                       2);
               if(confirmar == 0){
                   LReserva dts = new LReserva();
                   DReserva fun = new DReserva();
                   dts.setIdReserva(Integer.parseInt(txtId.getText()));
                   String mensaje = fun.cancelarReserva(dts);
                   JOptionPane.showMessageDialog(this, mensaje);
                   mostrarReserva();
            }
        
       
         
            
    }
                
    }
       
              
  
    
}
    

