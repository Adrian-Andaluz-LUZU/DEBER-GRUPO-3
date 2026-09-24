import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tablaInicial, tablaFinal, multFinal;

        // Validacion: la tabla inicial no puede ser mayor que la tabla final
        System.out.print("Ingrese la tabla inicial: ");
        tablaInicial = sc.nextInt();
        System.out.print("Ingrese la tabla final: ");
        tablaFinal = sc.nextInt();

        while (tablaInicial > tablaFinal) {
            System.out.println("La tabla inicial no puede ser mayor que la tabla final");
            System.out.print("Ingrese la tabla inicial: ");
            tablaInicial = sc.nextInt();
            System.out.print("Ingrese la tabla final: ");
            tablaFinal = sc.nextInt();
        }

        // Desafio: el usuario decide hasta que multiplicador generar las tablas
        System.out.print("Ingrese hasta que multiplicador desea generar: ");
        multFinal = sc.nextInt();

        while (multFinal <= 0) {
            System.out.println("El multiplicador final debe ser mayor que cero");
            System.out.print("Ingrese hasta que multiplicador desea generar: ");
            multFinal = sc.nextInt();
        }

        System.out.println();

        // Ciclos for anidados
        for (int tabla = tablaInicial; tabla <= tablaFinal; tabla++) {
            System.out.println("TABLA DEL " + tabla);

            for (int m = 1; m <= multFinal; m++) {
                int resultado = tabla * m;
                System.out.println(tabla + " x " + m + " = " + resultado);
            }

            System.out.println();
        }

        sc.close();
    }
}
