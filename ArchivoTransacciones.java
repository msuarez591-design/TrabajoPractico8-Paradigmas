import java.io.File;
import java.util.ArrayList;
import java.file.IOException;
import java.io.FileWriter;

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
    public void guardarTransacciones(ArrayList<Transacciones> listaTransacciones) {
        try (FileWriter writer = new FileWriter(this.archivoTransac)) {
            for (Transacciones transaccion : listaTransacciones) {
                writer.write(transaccion.getFecha() + "," + transaccion.getTipo() + "," + transaccion.getNumeroDeCuenta() + "," + transaccion.getMonto() + "," + transaccion.getDniPersona() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar las transacciones: " + e.getMessage());
        }
  
}
}