import java.io.File;

public class ArchivoCliente{
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
}