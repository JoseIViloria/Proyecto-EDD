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
        return -1;
    }
    
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
        
        Nodo primerNodo =  this.getLista(verticeActual).primero();
        String datoActual =(String) primerNodo.getDato();
        resultado.insertar(datoActual);
        Nodo adyacente = this.getLista(verticeActual).primero().getpNext();
        while (adyacente != null){
            String datoAdyacente = (String)adyacente.getDato();
            int posAdyacente = this.posiciónVertice(datoAdyacente);
            
            if (posAdyacente != -1 && !visitados[posAdyacente]){
                DFSRecursivo(posAdyacente, visitados, resultado);
            }
            adyacente =  adyacente.getpNext();
        }
    }
    public boolean HayenlaceDFS(String inicio, String destino){
        if (!this.verticeExiste(inicio) || !this.verticeExiste(destino)){
            return false;
        }
        boolean[] visitados = new boolean[this.getVertices()];
        int posInicio = this.posiciónVertice(inicio);
        int posDestino = this.posiciónVertice(destino);
        
        return HayenlaceDFSRecursivo(posInicio, posDestino, visitados);
    }
     private boolean HayenlaceDFSRecursivo(int actual, int destino, boolean[] visitados){
        if (actual == destino){
            return true;
        }
        visitados[actual] = true;
        
        Nodo adyacente =  this.getLista(actual).primero().getpNext();
        while (adyacente != null){
            String datoAdyacente = (String)adyacente.getDato();
            int posAdyacente = this.posiciónVertice(datoAdyacente);
            if (posAdyacente != -1 && !visitados[posAdyacente]){
                if (HayenlaceDFSRecursivo(posAdyacente, destino, visitados)){
                    return true;
                }
            }
            adyacente =  adyacente.getpNext();
        }
        return false;
         }
    
    public void imprimirdfs(String inicio){
        Lista resultado = this.DFS(inicio);
        System.out.println("DFS DE " + inicio + ":");
        if (resultado.esVacio()){
            System.out.println("El grafo esta vacio");
        } else {
            Nodo actual =  resultado.primero();
            while (actual != null){
                System.out.print(actual.getDato() + " ");
                actual = actual.getpNext();
            }
            System.out.println();
        }
    }
    public Lista DFSTranspuesto(String inicio) {
        Grafo grafoTranspuesto = this.obtenerGrafoTranspuesto();
    return grafoTranspuesto.DFS(inicio);
    }
    
    
     public Grafo obtenerGrafoTranspuesto(){
        Grafo transpuesto = new Grafo(this.getMaxVertices());
        
        for (int i = 0; i < this.getVertices(); i++){
            String datoVertice = (String) this.getLista(i).primero().getDato();
            transpuesto.insertarVertice(datoVertice);
        }
        
        for (int i = 0; i < this.getVertices(); i++){
            String from = (String) this.getLista(i).primero().getDato();
            int posFrom = transpuesto.posiciónVertice(from);
        Nodo adyacente = this.getLista(i).primero().getpNext();
            while (adyacente != null){
                String to = (String)adyacente.getDato();
                int posTo = transpuesto.posiciónVertice(to);
                
                if (posTo != -1){
                    transpuesto.insertarArista(from, posTo);
                }
                adyacente = adyacente.getpNext();
            }
        }
        return transpuesto;
    }
      public void imprimirDFSTranspuesto(String inicio){
        Lista resultado = this.DFSTranspuesto(inicio);
        System.out.print("DFS Transpuesto de " + inicio + ": ");
        if (resultado.esVacio()){
            System.out.println("No hay vertice");
        } else {
            Nodo actual =  resultado.primero();
            while (actual != null){
                System.out.print(actual.getDato() + " ");
                actual =  actual.getpNext();
            }
            System.out.println();
        }
    }
      public boolean existeCamino(String inicio, String destino) {
    return HayenlaceDFS(inicio, destino);
}
    
    
    
    public void compararDFSConTranspuesto(String inicio) {
        Lista dfsNormal = this.DFS(inicio);
        Lista dfsTranspuesto = this.DFSTranspuesto(inicio);
        
        System.out.println("Comparación para vértice: " + inicio);
        System.out.print("DFS Normal: ");
        imprimirLista(dfsNormal);
        
        System.out.print("DFS Transpuesto: ");
        imprimirLista(dfsTranspuesto);
    }
    
    private void imprimirLista(Lista lista) {
        if (lista == null || lista.esVacio()) {
            System.out.println("Lista vacía");
            return;
        }
        
        Nodo actual =  lista.primero();
        actual = actual.getpNext();
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = (Nodo<String>) actual.getpNext();
            }
        System.out.println();
    }
    
    /// Creacion de componentes fuertemente enlazados 
    
    public Lista componentesFuertementeConectados() {
        Lista componentes = new Lista();
        
        Lista orden = new Lista();
        boolean[] visitados = new boolean[this.getVertices()];
        
        for (int i = 0; i < this.getVertices(); i++) {
            if (!visitados[i]) {
                DFSOrden(i, visitados, orden);
            }
        }
         Grafo grafoTranspuesto = this.obtenerGrafoTranspuesto();
        boolean[] visitadosTranspuesto = new boolean[this.getVertices()];
        Lista ordenInverso = invertirLista(orden);
        Nodo actual = ordenInverso.primero();
        while (actual != null) {
            String nombreVertice = (String)actual.getDato();
            int vertice = this.posiciónVertice(nombreVertice);
            
            if (vertice != -1 && !visitadosTranspuesto[vertice]) {
                Lista componente = new Lista();
                grafoTranspuesto.DFSRecursivoSCC(vertice, visitadosTranspuesto, componente);
                componentes.insertar(componente);
            }
            actual =  actual.getpNext();
               }
        return componentes;
    }
    private Lista invertirLista(Lista original) {
    Lista invertida = new Lista();
    Nodo actual = original.primero();
    
    while (actual != null) {
        invertida.insertar(actual.getDato());
        actual = actual.getpNext();
    }
    return invertida;
}
    private void DFSOrden(int vertice, boolean[] visitados, Lista orden) {
        visitados[vertice] = true;
        
        Nodo adyacente = this.getLista(vertice).primero().getpNext();
        while (adyacente != null) {
            String datoAdyacente = (String)adyacente.getDato();
            int posAdyacente = this.posiciónVertice(datoAdyacente); 
            if (posAdyacente != -1 && !visitados[posAdyacente]) {
                DFSOrden(posAdyacente, visitados, orden);
            }
            adyacente = adyacente.getpNext();
        }
        
        String datoVertice = (String) this.getLista(vertice).primero().getDato();
        orden.insertar(datoVertice);
    }
    
    private void DFSRecursivoSCC(int verticeActual, boolean[] visitados, Lista componente) {
        visitados[verticeActual] = true;
       String datoActual = (String) this.getLista(verticeActual).primero().getDato();
        componente.insertar(datoActual);
        
        Nodo adyacente = this.getLista(verticeActual).primero().getpNext();
        while (adyacente != null) {
            String datoAdyacente =(String) adyacente.getDato();
            int posAdyacente = this.posiciónVertice(datoAdyacente);
            
            if (posAdyacente != -1 && !visitados[posAdyacente]) {
                DFSRecursivoSCC(posAdyacente, visitados, componente);
            }
            adyacente = adyacente.getpNext();
            }
    }
    
    public Lista[] obtenerComponentesParaColores() {
        Lista componentesLista = this.componentesFuertementeConectados();
        
        int count = 0;
        Nodo temp = componentesLista.primero();
        while (temp != null) {
            count++;
            temp = temp.getpNext();
        }
         Lista[] componentesArray = new Lista[count];
        temp = componentesLista.primero();
        for (int i = 0; i < count; i++) {
            componentesArray[i] = (Lista) temp.getDato();
            temp = temp.getpNext();
        }
        
        return componentesArray;
    }
    public void imprimirComponentesConectados() {
        Lista componentes = this.componentesFuertementeConectados();
        System.out.println("COMPONENTES FUERTEMENTE CONECTADOS ");
        
        if (componentes.esVacio()) {
            System.out.println("No hay componentes");
            return;
        }
        String[] paletaColores = {
        " ROJO", " AZUL", " VERDE", " AMARILLO", " NARANJA",
        " MORADO", " ROSA", " GRIS", " MARRÓN", " CORAL"
    };
        
        Nodo<Lista> componenteActual =(Nodo<Lista>) componentes.primero();
        int numero = 1;
        
        while (componenteActual != null) {
            Lista componente = componenteActual.getDato();
            String color = (numero - 1 < paletaColores.length) ? 
                      paletaColores[numero - 1] : "Color " + numero;
            System.out.print("Componente " + numero + ": ");
          Nodo<String> vertice = (Nodo<String>) componente.primero();
            while (vertice != null) {
                System.out.print(vertice.getDato() + " ");
                vertice =  vertice.getpNext();
            }
            System.out.println();
            
            componenteActual = componenteActual.getpNext();
            numero++;
        }
    }
    /**
 * Asigna colores a los componentes fuertemente conectados
 * Cada componente recibe un color diferente
 * @return Array de Strings con [vértice, color] para cada vértice
 */
public String[] colorearComponentes() {
    Lista componentes = this.componentesFuertementeConectados();
    String[] colores = new String[this.getVertices()];
    
    // Array de colores disponibles
    String[] paletaColores = {
        "ROJO", "AZUL", "VERDE", "AMARILLO", "NARANJA", 
        "MORADO", "ROSA",  "MARRON", "GRIS", "CORAL"
    };
    
    Nodo<Lista> componenteActual = (Nodo<Lista>) componentes.primero();
    int colorIndex = 0;
    
    // Recorrer cada componente
    while (componenteActual != null && colorIndex < paletaColores.length) {
        Lista componente = componenteActual.getDato();
        String color = paletaColores[colorIndex];
        
        // Colorear todos los vértices del componente con el mismo color
        Nodo<String> vertice = (Nodo<String>) componente.primero();
        while (vertice != null) {
            String nombreVertice = vertice.getDato();
            int posicion = this.posiciónVertice(nombreVertice);
            
            if (posicion != -1) {
                colores[posicion] = color;
            }
            vertice = vertice.getpNext();
        }
        
        componenteActual = componenteActual.getpNext();
        colorIndex++;
    }
    
    return colores;
}

/**
 * Muestra los componentes con sus colores asignados
 */
public void mostrarComponentesColoreados() {
    System.out.println("=== COMPONENTES FUERTEMENTE CONECTADOS CON COLORES ===");
    
    Lista componentes = this.componentesFuertementeConectados();
    String[] coloresVertices = this.colorearComponentes();
    
    String[] paletaColores = {
        "ROJO", "AZUL", "VERDE", "AMARILLO", "NARANJA", 
        "MORADO", "ROSA", "CORAL", "MARRON", "GRIS"
    };
    
    Nodo<Lista> componenteActual = (Nodo<Lista>) componentes.primero();
    int numero = 1;
    
    while (componenteActual != null) {
        Lista componente = componenteActual.getDato();
        
        // Obtiene el color del primer vértice del componente
        Nodo<String> primerVertice = (Nodo<String>) componente.primero();
        if (primerVertice != null) {
            String primerVerticeStr = primerVertice.getDato();
            int pos = this.posiciónVertice(primerVerticeStr);
            String color = (pos != -1 && coloresVertices[pos] != null) ? 
                          coloresVertices[pos] : "SIN COLOR";
            
            System.out.print("Componente " + numero + " (" + color + "): ");
            
            // Muestra todos los vértices del componente
            Nodo<String> vertice = primerVertice;
            while (vertice != null) {
                System.out.print(vertice.getDato() + " ");
                vertice = vertice.getpNext();
            }
            System.out.println();
        }
        
        componenteActual = componenteActual.getpNext();
        numero++;
    }
}
///muestra la asignacon de colores por vertice
public void mostrarColoresPorVertice() {
    System.out.println("=== ASIGNACIÓN DE COLORES POR VÉRTICE ===");
    
    String[] colores = this.colorearComponentes();
    
    for (int i = 0; i < this.getVertices(); i++) {
        String nombreVertice = (String) this.getLista(i).primero().getDato();
        String color = (colores[i] != null) ? colores[i] : "SIN COLOR";
        System.out.println("Vértice " + nombreVertice + " → Color: " + color);
    }
}
public String obtenerColorVertice(String vertice) {
    String[] colores = this.colorearComponentes();
    int posicion = this.posiciónVertice(vertice);
    
    if (posicion != -1 && colores[posicion] != null) {
        return colores[posicion];
    }
    return "SIN COLOR";
}
public Lista obtenerVerticesMismoColor(String color) {
    Lista resultado = new Lista();
    String[] colores = this.colorearComponentes();
    
    for (int i = 0; i < this.getVertices(); i++) {
        if (color.equals(colores[i])) {
            String nombreVertice = (String) this.getLista(i).primero().getDato();
            resultado.insertar(nombreVertice);
        }
    }
    
    return resultado;
}
}
