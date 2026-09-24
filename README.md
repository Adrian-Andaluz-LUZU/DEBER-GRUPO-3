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
<img width="4108" height="10600" alt="image" src="https://github.com/user-attachments/assets/c72af746-7cd5-40c8-a80b-e81b28d12c14" />


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

---
---

#### Capturas y evidencias

##### Ejecución del programa

<img width="446" height="213" alt="Captura de pantalla 2026-09-24 085850" src="https://github.com/user-attachments/assets/76d9d94f-7b02-42a1-83b8-5c9edc1c089b" />


---

#### Conclusiones

1. **Garantía de integridad de datos mediante validación de entradas:** 
   La implementación de los ciclos `while` permitió controlar eficazmente la entrada de datos, asegurando que el número de estudiantes fuera estrictamente positivo ($N > 0$) y que cada calificación se mantuviera dentro del rango permitido $[0, 10]$. Esto evita posibles errores en tiempo de ejecución y cálculos erróneos en el promedio general.

2. **Eficiencia en el procesamiento de iteraciones definidas:** 
   El uso del ciclo `for` resultó ser la estructura óptima para procesar exactamente $N$ estudiantes, permitiendo actualizar simultáneamente en cada paso la suma acumulada, el recuento de aprobados/reprobados y el control dinámico de las notas máxima y mínima.

3. **Determinación adecuada de valores extremos:** 
   La lógica aplicada en la primera iteración (`i == 1`) para inicializar las variables `notaMax` y `notaMin` garantizó que las comparaciones subsecuentes fueran precisas, evitando fallas comunes asociadas a la inicialización arbitraria de valores con cero o números fuera de contexto.

---

### Ejercicio 2. Tabla de multiplicar configurable

Desarrolle un programa que solicite dos números: **tabla inicial** y **tabla final**. El programa deberá generar las tablas de multiplicar de cada número comprendido entre la tabla inicial y la tabla final (ambas incluidas). El programa debe validar que la tabla inicial no sea mayor que la tabla final.

**Desafío:** permitir que el usuario determine también hasta qué multiplicador desea generar las tablas.

Ejemplo:

```text
Tabla inicial: 3
Tabla final: 5

TABLA DEL 3
3 x 1 = 3
...
3 x 10 = 30

TABLA DEL 4
...

TABLA DEL 5
...
```

#### Estructuras utilizadas

| Estructura | Uso en el Ejercicio 2 |
| :--- | :--- |
| `while` | Validar que la tabla inicial no sea mayor que la tabla final y que el multiplicador final sea mayor que 0 (se repite hasta recibir datos válidos). |
| `for` externo | Recorrer cada tabla desde la tabla inicial hasta la tabla final. |
| `for` interno | Recorrer los multiplicadores desde 1 hasta el multiplicador final para cada tabla. |
| Variable de cálculo | `resultado` guarda el producto de `tabla * multiplicador` en cada iteración. |

> **Estructura obligatoria:** ciclos `for` anidados.

> **Caso límite obligatorio:** probar tabla inicial igual a tabla final y multiplicador final igual a 1.

#### Análisis

##### Entradas
- Tabla inicial `tablaInicial`.
- Tabla final `tablaFinal` (debe cumplir `tablaInicial <= tablaFinal`).
- Multiplicador final `multFinal` (debe cumplir `multFinal > 0`).

##### Restricciones y validaciones
- Uso de la estructura `while` para validar que `tablaInicial <= tablaFinal`.
- Uso de la estructura `while` para validar que `multFinal > 0`.

##### Procesos
- Recorrer con un `for` externo cada tabla desde `tablaInicial` hasta `tablaFinal`.
- Mostrar el encabezado `TABLA DEL n` al iniciar cada tabla.
- Recorrer con un `for` interno los multiplicadores desde 1 hasta `multFinal`.
- Calcular `resultado = tabla * multiplicador` y mostrar la operación en cada iteración.

##### Salidas
- Encabezado de cada tabla (`TABLA DEL n`).
- Cada operación con el formato `tabla x multiplicador = resultado`.
- Mensajes de error cuando los datos ingresados no son válidos.

#### Diagrama de flujo
<img width="4940" height="8080" alt="image" src="https://github.com/user-attachments/assets/844fad8d-fc59-4c26-8654-a3c4afd004f5" />



#### Pseudocódigo

```text
Algoritmo TablaMultiplicarConfigurable
    Definir tablaInicial, tablaFinal, multFinal Como Entero
    Definir tabla, m, resultado Como Entero

    // Validacion de tabla inicial y tabla final
    Escribir "Ingrese la tabla inicial: "
    Leer tablaInicial
    Escribir "Ingrese la tabla final: "
    Leer tablaFinal

    Mientras tablaInicial > tablaFinal Hacer
        Escribir "La tabla inicial no puede ser mayor que la tabla final"
        Escribir "Ingrese la tabla inicial: "
        Leer tablaInicial
        Escribir "Ingrese la tabla final: "
        Leer tablaFinal
    FinMientras

    // Desafio: multiplicador final configurable
    Escribir "Ingrese hasta que multiplicador desea generar: "
    Leer multFinal

    Mientras multFinal <= 0 Hacer
        Escribir "El multiplicador final debe ser mayor que cero"
        Escribir "Ingrese hasta que multiplicador desea generar: "
        Leer multFinal
    FinMientras

    // Procesamiento con Para (for) anidados
    Para tabla <- tablaInicial Hasta tablaFinal Con Paso 1 Hacer
        Escribir "TABLA DEL ", tabla

        Para m <- 1 Hasta multFinal Con Paso 1 Hacer
            resultado <- tabla * m
            Escribir tabla, " x ", m, " = ", resultado
        FinPara

        Escribir ""
    FinPara
FinAlgoritmo
```

---

#### Casos de prueba

##### Prueba de escritorio — Ejercicio 2 (tabla inicial = 3, tabla final = 5, multiplicador final = 3)

| Paso | tabla (for externo) | m (for interno) | resultado | Salida en pantalla |
| :--- | :---: | :---: | :---: | :--- |
| **Inicio** | - | - | - | Válido (3 <= 5) y válido (3 > 0) |
| **Iteración 1** | 3 | 1 | 3 | TABLA DEL 3 / 3 x 1 = 3 |
| **Iteración 2** | 3 | 2 | 6 | 3 x 2 = 6 |
| **Iteración 3** | 3 | 3 | 9 | 3 x 3 = 9 |
| **Iteración 4** | 4 | 1 | 4 | TABLA DEL 4 / 4 x 1 = 4 |
| **Iteración 5** | 4 | 2 | 8 | 4 x 2 = 8 |
| **Iteración 6** | 4 | 3 | 12 | 4 x 3 = 12 |
| **Iteración 7** | 5 | 1 | 5 | TABLA DEL 5 / 5 x 1 = 5 |
| **Iteración 8** | 5 | 2 | 10 | 5 x 2 = 10 |
| **Iteración 9** | 5 | 3 | 15 | 5 x 3 = 15 |
| **Fin del ciclo** | - | - | - | Se generaron 3 tablas con 3 multiplicadores cada una |

##### Casos de validación

| Caso | Entrada | Resultado esperado |
| :--- | :--- | :--- |
| **Tabla inicial mayor que la final** | `tablaInicial = 5`, `tablaFinal = 3` | Muestra `"La tabla inicial no puede ser mayor que la tabla final"` y vuelve a solicitar ambos datos. |
| **Tabla inicial igual a la final** | `tablaInicial = 4`, `tablaFinal = 4` | Es válido; genera únicamente la TABLA DEL 4. |
| **Multiplicador final igual a cero** | `multFinal = 0` | Muestra `"El multiplicador final debe ser mayor que cero"` y vuelve a solicitar el dato. |
| **Multiplicador final negativo** | `multFinal = -3` | Muestra `"El multiplicador final debe ser mayor que cero"` y vuelve a solicitar el dato. |
| **Multiplicador mínimo** | `multFinal = 1` | Cada tabla muestra solo la operación `n x 1 = n`. |
| **Ejemplo del enunciado** | `tablaInicial = 3`, `tablaFinal = 5`, `multFinal = 10` | Genera TABLA DEL 3 (hasta `3 x 10 = 30`), TABLA DEL 4 y TABLA DEL 5. |

---
---

#### Capturas y evidencias

##### Ejecución del programa

<img width="1454" height="907" alt="image" src="https://github.com/user-attachments/assets/45afede2-90ca-4485-b8f5-8ea5ba3bc4f7" />


---

#### Conclusiones

1. **Validación de entradas con ciclos `while`:**
   La implementación de los ciclos `while` permitió asegurar que la tabla inicial no fuera mayor que la tabla final y que el multiplicador final fuera un valor positivo. Esto evita salidas vacías o resultados incorrectos.

2. **Uso de ciclos `for` anidados:**
   El `for` externo permitió recorrer cada tabla del rango indicado y el `for` interno generó los multiplicadores de cada una. Esta estructura evita repetir instrucciones y facilita cambiar el rango sin modificar el código.

3. **Flexibilidad mediante el desafío del multiplicador:**
   Permitir que el usuario elija hasta qué multiplicador generar las tablas volvió el programa configurable, ya que el límite dejó de ser un valor fijo (10) y pasó a depender de una variable ingresada.
---
### Ejercicio 3: Serie y suma de números pares

#### Descripción del Ejercicio
El programa solicita un número entero positivo $N$. A partir de este límite superior, el sistema genera y muestra en pantalla la serie de todos los números pares comprendidos desde 2 hasta $N$. Además, realiza el cálculo y muestra de:
- La cantidad total de números pares generados.
- La suma acumulada de dichos números pares.
- El promedio general de los números pares obtenidos.

**Requerimientos del ejercicio:**
- Uso de validación para garantizar que $N$ sea positivo ($N > 0$).
- Implementación de contador, acumulador y estructura repetitiva `for` (o `Para`).
- Manejo de casos límite: $N = 1$, $N = 2$ y valores negativos.

---

#### Análisis del Problema
- **Entrada:** Un número entero $N$.
- **Proceso:**
  1. Validar que $N > 0$ mediante un ciclo `while`. Si es menor o igual a cero, solicitar nuevamente el ingreso.
  2. Inicializar el contador de pares en 0 y el acumulador de la suma en 0.
  3. Recorrer desde $i = 2$ hasta $N$ aumentando de 2 en 2 (o de 1 en 1 verificando $i \% 2 == 0$).
  4. En cada iteración con número par, imprimir el número, incrementar el contador y sumar el número al acumulador.
  5. Calcular el promedio: $\text{promedio} = \frac{\text{suma}}{\text{cantidad de pares}}$. Si no existen pares (ej. cuando $N = 1$), el promedio se maneja en 0.
- **Salida:** Serie de pares, cantidad de pares, suma total y promedio.

---

#### Estructuras utilizadas

| Estructura | Uso en el Ejercicio |
| :--- | :--- |
| `while` | Validar que el límite superior sea un entero positivo ($N > 0$). |
| `for` | Recorrer los valores desde 2 hasta $N$ para identificar y procesar los números pares. |
| `if / else` | Verificar la paridad del número ($i \pmod 2 == 0$) y prevenir la división para el cálculo del promedio si la cantidad de pares es 0. |
| Acumulador | `suma` suma de manera sucesiva el valor de cada número par encontrado. |
| Contadores | `cantidadPares` contabiliza el total de números pares generados dentro del rango $[2, N]$. |

---

#### Diagrama de Flujo

<img width="4152" height="6336" alt="image" src="https://github.com/user-attachments/assets/0b6649d8-d2b8-47c5-86e7-9fc2ca4717e0" />

---

#### Pseudocódigo

```text
Algoritmo SerieYSumaNumerosPares
    Definir N, i, cantidadPares, suma Como Entero
    Definir promedio Como Real

    // Inicialización de variables
    suma <- 0
    cantidadPares <- 0

    // Validación del número N
    Escribir "Ingrese N: "
    Leer N

    Mientras N <= 0 Hacer
        Escribir "El numero debe ser entero positivo (mayor a cero)."
        Escribir "Ingrese nuevamente N: "
        Leer N
    FinMientras

    Escribir "Serie:"
    // Generación de la serie de pares con ciclo Para
    Para i <- 2 Hasta N Con Paso 2 Hacer
        Escribir i, " " Sin Bajar
        suma <- suma + i
        cantidadPares <- cantidadPares + 1
    FinPara
    Escribir "" // Salto de línea

    Escribir "Cantidad de pares: ", cantidadPares
    Escribir "Suma: ", suma

    // Cálculo del promedio
    Si cantidadPares > 0 Entonces
        promedio <- suma / cantidadPares
        Escribir "Promedio: ", promedio
    SiNo
        Escribir "Promedio: 0 (No se generaron numeros pares)"
    FinSi
FinAlgoritmo
```
---

#### Casos de prueba

##### Prueba de escritorio — Ejercicio 3 (Ejemplo $N = 12$)

| Paso | N | Iteración (i) | ¿$i \le N$? | Serie impresa | suma | cantidadPares | promedio |
| :--- | :---: | :---: | :---: | :--- | :---: | :---: | :---: |
| **Inicio** | 12 | - | - | - | 0 | 0 | - |
| **Iteración 1** | 12 | 2 | Válido (2 ≤ 12) | 2 | 2 | 1 | - |
| **Iteración 2** | 12 | 4 | Válido (4 ≤ 12) | 2 4 | 6 | 2 | - |
| **Iteración 3** | 12 | 6 | Válido (6 ≤ 12) | 2 4 6 | 12 | 3 | - |
| **Iteración 4** | 12 | 8 | Válido (8 ≤ 12) | 2 4 6 8 | 20 | 4 | - |
| **Iteración 5** | 12 | 10 | Válido (10 ≤ 12) | 2 4 6 8 10 | 30 | 5 | - |
| **Iteración 6** | 12 | 12 | Válido (12 ≤ 12) | 2 4 6 8 10 12 | 42 | 6 | - |
| **Fin del ciclo**| 12 | 14 | Falso (14 > 12) | - | 42 | 6 | 7.00 |

##### Casos de validación

| Caso | Entrada | Resultado esperado |
| :--- | :--- | :--- |
| **Negativos / Cero** | `N = -5` o `N = 0` | Muestra `"El numero debe ser entero positivo"` y vuelve a pedir $N$. |
| **Caso límite $N = 1$** | `N = 1` | Serie: *(vacía)*, Cantidad de pares: `0`, Suma: `0`, Promedio: `0`. |
| **Caso límite $N = 2$** | `N = 2` | Serie: `2`, Cantidad de pares: `1`, Suma: `2`, Promedio: `2.00`. |
| **Entrada normal par** | `N = 12` | Serie: `2 4 6 8 10 12`, Cantidad: `6`, Suma: `42`, Promedio: `7.00`. |
| **Entrada normal impar** | `N = 7` | Serie: `2 4 6`, Cantidad: `3`, Suma: `12`, Promedio: `4.00`. |

---
#### Capturas y evidencias

##### Ejecución del programa
<img width="908" height="530" alt="image" src="https://github.com/user-attachments/assets/6429b41f-dd64-48bb-bada-edebf42706c8" />


#### Conclusiones

1. **Control de rangos mediante validación:** 
   La aplicación del ciclo `while` para la lectura de $N$ previene la ejecución de algoritmos con valores inválidos o negativos, garantizando que el bucle principal de cálculo opere exclusivamente sobre el dominio de números enteros positivos.

2. **Optimización del ciclo de conteo:** 
   Al definir el paso del ciclo `for` de 2 en 2 iniciado en 2 (`Para i <- 2 Hasta N Con Paso 2`), se optimiza el rendimiento del algoritmo reduciendo las iteraciones a la mitad en comparación con la revisión individual de paridad término a término.

3. **Manejo correcto de casos extremos ($N = 1$):** 
   El análisis condicional antes del cálculo del promedio evita posibles indeterminaciones o errores de división por cero ($\frac{0}{0}$) cuando el rango $2 \le N$ no contiene ningún número par.
