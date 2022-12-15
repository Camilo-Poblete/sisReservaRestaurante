package Presentacion;

import Datos.DPlatillos;
import Logica.LPlatillos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class FrmPlatillos extends JInternalFrame {

    private JLabel lblId, lblNombre, lblCostos;
    private JTextField txtId, txtNombre, txtCostos, txtBuscar;
    private JButton btnNuevo, btnEditar, btnGuardar, btnCancelar, btnBuscar, btnEliminar;
    private JLabel lblImagen;

    private JTable tblPlatillo;
    private JScrollPane scrPlatillo;
    private DefaultTableModel dtPlatillos;
    private String[] titulos = {"Id", "Nombre", "Costo"};

    public FrmPlatillos() {
        setTitle("Platillos");
        setSize(850, 530);
        setClosable(true);
        setIconifiable(true);
        setLayout(null);
        setVisible(true);

        ImageIcon imIcono = new ImageIcon(getClass().getResource("/Imagenes/cuchilleria.png"));

        ImageIcon imNuevo = new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png"));
        ImageIcon imEditar = new ImageIcon(getClass().getResource("/Imagenes/editar.png"));
        ImageIcon imGuardar = new ImageIcon(getClass().getResource("/Imagenes/guardar.png"));
        ImageIcon imCancelar = new ImageIcon(getClass().getResource("/Imagenes/cancelar.png"));
        ImageIcon imEliminar = new ImageIcon(getClass().getResource("/Imagenes/eliminar.png"));
        ImageIcon imBuscar = new ImageIcon(getClass().getResource("/Imagenes/search.png"));

        lblId = new JLabel("Id:");
        lblNombre = new JLabel("Nombre:");
        lblCostos = new JLabel("Costos:");
        lblImagen = new JLabel();
        lblImagen.setIcon(imIcono);

        txtId = new JTextField();
        txtNombre = new JTextField();
        txtCostos = new JTextField();

        btnNuevo = new JButton("Nuevo");
        btnEditar = new JButton("Editar");
        btnCancelar = new JButton("Cancelar");
        btnGuardar = new JButton("Guardar");
        btnBuscar = new JButton("Buscar");
        btnEliminar = new JButton("Eliminar");

        dtPlatillos = new DefaultTableModel(null, titulos);
        tblPlatillo = new JTable(dtPlatillos);
        scrPlatillo = new JScrollPane(tblPlatillo);

        txtBuscar = new JTextField();

        btnBuscar.setIcon(imBuscar);
        btnNuevo.setIcon(imNuevo);
        btnEditar.setIcon(imEditar);
        btnCancelar.setIcon(imCancelar);
        btnGuardar.setIcon(imGuardar);

        btnEliminar.setIcon(imEliminar);

        //agregamos componentes
        add(lblId);
        add(lblNombre);
        add(lblCostos);

        add(txtId);
        add(txtNombre);
        add(txtCostos);

        add(lblImagen);

        add(btnNuevo);
        add(btnEditar);
        add(btnCancelar);
        add(btnGuardar);
        add(btnBuscar);

        add(btnEliminar);

        add(txtBuscar);
        add(scrPlatillo);

        //posicionar componentes
        lblId.setBounds(180, 50, 100, 25);
        lblNombre.setBounds(180, 80, 100, 25);
        lblCostos.setBounds(180, 110, 100, 25);
        lblImagen.setBounds(20, 30, 130, 130);

        txtId.setBounds(240, 50, 100, 25);
        txtNombre.setBounds(240, 80, 150, 25);
        txtCostos.setBounds(240, 110, 150, 25);

        btnNuevo.setBounds(20, 230, 120, 32);
        btnEditar.setBounds(150, 230, 120, 32);
        btnCancelar.setBounds(410, 230, 120, 32);
        btnGuardar.setBounds(280, 230, 120, 32);
        btnEliminar.setBounds(540, 230, 120, 32);

        txtBuscar.setBounds(20, 280, 160, 25);
        btnBuscar.setBounds(190, 276, 120, 32);

        scrPlatillo.setBounds(20, 310, 650, 180);

        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }

            private void btnEditarActionPerformed(ActionEvent evt) {
                txtNombre.setEnabled(true);
                txtCostos.setEnabled(true);

                btnNuevo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnGuardar.setEnabled(true);
                btnEliminar.setEnabled(false);
                btnBuscar.setEnabled(true);

            }

        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }

            private void btnCancelarActionPerformed(ActionEvent evt) {
                deshabilitar();
            }

        });

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }

              
        });
                
                
                
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }

           

        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }

            private void btnBuscarActionPerformed(ActionEvent evt) {
              DPlatillos miPlatillo = new DPlatillos();
              dtPlatillos = miPlatillo.buscarPlatillos(Integer.parseInt(txtBuscar.getText()));
              tblPlatillo.setModel(dtPlatillos);
            }

        });

        tblPlatillo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblPlatilloMouseClicked(evt);
            }

        });
        mostrarPlatillos();
        deshabilitar();
    }

    private void tblPlatilloMouseClicked(MouseEvent evt) {
        int fila = tblPlatillo.rowAtPoint(evt.getPoint());
        txtId.setText(tblPlatillo.getValueAt(fila, 0).toString());
        txtNombre.setText(tblPlatillo.getValueAt(fila, 1).toString());
        txtCostos.setText(tblPlatillo.getValueAt(fila, 2).toString());
    }

    public void deshabilitar() {

        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtCostos.setEnabled(false);

        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);

        txtId.setText("");
        txtNombre.setText("");
        txtCostos.setText("");

    }

    private void btnNuevoActionPerformed(ActionEvent evt) {
        txtNombre.setEnabled(true);
        txtCostos.setEnabled(true);

        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(true);

        txtId.setText("");
        txtNombre.setText("");
        txtCostos.setText("");
    }


    
     private void btnGuardarActionPerformed(ActionEvent evt) {
               if(txtNombre.getText().equals("")){
                   JOptionPane.showMessageDialog(this, "Falta ingresar el nombre","Validacion",2);
                   txtNombre.requestFocusInWindow();
                   return;
               }
               
               if(txtCostos.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Falta ingresar el costo","Validacion",2);
               }
               if(txtId.getText().equals("")){
                   DPlatillos fn = new DPlatillos();
                   LPlatillos dts = new LPlatillos();
                   
                   dts.setNombre(txtNombre.getText());
                   dts.setCosto(Double.parseDouble(txtCostos.getText()));
                   String msg = fn.insertarPlatillos(dts);
                   JOptionPane.showMessageDialog(this, msg);
                   
               }else{
                   
                       
                   DPlatillos fn = new DPlatillos();
                   LPlatillos dts = new LPlatillos();
                   
                   dts.setNombre(txtNombre.getText());
                   dts.setCosto(Double.parseDouble(txtCostos.getText()));
                   dts.setIdPlatillos(Integer.parseInt(txtId.getText()));
                   String msg = fn.editarPlatillo(dts);
                   JOptionPane.showMessageDialog(this, msg);
                   
                       
                   
             }
               
            deshabilitar();
            mostrarPlatillos();

        
          
     }
        private void btnEliminarActionPerformed(ActionEvent evt) {
                  if(!txtId.getText().equals("")){
               int confirmar = JOptionPane.showConfirmDialog(this, "En realidad deseas eliminar el registro?","Confrmar",2);
               if(confirmar == 0){
                   LPlatillos dts = new LPlatillos();
                   DPlatillos fn = new DPlatillos();
                   dts.setIdPlatillos(Integer.parseInt(txtId.getText()));
                   String mensaje = fn.eliminarPlatillo(dts);
                   JOptionPane.showMessageDialog(this, mensaje);
                   mostrarPlatillos();
               }
           }
                
                
        deshabilitar();
        }

        
    private void mostrarPlatillos() {
        DPlatillos miRes = new DPlatillos();
        dtPlatillos = miRes.mostrarPlatillos();
        tblPlatillo.setModel(dtPlatillos);
    }
                
        }
             
