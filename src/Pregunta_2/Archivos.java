package Pregunta_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Archivos
 */
public class Archivos {

    public void log_cliente(FileWriter file, String cliente) {
        try {
            file.write("["+java.time.LocalDateTime.now()+"] Esta siendo atendido: " + cliente);
        } catch (IOException e) {
            System.err.println("Error al escribir sobre el archivo log_cliente.txt");
        }
    }

    public void log_promotor(FileWriter file, LinkedList<Producto> productos) {
        try {
            file.write("["+java.time.LocalDateTime.now()+"] Clientes atendidos:");
        } catch (IOException e) {
            System.err.println("Error al escribir sobre el archivo log_cliente.txt");
        }
        for (Producto var : productos) {
            try {
                file.write("Cliente: " + var.cliente + ", compro: " + var.producto );
            } catch (IOException e) {
                System.err.println("Error al escribir sobre el archivo log_cliente.txt");
            }
        }
    }

    public void log_cajero(FileWriter file, LinkedList<Producto> productos) {
        System.out.println("hola");
    }

    public void log_empaquetador(FileWriter file, LinkedList<Producto> productos) {
        System.out.println("hola");
    }

}