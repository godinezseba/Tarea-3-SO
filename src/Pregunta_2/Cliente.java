public class Cliente implements Runnable{
    volatile String nombre;
    private Thread t;
    public Cliente(String nombre){
        this.nombre = nombre;
        t = new Thread(this, nombre);
        t.start();
    }
    public void run(){
        System.out.println("Hola soy: " + nombre);
    }
}