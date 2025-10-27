/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 * Esta clase representa los nodos utilizados en la clase Lista.
 * Cada nodo contiene un dato de tipo T y una referencia al siguiente.
 * 
 * @author José Viloria
 * @see Lista
 * @param <T>
 */
public class Nodo<T> {
    private T dato;
    private Nodo pNext;

    /**
     * Constructor para la clase Nodo.
     * 
     * @param dato La información que contiene el Nodo
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.pNext = null;
    }

    /**
     * @return dato que contiene el Nodo
     */
    public T getDato() {
        return dato;
    }

    /**
     * @param dato que se insertará en el Nodo
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return pNext - El siguiente Nodo
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * @param pNext que se insertará en el Nodo
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
 
}
