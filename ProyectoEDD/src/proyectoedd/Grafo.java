/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 * Representa al grafo y cada uno de sus componentes.
 * El grafo contiene dos atributos representando el número (entero) actual de vértices y el máximo.
 * También contiene un array con cada una de las listas de adyacencia.
 * @author Jose Viloria
 * @see Nodo, Lista
 */
public class Grafo {
    private int maxVertices;
    private int vertices;
    private Lista ady[];
    
    /**
     * Constructor de la clase Grafo.
     * @param n - Número máximo de vértices (usuarios)
     */
    public Grafo(int n){
        this.maxVertices = n;
        this.vertices = 0;
        ady = new Lista[n];
    }

    /**
     * @return el parámetro maxVertices
     */
    public int getMaxVertices() {
        return maxVertices;
    }

    /**
     * Cambia el parámetro "maxVertices" de la clase.
     * @param x - el nuevo número máximo de vétices 
     */
    public void setMaxVertices(int x) {
        this.maxVertices = x;
    }

    /**
     * @return vertices - el número actual de vertices presentes en el Grafo.
     */
    public int getVertices() {
        return vertices;
    }

    /**
     * Cambia el atributo "vertices" del Grafo.
     * @param vertices - el nuevo número de vértices en el grafo
     */
    public void setVertices(int vertices) {
        this.vertices = vertices;
    }
    
    /**
     * Regresa la lista en la posición "x" del array ady
     * @param x - La posición de la Lista dentro del array
     * @return La dirección de la lista en la posición especificada
     */
    public Lista getLista(int x){
        if (x>this.getMaxVertices()){
            return null;
        }
        else{
            return ady[x];
        }
    }
    
    /**
     * Cambia una de las listas del array ady por otra que se especifique.
     * @param y - Posición en el array de la lista que se quiere cambiar
     * @param l - Lista que se quiere insertar en la posición y
     */
    public void setLista(int y, Lista l){
        ady[y] = l;
    }
    
    /**
     * Crea una nueva Lista detro del array ady.
     * Inserta el primer Nodo en esa Lista y actualiza el parámetro "vertices" del Grafo.
     * @param x - Parámetro dato del "vértice" (Nodo) que se quiere insertar 
     */
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
    
    /**
     * Inserta un nuevo nodo a una de las listas del array ady.
     * El nuevo Nodo no puede ser el primero de la lista, ya que este representa un vértice del Grafo
     * @param x - "Dato" del Nodo que se insertará en la lista
     * @param y - Posición de la lista en la que se quiere insertar el Nodo (dentro de ady)
     */
    public void insertarArista(String x, int y){
        if (!(y+1>this.getMaxVertices())){
            if(!(this.getLista(y).esVacio())){
                this.getLista(y).insertar(x);
            }
        }  
    }
    
    /**
     * Elimina una de las listas en el array.
     * No cambia el tamaño del array y listas posteriores a la borrada pasan a ocupar su lugar.
     * @param y - Posición de una lista en el array
     */
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
    
    /**
     * Comprueba si el vértice con la información X se encuentra en la lista de adyacencia.
     * @param x - El dato contenido en uno de los vértices.
     * @return boolean True si el vértice existe, False en el caso  contrario
     */
    public boolean verticeExiste(String x){
        int i = 0;
        while(i<this.getVertices()){
            if(this.getLista(i).primero().getDato().equals(x)){
                return true;
            }
            i++;
        }
        return false;
    }
    
    /**
     * Regresa un booleano que indica si la relación entre dos usuarios existe.
     * @param from - String que corresponde al dato de un primer Nodo en la lista de adyacencia (ady)
     * @param to - String que corresponde al dato del Nodo con el que se quiere buscar una relación.
     * @return - true si la relación existe, false si no.
     */
    public boolean relacion_existe(String from, String to){
        Nodo aux;
        int position = this.posiciónVertice(from);
        aux = this.getLista(position).primero();
        while(aux!=null){
            if(aux.getDato().equals(to)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Regresa la posición dentro de el array ady, de un vértice que se busque.
     * @param x - El dato contenido dentro de uno de los vertices
     * @return la posición de el vertice buscado dentro del array ady.
     */
    public int posiciónVertice(String x){
        int pos = 0;
        while(pos<this.getVertices()){
            if(this.getLista(pos).primero().getDato().equals(x)){
                return pos;
            }
            pos++;
        }
        return 0;
    }
}
