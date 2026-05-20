/**
 * Representa un empleado del banco.
 */
public class Empleado extends Persona {
    private String cargo;

    public Empleado(int dni, String nombre, String cargo) {
        super(dni, nombre);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}