import java.io.File;

public class ArchivoTransacciones{
    //Atributo
    private File archivoTransac;
    /**
     * Constructor de ArchivoTransacciones
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public ArchivoTransacciones(String rutaArchivo){
        this.archivoTransac = new File(rutaArchivo);
    }
    public ArchivoTransacciones(){
        this.archivoTransac = new File("transacciones.txt");
    }
    //Getters y setters
    public File getArchivoTransac(){
        return this.archivoTransac;
    }
    public void setArchivoTransac(File archivoTransac){
        this.archivoTransac = archivoTransac;
    }
    /**
     * Carga de datos de transacciones al archivo
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
}