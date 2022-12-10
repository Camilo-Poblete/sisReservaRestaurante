
package Presentacion;


import Datos.DUsuarios;
import Logica.LUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;





/**
 *
 * @author Camilo-Poblete
 */
public class FrmUsuarios extends JInternalFrame{
    
    //declarar componentes
   private JLabel lblId,lblNombre,lblAparterno,lblAmaterno,lblImagen; 
   private JLabel lblUsuario, lblClave, lblConfirmaClave,lblPerfil,lblBuscar;
   private JTextField txtId, txtNombre,txtApaterno,txtAmaterno;
   private JTextField txtUsuario, txtBuscar;
   private JPasswordField txtClave,txtConfirmaClave;
   private JComboBox cmbPerfil;
   private JButton btnNuevo,btnEditar,btnGuardar,btnCancelar,btnBuscar,btnEliminar;
   
   
   private String []perfil={"Administrador","Empleado"};
   private String[]titulos = {"Id","Nombre","A/Paterno","A/Materno","Usuario","Clave","Perfil"};
   private JTable tblUsuarios;
   private JScrollPane scrUsuarios;
   private DefaultTableModel mimodelo;
   
   
   
    public FrmUsuarios()  {
        setTitle("Usuarios");
        setSize(900,600);
        setClosable(true);
        setIconifiable(true);
        setLayout(null);
        
        
        //creamos icono
        ImageIcon imagenLogin = new ImageIcon(getClass().getResource("/Imagenes/usuario.png"));
       ImageIcon imagenBuscar = new ImageIcon(getClass().getResource("/Imagenes/search.png"));
        
        //creamos componentes
        lblId = new JLabel("Id:");
        lblNombre = new JLabel("Nombre:");
        lblAparterno = new JLabel("Apellido parterno:");
        lblAmaterno = new JLabel("Apellido materno:");
        lblUsuario = new JLabel("Usuario:");
        lblClave = new JLabel("Contraseña:");
        lblConfirmaClave = new JLabel("Confirmar contraseña:");
        lblPerfil = new JLabel("Perfil:");
        
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtApaterno = new JTextField();
        txtAmaterno = new JTextField();
        txtUsuario = new JTextField();
        txtClave = new JPasswordField();
        txtConfirmaClave = new JPasswordField();
        cmbPerfil = new JComboBox(perfil);
        
        lblImagen = new JLabel();
        lblBuscar = new JLabel();
        txtBuscar = new JTextField();
        
        btnBuscar = new JButton("Buscar");
        mimodelo = new DefaultTableModel(null,titulos);
        tblUsuarios = new JTable(mimodelo);
        scrUsuarios = new JScrollPane(tblUsuarios);
        
        btnNuevo = new JButton("Nuevo");
        btnEditar  = new JButton("Editar");
        btnGuardar =  new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        btnEliminar = new JButton("Eliminar");
        
        //asignar iconos
        lblImagen.setIcon(imagenLogin);
        lblBuscar.setIcon(imagenBuscar);
        
        add(lblId);
        add(lblNombre);
        add(lblAparterno);
        add(lblAmaterno);
        add(lblUsuario);
        add(lblClave);
        add(lblConfirmaClave);
        add(lblPerfil);
        
        add(txtId);
        add(txtNombre);
        add(txtApaterno);
        add(txtAmaterno);
        add(txtUsuario);
        add(txtClave);
        add(txtConfirmaClave);
        
        add(cmbPerfil);
        
        add(lblImagen);
        add(lblBuscar); 
        add(txtBuscar);
        add(btnBuscar);
        add(scrUsuarios);
        
        add(btnNuevo);
        add(btnBuscar);
        add(btnGuardar);
        add(btnEditar);
        add(btnEliminar);
        add(btnCancelar);
        
       //asignar posiciones
        lblImagen.setBounds(20,40,150, 150);
        lblId.setBounds(230,20,180,25);
        txtId.setBounds(380,20,100,25);
        
        lblNombre.setBounds(230,50,180,25);
        txtNombre.setBounds(370,50,180,25);
        
        lblAparterno.setBounds(230,90,180,25);
        txtApaterno.setBounds(370,90,180,25);
        
        lblAmaterno.setBounds(230,130,180,25);
        txtAmaterno.setBounds(370,130,180,25);
         
        lblUsuario.setBounds(230,170,180,25);
        txtUsuario.setBounds(370,170,180,25);
        
        lblClave.setBounds(230,210,180,25);
        txtClave.setBounds(370,210,180,25);
        
        lblConfirmaClave.setBounds(230,250,180,25);
        txtConfirmaClave.setBounds(370,250,180,25);
        
        
        lblPerfil.setBounds(230,290,100,25);
        cmbPerfil.setBounds(370,290,130,25);
        
        
        lblBuscar.setBounds(60,350,25,25);
        
        txtBuscar.setBounds(80,350,150,25);
        
        btnBuscar.setBounds(240,350,100,25);
        
        btnNuevo.setBounds(700,80,100,25);
        btnEditar.setBounds(700,120,100,25);
        btnGuardar.setBounds(700,160,100,25);
        btnCancelar.setBounds(700,200,100,25);
        btnEliminar.setBounds(700,240,100,25);
        
        
        scrUsuarios.setBounds(50, 390, 800, 150);
      
        
        cargarUsuarios();
        nomostrarComponentes();
        
    
        
      
        
        btnGuardar.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent evt)  {
                 btnGuardarActionPerformed(evt);
            }
            
        });
        
        
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
        
        
        btnEliminar.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent evt){
                 btnEliminarActionPerformed(evt);
             
        
        
        
        }
        
             
             
    
    });
        
        tblUsuarios.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt){
                tblUsuariosMouseClicked(evt);
            }
        
        });
        
        
        
        
        
    }
    
  private void  tblUsuariosMouseClicked(MouseEvent evt){
      int fila = tblUsuarios.rowAtPoint(evt.getPoint());
      
      txtId.setText(tblUsuarios.getValueAt(fila, 0).toString());
      txtNombre.setText(tblUsuarios.getValueAt(fila, 1).toString());
      txtApaterno.setText(tblUsuarios.getValueAt(fila, 2).toString());
      txtAmaterno.setText(tblUsuarios.getValueAt(fila, 3).toString());
      txtUsuario.setText(tblUsuarios.getValueAt(fila, 4).toString());
      txtClave.setText(tblUsuarios.getValueAt(fila, 5).toString());
      cmbPerfil.setSelectedItem(tblUsuarios.getValueAt(fila, 6).toString());
  }
    
    
    

    
    
        private void nomostrarComponentes(){
             txtId.setEnabled(false);
            txtNombre.setEnabled(false);
            txtApaterno.setEnabled(false);
            txtAmaterno.setEnabled(false);
            txtUsuario.setEnabled(false);
            txtClave.setEnabled(false);
            txtConfirmaClave.setEnabled(false);
            cmbPerfil.setEnabled(false);
            
            btnNuevo.setEnabled(true);
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnBuscar.setEnabled(true);
            
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            
        }
        
        
        
        
    
        
        private void simostrarComponentes(){
            txtId.setEnabled(false);
            txtNombre.setEnabled(true);
            txtApaterno.setEnabled(true);
            txtAmaterno.setEnabled(true);
            txtUsuario.setEnabled(true);
            txtClave.setEnabled(true);
            txtConfirmaClave.setEnabled(true);
            cmbPerfil.setEnabled(true);
            
            btnNuevo.setEnabled(false);
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnBuscar.setEnabled(false);
            
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
                   
        }
        
        
    
        
        
        public void btnNuevoActionPerformed(ActionEvent evt){
            simostrarComponentes();
            
        }
        
          
        public void btnCancelarActionPerformed(ActionEvent evt){
           nomostrarComponentes();
            
        }
        
        
          
        public void btnEliminarActionPerformed(ActionEvent evt){
           
            
        }
        
         public void btnEditarActionPerformed(ActionEvent evt){
            simostrarComponentes();
            
        }
         
         
         
             
    private void btnGuardarActionPerformed(ActionEvent evt) {
        if(!txtId.getText().equals("")){
        
        LUsuarios dts = new LUsuarios();
        DUsuarios funciones = new DUsuarios();
        dts.setNombre(txtNombre.getText());
        dts.setAPaterno(txtApaterno.getText());
        dts.setAMaterno(txtAmaterno.getText());
        dts.setUsuarios(txtUsuario.getText());
        String Clave = new String(txtClave.getPassword());
        dts.setClave(Clave);
        int seleccion = cmbPerfil.getSelectedIndex();
        dts.setPerfil((String) cmbPerfil.getItemAt(seleccion));
        dts.setIdUsuarios(Integer.parseInt(txtId.getText()));
     
       String mensaje = funciones.editarUsuarios(dts);
       JOptionPane.showMessageDialog(this, mensaje);
      
       
       }else {
    
    
        LUsuarios datos = new LUsuarios();
        DUsuarios funciones = new DUsuarios();
        datos.setNombre(txtNombre.getText());
        datos.setAPaterno(txtApaterno.getText());
        datos.setAMaterno(txtAmaterno.getText());
        datos.setUsuarios(txtUsuario.getText());
        String Clave = new String(txtClave.getPassword());
        datos.setClave(Clave);
        int seleccion = cmbPerfil.getSelectedIndex();
        datos.setPerfil((String) cmbPerfil.getItemAt(seleccion));
        
     
       String mensaje = funciones.agregarUsuarios(datos);
       JOptionPane.showMessageDialog(this, mensaje);
         
    
     }
       
       cargarUsuarios();
       nomostrarComponentes();
     
    }
    

         
         
             private void cargarUsuarios(){
            DefaultTableModel miModelo;
            DUsuarios miFun = new DUsuarios();
            miModelo = miFun.mostrarUsuarios();
            
            tblUsuarios.setModel(miModelo);
        }
        
    }
    
    
        
