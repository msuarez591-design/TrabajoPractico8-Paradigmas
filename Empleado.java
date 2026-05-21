
/**
 * Representa un empleado del banco.
 */
public class Empleado extends Persona {

    //Atributos
    private String cargo;

    /**
     * Constructor de Empleado
     * @throws IllegalArgumentException si el cargo es null o vacio
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Empleado(Integer dni, String nombre, Float saldo, int numeroCuenta, String cargo, String tipoDeMoneda) {
        super(dni, nombre, tipoDeMoneda, saldo, numeroCuenta);
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("El cargo no puede estar vacio.");
        }
        this.cargo = cargo;
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
