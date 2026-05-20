import java.io.File;

public class ArchivoCliente{
    //Atributo
    private File archivoClient;
    /**
     * Constructor de ArchivoCliente
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public ArchivoCliente(String rutaArchivo){
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
        this.archivoClient = archivoClient;
    }
    /**
     * Carga de datos de clientes al archivo
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
}