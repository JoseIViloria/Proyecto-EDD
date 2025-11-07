/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 * Clase que permite hacer una Pila de enteros.
 * @author Diego Guzmán
 */
public class Pila {
    private Nodo cima;
    
    public Pila() {
        this.cima = null;
    }
    
    /**
     * "Apila" un nuevo valor
     * @param valor - int que será apilado
     */
    public void push(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.setpNext(cima);
        cima = nuevo;
    }
    
    /**
     * Comprueba si la Pila está vacía
     * @return boolean True si está vacía, False si no
     */
    public boolean estaVacia() {
        return cima == null;}
    
    /**
     * "Desapila" un valor de la Pila
     * @return valor - el int que fue desapilado
     */
    public int pop() {
        if (estaVacia()) {
            return -1;
        }
        int valor = (int) cima.getDato();
        cima = cima.getpNext();
        return valor;
    }
    
}
