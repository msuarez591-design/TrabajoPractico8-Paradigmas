
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
}
