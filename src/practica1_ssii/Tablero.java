/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_ssii;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Jason
 */
public class Tablero {
    private Casilla[][] tablero;
    private int ancho;
    private int alto;

    public Tablero(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }
    
    public void crearTablero(float x, float y){
        tablero= new Casilla[ancho+(int)x][alto+(int)y];
        for(int i=(int)x; i<ancho; i++){
            for(int j=(int)y; j<alto; j++){
                Casilla casilla= new Casilla(false, false);
                tablero[i][j]=casilla;
                
            }
        }        
    }
    
    public void definirObstaculos(LinkedList<Linea> obstaculos){
        Iterator<Linea> it= obstaculos.iterator();
        while(it.hasNext()){
            Linea linea= it.next();
            if(linea.getX1() < linea.getX2()){
                for(int i=(int)linea.getX1(); i<linea.getX2(); i++){
                    tablero[i][(int)linea.getY1()].setOcupada(true);                    
                }
            }else if(linea.getX2() < linea.getX1()){
                for(int i=(int)linea.getX2(); i<linea.getX1(); i++){
                    tablero[i][(int)linea.getY1()].setOcupada(true);                    
                }
            }else if(linea.getY1() < linea.getY2()){
                for(int i=(int)linea.getY1(); i<linea.getY2(); i++){
                    tablero[(int)linea.getX1()][i].setOcupada(true);                    
                }
            }else if(linea.getY2() < linea.getY1()){
                for(int i=(int)linea.getY2(); i<linea.getY1(); i++){
                    tablero[(int)linea.getX1()][i].setOcupada(true);                    
                }
            }
        }
    }
    public Casilla casillaTablero(int x, int y){    
        return tablero[x][y];
        
    }
    
}
