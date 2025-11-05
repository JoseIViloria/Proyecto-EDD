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
    private int size;
   
    public Pila(){
        this.cima= null;
        this.size =0;
    }
    
    public boolean esVacia(){
        return cima == null;
        
    }
   

    
}
