/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones3d;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * @author Usuario
 */
public class PanelOpciones extends JPanel{
    public PanelDibujo panelDibujo;
    
    private JButton btnRotar;
    private JLabel lblRotar;
    private JLabel lblEscalar;
    
    private JTextField jtRotar;
    private JButton btnEscalarX;
    private JButton btnEscalarY;
    private JButton btnEscalarZ;
    private JTextField jtEscalar;
    

    public PanelOpciones(PanelDibujo p){
        panelDibujo = p;
        this.setFocusable(true);
        this.requestFocusInWindow();
        TitledBorder border = BorderFactory.createTitledBorder("Opcion Panel");
        border.setTitleColor(Color.BLUE);
        setBorder(border);
        
        
        
         setLayout(new GridLayout(2,4));
        
         
         
        lblEscalar = new JLabel("Escalar"); 
        jtEscalar = new JTextField();
        jtEscalar.setHorizontalAlignment(JTextField.CENTER);
        btnEscalarX =  new JButton("Escalar en X");
        btnEscalarY =  new JButton("Escalar en Y");
        btnEscalarZ =  new JButton("Escalar en Z");
        
        btnRotar = new JButton("Rotar");
        lblRotar = new JLabel("ROTAR: Ingrese valores entre (0° y 100°)");
        jtRotar = new JTextField("0"); 
        jtRotar.setHorizontalAlignment(JTextField.CENTER);
    
        //add(lblEscalar);
        add(jtEscalar);
        add(btnEscalarX);
        add(btnEscalarY);
        add(btnEscalarZ);
        add(lblRotar);
        add(jtRotar);
        add(btnRotar);
        
        btnEscalarX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    panelDibujo.transformaciones.Escalar(valorEscalamiento(), 1, 1);
                    }catch(Exception err){}
            }
        });
        
       btnEscalarY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    panelDibujo.transformaciones.Escalar(1, valorEscalamiento(), 1);
                }catch(Exception err){}
            }
        });
       btnEscalarZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    panelDibujo.transformaciones.Escalar(1, 1 ,valorEscalamiento());
                }catch(Exception err){}
            }
        });       
       btnRotar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //System.err.println(Float.parseFloat(jtRotar.getText())*57.29577951);
                    panelDibujo.transformaciones.Rotacion(Float.parseFloat(jtRotar.getText()));
                    
                }catch(Exception err){
                }
            }
        });
        
    
    }
    public float valorEscalamiento(){
            float r = Float.parseFloat(jtEscalar.getText());
            return r;
    }

}
