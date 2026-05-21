import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Encargada de persistir los datos de los clientes en un archivo de texto.
 * * @author Bravo Guadalupe, Suarez Martin
 * @version 1.0
 */
public class ArchivoCliente {
    //Atributo
    private File archivoClient;

    /**
     * Constructor de ArchivoCliente
     * @throws RuntimeException si la ruta del archivo es null o vacia
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public ArchivoCliente(String rutaArchivo){
        if (rutaArchivo == null || rutaArchivo.trim().isEmpty()) {
            throw new RuntimeException("La ruta del archivo no puede estar vacía.");
        }
        this.archivoClient = new File(rutaArchivo);
    }

    public ArchivoCliente(){
        this.archivoClient = new File("clientes.txt");
    }

    //Getters y setters
    public File getArchivoClient(){
        return this.archivoClient;
    }

    public void setArchivoClient(File archivoClient){
        if (archivoClient == null) {
            throw new RuntimeException("El archivo no puede ser null.");
        }
        this.archivoClient = archivoClient;
    }

    /**
     * Carga de datos de clientes al archivo 
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public void guardarClientes(ArrayList<Cliente> listaClientes) {
        try (FileWriter writer = new FileWriter(this.archivoClient)) {
            for (Cliente cliente : listaClientes) {
                writer.write(
                    cliente.getDni() + "," +
                    cliente.getNombre() + "," +
                    cliente.getTipoCliente() + "," +
                    cliente.getAnioIngreso() + "," +
                    cliente.getEstado() + "\n"
                );
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los clientes: " + e.getMessage());
        }
    }
}