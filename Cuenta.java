/**
 * Representa una cuenta bancaria (Caja de Ahorros).
 * * @author Bravo Guadalupe, Suarez Martin
 * @version 1.0
 */
public class Cuenta {
    //Atributos
    private String tipoDeMoneda;
    private Float saldo;
    private int numeroCuenta;

    /**
     * Constructor de Cuenta
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Cuenta(String tipoDeMoneda, Float saldo, int numeroCuenta){
        this.tipoDeMoneda = tipoDeMoneda;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public Cuenta(){
        this.tipoDeMoneda = "";
        this.saldo = 0.0f;
        this.numeroCuenta = 0;
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

    public int getNumeroCuenta(){
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta){
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Metodo para depositar dinero en la cuenta, lanza una excepcion si el monto es negativo o cero
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void depositar(Float monto){
        if(monto > 0){
            this.saldo += monto;
        } else {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
    }

    /**
     * Metodo para retirar dinero de la cuenta, lanza una excepcion si el saldo es insuficiente o el monto es inválido
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void retirar(Float monto){
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if(this.saldo >= monto){
            this.saldo -= monto;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para retirar el monto solicitado.");     
        }
    }
}