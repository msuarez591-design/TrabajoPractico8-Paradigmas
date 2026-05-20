/**
 * Representa un cliente del banco.
 */
public class Cliente extends Persona {
    private String tipoCliente; // Plata, Oro, Platino
    private int anioIngreso;
    private String estado; // ACTIVO o BAJA

    public Cliente(String dni, String nombre, String tipoCliente, int anioIngreso, String estado) {
        super(dni, nombre); // ← clave: llama al constructor de Persona
        this.tipoCliente = tipoCliente;
        this.anioIngreso = anioIngreso;
        this.estado = estado;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}