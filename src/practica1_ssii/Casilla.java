/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_ssii;

/**
 *
 * @author Jason
 */
public class Casilla {
    private boolean ocupada;
    private boolean visitiada;

    public Casilla(boolean ocupada, boolean visitiada) {
        this.ocupada = ocupada;
        this.visitiada = visitiada;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public boolean isVisitiada() {
        return visitiada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setVisitiada(boolean visitiada) {
        this.visitiada = visitiada;
    }
    
}
