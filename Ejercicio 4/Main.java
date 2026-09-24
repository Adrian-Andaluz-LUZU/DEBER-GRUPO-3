import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        int depositos = 0;
        int retiros = 0;
        double saldo = 100;
        double monto;
        double totalDepositado = 0;
        double totalRetirado = 0;

        // do-while: el menu se repite hasta que el usuario elija Salir (5)
        do {
            System.out.println("==========================");
            System.out.println("     CAJERO ACADEMICO");
            System.out.println("==========================");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar movimientos");
            System.out.println("5. Salir");
            System.out.println("==========================");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.printf("Saldo actual: $%.2f%n", saldo);
                    break;

                case 2:
                    System.out.print("Ingrese el monto a depositar: ");
                    monto = sc.nextDouble();
                    if (monto <= 0) {
                        System.out.println("Monto invalido. Debe ser mayor que cero");
                    } else {
                        saldo += monto;
                        depositos++;
                        totalDepositado += monto;
                        System.out.printf("Deposito exitoso. Saldo actual: $%.2f%n", saldo);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    monto = sc.nextDouble();
                    if (monto <= 0) {
                        System.out.println("Monto invalido. Debe ser mayor que cero");
                    } else if (monto > saldo) {
                        System.out.printf("Fondos insuficientes. Saldo disponible: $%.2f%n", saldo);
                    } else {
                        saldo -= monto;
                        retiros++;
                        totalRetirado += monto;
                        System.out.printf("Retiro exitoso. Saldo actual: $%.2f%n", saldo);
                    }
                    break;

                case 4:
                    System.out.println("Depositos realizados: " + depositos);
                    System.out.println("Retiros realizados: " + retiros);
                    System.out.printf("Total depositado: $%.2f%n", totalDepositado);
                    System.out.printf("Total retirado: $%.2f%n", totalRetirado);
                    break;

                case 5:
                    System.out.println("Saliendo del cajero...");
                    break;

                default:
                    System.out.println("Opcion invalida. Elija una opcion entre 1 y 5");
            }

            System.out.println();
        } while (opcion != 5);

        // Resumen final
        System.out.println("Depositos realizados: " + depositos);
        System.out.println("Retiros realizados: " + retiros);
        System.out.printf("Total depositado: $%.2f%n", totalDepositado);
        System.out.printf("Total retirado: $%.2f%n", totalRetirado);
        System.out.printf("Saldo final: $%.2f%n", saldo);

        sc.close();
    }
}
