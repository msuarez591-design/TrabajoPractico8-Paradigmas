public class Tarjeta{
    //Atributos
    private String tipo;
    private Float limite;
    /**
     * Constructor de Tarjeta
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Tarjeta(String tipo, Float limite){
        this.tipo = tipo;
        this.limite = limite;
    }
    public Tarjeta(){
        this.tipo = "";
        this.limite = 0.0f;
    }
    //Getters y setters
    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public Float getLimite(){
        return this.limite;
    }
    public void setLimite(Float limite){
        this.limite = limite;
    }
}