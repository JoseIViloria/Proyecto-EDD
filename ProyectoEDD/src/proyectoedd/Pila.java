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
    private NodoPila cima;
   
    public Pila(){
        this.cima= null;
    }
    
    public boolean esVacia(){
        return cima == null;
        
    }
    
    public int cima(){
        if (esVacia()){
            System.out.println("la pila se encuentra vacia");
            return -1;
                }
        return cima.getData();
    }
        public void apilar (int data){
            NodoPila newNodoPila= new NodoPila(data);
            newNodoPila.setNext(cima);
            cima = newNodoPila;
            System.out.println("elemento"+data+"agregado");
        }
        public int desapilar(){
            if(esVacia()){
                System.out.println("la pila esta vacia, no se puede desapilar");
                
            }
            int data = cima.getData();
            cima=cima.getNext();
            return data;
            
        }
   

    
}
