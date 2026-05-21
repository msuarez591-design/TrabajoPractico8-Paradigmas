public class Main{
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        // Crear clientes
        Cliente cliente1 = new Cliente(12345678, "Juan Perez", "VIP", 2010, "ACTIVO", "USD", 1000.0f, 1111);
        Cliente cliente2 = new Cliente(87654321, "Maria Gomez", "Regular", 2015, "ACTIVO", "USD", 500.0f, 2222);
        // Agregar clientes al gestor
        gestor.agregarCliente(cliente1);
        gestor.agregarCliente(cliente2);
        // Asignar tarjetas a los clientes
        gestor.asignarTarjeta(12345678);
        gestor.asignarTarjeta(87654321);
        

    }
}