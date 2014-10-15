/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_ssii;

import java.util.Iterator;

/**
 *
 * @author Jason
 */
public class Problema {
    private float x;
    private float y;

    public Problema(float x, float y) {
        this.x = x;
        this.y = y;
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
    
    
    public void busquedaAnchura(ColaPrioridad frontera, Nodo nodo, Arbol arb,Tablero tab){
        arb.crearHijos(nodo, tab);
        if(nodo.getHijos()!=null){
            Iterator<Nodo> it= nodo.getHijos().iterator();
            while(it.hasNext()){//signar a cada nodo la prioridad y el coste
                Nodo nodoAux=it.next();
                nodoAux.setCosto(nodoAux.getProfundidad());
                nodoAux.setF(nodoAux.getCosto());
                frontera.insertar(nodoAux);
            }
        }
        
    }

    public void busquedaProfundidad(ColaPrioridad frontera, Nodo nodo, Arbol arb,Tablero tab){
        arb.crearHijos(nodo, tab);
        if(nodo.getHijos()!=null){
            Iterator<Nodo> hijoPrior= nodo.getHijos().iterator();
            while(hijoPrior.hasNext()){
                Nodo nodoAux=hijoPrior.next();
                tab.getTablero()[(int)nodoAux.getX()][(int)nodoAux.getY()].setOcupada(false);
                nodoAux.setCosto(nodoAux.getProfundidad());
                nodoAux.setF(-nodoAux.getCosto());
                
                frontera.insertar(nodoAux);
            }
        }
        
    } 
    public int busquedaProfIterativa(ColaPrioridad frontera, Nodo nodo, Arbol arb,
            Tablero tab, Meta meta, int prof){
        while(!nodo.isMeta(meta)&& !frontera.esVacia()){
            //elimino primero
            frontera.eliminarMin();
            // marco como visitado
            tab.casillaTablero((int) nodo.getX(), (int) nodo.getY()).setVisitiada(true);
            if(nodo.getProfundidad()<= prof){
                //genero sucesores
                arb.crearHijos(nodo, tab);
            }
            //si hay sucesores los guardo
            if(nodo.getHijos()!=null){
                Iterator<Nodo> hijoPrior= nodo.getHijos().iterator();
                while(hijoPrior.hasNext()){
                    Nodo nodoAux=hijoPrior.next();
                    nodoAux.setCosto(nodoAux.getProfundidad());
                    nodoAux.setF(nodoAux.getCosto());
                    frontera.insertar(nodoAux);
                }
            }
            nodo=frontera.buscarMin();
            prof++;           
        }
        return prof;
    }
    
    public void busquedaCostoUniforme(ColaPrioridad frontera, Nodo nodo, Arbol arb,Tablero tab){
        arb.crearHijos(nodo, tab);
        if(nodo.getHijos()!=null){
            Iterator<Nodo> it= nodo.getHijos().iterator();
            while(it.hasNext()){//signar a cada nodo la prioridad y el coste
                Nodo nodoAux=it.next();
                nodoAux.setCosto(nodoAux.getProfundidad());
                nodoAux.setF(nodoAux.getCosto());
                frontera.insertar(nodoAux);
            }
        }
        
    }
    
    public void busquedaHeuristica(ColaPrioridad frontera, Nodo nodo, Arbol arb,Tablero tab){
        arb.crearHijos(nodo, tab);
        if(nodo.getHijos()!=null){
            float heuristica=0;
            Iterator<Nodo> hijoPrior= nodo.getHijos().iterator();
            while(hijoPrior.hasNext()){
                Nodo nodoAux=hijoPrior.next();
                if("DM".equals(nodo.getHeuristica())){
                    heuristica= heuristicaDM(nodo); 
                }else if("DE".equals(nodo.getHeuristica())){
                    heuristica= heuristicaDE(nodo);
                }
                nodoAux.setCosto(nodo.getCosto()+1);
                nodoAux.setF(nodoAux.getCosto()+heuristica);
                frontera.insertar(nodoAux);
            }
        }
    }
    
    public void busquedaVoraz(ColaPrioridad frontera, Nodo nodo, Arbol arb, Tablero tab){
        arb.crearHijos(nodo, tab);
        if(nodo.getHijos()!=null){
            float heuristica=0;      
            Iterator<Nodo> hijoPrior= nodo.getHijos().iterator();
            while(hijoPrior.hasNext()){
                Nodo nodoAux=hijoPrior.next();
                if("DM".equals(nodo.getHeuristica())){
                    heuristica= heuristicaDM(nodo); 
                }else if("DE".equals(nodo.getHeuristica())){
                    heuristica= heuristicaDE(nodo);
                }
                nodoAux.setCosto(nodo.getCosto()+1);
                nodoAux.setF(heuristica);

                frontera.insertar(nodoAux);
            }
        }
    }
    private float heuristicaDM (Nodo nodo){
        float resultado;
        resultado= Math.abs(nodo.getX()-x)+Math.abs(nodo.getY()-y);
        return resultado;
    }
    
    private float heuristicaDE (Nodo nodo){
        double resultado;
        resultado= Math.sqrt(Math.pow(nodo.getX()-x,2)+Math.pow(nodo.getY()-y,2));
        return (float)resultado;
    }
    
}
