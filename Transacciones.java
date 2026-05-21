/**
 * Representa una transacción bancaria (Depósito o Extracción).
 * * @author Bravo Guadalupe, Suarez Martin
 * @version 1.0
 */
public class Transacciones {
    //Atributos
    private String fecha;
    private String tipo;
    private Integer numeroCuenta;
    private double monto;
    private Integer dniPersona;

    /**
     * Constructor de Transacciones que valida el tipo de transacción, el monto, el número de cuenta y el DNI de la persona
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Transacciones(String fecha, String tipo, Integer numeroDeCuenta, double monto, Integer dniPersona){
        if (!tipo.equals("DEPOSITO") && !tipo.equals("EXTRACCION")) {
            throw new IllegalArgumentException("El tipo de transacción debe ser 'DEPOSITO' o 'EXTRACCION'.");
        } else if (monto <= 0) {
            throw new IllegalArgumentException("El monto de la transacción debe ser positivo.");
        } else if (numeroDeCuenta <= 0) {
            throw new IllegalArgumentException("El número de cuenta debe ser un entero positivo.");
        } else if (dniPersona <= 0) {
            throw new IllegalArgumentException("El DNI de la persona debe ser un entero positivo.");
        }
        this.fecha = fecha;
        this.tipo = tipo;
        this.numeroCuenta = numeroDeCuenta;
        this.monto = monto;
        this.dniPersona = dniPersona;
    }

    public Transacciones(){
        this.fecha = "";
        this.tipo = "";
        this.numeroCuenta = 0;
        this.monto = 0.0;
        this.dniPersona = 0;
    }

    //Getters y setters
    public String getFecha(){
        return this.fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public Integer getNumeroDeCuenta(){
        return this.numeroCuenta;
    }

    public void setNumeroDeCuenta(Integer numeroDeCuenta){
        this.numeroCuenta = numeroDeCuenta;
    }

    public double getMonto(){
        return this.monto;
    }

    public void setMonto(double monto){
        this.monto = monto;
    }

    public Integer getDniPersona(){
        return this.dniPersona;
    }

    public void setDniPersona(Integer dniPersona){
        this.dniPersona = dniPersona;
    }
}