package Pregunta_2;

/**
 * Cliente
 */
public class Cliente extends Main implements Runnable{

    private String nombre;
    private Thread t;
    public Cliente(String nombre){
        this.nombre = nombre;
        t = new Thread(this, nombre);
        t.start();
    }
    
}