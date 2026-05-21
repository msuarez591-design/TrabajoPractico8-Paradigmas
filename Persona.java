/**
 * Representa una persona del sistema bancario.
 * Contiene datos básicos compartidos por clientes y empleados.
 */
public class Persona {
    private int dni;
    private String nombre;
    private Cuenta cuentaPesos;
    private Cuenta cuentaDolares;

     /**
     * Constructor de Persona
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Persona(int dni, String nombre,String tipoDeMoneda, Float saldo, int numeroCuenta) {
        if (dni <= 0) {
            throw new IllegalArgumentException("El DNI debe ser un número positivo.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.cuentaPesos = new Cuenta(tipoDeMoneda, saldo, numeroCuenta);
        this.cuentaDolares = new Cuenta(tipoDeMoneda, saldo, numeroCuenta);
    }
    public Persona() {
        this.dni = 0;
        this.nombre = "";
        this.cuentaPesos = new Cuenta();
        this.cuentaDolares = new Cuenta();
    }

    // Getters
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Cuenta getCuentaPesos() {
            return cuentaPesos;
    }

    public Cuenta getCuentaDolares() {
            return cuentaDolares;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setCuentaPesos(Cuenta cuentaPesos) {
        this.cuentaPesos = cuentaPesos;
    }

    public void setCuentaDolares(Cuenta cuentaDolares) {
        this.cuentaDolares = cuentaDolares;
    }

    //metodo
    public void getCuenta(String tipoDeMoneda){
        if(tipoDeMoneda.equalsIgnoreCase("pesos")){
            System.out.println("Cuenta en pesos: " + cuentaPesos.getSaldo());
        } else if(tipoDeMoneda.equalsIgnoreCase("dolares")){
            System.out.println("Cuenta en dolares: " + cuentaDolares.getSaldo());
        } else {
            System.out.println("Tipo de moneda no reconocido.");
        }
    }
}