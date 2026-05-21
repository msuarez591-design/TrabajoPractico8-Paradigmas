
/**
 * Representa un cliente del banco.
 */
public class Cliente extends Persona {

    //Atributos
    private String tipoCliente; // Plata, Oro, Platino
    private int anioIngreso;
    private String estado; // ACTIVO o BAJA

    /**
     * Constructor de CLiente
     * @throws IllegalArgumentException si el tipo de cliente es null o vacio,
     * el anio de ingreso es negativo, el estado es null o vacio
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Cliente(int dni, String nombre, String tipoCliente, int anioIngreso, String estado, String tipoDeMoneda, Float saldo, int numeroCuenta) {
        super(dni, nombre, tipoDeMoneda, saldo, numeroCuenta);
        if (tipoCliente == null || tipoCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de cliente no puede estar vacío.");
        }
        if (anioIngreso < 0) {
            throw new IllegalArgumentException("El año de ingreso no puede ser negativo.");
        }
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }
        this.tipoCliente = tipoCliente;
        this.anioIngreso = anioIngreso;
        this.estado = estado;
    }

    //Getters
    public String getTipoCliente() {
        return this.tipoCliente;
    }
    public int getAnioIngreso() {
        return this.anioIngreso;
    }
    public String getEstado() {
        return this.estado;
    }
    /**
     * Setters
     * @throws IllegalArgumentException si el tipo de cliente es null o vacio, el anio de ingreso es negativo, el estado es null o vacio
     */
    public void setTipoCliente(String tipoCliente){
        if(tipoCliente == null || tipoCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de cliente no puede estar vacío.");
        }
        this.tipoCliente = tipoCliente;
    }
    public void setAnioIngreso(int anioIngreso){
        if(anioIngreso < 0) {
            throw new IllegalArgumentException("El año de ingreso no puede ser negativo.");
        }
        this.anioIngreso = anioIngreso;
    }
    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }
        this.estado = estado;
    }
}
