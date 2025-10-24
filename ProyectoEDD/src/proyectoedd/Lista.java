/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 *
 * @author Gemelos
 */
public class Lista<T> {
    private Nodo pFirst;

    public Lista() {
        this.pFirst = null;
    }
    
    public void setPfirst(Nodo x){
        this.pFirst = x;
    }
    
    public Nodo primero(){
        return this.pFirst;
    }
    
    public Nodo last(){
        Nodo x = new Nodo(null);
        x = this.primero();
        while(x.getpNext()!=null){
            x = x.getpNext();
        }
        return x;
    }
    
    public boolean esVacio(){
        return this.primero() == null;
    }
    
    public void insertar(T x){
        Nodo aux = new Nodo(x);
        if (this.esVacio()){
            this.setPfirst(aux);
        }else{
            this.last().setpNext(aux);
        }
    }
    
    public void eliminar(T x){
        Nodo aux = this.primero();
        if(aux.getDato().equals(x)){
            this.setPfirst(aux.getpNext());
        }else{
            while(!aux.getpNext().getDato().equals(x)){
                aux= aux.getpNext();
            }
            aux.setpNext(aux.getpNext().getpNext());
        }
    }
    
    public Nodo buscar(T x){
        Nodo aux = this.primero();
        while((!aux.getDato().equals(x))|| aux!=null){
            aux = aux.getpNext();
        }
        return aux;
    }
}
