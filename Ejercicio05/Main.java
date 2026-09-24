import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion, cantidad;
        int contLibros = 0, contEsferos = 0, contCuadernos = 0;
        double precioUnitario, subtotal, descuento, iva, totalPagar;
        double acumVentas = 0.0;
        char respuesta;

        do {
            System.out.println("========================================");
            System.out.println("        SISTEMA DE VENTAS - TIENDA       ");
            System.out.println("========================================");
            System.out.println("Seleccione el producto:");
            System.out.println("1. Libro ($15.00 c/u)");
            System.out.println("2. Esfero ($1.25 c/u)");
            System.out.println("3. Cuaderno ($3.50 c/u)");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            if (opcion < 1 || opcion > 3) {
                System.out.println("¡Error! Producto no válido.");
            } else {
                do {
                    System.out.print("Ingrese la cantidad a comprar: ");
                    cantidad = scanner.nextInt();
                    if (cantidad <= 0) {
                        System.out.println("¡Error! La cantidad debe ser mayor a cero.");
                    }
                } while (cantidad <= 0);

                switch (opcion) {
                    case 1:
                        precioUnitario = 15.00;
                        contLibros += cantidad;
                        break;
                    case 2:
                        precioUnitario = 1.25;
                        contEsferos += cantidad;
                        break;
                    case 3:
                        precioUnitario = 3.50;
                        contCuadernos += cantidad;
                        break;
                    default:
                        precioUnitario = 0.0;
                        break;
                }

                subtotal = cantidad * precioUnitario;

                // Aplicar descuento del 10% si la compra supera los $50
                if (subtotal > 50.00) {
                    descuento = subtotal * 0.10;
                } else {
                    descuento = 0.0;
                }

                iva = (subtotal - descuento) * 0.15;
                totalPagar = (subtotal - descuento) + iva;
                acumVentas += totalPagar;

                System.out.println("----------------------------------");
                System.out.printf("Subtotal: $%.2f%n", subtotal);
                System.out.printf("Descuento aplicado: $%.2f%n", descuento);
                System.out.printf("IVA (15%%): $%.2f%n", iva);
                System.out.printf("Total a Pagar: $%.2f%n", totalPagar);
                System.out.println("----------------------------------");
            }

            System.out.print("¿Desea realizar otra venta? (S/N): ");
            respuesta = scanner.next().charAt(0);

        } while (respuesta != 'N' && respuesta != 'n');

        System.out.println();
        System.out.println("===== REPORTE DE CIERRE DE CAJA =====");
        System.out.println("Total Libros vendidos: " + contLibros);
        System.out.println("Total Esferos vendidos: " + contEsferos);
        System.out.println("Total Cuadernos vendidos: " + contCuadernos);
        System.out.printf("Ingresos Totales Acumulados: $%.2f%n", acumVentas);
        System.out.println("=====================================");

        scanner.close();
    }
}