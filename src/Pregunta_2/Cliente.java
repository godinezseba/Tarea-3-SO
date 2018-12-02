package Pregunta_2;

public class Cliente implements Runnable{
    volatile String nombre;
    private Thread t;
    public Cliente(String nombre){
        this.nombre = nombre;
        t = new Thread(this, nombre);
    }
    public void StartThread(){
        this.t.start();
    }
    public void run(){
        System.out.println("Hola soy: " + nombre);
    }
}