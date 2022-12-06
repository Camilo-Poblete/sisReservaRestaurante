
package Presentacion;


import Datos.DUsuarios;
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
   private String[]titulos = {"Id","Nombre","Usuario","Clave","Perfil"};
   private JTable tblUsuarios;
   private JScrollPane scrUsuarios;
   private DefaultTableModel mimodelo;
   
   
    public FrmUsuarios() throws SQLException{
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
    }
    
    private  void cargarUsuarios() throws SQLException{
        try{
        
        String titulos[] = {"Id","Nombre","Usuario","Clave","Perfil"};
        String registros[] = new String[5];
       // mimodelo = new DefaultTableModel(null,titulos);
        DUsuarios misusuarios = new DUsuarios();
        ResultSet rs = misusuarios.obtenerUsuarios();
        
        while(rs.next()){
             registros[0] = rs.getString("idUsuario");
             registros[1] = rs.getString("Nombre")+ " "+rs.getString("Apaterno")+ ""+ rs.getString("Amaterno");
             registros[2] = rs.getString("Usuario");
             registros[3] = rs.getString("Clave");
             registros[4] = rs.getString("Perfil");
             mimodelo.addRow(registros);
             
        }
        tblUsuarios.setModel(mimodelo);
        
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }
    
    }
        
     