public class Main {
    
    public static void main(String[] args) {
        String nombre_cliente = "";
        while (!nombre_cliente.equals("Salir")) {
            System.out.println("Ingrese Nombre de Cliente:"
            + "\n(para salir ingrese \"Salir\")");
            try {
                nombre_cliente = System.console().readLine();
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida!");
                nombre_cliente = "";
            }
            Cliente test = new Cliente(nombre_cliente);
        }
    }
}