import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, cantidadPares = 0, suma = 0;
        double promedio;

        // Validación del número N
        System.out.print("Ingrese N: ");
        n = scanner.nextInt();

        while (n <= 0) {
            System.out.println("El numero debe ser entero positivo (mayor a cero).");
            System.out.print("Ingrese nuevamente N: ");
            n = scanner.nextInt();
        }

        System.out.println("Serie:");
        // Generación de la serie de pares con ciclo for
        for (int i = 2; i <= n; i += 2) {
            System.out.print(i + " ");
            suma += i;
            cantidadPares++;
        }
        System.out.println(); // Salto de línea

        System.out.println("Cantidad de pares: " + cantidadPares);
        System.out.println("Suma: " + suma);

        // Cálculo del promedio
        if (cantidadPares > 0) {
            promedio = (double) suma / cantidadPares;
            System.out.println("Promedio: " + promedio);
        } else {
            System.out.println("Promedio: 0 (No se generaron numeros pares)");
        }

        scanner.close();
    }
}