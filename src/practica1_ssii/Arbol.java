/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_ssii;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Jason
 */
public class Arbol  {
    
    protected Nodo root;

    public Arbol(Nodo root) {
        this.root = root;
    }


    public Nodo root() { return root; }
    public Nodo padre(Nodo node) { return node.getPadre(); }
    public Iterable<Nodo> hijos(Nodo node) { return node.getHijos(); }
    public boolean isInternal(Nodo node) { return !isExternal(node); }
    public boolean isExternal(Nodo node) { return node.getHijos()==null; }
    public boolean isRoot(Nodo node) { return root == node; }
    public boolean isEmpty() { return root==null; }

  public void setRoot(Nodo root)
  {
    if (this.root==null){
     this.root=root;
    }
   
  }
  
  public Nodo getHijo(Nodo node)
  {
    Iterator<Nodo> it=node.getHijos().iterator();
    int i=0;
    while (i<node.getProfundidad() && it.hasNext()){
      it.next();
      i++;
    }
    return it.next();  
  }
  public void addChild(Nodo parent, Nodo child)
  {
    if(parent.getHijos()==null) {
      ArrayList<Nodo> children=new ArrayList();
      children.add(child);
      parent.setHijos(children);
      child.setPadre(parent);
      child.setHijos(null); // como sÃ³lo aÃ±adimos un nodo, Ã©ste no tiene hijos
    } else {
      ArrayList children=parent.getHijos();
      children.add(child);
      child.setPadre(parent);
      child.setHijos(null); // como sÃ³lo aÃ±adimos un nodo, Ã©ste no tiene hijos
    }
  }
    public void crearHijos(Nodo padre, Tablero tab){
        float x, y;
        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                if(i!=0 || j!=0){
                    x=padre.getX()+i;
                    y=padre.getY()+j;
                    if(cumpleRequisitos(tab, x, y)){
                        Nodo nodo= new Nodo(padre , x,y, null,padre.getProfundidad()+1,
                                        0 , null, 0, padre.getHeuristica());
                        asignarAccion(padre, nodo);
                        addChild(padre, nodo);
                    }
                    
                }
            }
        }
    } 
    
    private boolean cumpleRequisitos(Tablero tab, float x, float y){
        boolean si=false;
        if(tab.getTablero()[(int)x][(int)y]!=null || x> tab.getAncho() || y > tab.getAlto()){
            if(!tab.getTablero()[(int)x][(int)y].isOcupada() && !tab.getTablero()[(int)x][(int)y].isVisitiada()){
                tab.getTablero()[(int)x][(int)y].setOcupada(true);
                si=true;
            }
        }
        return si;
    }
    
    public void asignarAccion(Nodo padre, Nodo hijo){
        if(padre.getX()==hijo.getX()&&padre.getY()<hijo.getY()){
            hijo.setAccion("Norte");
        }else if(padre.getX()<hijo.getX()&&padre.getY()<hijo.getY()){
            hijo.setAccion("NorEste");
        }else if(padre.getX()<hijo.getX()&&padre.getY()==hijo.getY()){
            hijo.setAccion("Este");
        }else if(padre.getX()<hijo.getX()&&padre.getY()>hijo.getY()){
            hijo.setAccion("SurEste");
        }else if(padre.getX()==hijo.getX()&&padre.getY()>hijo.getY()){
            hijo.setAccion("Sur");
        }else if(padre.getX()>hijo.getX()&&padre.getY()>hijo.getY()){
            hijo.setAccion("SurOeste");
        }else if(padre.getX()>hijo.getX()&&padre.getY()==hijo.getY()){
            hijo.setAccion("Oeste");
        }else if(padre.getX()>hijo.getX()&&padre.getY()<hijo.getY()){
            hijo.setAccion("NorOeste");
        }
    }
}
