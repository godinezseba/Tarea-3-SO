package Pregunta_2;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        String nombre_cliente = "";

        while (!nombre_cliente.equals("salir")) {
            System.out.println("Ingrese Nombre de Cliente:"
            + "\n(para salir ingrese \"Salir\")");
            try {
                nombre_cliente = System.console().readLine();
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida!");
                nombre_cliente = "";
            }
            System.out.println(nombre_cliente);
        }
    }
}