
package Presentacion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Camilo-Poblete
 */

public class MDIPrincipal extends JFrame{
    
    //declarar variables
    private JMenuBar miBarraMenu; 
    private JMenu jmiMenuRegistros,jmiMenuOpciones,jmiMenuConsultas;
    private JMenuItem jmItemPlatillos,jmItemReservas,jmItemVentas;
    private JMenuItem jmItemUsuarios,jmItemConsultasV;
    private JDesktopPane jdpEscritorio;
    
    public MDIPrincipal(){
        setTitle("...:: Sistema para reservaciones");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //creamos iconos
        Image icon = new ImageIcon(getClass().getResource("/Imagenes/restaurante.png")).getImage();
        setIconImage(icon);
        
        ImageIcon immenuReg = new ImageIcon(getClass().getResource("/Imagenes/register.png"));
        ImageIcon immenuCon = new ImageIcon(getClass().getResource("/Imagenes/create.png"));
        ImageIcon immenuOp = new ImageIcon(getClass().getResource("/Imagenes/ajuste.png"));
        ImageIcon imitemplatillos = new ImageIcon(getClass().getResource("/Imagenes/platillo.png"));
        ImageIcon imireservas = new ImageIcon(getClass().getResource("/Imagenes/reserva.png"));
        ImageIcon imiVentas = new ImageIcon(getClass().getResource("/Imagenes/venta.png"));
        ImageIcon imiUsuarios = new ImageIcon(getClass().getResource("/Imagenes/usuarios.png"));
        ImageIcon imiConven = new ImageIcon(getClass().getResource("/Imagenes/consulta-venta.png"));
        
        //asignar imagenes
        
        miBarraMenu = new JMenuBar();
        jmiMenuRegistros = new JMenu("Registros");
        jmiMenuOpciones = new JMenu("Opciones");
        jmiMenuConsultas = new JMenu("Consultas");
        jmItemPlatillos = new JMenuItem("Platillos");
        jmItemReservas = new JMenuItem("Reservasiones");
        jmItemVentas = new JMenuItem("Ventas");
        jmItemUsuarios = new JMenuItem("Usuarios");
        jmItemConsultasV = new JMenuItem("Consulta de venta");     
        
        //creamos componentes
        
        jmiMenuRegistros.setIcon(immenuReg);
        jmiMenuOpciones.setIcon(immenuOp);
        jmiMenuConsultas.setIcon(immenuCon);
        jmItemPlatillos.setIcon(imitemplatillos);
        jmItemReservas.setIcon(imireservas);
        jmItemVentas.setIcon(imiVentas);
        jmItemUsuarios.setIcon(imiUsuarios);
        jmItemConsultasV.setIcon(imiConven);
        
        //agregar componentes a la barra menu
        jmiMenuRegistros.add(jmItemPlatillos);
        jmiMenuRegistros.add(jmItemReservas);
        jmiMenuRegistros.add(jmItemVentas);
        jmiMenuConsultas.add(jmItemConsultasV);
        jmiMenuOpciones.add(jmItemUsuarios);
        
        miBarraMenu.add(jmiMenuRegistros);
        miBarraMenu.add(jmiMenuConsultas);
        miBarraMenu.add(jmiMenuOpciones);
        
        
        setJMenuBar(miBarraMenu);
        jdpEscritorio = new JDesktopPane();
        getContentPane().add(jdpEscritorio);
        
        
        
    jmItemUsuarios.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt){
            
         
                jmItemUsuariosActionPerformed(evt);
            
               
        
       }
    });
}

private void jmItemUsuariosActionPerformed(ActionEvent evt) {
    FrmUsuarios misUsuarios = new FrmUsuarios();
    jdpEscritorio.add(misUsuarios);
    misUsuarios.show();
}

}