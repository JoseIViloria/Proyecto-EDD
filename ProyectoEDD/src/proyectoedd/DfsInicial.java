/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd;

/**
 *
 * @author Usuario
 */
public class DfsInicial {
    
    public static void dfsRecursivo(int NodoActual,boolean[] visitado,int [][] grafo){
        
        visitado[NodoActual]=true ;///se marco como visitado el nodo
        System.out.println(NodoActual+"");///se imprime el orden de visita 
        for (int i= 0;i<grafo[NodoActual].length;i++){
            int vecino = grafo[NodoActual][i];///obtenemos el nodo vecino en la posicion i 
            if(!visitado[vecino])///verificar si ya fue visitado
                    dfsRecursivo(vecino,visitado,grafo);///si el vecino no ha sido visitado se llama recursivamente a dfs
            
            
        }
        
    }
    
}
