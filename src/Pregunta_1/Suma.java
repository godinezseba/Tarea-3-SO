package Pregunta_1;

/**
 * Suma
 */
public class Suma implements Runnable{
    private int a;
    private int b;
    private Thread t;
    private String nombre;
    public Suma (int x, int y, String nombre){
        this.a = x;
        this.b = y;
        this.nombre = nombre;
        t = new Thread(this, nombre);
        t.start();
    }
    public void run() {
        System.out.println("Hola la hebra: "+ nombre + " \nla suma es: " + (a + b));
    }
    
}