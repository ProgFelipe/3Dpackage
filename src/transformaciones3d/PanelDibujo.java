/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones3d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PanelDibujo extends JPanel implements KeyListener{
    public int minH = 0;
    public int maxH; 
    public int maxW;
    public Transformaciones transformaciones;    
    public Graphics2D g2d;
    public int[][] CoordenadasCasa;
    public readFile r;
    
    public PanelDibujo( ){
            this.setBackground(Color.BLACK);
            this.setFocusable(true);
            this.requestFocus();
            this.requestFocusInWindow();
            this.addKeyListener(this);
    }

    public void archivo(){
            r = new readFile();
            r.read();
            //r.setLines(1270,581);
            r.setLines();
            this.CoordenadasCasa = r.getCoordenadas();
    }
    @Override
     public void paintComponent( Graphics g){
            transformaciones = new Transformaciones(this);
            
            super.paintComponent(g);
            g2d = (Graphics2D) g;
            g2d.setColor(Color.CYAN);
            g2d.translate(getWidth()/2, getHeight()/2);
            g2d.drawLine(-this.getWidth()/2, 0, this.getWidth()/2, 0);
            g2d.drawLine(0, this.getHeight()/2, 0, -this.getHeight()/2);
            g2d.setColor(Color.green);
            g2d.setStroke(new BasicStroke(4));
            
            dibujarCasa(g2d);      
    }
    
    public void dibujarCasa(Graphics g){
        try {
            if(CoordenadasCasa != null){
                for(int f = 0; f < CoordenadasCasa.length-1; f+=2){    
                 g.drawLine(CoordenadasCasa[f][0], CoordenadasCasa[f][1],
                         CoordenadasCasa[f+1][0], CoordenadasCasa[f+1][1]);
                }   
            }
        } catch (Exception e) {}
    }
      

    public void resetHouse(){
      r = new readFile();
      r.read();
      //r.setLines(this.getWidth(),this.getHeight());
      r.setLines();
      this.CoordenadasCasa = r.getCoordenadas();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //Uso del teclado para la traslacion
        //tecla z y x para la traslacion en 'Z'
        int keyCode = e.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                transformaciones.Traslacion(0, -15, 0);
                break;
            case KeyEvent.VK_DOWN:
                transformaciones.Traslacion(0, 15, 0);
                break;
            case KeyEvent.VK_LEFT:
                transformaciones.Traslacion(-15, 0, 0);
                break;
            case KeyEvent.VK_RIGHT :
                transformaciones.Traslacion(15, 0, 0);
                break;
            case KeyEvent.VK_Z  :
                transformaciones.Traslacion(0, 0, 15);
                break;
            case KeyEvent.VK_X  :
                transformaciones.Traslacion(0, 0, -15);
                break;
     }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}    
}