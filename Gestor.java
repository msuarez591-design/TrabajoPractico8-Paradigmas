import java.util.ArrayList;

/**
 * Orquestador principal del sistema del Banco IUA. Contiene las colecciones de datos.
 * * @author Bravo Guadalupe, Suarez Martin
 * @version 2.0
 */
public class Gestor {

    //Atributos
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Transacciones> listaTransacciones;
    private ArchivoCliente archCliente;
    private ArchivoTransacciones archTransaccion;

    /**
     * Constructor parametrizado de Gestor
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Gestor(ArrayList<Cliente> listaClientes, ArrayList<Transacciones> listaTransacciones, ArchivoCliente archCliente, ArchivoTransacciones archTransaccion) {
        this.listaClientes = listaClientes;
        this.listaTransacciones = listaTransacciones;
        this.archCliente = archCliente;
        this.archTransaccion = archTransaccion;
    }

    public Gestor(){
        this.listaClientes = new ArrayList<>();
        this.listaTransacciones = new ArrayList<>();
        this.archCliente = new ArchivoCliente();
        this.archTransaccion = new ArchivoTransacciones();
    }

    /**
     * Metodo para agregar un cliente a la lista de clientes
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void agregarCliente(Cliente cliente){
        this.listaClientes.add(cliente);
    }

    /**
     * Metodo para buscar un cliente por su DNI en la lista de clientes
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Cliente buscarClientePorDni(int dni){ 
        for (Cliente c : listaClientes) {
            if (c.getDni() == dni) {
                return c;
            }
        }
        return null; // Retorna null si no lo encuentra para manejarlo ordenadamente
    }

    /**
     * Metodo para buscar un cliente por cualquiera de sus números de cuenta (Pesos o Dólares)
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Cliente buscarClientePorCuenta(int numeroCuenta) {
        for (Cliente c : listaClientes) {
            if (c.getCuentaPesos().getNumeroCuenta() == numeroCuenta ||
                c.getCuentaDolares().getNumeroCuenta() == numeroCuenta) {
                return c;
            }
        }
        return null;
    }

    /**
     * Metodo para asignar una tarjeta a un cliente según su tipo de cliente.
     * Lanza una excepcion si el cliente no existe.
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void asignarTarjeta(int dni){
        Cliente c = buscarClientePorDni(dni);
        if (c == null) {
            throw new IllegalArgumentException("Cliente no encontrado con DNI: " + dni);
        }

        if (c.getTipoCliente().equalsIgnoreCase("ORO")) {
            c.setTarjeta(new Tarjeta("Credix", 250000));
        } else if (c.getTipoCliente().equalsIgnoreCase("PLATINO")) {
            c.setTarjeta(new Tarjeta("Premium", 500000));
        } else if (c.getTipoCliente().equalsIgnoreCase("PLATA")) {
            System.out.println("El cliente " + c.getNombre() + " es tipo PLATA. No tiene acceso a tarjeta de crédito.");
        } else {
            throw new IllegalArgumentException("Tipo de cliente no válido para asignar tarjeta: " + c.getTipoCliente());
        }
    }

    /**
     * Metodo para realizar un depósito en la cuenta de un cliente, identificando el número de cuenta y guardando la transacción
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void depositar(int numeroCuenta, double monto){
        Cliente c = buscarClientePorCuenta(numeroCuenta);
        if (c == null) {
            throw new IllegalArgumentException("Cuenta no encontrada con número: " + numeroCuenta);
        }

        if (c.getCuentaPesos().getNumeroCuenta() == numeroCuenta) {
            c.getCuentaPesos().depositar((float)monto);
        } else {
            c.getCuentaDolares().depositar((float)monto);
        }

        listaTransacciones.add(new Transacciones("2026-05-21", "DEPOSITO", numeroCuenta, monto, c.getDni()));
    }

    /**
     * Metodo para realizar una extracción en la cuenta de un cliente, validando el número de cuenta, el monto a extraer y el saldo disponible
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void extraer(int numeroCuenta, double monto){
        Cliente c = buscarClientePorCuenta(numeroCuenta);
        if (c == null) {
            throw new IllegalArgumentException("Cuenta no encontrada con número: " + numeroCuenta);
        }

        if (c.getCuentaPesos().getNumeroCuenta() == numeroCuenta) {
            c.getCuentaPesos().retirar((float)monto);
        } else {
            c.getCuentaDolares().retirar((float)monto);
        }

        listaTransacciones.add(new Transacciones("2026-05-21", "EXTRACCION", numeroCuenta, monto, c.getDni()));
    }

    /**
     * Metodo para listar todos los clientes registrados en el sistema, mostrando su DNI, nombre, tipo de cliente y estado
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void listarClientes() {
        for (Cliente c : listaClientes) {
            System.out.println(
                "DNI: " + c.getDni() +
                " | Nombre: " + c.getNombre() +
                " | Tipo: " + c.getTipoCliente() +
                " | Estado: " + c.getEstado()
            );
        }
    }

    /**
     * Metodo para guardar clientes y transacciones en sus respectivos archivos de texto
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void guardarDatos() {
        archCliente.guardarClientes(listaClientes);
        archTransaccion.guardarTransacciones(listaTransacciones);
    }

    /**
     * Da de baja a un cliente cambiando su estado a "BAJA"
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void darDeBajaCliente(int dni) {
        Cliente c = buscarClientePorDni(dni);
        if (c != null) {
            c.setEstado("BAJA");
            System.out.println("El cliente " + c.getNombre() + " ha sido dado de baja.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    /**
     * Lista las transacciones de un cliente específico
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void listarTransaccionesPorCliente(int dni) {
        System.out.println("--- Transacciones del DNI: " + dni + " ---");
        for (Transacciones t : listaTransacciones) {
            if (t.getDniPersona() == dni) {
                System.out.println("Fecha: " + t.getFecha() + " | Tipo: " + t.getTipo() + " | Monto: $" + t.getMonto());
            }
        }
    }

    /**
     * Informe de transacciones filtrado por un mes específico (Ej: "05" para Mayo)
     * Asume formato de fecha "YYYY-MM-DD"
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin   
     */
    public void informeTransaccionesPorMes(String mes) {
        System.out.println("--- Transacciones del Mes: " + mes + " ---");
        for (Transacciones t : listaTransacciones) {
            String[] partesFecha = t.getFecha().split("-");
            if (partesFecha.length >= 2 && partesFecha[1].equals(mes)) {
                System.out.println(t.getFecha() + " | " + t.getTipo() + " | $" + t.getMonto());
            }
        }
    }

    /**
     * Informe de transacciones filtrado por un año específico (Ej: "2024")
     * Asume formato de fecha "YYYY-MM-DD"
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void informeTransaccionesPorAnio(String anio) {
        System.out.println("--- Transacciones del Año: " + anio + " ---");
        for (Transacciones t : listaTransacciones) {
            if (t.getFecha().startsWith(anio)) {
                System.out.println(t.getFecha() + " | " + t.getTipo() + " | $" + t.getMonto());
            }
        }
    }

    /**
     * Informe de todas las transacciones registradas
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void informeTodasLasTransacciones() {
        System.out.println("--- TODAS LAS OPERACIONES ---");
        for (Transacciones t : listaTransacciones) {
            System.out.println("Fecha: " + t.getFecha() + " | DNI: " + t.getDniPersona() + " | " + t.getTipo() + " | $" + t.getMonto());
        }
    }
}