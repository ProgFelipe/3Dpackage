/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones3d;

/**
 *
 * @author Felipe Gutierrez
 */
public class Transformaciones{
 

    public PanelDibujo pD;
    public Transformaciones(PanelDibujo p){this.pD = p;}
    
            //P' = P+T
    /*
     * [X']    [X]          [Tx]
     *      =             +
     * [Y']    [Y]          [Ty]
     *      =             +
     * [Z']    [Z]          [Tz]
     */
    public void Traslacion(int tx, int  ty, int tz){  
        if(tx != 0){
                for(int f = 0; f < pD.CoordenadasCasa.length; f++){
                    pD.CoordenadasCasa[f][0] += tx;
                    }}
        if(ty != 0 ){
                for(int f = 0; f < pD.CoordenadasCasa.length; f++){
                    pD.CoordenadasCasa[f][1] += ty;
                    }}
        if(tz != 0){
                for(int f = 0; f < pD.CoordenadasCasa.length; f++){
                    pD.CoordenadasCasa[f][2] += tz;
                  }}
       pD.repaint();
    }
    
        //P' = S*P
    /*
     * [X']    [Sx  0]          [X]
     *      =             *
     * [Y']    [0  Sy]          [Y]
     *      =             *
     * [Z']    [0  Sz]          [Z]
     */
    public void Escalar(float sx, float sy, float sz){
    int fil = 0;
    float [][] escalamiento = {{sx,0,0,0},{0, sy,0,0},{0,0,sz,0},{0,0,0,1}};
           for(int f = 0; f < pD.CoordenadasCasa.length; f++){
               fil = 0;
                for(int c = 0; c < pD.CoordenadasCasa[f].length; c++){
                   pD.CoordenadasCasa[f][c] *= escalamiento[fil][c];
                   fil++;
                   }
                }
           pD.repaint();
    }
    
    public void Rotacion(double angulo){
        angulo = Math.toRadians(angulo);
        
        double [][] rotacionZ = {{Math.cos(angulo),-Math.sin(angulo),0,0},
                                {Math.sin(angulo),Math.cos(angulo),0,0},
                                {0,0,1,0},
                                {0,0,0,1}};
        double [][] rotacionX = {{1,0,0,0},
                                {0,Math.cos(angulo),-Math.sin(angulo),0},
                                {0,Math.sin(angulo),Math.cos(angulo),0},
                                {0,0,0,1}};
        double [][] rotacionY = {{Math.cos(angulo),0,Math.sin(angulo),0},
                                {0,1,0,0},
                                {-Math.sin(angulo),0,Math.cos(angulo),0},
                                {0,0,0,1}};



           /*for(int f = 0; f < pD.CoordenadasCasa.length; f++){
               //X
                   int x1 = (int) (pD.CoordenadasCasa[f][0] * rotacionX[0][0]);
                   x1 += pD.CoordenadasCasa[f][1] * rotacionX[0][1];
                   x1 += pD.CoordenadasCasa[f][2] * rotacionX[0][2];
               //YCOS-ZSIN
                   int y1 = (int) (pD.CoordenadasCasa[f][0] * rotacionX[1][0]);
                   y1 += pD.CoordenadasCasa[f][1] * rotacionX[1][1];
                   y1 += pD.CoordenadasCasa[f][2] * rotacionX[1][1];
                //YSIN+ZCOS   
                   int z1 = (int) (pD.CoordenadasCasa[f][0] * rotacionX[2][0]);
                   z1 += pD.CoordenadasCasa[f][1] * rotacionX[2][1];
                   z1 += pD.CoordenadasCasa[f][2] * rotacionX[2][2];
                  //X0 -> X1; Y0 -> Y1;
                  pD.CoordenadasCasa[f][0] = x1;
                  pD.CoordenadasCasa[f][1] = y1;
                  pD.CoordenadasCasa[f][2] = z1;
                }
          for(int f = 0; f < pD.CoordenadasCasa.length; f++){
               //XCOS+ZSIN
                   int x1 = (int) (pD.CoordenadasCasa[f][0] * rotacionY[0][0]);
                   x1 += pD.CoordenadasCasa[f][1] * rotacionY[0][1];
                   x1 += pD.CoordenadasCasa[f][2] * rotacionY[0][2];
               //Y
                   int y1 = (int) (pD.CoordenadasCasa[f][0] * rotacionY[1][0]);
                   y1 += pD.CoordenadasCasa[f][1] * rotacionY[1][1];
                   y1 += pD.CoordenadasCasa[f][2] * rotacionY[1][1];
                //ZCOS-XSIN
                   int z1 = (int) (pD.CoordenadasCasa[f][0] * rotacionY[2][0]);
                   z1 += pD.CoordenadasCasa[f][1] * rotacionY[2][1];
                   z1 += pD.CoordenadasCasa[f][2] * rotacionY[2][2];
                  //X0 -> X1; Y0 -> Y1;
                  pD.CoordenadasCasa[f][0] = x1;
                  pD.CoordenadasCasa[f][1] = y1;
                  pD.CoordenadasCasa[f][2] = z1;
                }
           for(int f = 0; f < pD.CoordenadasCasa.length; f++){
               //XCOS-YSIN
                   int x1 = (int) (pD.CoordenadasCasa[f][0] * rotacionZ[0][0]);
                   x1 += pD.CoordenadasCasa[f][1] * rotacionZ[0][1];
                   x1 += pD.CoordenadasCasa[f][2] * rotacionZ[0][2];
               //XSIN+YCOS
                   int y1 = (int) (pD.CoordenadasCasa[f][0] * rotacionZ[1][0]);
                   y1 += pD.CoordenadasCasa[f][1] * rotacionZ[1][1];
                   y1 += pD.CoordenadasCasa[f][2] * rotacionZ[1][1];
                //Z
                   int z1 = (int) (pD.CoordenadasCasa[f][0] * rotacionZ[2][0]);
                   z1 += pD.CoordenadasCasa[f][1] * rotacionZ[2][1];
                   z1 += pD.CoordenadasCasa[f][2] * rotacionZ[2][2];
                  //X0 -> X1; Y0 -> Y1;
                  pD.CoordenadasCasa[f][0] = x1;
                  pD.CoordenadasCasa[f][1] = y1;
                  pD.CoordenadasCasa[f][2] = z1;
                } 
                 */      
                double [][] rotacion = {{Math.cos(angulo),-Math.sin(angulo)},
                               {Math.sin(angulo),Math.cos(angulo)}};

        //System.err.println(rotacion[1][0]);
        //System.err.println(rotacion[0][0]);
           for(int f = 0; f < pD.CoordenadasCasa.length; f++){
               
               //x*cos(a) + y*(-sen(a))
                   int x1 = (int) (pD.CoordenadasCasa[f][0] * rotacion[0][0]);
                   x1 += pD.CoordenadasCasa[f][1] * rotacion[0][1];
               //x*sen(a) + y*cos(a)    
                   int y1 = (int) (pD.CoordenadasCasa[f][0] * rotacion[1][0]);
                   y1 += pD.CoordenadasCasa[f][1] * rotacion[1][1];
                  //X0 -> X1; Y0 -> Y1;
                  pD.CoordenadasCasa[f][0] = x1;
                  pD.CoordenadasCasa[f][1] = y1;
                }    
           
           pD.repaint();
    }
   
}
