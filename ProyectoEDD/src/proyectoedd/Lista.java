/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 * Clase que representa listas simplemente enlazadas, para ser utilizadas en la Clase Grafo.
 * Son las listas de ayacencia que contienen los vértices y sus conexiones.
 * Su único atributo es un apuntador al primer Nodo de la Lista.
 * 
 * @author Jose Viloria
 * @see Grafo, Nodo
 */
public class Lista<T> {
    private Nodo pFirst;

    /**
     * Constructor de la clase Lista.
     */
    public Lista() {
        this.pFirst = null;
    }
    
    /**
     * Cambia el atributo pFirst de la Lista.
     * @param x - Nodo que será insertado como pFirst
     */
    public void setPfirst(Nodo x){
        this.pFirst = x;
    }
    
    /**
     * Regresa el atributo pFirst de la Lista.
     * @return pFirst - primer Nodo de la Lista.
     */
    public Nodo getPrimero(){
        return this.pFirst;
    }
    public Nodo primero(){
        return this.pFirst;
    }
    
    /**
     * Regresa el último nodo en la Lista.
     * @return Ultimo Nodo de la lista
     */
    public Nodo last(){
        if (this.esVacio()){
            return null;
        }
        Nodo x = this.primero();
        while(x.getpNext()!=null){
            x = x.getpNext();
        }
        return x;
    }
    
    /**
     * Regresa un booleano dependiendo si la lista está vaciá o no.
     * @return True si la Lista está vacía, False si no.
     */
    public boolean esVacio(){
        return this.primero() == null;
    }
    
    /**
     * Inserta un Nodo nuevo al final de la lista, con el dato que entra como parámetro.
     * @param x - El atributo "dato" del nodo que se quiere insertar
     */
    public void insertar(T x){
        Nodo aux = new Nodo(x);
        if (this.esVacio()){
            this.setPfirst(aux);
        }else{
            this.last().setpNext(aux);
        }
    }
    
    /**
     * Busca, usando el atributo del nodo, un nodo en la lista y lo elimina.
     * @param x - el atributo "dato" del nodo que se quiere eliminar.
     */
    public void eliminarElemento(T x){
        if (this.esVacio()){
            return;
        }
        Nodo aux = this.primero();
        if(aux.getDato().equals(x)){
            this.setPfirst(aux.getpNext());
        }else{
            while(!aux.getpNext().getDato().equals(x)){
                aux= aux.getpNext();
            }
            if (aux.getpNext()!= null){
            aux.setpNext(aux.getpNext().getpNext());
        }
    }
   }
    
    /**
     * Busca un Nodo en la lista; regresa la dirección del Nodo
     * @param x - El atributo "dato" del nodo que se busca.
     * @return El nodo que se encontró
     */
    public Nodo buscar(T x){
        Nodo aux = this.primero();
        while(aux!= null){
            if(aux.getDato().equals(x)){
                return aux;
            }
            
            aux = aux.getpNext();
        }
        return null;
    }
    
    public void insertarAlinicio(T x){
        Nodo nuevo = new Nodo (x);
        if(this.esVacio()){
            this.setPfirst(nuevo);
        }else{
            nuevo.setpNext(this.getPrimero());
            this.setPfirst(nuevo);
        }
    }
}
