/**
 * Clase principal de ejecución para comprobar el correcto funcionamiento del ecosistema bancario.
 * * @author Bravo Guadalupe, Suarez Martin
 * @version 3.0
 */
public class Main {
    public static void main(String[] args) {

        Gestor gestor = new Gestor();

        // 1. Crear clientes (DNI, Nombre, TipoCliente, AñoIngreso, Estado, numCtaPesos, numCtaDolares)
        Cliente c1 = new Cliente(12345678, "Juan Perez", "ORO", 2010, "ACTIVO", 1111, 1112);
        Cliente c2 = new Cliente(87654321, "Maria Gomez", "PLATINO", 2015, "ACTIVO", 2222, 2223);
        Cliente c3 = new Cliente(11111111, "Pedro Lopez", "PLATA", 2020, "ACTIVO", 3333, 3334);

        // 2. Agregar clientes al Gestor
        gestor.agregarCliente(c1);
        gestor.agregarCliente(c2);
        gestor.agregarCliente(c3);

        System.out.println("=========================================");
        System.out.println("          SISTEMA BANCO IUA              ");
        System.out.println("=========================================\n");

        // 3. LISTADO INICIAL
        System.out.println("--- LISTADO DE CLIENTES (ALTAS) ---");
        gestor.listarClientes();

        // 4. TARJETAS
        System.out.println("\n--- ASIGNACIÓN DE TARJETAS ---");
        gestor.asignarTarjeta(12345678); // Juan (Oro) -> Credix
        gestor.asignarTarjeta(87654321); // Maria (Platino) -> Premium
        gestor.asignarTarjeta(11111111); // Pedro (Plata) -> Mensaje de rechazo controlado.

        // 5. TRANSACCIONES
        System.out.println("\n--- REGISTRO DE TRANSACCIONES ---");
        gestor.depositar(1111, 1000); // Deposita $1000 pesos a Juan
        gestor.depositar(2223, 500);  // Deposita u$s500 dólares a Maria
        gestor.extraer(1111, 200);    // Juan extrae $200 pesos
        gestor.extraer(2223, 100);    // Maria extrae u$s100 dólares
        
        System.out.println("Transacciones realizadas con exito.");

        // 6. MOSTRAR SALDOS
        System.out.println("\n--- SALDOS ACTUALIZADOS ---");
        System.out.print("Juan Perez -> ");
        c1.mostrarCuenta("pesos");
        
        System.out.print("Maria Gomez -> ");
        c2.mostrarCuenta("dolares");

        // 7. PRUEBA DE BAJA DE CLIENTE
        System.out.println("\n--- PRUEBA: DAR DE BAJA ---");
        gestor.darDeBajaCliente(11111111); // Damos de baja a Pedro Lopez
        System.out.println("\nListado actualizado tras la baja:");
        gestor.listarClientes(); // Acá Pedro debería decir Estado: BAJA

        // 8. INFORMES Y CONSULTAS EXIGIDAS
        System.out.println("\n=========================================");
        System.out.println("          INFORMES Y CONSULTAS           ");
        System.out.println("=========================================\n");

        // Detalle de transacciones por cliente
        gestor.listarTransaccionesPorCliente(12345678); // Transacciones de Juan

        System.out.println();
        // Informe por mes (Como en el Gestor pusimos la fecha "2026-05-21", buscamos el mes "05")
        gestor.informeTransaccionesPorMes("05");

        System.out.println();
        // Informe por año
        gestor.informeTransaccionesPorAnio("2026");

        System.out.println();
        // Todas las transacciones
        gestor.informeTodasLasTransacciones();

        // 9. GUARDAR EN ARCHIVOS
        System.out.println("\n--- PERSISTENCIA DE DATOS ---");
        gestor.guardarDatos();
        System.out.println("Sistema finalizado de manera excelente. Archivos txt actualizados.");
    }
}