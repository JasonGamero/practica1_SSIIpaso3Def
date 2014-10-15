/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_ssii;

import java.util.ArrayList;

/**
 *
 * @author Jason
 * 
 */
public class Nodo implements Comparable<Nodo> {
    private Nodo padre;
    private float x;
    private float y;
    private String accion;
    private int profundidad;
    private int costo;
    private ArrayList<Nodo> hijos;
    private float f;
    private String heuristica;

    public Nodo(Nodo padre, float x, float y, String accion, int profundidad,int costo, ArrayList<Nodo> hijos, float f,String heuristica) {
        this.padre = padre;
        this.x = x;
        this.y = y;
        this.accion = accion;
        this.profundidad = profundidad;
        this.hijos = hijos;
        this.f = f;
        this.heuristica= heuristica;
        this.costo= costo;
    }

    public String getAccion() {
        return accion;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public int getCosto() {
        return costo;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public Nodo getPadre() {
        return padre;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getF() {
        return f;
    }

    public String getHeuristica() {
        return heuristica;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setF(float f) {
        this.f = f;
    }

    public void setHeuristica(String heuristica) {
        this.heuristica = heuristica;
    }
    

    @Override
    public int compareTo(Nodo nodo) {
        int compareResult = 0;
        if(nodo!=null){
            if(f < nodo.getF()) {
                compareResult  = -1;
            }else{
                if(f > nodo.getF()) {
                    compareResult = 1;
                }
            }
	}
        return compareResult;
    }
    
    public boolean isMeta(Meta meta){
        boolean fin= false;
        if(meta.getX()==x && meta.getY()==y){
            fin = true;
        }
        return fin;
    }
	
}

