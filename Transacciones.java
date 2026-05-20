public class Transacciones{
    //Atributos
    private String fecha;
    private String tipo;
    private Integer numeroDeCuenta;
    /**
     * Constructor de Transacciones
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Transacciones(String fecha, String tipo, Integer numeroDeCuenta){
        this.fecha = fecha;
        this.tipo = tipo;
        this.numeroDeCuenta = numeroDeCuenta;
    }
    public Transacciones(){
        this.fecha = "";
        this.tipo = "";
        this.numeroDeCuenta = 0;
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
        return this.numeroDeCuenta;
    }
    public void setNumeroDeCuenta(Integer numeroDeCuenta){
        this.numeroDeCuenta = numeroDeCuenta;
    }
}