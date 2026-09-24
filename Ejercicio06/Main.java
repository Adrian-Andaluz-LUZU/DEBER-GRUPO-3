import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;

        // Validación del número N entre 2 y 10
        System.out.print("Ingrese un numero entre 2 y 10: ");
        n = scanner.nextInt();

        while (n < 2 || n > 10) {
            System.out.println("El numero debe estar estrictamente entre 2 y 10.");
            System.out.print("Ingrese nuevamente el numero: ");
            n = scanner.nextInt();
        }

        // Patrón 1: Triángulo creciente de asteriscos
        System.out.println("\nPatrón 1:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println(); // Separador

        // Patrón 2: Triángulo decreciente de asteriscos
        System.out.println("Patrón 2:");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println(); // Separador

        // Patrón 3: Triángulo numérico creciente
        System.out.println("Patrón 3:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        scanner.close();
    }
}