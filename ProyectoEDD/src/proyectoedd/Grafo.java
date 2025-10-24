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
    private int maxNodos;
    private int vertices;
    private Lista ady[];
    
    public Grafo(int n){
        this.maxNodos = n;
        this.vertices = 0;
        ady = new Lista[n];
    }

    /**
     * @return the maxNodos
     */
    public int getMaxNodos() {
        return maxNodos;
    }

    public void setMaxNodos(int maxNodos) {
        this.maxNodos = maxNodos;
    }


    public int getVertices() {
        return vertices;
    }


    public void setVertices(int vertices) {
        this.vertices = vertices;
    }
    
    public Lista getLista(int x){
        if (x>this.getMaxNodos()){
            return null;
        }
        else{
            return ady[x];
        }
    }
}
