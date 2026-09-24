import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion, producto, cantidad;
        int numeroVentas = 0, totalProductos = 0;
        int cantCafe = 0, cantSandwich = 0, cantJugo = 0, cantEmpanada = 0;
        double precioUnitario = 0.0, subtotal, totalRecaudado = 0.0, promedioVenta;
        int mayorCantidad;
        String productoMasVendido;

        do {
            System.out.println("====================================");
            System.out.println("     CAFETERÍA UNIVERSITARIA        ");
            System.out.println("====================================");
            System.out.println("1. Registrar venta");
            System.out.println("2. Mostrar estadísticas");
            System.out.println("3. Mostrar tabla de productos");
            System.out.println("4. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            while (opcion < 1 || opcion > 4) {
                System.out.print("Opción inválida. Ingrese un valor entre 1 y 4: ");
                opcion = scanner.nextInt();
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR VENTA ---");
                    System.out.println("1. Café ($1.00)");
                    System.out.println("2. Sándwich ($2.50)");
                    System.out.println("3. Jugo ($1.50)");
                    System.out.println("4. Empanada ($1.25)");
                    System.out.print("Seleccione el producto (1-4): ");
                    producto = scanner.nextInt();

                    while (producto < 1 || producto > 4) {
                        System.out.print("Producto no válido. Seleccione (1-4): ");
                        producto = scanner.nextInt();
                    }

                    System.out.print("Ingrese la cantidad: ");
                    cantidad = scanner.nextInt();

                    while (cantidad <= 0) {
                        System.out.print("La cantidad debe ser mayor que cero. Reintente: ");
                        cantidad = scanner.nextInt();
                    }

                    switch (producto) {
                        case 1:
                            precioUnitario = 1.00;
                            cantCafe += cantidad;
                            break;
                        case 2:
                            precioUnitario = 2.50;
                            cantSandwich += cantidad;
                            break;
                        case 3:
                            precioUnitario = 1.50;
                            cantJugo += cantidad;
                            break;
                        case 4:
                            precioUnitario = 1.25;
                            cantEmpanada += cantidad;
                            break;
                    }

                    subtotal = precioUnitario * cantidad;
                    totalRecaudado += subtotal;
                    totalProductos += cantidad;
                    numeroVentas++;

                    System.out.printf("Venta registrada con éxito. Subtotal: $%.2f%n%n", subtotal);
                    break;

                case 2:
                    System.out.println("\n--- REPORTES Y ESTADÍSTICAS ---");
                    if (numeroVentas == 0) {
                        System.out.println("No hay ventas registradas en el sistema aún.\n");
                    } else {
                        promedioVenta = totalRecaudado / numeroVentas;

                        // Determinar el producto con mayor cantidad vendida
                        mayorCantidad = cantCafe;
                        productoMasVendido = "Café";

                        if (cantSandwich > mayorCantidad) {
                            mayorCantidad = cantSandwich;
                            productoMasVendido = "Sándwich";
                        }
                        if (cantJugo > mayorCantidad) {
                            mayorCantidad = cantJugo;
                            productoMasVendido = "Jugo";
                        }
                        if (cantEmpanada > mayorCantidad) {
                            mayorCantidad = cantEmpanada;
                            productoMasVendido = "Empanada";
                        }

                        System.out.println("Número de ventas: " + numeroVentas);
                        System.out.println("Cantidad total de productos: " + totalProductos);
                        System.out.printf("Total recaudado: $%.2f%n", totalRecaudado);
                        System.out.printf("Promedio por venta: $%.2f%n", promedioVenta);
                        System.out.println("Producto más vendido: " + productoMasVendido + " (" + mayorCantidad + " unidades)\n");
                    }
                    break;

                case 3:
                    System.out.println("\n--- TABLA DE PRODUCTOS ---");
                    System.out.println("1. Café       $1.00");
                    System.out.println("2. Sándwich   $2.50");
                    System.out.println("3. Jugo       $1.50");
                    System.out.println("4. Empanada   $1.25\n");
                    break;

                case 4:
                    System.out.println("\nGracias por utilizar el sistema de la Cafetería Universitaria.");
                    break;
            }

        } while (opcion != 4);

        scanner.close();
    }
}