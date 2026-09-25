import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numEstudiantes;
        int sumaEdades = 0;
        double sumaHoras = 0;
        double maxHoras = -1;
        int estudianteMaxHoras = 0;
        int menosDe2Horas = 0;

        // Arreglo para almacenar la cantidad de estudiantes por semestre (1 al 10)
        int[] conteoSemestres = new int[11]; // Índices 1 a 10

        // Validacion de la cantidad de estudiantes
        do {
            System.out.print("Ingrese la cantidad de estudiantes a encuestar (minimo 1): ");
            while (!scanner.hasNextInt()) {
                System.out.println("[ERROR] Debe ingresar un numero entero valido.");
                scanner.next();
            }
            numEstudiantes = scanner.nextInt();
            if (numEstudiantes < 1) {
                System.out.println("[ERROR] Debe haber al menos 1 estudiante.");
            }
        } while (numEstudiantes < 1);

        // Ciclo principal para registrar los datos de cada estudiante
        for (int i = 1; i <= numEstudiantes; i++) {
            System.out.println("\n=== DATOS DEL ESTUDIANTE " + i + " ===");

            // 1. Validacion de Edad (16 - 80)
            int edad;
            do {
                System.out.print("Ingrese Edad (16 a 80): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("[ERROR] Ingrese una edad valida.");
                    scanner.next();
                }
                edad = scanner.nextInt();
                if (edad < 16 || edad > 80) {
                    System.out.println("[ERROR] Edad fuera del rango permitido (16-80).");
                }
            } while (edad < 16 || edad > 80);

            // 2. Validacion de Semestre (1 - 10)
            int semestre;
            do {
                System.out.print("Ingrese Semestre (1 a 10): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("[ERROR] Ingrese un semestre valido.");
                    scanner.next();
                }
                semestre = scanner.nextInt();
                if (semestre < 1 || semestre > 10) {
                    System.out.println("[ERROR] Semestre fuera del rango permitido (1-10).");
                }
            } while (semestre < 1 || semestre > 10);

            // 3. Validacion de Horas de Estudio (0 - 24)
            double horasEstudio;
            do {
                System.out.print("Ingrese Horas de estudio diarias (0 a 24): ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("[ERROR] Ingrese un valor numerico valido.");
                    scanner.next();
                }
                horasEstudio = scanner.nextDouble();
                if (horasEstudio < 0 || horasEstudio > 24) {
                    System.out.println("[ERROR] Horas fuera del rango permitido (0-24).");
                }
            } while (horasEstudio < 0 || horasEstudio > 24);

            // Acumulación de datos generales
            sumaEdades += edad;
            sumaHoras += horasEstudio;

            if (horasEstudio > maxHoras) {
                maxHoras = horasEstudio;
                estudianteMaxHoras = i;
            }

            if (horasEstudio < 2.0) {
                menosDe2Horas++;
            }

            // Conteo por semestre
            conteoSemestres[semestre]++;
        }

        // Cálculos de promedios
        double edadPromedio = (double) sumaEdades / numEstudiantes;
        double horasPromedio = sumaHoras / numEstudiantes;

        // Presentación de Resultados
        System.out.println("\n==================================================");
        System.out.println("       RESULTADOS ESTADISTICOS DE LA ENCUESTA     ");
        System.out.println("==================================================");
        System.out.printf("1. Edad Promedio: %.2f anos.%n", edadPromedio);
        System.out.printf("2. Horas Promedio de Estudio: %.2f horas/dia.%n", horasPromedio);
        System.out.println("3. Mayor dedicacion: Estudiante #" + estudianteMaxHoras + " con " + maxHoras + " horas.");
        System.out.println("4. Estudiantes que estudian menos de 2 horas: " + menosDe2Horas);

        System.out.println("\n5. CANTIDAD DE ESTUDIANTES POR SEMESTRE (HISTOGRAMA):");

        // Uso de CICLOS ANIDADOS para generar el gráfico del histograma por semestre
        for (int sem = 1; sem <= 10; sem++) {
            System.out.print("Semestre " + sem + " (" + conteoSemestres[sem] + " estudiantes): ");

            if (conteoSemestres[sem] == 0) {
                System.out.println("[Sin registros]");
            } else {
                // Ciclo interno para imprimir asteriscos
                for (int j = 1; j <= conteoSemestres[sem]; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
