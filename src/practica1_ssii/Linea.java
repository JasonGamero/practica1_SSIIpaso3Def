/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_ssii;

import java.awt.Graphics;

/**
 *
 * @author Jason
 */
public class Linea {
    private float x1;
    private float y1;
    private float x2;
    private float y2;

    public Linea(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public float getX1() {
        return x1;
    }

    public float getX2() {
        return x2;
    }

    public float getY1() {
        return y1;
    }

    public float getY2() {
        return y2;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }
    
    public void pintarLinea(Graphics g){
    g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    g.dispose();
    }
    
    public void recolocarCoordenadas(float ancho, float alto){
        float anc= (ancho-100)/2;
        float alt= (alto-100)/2;
        
        x1=anc+x1+100;
        x2=anc+x2+100;
        y1=alt+y1+100;
        y2=alt+y2+100;
       
    }
    
}
