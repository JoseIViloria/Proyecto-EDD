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
     * El nuevo Nodo no puede ser el primero de la lista, ya que  representa un vértice del Grafo
     * @param x - "Dato" del Nodo que se insertará en la lista
     * @param y - Posición de la lista en la que se quiere insertar el Nodo
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
     * No cambia el tamaño del array y listas siguientes a la borrada pasan a ocupar su lugar.
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
     * @param x - El dato que hay  en uno de los vértices.
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
     * @param from - String correspondiente al dato de  primer Nodo en la lista de adyacencia 
     * @param to - String correspondiente al dato del Nodo con el que se quiere buscar una relación.
     * @return - true si la relación existe, false si no.
     */
    public boolean relacion_existe(String from, String to){
        Nodo aux;
        int position = this.posiciónVertice(from);
        aux = this.getLista(position).primero().getpNext();
        while(aux!=null){
            if(aux.getDato().equals(to)){
                return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }
    
    /**
     * Regresa la posición dentro de el array ady, de un vértice que bisque
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
        return -1;
    }
    
    /**
     * Hace un recorrido DFS.
     * @param inicio - el String que corresponde al Dato del Nodo a partir del cual se iniciará el recorrido
     * @return result - Una lista con los resultados
     * @deprecated
     */
    public Lista DFS (String inicio){
        Lista result = new Lista();
        boolean [] visitados = new boolean [this.getVertices()];
        
        int  posInicio = this.posiciónVertice(inicio);
        if (posInicio == -1){
            return result;
        }
        DFSRecursivo (posInicio, visitados, result);
        return result;
    }
    
    /**
     * Función que realiza un recorrido DFS recursivamente.
     * @param verticeActual - Entero que indica una posición en la lista de ayacencia.
     * @param visitados - Array de booleanos para identificar que nodos han sido visitados.
     * @param resultado - Lista en la que se escribirá información.
     * @deprecated
     */
    private void DFSRecursivo(int verticeActual, boolean[] visitados, Lista resultado){
        if (verticeActual < 0 || verticeActual >= this.getVertices()){
            return;
            }
        if (this.getLista(verticeActual) == null){
            return;
        }
        if (this.getLista(verticeActual).primero() == null){
            return;
        }
        visitados[verticeActual] = true;
        Nodo<String> primerNodo = (Nodo<String>) this.getLista(verticeActual).primero();
        String datoActual = primerNodo.getDato();
        resultado.insertar(datoActual);
        Nodo<String> adyacente = (Nodo<String>) this.getLista(verticeActual).primero().getpNext();
        while (adyacente != null){
            String datoAdyacente = adyacente.getDato();
            int posAdyacente = this.posiciónVertice(datoAdyacente);          
            if (posAdyacente != -1 && !visitados[posAdyacente]){
                DFSRecursivo(posAdyacente, visitados, resultado);
            }
            adyacente = (Nodo<String>) adyacente.getpNext();
        }
    }
    
    /**
     * Función que permite verificar si hay un enlace entre 2 vértices.
     * @param inicio - String correspondiente al vértice a partir del cual se buscará
     * @param destino - String correspondiente al vértice que se busca
     * @return HayenlaceDFSRecursivo
     * @deprecated 
     */
    public boolean HayenlaceDFS(String inicio, String destino){
        if (!this.verticeExiste(inicio) || !this.verticeExiste(destino)){
            return false;
        }
        boolean[] visitados = new boolean[this.getVertices()];
        int posInicio = this.posiciónVertice(inicio);
        int posDestino = this.posiciónVertice(destino);
        
        return HayenlaceDFSRecursivo(posInicio, posDestino, visitados);
    }
    
    /**
     * Recorre recursivamente entre Nodos, verificando si están enlazados entre sí
     * @param actual - (Entero) Posición del nodo actual
     * @param destino - (Entero) Posición del nodo final
     * @param visitados - Lista de booleanos que permite reconocer que nodos ya han sido visitados.
     * @return Boolean True, si se encuentra un enlace; False en el caso contrario
     * @deprecated 
     */
    private boolean HayenlaceDFSRecursivo(int actual, int destino, boolean[] visitados){
        if (actual == destino){
            return true;
        }
        visitados[actual] = true;
        Nodo<String> adyacente = (Nodo<String>) this.getLista(actual).primero().getpNext();
        while (adyacente != null){
            String datoAdyacente = adyacente.getDato();
            int posAdyacente = this.posiciónVertice(datoAdyacente);
            if (posAdyacente != -1 && !visitados[posAdyacente]){
                if (HayenlaceDFSRecursivo(posAdyacente, destino, visitados)){
                    return true;
                }
            }
            adyacente = (Nodo<String>) adyacente.getpNext();
        }
        return false;      
    }
    
    /**
     * Función que utiliza el algoritmo de Kosaraju para encontrar los componentes fuertemente conectados del Grafo
     * @return resultado - Un array con los componentes encontrados
     */
    public String[][] EncontrarComponentesFuertementeConectados(){
         if(this.getVertices()==0){
             return new String [0][0];
         }
         Pila pila = new Pila();
         boolean[]visitados = new boolean[this.getVertices()];
         for (int i= 0; i< this.getVertices();i++){
             if (!visitados[i]){
                 primeraDFS(i, visitados,pila);
             }
         }
         Grafo grafoTranspuesto= transponerGrafo();
         visitados= new boolean[this.getVertices()];
         String[][] componentesTemp = new String [this.getVertices()][];
         int numComponentes = 0;
         while (!pila.estaVacia()){
             int vertice = pila.pop();
             if(!visitados[vertice]){
                 Lista componenteLista= new Lista();
                 segundaDFS (grafoTranspuesto,vertice,visitados,componenteLista);
                 String[]componente = listaToArray(componenteLista);
                 componentesTemp[numComponentes++]=componente;
             }
         }
         String[][]resultado = new String[numComponentes][];
         for(int i =0; i<numComponentes;i++){
             resultado[i]=componentesTemp[i];
         }
         return resultado;
    }
    
    /**
     * Realiza el primer recorrido DFS necesario para Kosaraju
     * @param vertice  - Int correspondiente al vértice a partir del cual se va a recorrer
     * @param visitados - Array de booleanos que indica cuáles nodos han sido visitados
     * @param pila - Una pila que guarda la prioridad que se usará para guardar la "prioridad" del recorrido
     */
    private void primeraDFS (int vertice, boolean[]visitados,Pila pila){
         visitados[vertice]=true;
         Nodo adyacente = this.getLista(vertice).primero().getpNext();
         while (adyacente!= null){
             String datoAdyacente = (String) adyacente.getDato();
             int posAdyacente = this.posiciónVertice(datoAdyacente);
             if (posAdyacente != -1 && !visitados[posAdyacente]){
                 primeraDFS(posAdyacente,visitados,pila);       
             }
             adyacente=adyacente.getpNext();
         }
         pila.push(vertice); 
    }
    
    /**
     * Transpone el grafo (revierte la dirección de las relaciones)
     * @return transpuesto - El grafo nuevo con las relaciones invertidas
     */
    private Grafo transponerGrafo(){
         Grafo transpuesto = new Grafo(this.getMaxVertices());
         for (int i=0 ; i< this.getVertices();i++){
             String usuario = (String) this.getLista(i).primero().getDato();
             transpuesto.insertarVertice(usuario);
         }
         for (int i = 0 ; i<this.getVertices();i++){
             String usuarioOrigen= (String) this.getLista(i).primero().getDato();
             Nodo adyacente = this.getLista(i).primero().getpNext();
             
             while (adyacente != null){
                 String usuarioDestino = (String) adyacente.getDato();
                 int posDestino= transpuesto.posiciónVertice(usuarioDestino);
                 if (posDestino!= -1){
                     transpuesto.insertarArista(usuarioOrigen, posDestino);
                 }
                 adyacente = adyacente.getpNext();
             }
         }
         return transpuesto;
    }
    
    /**
     * Realiza el segundo recorrido DFS necesario para el algoritmo de Kosaraju
     * @param grafo - El grafo que se va a recorrer
     * @param vertice - Int correspondiente al vértice a partir del cual se va a recorrer
     * @param visitados - Array que representa cuales nodos han sido visitados
     * @param componente - Lista en la que se guardaran los componentes encontrados
     */
    private void segundaDFS(Grafo grafo, int vertice, boolean[] visitados, Lista componente) {
        visitados[vertice] = true;
        String usuario = (String) grafo.getLista(vertice).primero().getDato();
        componente.insertar(usuario);
        Nodo adyacente = grafo.getLista(vertice).primero().getpNext();
        while (adyacente != null) {
            String datoAdyacente = (String) adyacente.getDato();
            int posAdyacente = grafo.posiciónVertice(datoAdyacente);
            if (posAdyacente != -1 && !visitados[posAdyacente]) {
                segundaDFS(grafo, posAdyacente, visitados, componente);
            }
            adyacente = adyacente.getpNext();
        }
    }
    
     /**
     * Convierte una Lista en un array de Strings
     */
    private String[] listaToArray(Lista lista) {
        if (lista == null || lista.esVacio()) {
            return new String[0];
        }
        int count = 0;
        Nodo actual = lista.primero();
        while (actual != null) {
            count++;
            actual = actual.getpNext();
        }
        String[] array = new String[count];
        actual = lista.primero();
        for (int i = 0; i < count; i++) {
            array[i] = (String) actual.getDato();
            actual = actual.getpNext();
        }
        return array;
    }
    
    /**
     * Consigue los colores para cada uno de los componentes del Grafo
     * @param numComponentes - número de componentes presentes en el Grafo
     * @return coloresAsignados - un array que contiene los colores de cada componente
     */
    public String[] obtenerColoresComponentes(int numComponentes) {
        String[] colores = {"#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#FF00FF", "#00FFFF", 
                            "#FFA500", "#800080", "#008000", "#800000"};
        String[] coloresAsignados = new String[numComponentes];
        for (int i = 0; i < numComponentes && i < colores.length; i++) {
            coloresAsignados[i] = colores[i];
        }
        for (int i = colores.length; i < numComponentes; i++) {
            coloresAsignados[i] = colores[i % colores.length];
        }
        return coloresAsignados;
    }     
}
       
        
        
        
                
    

