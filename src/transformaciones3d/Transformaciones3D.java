/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones3d;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


/**
 *
 * @Felipe @Gutierrez @Isaza
 * @author fgutier7@eafit.edu.co
 * 
 */
public class Transformaciones3D {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
              // Crear un nuevo Frame
      final JFrame frame = new JFrame("3D TRANSFORMATIONS 0.1");
      // Al cerrar el frame, termina la ejecuciÃ³n de este programa
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();  
      //frame.setResizable(false);
      // Agregar un JPanel que se llama Mesh (esta clase)
      frame.setLayout( new BorderLayout( ) );

      
      final PanelDibujo panelDibujo = new PanelDibujo();
      panelDibujo.archivo();
      panelDibujo.requestFocus();
      frame.add(panelDibujo, BorderLayout.CENTER);
      JPanel panelOpciones = new PanelOpciones((PanelDibujo) panelDibujo);
      frame.add(panelOpciones, BorderLayout.SOUTH);
             
      JMenuBar menuBar = new JMenuBar();
       final JMenu ayuda = new JMenu("Ayuda");
       final JMenu reiniciar = new JMenu("Reiniciar");
       reiniciar.addMenuListener(new MenuListener() {
            @Override
          public void menuSelected(MenuEvent e) {
              panelDibujo.resetHouse();
              panelDibujo.repaint();
          }
          @Override
          public void menuDeselected(MenuEvent e) {
              
          }
          @Override
          public void menuCanceled(MenuEvent e) {
              
          }
        });
       ayuda.setMnemonic(KeyEvent.VK_A);
       ayuda.getAccessibleContext().setAccessibleDescription(
        "The only menu in this program that has menu items");
       ayuda.addMenuListener(new MenuListener() {
            @Override
          public void menuSelected(MenuEvent e) {
              JOptionPane.showMessageDialog(frame,"1.) Para trasladar use las flechas del teclado. Tecla shift para enfocar panel."
                      + "\n2.) Para escalar ingrese el valor (eje: 2 o 0.5) luego indique si en X o en Y con los botones 'Escalar en X'\n"
                      + " 'Escalar en Y' respectivamente."
                      + "\n3.) Para rotar indique el grado y luego presione el boton 'Rotar'."
                      + "\n\nNOTA: Cuando la casa no se pueda o bien trasladar, escalar o girar\n"
                      + "porque se sale del Panel escuchara un sonido."
                      + "\n\n Reiniciar para volver a situar casa");
          }
          @Override
          public void menuDeselected(MenuEvent e) {
              
          }
          @Override
          public void menuCanceled(MenuEvent e) {
              
          }
        });
       menuBar.add(reiniciar);
       menuBar.add(ayuda);
       menuBar.setVisible(true);
       frame.setJMenuBar(menuBar);
      // Asignarle tamaÃ±o
      frame.setSize(screenSize.width-80, screenSize.height-50);
      // Poner el frame en el centro de la pantalla
      frame.setLocationRelativeTo(null);
      // Mostrar el frame
      frame.setVisible(true);
      
            

    }
    
}
