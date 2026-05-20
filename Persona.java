/**
 * Representa una persona del sistema bancario.
 * Contiene datos básicos compartidos por clientes y empleados.
 */
public class Persona {
    private int dni;
    private String nombre;

    /**
     * Constructor de Persona
     */
    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }
    public Persona() {
        this.dni = 0;
        this.nombre = "";
    }

    // Getters
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
}