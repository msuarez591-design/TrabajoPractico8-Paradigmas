import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Encargada de persistir y recuperar los datos de los clientes en un archivo de texto.
 * @author Bravo Guadalupe, Suarez Martin
 * @version 4.0
 */
public class ArchivoCliente {
    
    private File archivoClient;

    public ArchivoCliente(String rutaArchivo){
        if (rutaArchivo == null || rutaArchivo.trim().isEmpty()) {
            throw new RuntimeException("La ruta del archivo no puede estar vacía.");
        }
        this.archivoClient = new File(rutaArchivo);
    }

    public ArchivoCliente(){
        this.archivoClient = new File("clientes.txt");
    }

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
        try {
            // Usamos la variable de la clase (this.archivoClient)
            FileWriter escritor = new FileWriter(this.archivoClient);
            for (Cliente c : listaClientes) {
                escritor.write(c.getDni() + "," + c.getNombre() + "," + c.getTipoCliente() + "," + 
                               c.getAnioIngreso() + "," + c.getEstado() + "," + 
                               c.getCuentaPesos().getNumeroCuenta() + "," + 
                               c.getCuentaDolares().getNumeroCuenta() + "\n");
            }
            escritor.close();
        } catch (Exception e) {
            System.out.println("Error al guardar clientes");
        }
    }

    /**
     * Lee los datos del archivo txt y los transforma en objetos Cliente
     * @version 2.0
     * @author Bravo Guadalupe, Suarez Martin
     */
    public ArrayList<Cliente> leerClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            // Si el archivo no existe, devolvemos la lista vacía para que no rompa
            if (!this.archivoClient.exists()) {
                return lista; 
            }

            Scanner lector = new Scanner(this.archivoClient);
            while (lector.hasNextLine()) {
                // Leemos el renglón y cortamos por comas
                String[] datos = lector.nextLine().split(",");
                
                // Convertimos los 7 datos
                int dni = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String tipo = datos[2];
                int anio = Integer.parseInt(datos[3]);
                String estado = datos[4];
                int ctaPesos = Integer.parseInt(datos[5]);
                int ctaDolares = Integer.parseInt(datos[6]);
                
                // Creamos y agregamos el cliente a la lista
                lista.add(new Cliente(dni, nombre, tipo, anio, estado, ctaPesos, ctaDolares));
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error al leer clientes");
        }
        return lista;
    }
}