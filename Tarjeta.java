/**
 * Representa una tarjeta de crédito del banco asociada a un cliente.
 * * @author Bravo Guadalupe, Suarez Martin
 * @version 1.0
 */
public class Tarjeta {
    //Atributos
    private String tipo;
    private double limite;

    /**
     * Constructor de Tarjeta
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Tarjeta(String tipo, double limite){
        this.tipo = tipo;
        this.limite = limite;
    }

    public Tarjeta(){
        this.tipo = "";
        this.limite = 0.0;
    }

    //Getters y setters
    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public double getLimite(){
        return this.limite;
    }

    public void setLimite(double limite){
        this.limite = limite;
    }
}