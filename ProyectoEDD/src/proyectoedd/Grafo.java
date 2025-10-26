/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 *
 * @author Jose Viloria
 */
public class Grafo {
    private int maxVertices;
    private int vertices;
    private Lista ady[];
    
    public Grafo(int n){
        this.maxVertices = n;
        this.vertices = 0;
        ady = new Lista[n];
    }

    /**
     * @return the maxVertices
     */
    public int getMaxVertices() {
        return maxVertices;
    }

    public void setMaxVertices(int maxVertices) {
        this.maxVertices = maxVertices;
    }


    public int getVertices() {
        return vertices;
    }


    public void setVertices(int vertices) {
        this.vertices = vertices;
    }
    
    public Lista getLista(int x){
        if (x>this.getMaxVertices()){
            return null;
        }
        else{
            return ady[x];
        }
    }
    
    public void setLista(int y, Lista l){
        ady[y] = l;
    }
    
    public void insertarVertice(String x){
        if (this.getVertices()==this.getMaxVertices()){
            return;
        }else{
            Lista aux = new Lista();
            this.setLista(this.getVertices(), aux);
            this.getLista(this.getVertices()).insertar(x);
            this.setVertices(this.getVertices()+1);
        }
    }
    
    public void insertarArista(String x, int y){
        if (!(y+1>=this.getMaxVertices())){
            if(!(this.getLista(y).esVacio())){
                this.getLista(y).insertar(x);
            }
        }  
    }
    
    public void elminarVertice(int y){
        if(y+1>vertices || y<0){
            return;
        }
        this.setLista(y, null);    
        if((y+1)==this.getVertices()){
            this.setVertices(this.getVertices()-1);
            return;
        }else{
            this.setVertices(this.getVertices()-1);
            for(;y<this.getVertices();y++){
                this.setLista(y, this.getLista(y+1));              
            }
        }
    }
}
