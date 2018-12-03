package Pregunta_2;

import java.io.FileWriter;
import java.util.LinkedList;

public class Main {
    
    public static void main(String[] args) throws InterruptedException{
        final Tienda tienda = new Tienda();
        Thread cliente;
        FileWriter file = new FileWriter("log_cliente.txt");
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
                        tienda.cliente(file);
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
        file.close();
    }
}