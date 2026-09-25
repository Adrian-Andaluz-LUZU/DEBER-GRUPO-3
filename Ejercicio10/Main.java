import java.util.Scanner;

public class Main {

    static final int MAX = 50;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] tipoVeh = new int[MAX];
        int[] rolVeh = new int[MAX];
        int[] diaVeh = new int[MAX];
        char[] boletoVeh = new char[MAX];
        double[] horasVeh = new double[MAX];
        double[] valorVeh = new double[MAX];

        int n = 0;
        int opcion;
        double totalHoras = 0;
        double totalRecaudado = 0;

        do {
            System.out.println("=================================");
            System.out.println("   PARQUEADERO UNIVERSITARIO");
            System.out.println("=================================");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Mostrar vehiculos registrados");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Mostrar recaudacion");
            System.out.println("5. Salir");
            System.out.println("=================================");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1: {
                    if (n >= MAX) {
                        System.out.println("Parqueadero lleno. No se pueden registrar mas vehiculos");
                        break;
                    }

                    System.out.print("Tipo de vehiculo (1 Automovil, 2 Moto, 3 Camioneta/Bus): ");
                    int tipo = sc.nextInt();
                    while (tipo < 1 || tipo > 3) {
                        System.out.print("Tipo invalido. Ingrese 1, 2 o 3: ");
                        tipo = sc.nextInt();
                    }

                    System.out.print("Rol (1 Estudiante, 2 Docente, 3 Visitante): ");
                    int rol = sc.nextInt();
                    while (rol < 1 || rol > 3) {
                        System.out.print("Rol invalido. Ingrese 1, 2 o 3: ");
                        rol = sc.nextInt();
                    }

                    System.out.print("Numero de horas: ");
                    double horas = sc.nextDouble();
                    while (horas <= 0) {
                        System.out.print("Las horas deben ser mayores que cero: ");
                        horas = sc.nextDouble();
                    }

                    System.out.print("Dia de la semana (1 Lunes ... 7 Domingo): ");
                    int dia = sc.nextInt();
                    while (dia < 1 || dia > 7) {
                        System.out.print("Dia invalido. Ingrese un valor entre 1 y 7: ");
                        dia = sc.nextInt();
                    }

                    System.out.print("Perdio el boleto? (S/N): ");
                    char boletoPerdido = sc.next().toUpperCase().charAt(0);
                    while (boletoPerdido != 'S' && boletoPerdido != 'N') {
                        System.out.print("Respuesta invalida. Ingrese S o N: ");
                        boletoPerdido = sc.next().toUpperCase().charAt(0);
                    }

                    double valor;
                    if (boletoPerdido == 'S') {
                        valor = 15;
                    } else {
                        double tarifaBase;
                        switch (tipo) {
                            case 1: tarifaBase = 0.75; break;
                            case 2: tarifaBase = 0.40; break;
                            default: tarifaBase = 1.00; break;
                        }

                        double descuento;
                        switch (rol) {
                            case 1: descuento = 0.50; break;
                            case 2: descuento = 0.30; break;
                            default: descuento = 0; break;
                        }

                        double recargo = (dia == 6 || dia == 7) ? 1.20 : 1;

                        valor = tarifaBase * horas * (1 - descuento) * recargo;
                    }

                    tipoVeh[n] = tipo;
                    rolVeh[n] = rol;
                    horasVeh[n] = horas;
                    diaVeh[n] = dia;
                    boletoVeh[n] = boletoPerdido;
                    valorVeh[n] = valor;
                    n++;

                    totalHoras += horas;
                    totalRecaudado += valor;

                    System.out.printf("Vehiculo registrado. Valor a pagar: $%.2f%n", valor);
                    break;
                }

                case 2:
                    if (n == 0) {
                        System.out.println("No hay vehiculos registrados");
                    } else {
                        for (int i = 0; i < n; i++) {
                            System.out.printf(
                                "Vehiculo %d: tipo=%d rol=%d horas=%.1f dia=%d boleto perdido=%c valor=$%.2f%n",
                                i + 1, tipoVeh[i], rolVeh[i], horasVeh[i], diaVeh[i], boletoVeh[i], valorVeh[i]);
                        }
                    }
                    break;

                case 3:
                    if (n == 0) {
                        System.out.println("No hay datos para mostrar estadisticas");
                    } else {
                        System.out.println("Vehiculos registrados: " + n);

                        // Ciclos anidados: cuenta por tipo (1 a 3)
                        for (int t = 1; t <= 3; t++) {
                            int contTipo = 0;
                            for (int i = 0; i < n; i++) {
                                if (tipoVeh[i] == t) {
                                    contTipo++;
                                }
                            }
                            System.out.println("Cantidad tipo " + t + ": " + contTipo);
                        }

                        // Ciclos anidados: cuenta por rol (1 a 3)
                        for (int r = 1; r <= 3; r++) {
                            int contRol = 0;
                            for (int i = 0; i < n; i++) {
                                if (rolVeh[i] == r) {
                                    contRol++;
                                }
                            }
                            System.out.println("Cantidad rol " + r + ": " + contRol);
                        }

                        System.out.println("Total de horas: " + totalHoras);
                        double promedio = totalHoras / n;
                        System.out.printf("Promedio de permanencia: %.2f%n", promedio);

                        double mayorValor = valorVeh[0];
                        double menorValor = valorVeh[0];
                        for (int i = 1; i < n; i++) {
                            if (valorVeh[i] > mayorValor) {
                                mayorValor = valorVeh[i];
                            }
                            if (valorVeh[i] < menorValor) {
                                menorValor = valorVeh[i];
                            }
                        }
                        System.out.printf("Mayor valor pagado: $%.2f%n", mayorValor);
                        System.out.printf("Menor valor pagado: $%.2f%n", menorValor);
                    }
                    break;

                case 4:
                    System.out.printf("Total recaudado: $%.2f%n", totalRecaudado);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida. Elija una opcion entre 1 y 5");
            }

            System.out.println();
        } while (opcion != 5);

        // Reporte final
        System.out.println("===== REPORTE FINAL =====");
        System.out.println("Vehiculos registrados: " + n);
        System.out.println("Total de horas: " + totalHoras);
        System.out.printf("Total recaudado: $%.2f%n", totalRecaudado);

        sc.close();
    }
}
