import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        // Validación del número de estudiantes mediante ciclo while
        System.out.print("Ingrese el numero de estudiantes: ");
        n = scanner.nextInt();

        while (n <= 0) {
            System.out.println("El numero de estudiantes debe ser mayor que cero.");
            System.out.print("Ingrese nuevamente el numero de estudiantes: ");
            n = scanner.nextInt();
        }

        double suma = 0.0;
        int aprobados = 0;
        int reprobados = 0;
        double notaMax = 0.0;
        double notaMin = 0.0;

        // Procesamiento de notas mediante ciclo for
        for (int i = 1; i <= n; i++) {
            double nota;
            System.out.print("Ingrese la calificacion del estudiante " + i + ": ");
            nota = scanner.nextDouble();

            // Validación de rango de nota [0, 10] mediante ciclo while
            while (nota < 0 || nota > 10) {
                System.out.println("Nota incorrecta. Debe estar entre 0 y 10.");
                System.out.print("Ingrese nuevamente la calificacion: ");
                nota = scanner.nextDouble();
            }

            suma += nota;

            if (nota >= 7.0) {
                aprobados++;
            } else {
                reprobados++;
            }

            // Inicialización y actualización de nota más alta y más baja
            if (i == 1) {
                notaMax = nota;
                notaMin = nota;
            } else {
                if (nota > notaMax) {
                    notaMax = nota;
                }
                if (nota < notaMin) {
                    notaMin = nota;
                }
            }
        }

        double promedio = suma / n;

        // Visualización de resultados en consola
        System.out.println("\n========== RESULTADOS ==========");
        System.out.println("Numero de estudiantes : " + n);
        System.out.println("Suma de calificaciones: " + suma);
        System.out.println("Promedio general     : " + String.format("%.2f", promedio));
        System.out.println("Aprobados            : " + aprobados);
        System.out.println("Reprobados           : " + reprobados);
        System.out.println("Nota mas alta        : " + notaMax);
        System.out.println("Nota mas baja        : " + notaMin);

        scanner.close();
    }
}