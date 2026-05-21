import java.io.File;

public class ArchivoTransacciones{
    //Atributo
    private File archivoTransac;
    /**
     * Constructor de ArchivoTransacciones
     * @throws RuntimeException si la ruta del archivo es null o vacia
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public ArchivoTransacciones(String rutaArchivo){
        if(rutaArchivo == null || rutaArchivo.trim().isEmpty()) {
            throw new RuntimeException("La ruta del archivo no puede estar vacía.");
        }
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
        if (archivoTransac == null) {
            throw new RuntimeException("El archivo no puede ser null.");
        }
        this.archivoTransac = archivoTransac;
    }
    /**
     * Carga de datos de transacciones al archivo
     * @version 1.0
     * @author Bravo Guadalupe, Suarez Martin
     */
}