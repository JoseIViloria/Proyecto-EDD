/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoedd;

/**
 * Main del programa.
 * Muestra la interfaz en pantalla.
 * @author José Viloria, Luis Viloria, Diego Guzmán
 */
public class ProyectoEDD {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaz display = new Interfaz();
        display.setVisible(true);
        System.setProperty("org.graphstream.ui", "swing");
    } 
}
