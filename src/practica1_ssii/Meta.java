/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_ssii;

import java.awt.Color;
import java.awt.Graphics;

public class Meta {
    protected float x;
    protected float y;
    protected float radio=4;

    public Meta(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getRadio() {
        return radio;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public void pintarMeta(Graphics g){
        g.setColor(Color.green);
        g.drawOval((int)x, (int)y, (int)radio, (int)radio);
        g.fillOval((int)x, (int)y, (int)radio, (int)radio);
    }
    public void recolocarMeta(float ancho, float alto){
        float anc= (ancho-100)/2;
        float alt= (alto-100)/2;
        x=anc+x+100;
        y=alt+y+100;
        
    }
    
}
