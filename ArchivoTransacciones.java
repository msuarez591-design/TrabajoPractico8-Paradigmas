import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Encargada de persistir y recuperar el historial de transacciones en un archivo de texto.
 * @author Bravo Guadalupe, Suarez Martin
 * @version 2.0
 */
public class ArchivoTransacciones {
    
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
        try {
            FileWriter escritor = new FileWriter(this.archivoTransac);
            for (Transacciones t : listaTransacciones) {
                escritor.write(t.getFecha() + "," + t.getTipo() + "," + t.getNumeroDeCuenta() + "," + 
                               t.getMonto() + "," + t.getDniPersona() + "\n");
            }
            escritor.close();
        } catch (Exception e) {
            System.out.println("Error al guardar transacciones");
        }
    }

    /**
     * Lee los datos del archivo txt y los transforma en objetos Transacciones
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public ArrayList<Transacciones> leerTransacciones() {
        ArrayList<Transacciones> lista = new ArrayList<>();
        try {
            if (!this.archivoTransac.exists()) {
                return lista;
            }

            Scanner lector = new Scanner(this.archivoTransac);
            while (lector.hasNextLine()) {
                // Leemos el renglón y cortamos por comas
                String[] datos = lector.nextLine().split(",");
                
                // Convertimos los 5 datos
                String fecha = datos[0];
                String tipo = datos[1];
                int numCuenta = Integer.parseInt(datos[2]);
                double monto = Double.parseDouble(datos[3]);
                int dniPersona = Integer.parseInt(datos[4]);
                
                // Guardamos en la lista
                lista.add(new Transacciones(fecha, tipo, numCuenta, monto, dniPersona));
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error al leer transacciones");
        }
        return lista;
    }
}