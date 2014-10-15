/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_ssii;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Jason
 */
public class Agente {
    private float x;
    private float y;
    private float radio=3;
    private float costo=0;

    public Agente(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getCosto() {
        return costo;
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

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public void pintarAgente(Graphics g){
        g.setColor(Color.yellow);
        g.drawOval((int)x, (int)y, (int)radio, (int)radio);
        g.fillOval((int)x, (int)y, (int)radio, (int)radio);
    }
    public void recolocarAgente(float ancho, float alto){
        float anc= (ancho-100)/2;
        float alt= (alto-100)/2;
        x=anc+x+100;
        y=alt+y+100;
        
    }
}
