/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 *
 * @author Usuario
 */
public class Pila {
    private Nodo cima;
    
    public Pila() {
        this.cima = null;
    }
    
    public void push(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.setpNext(cima);
        cima = nuevo;
    }
    public boolean estaVacia() {
        return cima == null;}
    public int pop() {
        if (estaVacia()) {
            return -1;
        }
        int valor = (int) cima.getDato();
        cima = cima.getpNext();
        return valor;
    }
    
}
