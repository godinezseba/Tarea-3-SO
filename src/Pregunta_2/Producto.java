package Pregunta_2;

/**
 * Producto
 */
public class Producto {

    String cliente;
    String producto;
    String bolsa;
    int total;
    String pago;

    public Producto(String cliente, String producto){
        this.cliente =  cliente;
        this.producto = producto;
        switch (producto) {
            case "Zapatos":
                this.total = 20000;
                break;
            case "Jeans":
                this.total = 15000;
                break;
            case "Polera":
                this.total = 5000;
                break;
            default:
                break;
        }
    }

    public void setPago(String pago){
        this.pago = pago;
    }

    public void setBolsa(String bolsa){
        this.bolsa = bolsa;
        switch (bolsa) {
            case "Plastico":
                this.total += 500;
                break;
            case "Tela":
                this.total += 200;
            default:
                break;
        }
    }

    public String toString(){
        return "Cliente: " +this.cliente+ ",\nCompro " +this.producto+ 
        " con " +this.pago+ "\nBolsa: " + this.bolsa +"\nTotal: " + this.total;
    }
}