/**
 * Representa un empleado del banco.
 * * @author Bravo Guadalupe, Suarez Martin
 * @version 2.0
 */
public class Empleado extends Persona {

    //Atributos
    private String cargo;

    /**
     * Constructor de Empleado
     * @throws IllegalArgumentException si el cargo es null o vacio
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Empleado(int dni, String nombre, String cargo, int numCtaPesos, int numCtaDolares) {
        super(dni, nombre, numCtaPesos, numCtaDolares);
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("El cargo no puede estar vacio.");
        }
        this.cargo = cargo;
    }

    public Empleado() {
        super();
        this.cargo = "";
    }

    //Getters y setters
    public String getCargo() {
        return this.cargo;
    }

    /**
     * @throws IllegalArgumentException si el cargo es null o vacio
     */
    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("El cargo no puede estar vacio.");
        }
        this.cargo = cargo;
    }
}