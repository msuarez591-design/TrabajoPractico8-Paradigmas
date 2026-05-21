/**
 * Representa un cliente del banco.
 * * @author Bravo Guadalupe, Suarez Martin
 * @version 2.0
 */
public class Cliente extends Persona {

    //Atributos
    private String tipoCliente; // Plata, Oro, Platino
    private int anioIngreso;
    private String estado; // ACTIVO o BAJA
    private Tarjeta tarjeta; // Puede ser null si es PLATA

    /**
     * Constructor de Cliente
     * @throws IllegalArgumentException si el tipo de cliente es null o vacio,
     * el anio de ingreso es negativo, el estado es null o vacio
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Cliente(int dni, String nombre, String tipoCliente, int anioIngreso, String estado, int numCtaPesos, int numCtaDolares) {
        super(dni, nombre, numCtaPesos, numCtaDolares);
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
        this.tarjeta = null; 
    }

    public Cliente() {
        super();
        this.tipoCliente = "";
        this.anioIngreso = 0;
        this.estado = "ACTIVO";
        this.tarjeta = null;
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

    public Tarjeta getTarjeta() {
        return this.tarjeta;
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

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}