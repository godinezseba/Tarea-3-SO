package Pregunta_2;

import java.util.LinkedList;

public class Main {
    public static class Tienda {
        String cliente;
        LinkedList<Producto> compras;
        int estado;
        Producto producto;
        boolean termino;

        public Tienda(){
            this.compras = new LinkedList<>();
            this.estado = 0;
            this.cliente = "";
            this.termino = false;
        }

        public void cierro() throws InterruptedException{
            synchronized(this){
                this.termino = true;
                notifyAll();
            }
        }

        public void cliente() throws InterruptedException{
            synchronized(this){
                this.estado = 1;
                notifyAll();
                while (!(this.estado == 0)) 
                    wait();
                
            }
        }

        public void promotor() throws InterruptedException{
            int opcion;
            while (true) {
                synchronized (this){
                    while(!(estado == 1)){
                        wait(5);
                        if(termino)
                            System.exit(0);
                    }
                    
                    System.out.println("Promotor: Hola! " +this.cliente+", tengo los siguiente productos para ofrecerte:"+
                    "\n-Zapatos $20000 (1)"+ 
                    "\n-Jeans   $10000 (2)"+
                    "\n-Polera  $5000  (3)"+
                    "\n-Ninguno       (-1)");
                    try {
                        opcion = Integer.parseInt(System.console().readLine());
                    } catch (Exception e) {
                        System.err.println("Error al ingresar un producto");
                        opcion = -1;
                    }
                    if(opcion < 4 && opcion > 0){
                        switch (opcion) {
                            case 1:
                                this.producto = new Producto(this.cliente, "Zapatos");
                                break;
                            case 2:
                                this.producto = new Producto(this.cliente, "Jeans");
                                break;
                            case 3:
                                this.producto = new Producto(this.cliente, "Polera");
                                break;
                            default:
                                break;
                        }
                        this.estado = 2; 
                        notifyAll();
                    }
                    else{
                        this.estado = 0;
                        notifyAll();
                    }
                    while (!(estado == 0)) {
                        wait(5);
                    }
                    System.out.println("Promotor: Gracias! Vuelva pronto!");
                }
            }
        }

        public void cajero() throws InterruptedException{
            int opcion;
            while (true) {
                synchronized(this){
                    while(!(estado == 2)){
                        wait(5);
                        if(termino)
                            System.exit(0);
                    }
                    System.out.println("Cajero: Como pagara?:"+
                    "\n-Efectivo (1)"+
                    "\n-Tarjeta  (2)");
                    try {
                        opcion = Integer.parseInt(System.console().readLine());
                    } catch (Exception e) {
                        System.err.println("Error al ingresar un metodo de pago!");
                        opcion = -1;
                    }
                    switch (opcion) {
                        case 1:
                            producto.setPago("Efectivo");
                            break;
                        case 2:
                            producto.setPago("Tarjeta");
                        default:
                            break;
                    }
                    this.estado = 3;
                    notifyAll();
                    while (!(estado == 2)) {
                        wait(5);
                    }
                    System.out.println("Cajero: Serian: " + producto.total);
                    compras.addLast(producto);
                    System.out.println("Cajero: Gracias!");
                    this.estado = 0;
                    notifyAll();
                }
            }
        }

        public void empaquetador() throws InterruptedException{
            int opcion;
            while (true) {
                synchronized(this){
                    while(!(estado == 3)){
                        wait(5);
                        if(termino)
                            System.exit(0);
                    }
                    System.out.println("Empaquetador: Que tipo de bolsa desea?:"+
                    "\n-Plastico $500 (1)"+
                    "\n-Tela     $200 (2)"+
                    "\n-Ninguno       (3)");

                    try {
                        opcion = Integer.parseInt(System.console().readLine());
                    } catch (Exception e) {
                        System.err.println("Error al ingresar un valor!");
                        opcion = -1;
                    }
                    switch (opcion) {
                        case 1:
                            producto.setBolsa("Plastico");
                            break;
                        case 2:
                            producto.setBolsa("Tela");
                            break;
                        case 3:
                            producto.setBolsa("Ninguno");
                            break;
                        default:
                            break;
                    }
                    this.estado = 2;
                    notifyAll();
                    while (!(estado == 0)) {
                        wait(5);
                    }
                    System.out.println("Empaquetador: Gracias por venir!");
                }
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        final Tienda tienda = new Tienda();
        Thread cliente;
        Thread promotor = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    tienda.promotor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        promotor.setName("Promotor");
        promotor.start();
        Thread cajero = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try {
                    tienda.cajero();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        cajero.setName("Cajero");
        cajero.start();
        Thread empaquetador = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try {
                    tienda.empaquetador();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        empaquetador.setName("Empaquetador");
        empaquetador.start();
        System.out.println("Ingrese Nombre de Cliente:"
            + "\n(para salir ingrese \"Salir\")");
            try {
                tienda.cliente = System.console().readLine();
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida!");
                tienda.cliente = "Salir";
            }
        while (!tienda.cliente.equals("Salir")) {
            cliente = new Thread(new Runnable() {
            
                @Override
                public void run() {
                    try {
                        tienda.cliente();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            cliente.setName("Cliente");
            cliente.start();
            cliente.join();
            
            for (Producto var : tienda.compras) {
                System.out.println(var);
            }

            System.out.println("Ingrese Nombre de Cliente:"
            + "\n(para salir ingrese \"Salir\")");
            try {
                tienda.cliente = System.console().readLine();
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida!");
                tienda.cliente = "Salir";
            }
        }
        tienda.cierro();
        promotor.join();
        cajero.join();
        empaquetador.join();
    }
}