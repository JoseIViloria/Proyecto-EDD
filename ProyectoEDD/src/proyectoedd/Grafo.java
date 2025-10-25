/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 *
 * @author Gemelos
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
    
    public void insertarVertice(String x){
        if (this.getVertices()==this.getMaxVertices()){
            return;
        }else{
            this.getLista(this.getVertices()).insertar(x);
            this.setVertices(this.getVertices()+1);
        }
    }
    
    public void insertarArista(String x, int y){
        if (!(y>=this.getMaxVertices())){
            if(!(this.getLista(y).esVacio()) && (this.getLista(y).buscar(x)==null)){
                this.getLista(y).insertar(x);
            }
        }  
    }
}
