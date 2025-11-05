/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 *
 * @author Usuario
 */
public class NodoPila {
    
    private int data;
    private NodoPila next;
    
    public NodoPila (int data) {
        
        this.next =null;
        this.data = data;
        
    }
    
    public int getData() {
        return data;
       } 
    public void setNext(NodoPila next){
        this.next=next;
    }
    public NodoPila getNext() {
        return next ;
       } 
            
    
}
