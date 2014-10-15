/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_ssii;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author Jason
 */
public class Monticulo {

    private PriorityQueue<Nodo> vector= new PriorityQueue<Nodo>();

    public Monticulo() {
    }

    
    public int tamanyo(){
        return vector.size();
    }
    public void insertar(Nodo x){
        if(!estaYa(x.getX(), x.getY())){
            vector.add(x);
        }
    }
    
    public Nodo buscarMin(){
        return vector.peek();
    }
 
    public void eliminarMin(){
        vector.remove();
    }
    public boolean esVacia(){
        return vector.size()==0;
    }
    public void vaciar(){
        vector.removeAll(vector);
    }
    
    private boolean estaYa(float x, float y){
        boolean si= false;
        Iterator<Nodo> it= vector.iterator();
        while(it.hasNext()){
            Nodo ahora=it.next();
            if(ahora.getX()== x && ahora.getY()== y){
                si= true;
                break;
            }
        }
        return si;
    } 
}
