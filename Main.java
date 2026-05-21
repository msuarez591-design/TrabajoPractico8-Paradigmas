/**
 * Clase principal de ejecución para comprobar el correcto funcionamiento del ecosistema bancario.
 * @author Bravo Guadalupe, Suarez Martin
 * @version 4.0
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("          SISTEMA BANCO IUA              ");
        System.out.println("=========================================\n");

        // 1. Nace el gestor (Acá adentro, automáticamente LEE el txt si es que existe)
        Gestor gestor = new Gestor();

        // 2. Creamos los clientes en memoria
        Cliente c1 = new Cliente(12345678, "Juan Perez", "ORO", 2010, "ACTIVO", 1111, 1112);
        Cliente c2 = new Cliente(87654321, "Maria Gomez", "PLATINO", 2015, "ACTIVO", 2222, 2223);
        Cliente c3 = new Cliente(11111111, "Pedro Lopez", "PLATA", 2020, "ACTIVO", 3333, 3334);

        // 3. Los agregamos al Gestor (El gestor ya sabe que si están repetidos, no hace nada)
        gestor.agregarCliente(c1);
        gestor.agregarCliente(c2);
        gestor.agregarCliente(c3);

        // 4. Asignamos las tarjetas
        System.out.println("\n--- ASIGNACIÓN DE TARJETAS ---");
        gestor.asignarTarjeta(12345678); 
        gestor.asignarTarjeta(87654321); 
        gestor.asignarTarjeta(11111111); // Pedro es plata, tira mensaje de rechazo

        // 5. Hacemos algunas transacciones de prueba
        System.out.println("\n--- REGISTRO DE TRANSACCIONES ---");
        gestor.depositar(1111, 1000); 
        gestor.depositar(2223, 500);  
        gestor.extraer(1111, 200);    
        System.out.println("Transacciones de prueba finalizadas.");

        // 6. Damos de baja a Pedro
        System.out.println("\n--- PRUEBA: DAR DE BAJA ---");
        gestor.darDeBajaCliente(11111111); 

        // =============================================================
        // PARTE FINAL: LISTAR ABSOLUTAMENTE TODO LO QUE PIDE LA CONSIGNA
        // =============================================================
        System.out.println("\n=========================================");
        System.out.println("          INFORMES FINALES               ");
        System.out.println("=========================================\n");

        System.out.println("1. LISTADO DE TODOS LOS CLIENTES (Con su estado actual):");
        gestor.listarClientes();

        System.out.println("\n2. SALDOS DE CUENTAS (Ejemplos):");
        System.out.print("Saldo Juan Perez -> ");
        c1.mostrarCuenta("pesos");
        System.out.print("Saldo Maria Gomez -> ");
        c2.mostrarCuenta("dolares");

        System.out.println("\n3. TODAS LAS TRANSACCIONES DEL SISTEMA:");
        gestor.informeTodasLasTransacciones();

        System.out.println("\n4. TRANSACCIONES FILTRADAS (Solo de Juan Perez):");
        gestor.listarTransaccionesPorCliente(12345678);

        // 7. Guardar los datos en el TXT
        System.out.println("\n--- PERSISTENCIA DE DATOS ---");
        gestor.guardarDatos();
        System.out.println("¡Datos guardados con éxito en clientes.txt y transacciones.txt!");
    }
}