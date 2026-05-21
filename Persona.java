/**
 * Representa una persona del sistema bancario.
 * Contiene datos básicos compartidos por clientes y empleados.
 * * @author Bravo Guadalupe, Suarez Martin
 * @version 2.0
 */
public class Persona {

    //Atributos
    private int dni;
    private String nombre;
    private Cuenta cuentaPesos;
    private Cuenta cuentaDolares;

    /**
     * Constructor de Persona
     * @throws IllegalArgumentException si el dni es negativo o cero, el nombre es nulo o vacío
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Persona(int dni, String nombre, int numCtaPesos, int numCtaDolares) {
        if (dni <= 0) {
            throw new IllegalArgumentException("El DNI debe ser un número positivo.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.dni = dni;
        this.nombre = nombre;
        // Toda persona nace con sus dos cuentas asignadas automáticamente
        this.cuentaPesos = new Cuenta("pesos", 0.0f, numCtaPesos);
        this.cuentaDolares = new Cuenta("dolares", 0.0f, numCtaDolares);
    }

    public Persona() {
        this.dni = 0;
        this.nombre = "";
        this.cuentaPesos = new Cuenta();
        this.cuentaDolares = new Cuenta();
    }

    // Getters
    public int getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Cuenta getCuentaPesos() {
        return this.cuentaPesos;
    }

    public Cuenta getCuentaDolares() {
        return this.cuentaDolares;
    }

    /**
     * Setters
     * @throws IllegalArgumentException si el dni es negativo o el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        if (dni <= 0) {
            throw new IllegalArgumentException("El dni debe ser un numero positivo.");
        }
        this.dni = dni;
    }

    public void setCuentaPesos(Cuenta cuentaPesos) {
        this.cuentaPesos = cuentaPesos;
    }

    public void setCuentaDolares(Cuenta cuentaDolares) {
        this.cuentaDolares = cuentaDolares;
    }

    /**
     * Muestra el saldo de la cuenta correspondiente al tipo de moneda ingresado
     *
     * @throws IllegalArgumentException si el tipo de moneda es nulo o vacio
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void mostrarCuenta(String tipoDeMoneda) {
        if (tipoDeMoneda == null || tipoDeMoneda.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de moneda no puede estar vacío.");
        }
        if (tipoDeMoneda.equalsIgnoreCase("pesos")) {
            System.out.println("Cuenta en pesos: " + cuentaPesos.getSaldo());
        } else if (tipoDeMoneda.equalsIgnoreCase("dolares")) {
            System.out.println("Cuenta en dolares: " + cuentaDolares.getSaldo());
        } else {
            System.out.println("Tipo de moneda no reconocido.");
        }
    }
}