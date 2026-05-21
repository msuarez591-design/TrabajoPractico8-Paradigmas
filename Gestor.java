
import java.util.ArrayList;

public class Gestor {

    //Atributos
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Transacciones> listaTransacciones;
    private ArchivoCliente archCliente;
    private ArchivoTransacciones archTransaccion;

    /**
     * Constructor de Gestor
     *
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
     *
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void agregarCliente(Cliente cliente){
        this.listaClientes.add(cliente);
    }
     /**
     * Metodo para buscar un cliente por su DNI en la lista de clientes, se lanza una excepcion si el cliente no existe
     *
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public Cliente buscarCliente(Integer dni){
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        throw new IllegalArgumentException("Cliente no encontrado con DNI: " + dni);
    }
     /**
     * Metodo para asignar una tarjeta a un cliente según su tipo de cliente se lanza una excepcion si el cliente no existe o si el tipo de cliente no es válido
     *
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void asignarTarjeta(Integer dni){
         Cliente c = buscarCliente(dni);

        if (c != null) {
            if (c.getTipoCliente().equalsIgnoreCase("ORO")) {
                c.setTarjeta(new Tarjeta("Credix", 250000));
            } else if (c.getTipoCliente().equalsIgnoreCase("PLATINO")) {
                c.setTarjeta(new Tarjeta("Premium", 500000));
            }
        } else {
            throw new IllegalArgumentException("Cliente no encontrado con DNI: " + dni);
        }
    }
      /**
     * Metodo para realizar un depósito o extracción en la cuenta de un cliente, validando el número de cuenta y el monto a transaccionar
     *
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void depositar(Integer numeroCuenta, double monto){
        Cliente c = buscarClientePorCuenta(numeroCuenta);
        if (c != null) {
            c.getCuenta().setSaldo(c.getCuenta().getSaldo() + monto);
            Transacciones t = new Transacciones("2024-06-01", "DEPOSITO", numeroCuenta, monto, c.getDni());
            listaTransacciones.add(t);
        } else {
            throw new IllegalArgumentException("Cuenta no encontrada con número: " + numeroCuenta);
        }
    }
       /**
     * Metodo para realizar una extracción en la cuenta de un cliente, validando el número de cuenta, el monto a extraer y el saldo disponible en la cuenta
     *
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void extraer(Integer numeroCuenta, double monto){
        Cliente c = buscarClientePorCuenta(numeroCuenta);
        if (c != null) {
            if (c.getCuenta().getSaldo() >= monto) {
                c.getCuenta().setSaldo(c.getCuenta().getSaldo() - monto);
                Transacciones t = new Transacciones("2024-06-01", "EXTRACCION", numeroCuenta, monto, c.getDni());
                listaTransacciones.add(t);
            } else {
                throw new IllegalArgumentException("Saldo insuficiente en la cuenta número: " + numeroCuenta);
            }
        } else {
            throw new IllegalArgumentException("Cuenta no encontrada con número: " + numeroCuenta);
        }
    }
       /**
     * Metodo para guardar clientes y transacciones en sus respectivos archivos
     *
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void guardarDatos() {
        archCliente.guardarClientes(listaClientes);
        archTransaccion.guardarTransacciones(listaTransacciones);
    }
}
