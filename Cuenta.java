public class Cuenta{
    //Atributos
    private String tipoDeMoneda;
    private Float saldo;
    /**
     * Constructor de Cuenta
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Cuenta(String tipoDeMoneda, Float saldo){
        this.tipoDeMoneda = tipoDeMoneda;
        this.saldo = saldo;
    }
    public Cuenta(){
        this.tipoDeMoneda = "";
        this.saldo = 0.0f;
    }
    //Getters y setters
    public String getTipoDeMoneda(){
        return this.tipoDeMoneda;
    }
    public void setTipoDeMoneda(String tipoDeMoneda){
        this.tipoDeMoneda = tipoDeMoneda;
    }
    public Float getSaldo(){
        return this.saldo;
    }
    public void setSaldo(Float saldo){
        this.saldo = saldo;
    }
}