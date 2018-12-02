package Pregunta_2;

public class Main {
    class Cliente implements Runnable{
        volatile String nombre;
        private Thread t;
        public Cliente(String nombre){
            this.nombre = nombre;
            t = new Thread(this, nombre);
        }
        public void StartThread(){
            this.t.start();
        }
        public void setnombre(String nombre){ this.nombre = nombre; }
        public void run(){
            System.out.println("Hola soy: " + nombre);
        }
    }
    

    class Promotor implements Runnable{
        private Thread t;
        public Promotor(){
            t = new Thread(this);
            t.start();
        }
        public void run(){
            System.out.println("Hola: " + cliente.nombre);
        }
        
    }
    public static void main(String[] args) {
        final Cliente cliente = new Cliente("");
        Promotor promotor = new Promotor();
        while (!nombre_cliente.equals("Salir")) {
            System.out.println("Ingrese Nombre de Cliente:"
            + "\n(para salir ingrese \"Salir\")");
            try {
                cliente.setnombre(System.console().readLine());
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida!");
                cliente.setnombre("");
            }
            cliente.StartThread();
        }
    }
}