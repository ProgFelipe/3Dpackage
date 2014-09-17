/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones3d;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class readFile extends PanelDibujo{
    public Stack<Integer> vertices;
    public String [] puntos;
    public int [][] CoordenadasCasa;
    public int aristas;
    public readFile(){}
    //Read File and store points in puntos[] and ajex on vertices Stack.
    public void read( ){
         try{
    // Open the file that is the first 
    // command line parameter
    FileInputStream fstream = new FileInputStream("puntos.txt");
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    strLine = br.readLine();
    int count = 0;
    //Read File Line By Line
   vertices = new Stack<Integer>();
   //Nro de puntos
   int size = Integer.parseInt(strLine);
   puntos = new String [size];
   while((strLine = br.readLine()) != null){
          // System.out.println(strLine);
          //Mira si faltan puntos por leer
           if(count < size){
          //Guarda los puntos en el vector
           puntos[count] = strLine;
           count++;
           }else{
                 if(count == size){
                   aristas = Integer.parseInt(strLine);
                   count++;
                 }
           //Store the vertex
               //
               String[] b = strLine.split(" ");
                    for(int c = 0; c < b.length; c++){
                        vertices.push(Integer.parseInt(b[c]));
                    }
           }

    }
    //Close the input stream
    in.close();
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e);
    }
  }
      public void setLines(){
          //w, h es el punto de origen
       CoordenadasCasa = new int [aristas*2][3];
         int fila = 0;
       while(vertices.size() > 1  ){
                    double vf = vertices.pop();
                    double vi = vertices.pop();
                    // System.out.println("Va de "+vi+" a "+vf);
                    String [] p0 = puntos[(int)vi].split(",");
                    int xi = Integer.parseInt(p0[0]);
                    int yi = Integer.parseInt(p0[1]);
                    int zi = Integer.parseInt(p0[2]);
                    String [] p1 = puntos[(int)vf].split(",");
                    int xf = Integer.parseInt(p1[0]);
                    int yf = Integer.parseInt(p1[1]);
                    int zf = Integer.parseInt(p1[2]);
                    if(zi == -300){
                        if(xi > 0){xi -=15;}else{xi +=15;}
                        if(yi > 0){yi -=15;}else{yi +=15;}
                    }
                    if(zf == -300){
                        if(xf > 0){xf -=15;}else{xf +=15;}
                        if(yf > 0){yf -=15;}else{yf +=15;}
                    }
                    CoordenadasCasa[fila][0] = xi;
                    CoordenadasCasa[fila][1] = yi;
                    CoordenadasCasa[fila][2] = zi;
                    CoordenadasCasa[fila+1][0] = xf;
                    CoordenadasCasa[fila+1][1] = yf;
                    CoordenadasCasa[fila+1][2] = zf;
                    fila +=2;
                    //System.out.println("Linea de ("+xi+", "+yi+") a ("+xf+", "+yf+") ");
       }
          /*System.out.println("FILA    Columna");
           for(int f = 0; f < CoordenadasCasa.length-1; f++){    
               System.out.println("["+CoordenadasCasa[f][0]+", "+ CoordenadasCasa[f][1]+"]["+CoordenadasCasa[f][3]+", "+ CoordenadasCasa[f][4]+"]");
            }
           */   
   }
      public int[][] getCoordenadas(){
          return this.CoordenadasCasa;
      }
}
