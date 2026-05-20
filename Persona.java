/**
 * Representa una persona del sistema bancario.
 * Contiene datos básicos compartidos por clientes y empleados.
 */
public class Persona {
    protected String dni;
    protected String nombre;

    /**
     * Constructor de Persona
     */
    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    // Getters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}