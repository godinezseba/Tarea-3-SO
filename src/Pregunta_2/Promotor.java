package Pregunta_2;
/**
 * Promotor
 */
public class Promotor implements Runnable{
    private Thread t;
    public Promotor(){
        t = new Thread(this);
        t.start();
    }
    public void run(){
        System.out.println("Hola: " + nombre);
    }
    
}