# DEBER-GRUPO-3
# Ciclos-Java — Taller Ciclos Grupo #3

## Integrantes
- Adrián Andaluz
- Paulo Escobar
- Ariel Chanatagsi
- Mateo Salazar

## Objetivo
Desarrollar y fortalecer el conocimiento sobre el uso de ciclos en Java, aplicando estructuras repetitivas como `while`, `do-while` y `for` para resolver diferentes problemas mediante programas sencillos y prácticos.

---

## Descripción de los ejercicios

### Ejercicio 1. Control de calificaciones

Desarrolle un programa que permita ingresar las calificaciones de N estudiantes. El número de estudiantes debe ser mayor que cero y cada calificación deberá estar entre **0 y 10**.

El programa deberá determinar:
- Número de estudiantes;
- Suma de calificaciones;
- Promedio general;
- Cantidad de aprobados;
- Cantidad de reprobados;
- Nota más alta;
- Nota más baja.

#### Estructuras utilizadas

| Estructura | Uso en el Ejercicio 1 |
| :--- | :--- |
| `while` | Validar que `N > 0` y que cada nota esté entre 0 y 10 (se repite hasta recibir un dato válido). |
| `for` | Recorrer exactamente `N` estudiantes para leer y procesar cada calificación. |
| `if / else` | Clasificar aprobados/reprobados y actualizar la nota más alta y más baja. |
| Acumulador | `suma` guarda el total de calificaciones. |
| Contadores | `aprobados` y `reprobados`. |

> **Caso límite obligatorio:** probar las notas 0, 7 y 10.

#### Análisis

##### Entradas
- Número de estudiantes `N` (debe cumplir `N > 0`).
- Las `N` calificaciones individuales (cada una en el rango `[0, 10]`).

##### Restricciones y validaciones
- Uso de la estructura `while` para validar que `N > 0` y que cada nota esté entre 0 y 10.

##### Procesos
- Acumular las notas para calcular la suma total y el promedio general.
- Contar cuántos estudiantes aprobaron (`nota >= 7`) y cuántos reprobaron (`nota < 7`).
- Determinar la nota máxima y la nota mínima.
- Uso de la estructura `for` para iterar exactamente `N` veces.

##### Salidas
- Número total de estudiantes.
- Suma total de calificaciones.
- Promedio general.
- Cantidad de aprobados y reprobados.
- Nota más alta y nota más baja.

#### Diagrama de flujo
*(Sube tu imagen del diagrama a la carpeta Ejercicio01 o arrástrala aquí)*
![Diagrama de Flujo](./Ejercicio01/diagrama_ejercicio1.png)

#### Pseudocódigo

```text
Algoritmo ControlCalificaciones
    Definir n, i, aprobados, reprobados Como Entero
    Definir nota, suma, notaMax, notaMin, promedio Como Real

    suma <- 0
    aprobados <- 0
    reprobados <- 0

    // Validación del número de estudiantes
    Escribir "Ingrese el numero de estudiantes: "
    Leer n

    Mientras n <= 0 Hacer
        Escribir "El numero de estudiantes debe ser mayor que cero"
        Escribir "Ingrese el numero de estudiantes: "
        Leer n
    FinMientras

    // Procesamiento con Para (for)
    Para i <- 1 Hasta n Con Paso 1 Hacer
        Escribir "Ingrese la calificacion del estudiante ", i, ": "
        Leer nota

        Mientras nota < 0 O nota > 10 Hacer
            Escribir "Calificacion invalida. Debe estar entre 0 y 10"
            Escribir "Ingrese la calificacion del estudiante ", i, ": "
            Leer nota
        FinMientras

        suma <- suma + nota

        Si nota >= 7 Entonces
            aprobados <- aprobados + 1
        SiNo
            reprobados <- reprobados + 1
        FinSi

        Si i == 1 Entonces
            notaMax <- nota
            notaMin <- nota
        SiNo
            Si nota > notaMax Entonces
                notaMax <- nota
            FinSi
            Si nota < notaMin Entonces
                notaMin <- nota
            FinSi
        FinSi
    FinPara
FinAlgoritmo
```
---

#### Casos de prueba

##### Prueba de escritorio — Ejercicio 1 (caso límite: notas 0, 7 y 10)

| Paso | Iteración (i) | N | Entrada (nota) | Validación | suma | aprobados | reprobados | notaMax | notaMin | promedio |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | - | 3 | - | Válido (3 > 0) | 0.0 | 0 | 0 | - | - | - |
| **Iteración 1** | 1 | 3 | 0.0 | Válida (0 entre 0 y 10) | 0.0 | 0 | 1 | 0.0 | 0.0 | - |
| **Iteración 2** | 2 | 3 | 7.0 | Válida (7 entre 0 y 10) | 7.0 | 1 | 1 | 7.0 | 0.0 | - |
| **Iteración 3** | 3 | 3 | 10.0 | Válida (10 entre 0 y 10) | 17.0 | 2 | 1 | 10.0 | 0.0 | - |
| **Fin del ciclo** | - | 3 | - | - | 17.0 | 2 | 1 | 10.0 | 0.0 | 5.67 |

##### Casos de validación

| Caso | Entrada | Resultado esperado |
| :--- | :--- | :--- |
| **N no válido** | `n = 0` o `n = -2` | Muestra `"El numero de estudiantes debe ser mayor que cero."` y vuelve a solicitar `n`. |
| **Nota menor al rango** | `nota = -1` | Muestra `"Nota incorrecta. Debe estar entre 0 y 10."` y vuelve a solicitar la nota. |
| **Nota mayor al rango** | `nota = 11` | Muestra `"Nota incorrecta. Debe estar entre 0 y 10."` y vuelve a solicitar la nota. |
| **Nota límite de aprobación** | `nota = 7.0` | Se contabiliza como **aprobado** (`aprobados++`). |
| **Un solo estudiante** | `n = 1`, `nota = 8.0` | Suma: 8.0, Promedio: 8.00, Aprobados: 1, Reprobados: 0, Nota más alta y más baja: 8.0. |
