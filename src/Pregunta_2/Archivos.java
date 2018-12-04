package Pregunta_2;

import java.io.IOException;
import java.util.LinkedList;
import java.io.PrintStream;
import java.io.FileOutputStream;

/**
 * Archivos
 */
public class Archivos {

    public void log_cliente(String cliente) {
        try {
            PrintStream file = new PrintStream(new FileOutputStream("log_cliente.txt", true));
            file.println("["+java.time.LocalDateTime.now()+"] Esta siendo atendido: " + cliente);
            file.close();
        } catch (IOException e) {
            System.err.println("Error al escribir sobre el archivo log_cliente.txt");
        }
    }

    public void log_promotor(LinkedList<Producto> productos) {
        try {
            PrintStream file = new PrintStream(new FileOutputStream("log_promotor.txt", true));
            file.println("["+java.time.LocalDateTime.now()+"] Clientes atendidos:");
            for (Producto var : productos) {
                file.println("Cliente: " + var.cliente + ", compro: " + var.producto );
            }
            file.close();
        } catch (IOException e) {
            System.err.println("Error al escribir sobre el archivo log_promotor.txt");
        }
    }

    public void log_cajero(LinkedList<Producto> productos) {
        try {
            PrintStream file = new PrintStream(new FileOutputStream("log_cajero.txt", true));
            file.println("["+java.time.LocalDateTime.now()+"] Clientes atendidos:");
            for (Producto var : productos) {
                file.println("Cliente: " + var.cliente + ", compro: " + var.producto +" pago con: "+ var.pago);
            }
            file.close();
        } catch (IOException e) {
            System.err.println("Error al escribir sobre el archivo log_promotor.txt");
        }
    }

    public void log_empaquetador(LinkedList<Producto> productos) {
        try {
            PrintStream file = new PrintStream(new FileOutputStream("log_empaquetador.txt", true));
            file.println("["+java.time.LocalDateTime.now()+"] Clientes atendidos:");
            for (Producto var : productos) {
                file.println("Cliente: " + var.cliente + ", llevo bolsa: " + var.bolsa);
            }
            file.close();
        } catch (IOException e) {
            System.err.println("Error al escribir sobre el archivo log_promotor.txt");
        }
    }

}