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


---

### Ejercicio 4. Cajero automático básico

Desarrolle un programa que simule un cajero automático con el siguiente menú:

```text
==========================
     CAJERO ACADÉMICO
==========================
1. Consultar saldo
2. Depositar
3. Retirar
4. Mostrar movimientos
5. Salir
==========================
```

El usuario comenzará con un saldo de **$100**. El programa deberá permanecer activo hasta seleccionar **Salir**.

Validaciones:
- No permitir depósitos negativos;
- No permitir retiros negativos;
- No permitir retirar más dinero del disponible;
- No aceptar opciones inexistentes.

Al finalizar deberá mostrar:

```text
Depósitos realizados:
Retiros realizados:
Total depositado:
Total retirado:
Saldo final:
```

#### Estructuras utilizadas

| Estructura | Uso en el Ejercicio 4 |
| :--- | :--- |
| `do-while` | Mantener el menú activo hasta que el usuario seleccione la opción 5 (Salir). |
| `switch` | Ejecutar la acción correspondiente a cada opción del menú (1 a 5) y detectar opciones inexistentes con `default`. |
| `if / else` | Validar los montos de depósito y retiro, y verificar que el retiro no supere el saldo. |
| Contadores | `depositos` y `retiros` cuentan las transacciones realizadas con éxito. |
| Acumuladores | `totalDepositado` y `totalRetirado` suman los montos; `saldo` se actualiza en cada operación. |

> **Caso límite:** retirar exactamente el saldo disponible ($100), que debe permitirse y dejar el saldo en $0.

#### Análisis

##### Entradas
- Opción del menú `opcion` (valores del 1 al 5).
- Monto a depositar `monto` (debe ser mayor que 0).
- Monto a retirar `monto` (debe ser mayor que 0 y no superar el saldo).
- Dato inicial fijo: `saldo = 100`.

##### Restricciones y validaciones
- Uso de la estructura `do-while` para repetir el menú hasta que `opcion = 5`.
- No se permiten depósitos negativos ni iguales a cero.
- No se permiten retiros negativos ni iguales a cero.
- No se permite retirar un monto mayor que el saldo disponible.
- Cualquier opción distinta de 1, 2, 3, 4 o 5 muestra un mensaje de error y vuelve a mostrar el menú.

##### Procesos
- Mostrar el menú y leer la opción elegida.
- Consultar saldo: mostrar el valor actual de `saldo`.
- Depositar: si el monto es válido, sumarlo al `saldo` y a `totalDepositado`, e incrementar `depositos`.
- Retirar: si el monto es válido y hay saldo suficiente, restarlo del `saldo`, sumarlo a `totalRetirado` e incrementar `retiros`.
- Mostrar movimientos: presentar el resumen de depósitos, retiros y totales acumulados hasta el momento.
- Salir: terminar el ciclo y mostrar el resumen final.

##### Salidas
- Saldo actual después de cada operación.
- Mensajes de error para montos u opciones inválidas y para fondos insuficientes.
- Resumen final: depósitos realizados, retiros realizados, total depositado, total retirado y saldo final.

#### Diagrama de flujo
<img width="2601" height="1695" alt="image" src="https://github.com/user-attachments/assets/3a65b300-6290-417b-be97-f6d998deb70e" />



#### Pseudocódigo

```text
Algoritmo CajeroAcademico
    Definir opcion, depositos, retiros Como Entero
    Definir saldo, monto, totalDepositado, totalRetirado Como Real

    saldo <- 100
    depositos <- 0
    retiros <- 0
    totalDepositado <- 0
    totalRetirado <- 0

    Repetir
        Escribir "=========================="
        Escribir "     CAJERO ACADEMICO"
        Escribir "=========================="
        Escribir "1. Consultar saldo"
        Escribir "2. Depositar"
        Escribir "3. Retirar"
        Escribir "4. Mostrar movimientos"
        Escribir "5. Salir"
        Escribir "=========================="
        Escribir "Seleccione una opcion: "
        Leer opcion

        Segun opcion Hacer
            Caso 1:
                Escribir "Saldo actual: $", saldo

            Caso 2:
                Escribir "Ingrese el monto a depositar: "
                Leer monto
                Si monto <= 0 Entonces
                    Escribir "Monto invalido. Debe ser mayor que cero"
                SiNo
                    saldo <- saldo + monto
                    depositos <- depositos + 1
                    totalDepositado <- totalDepositado + monto
                    Escribir "Deposito exitoso. Saldo actual: $", saldo
                FinSi

            Caso 3:
                Escribir "Ingrese el monto a retirar: "
                Leer monto
                Si monto <= 0 Entonces
                    Escribir "Monto invalido. Debe ser mayor que cero"
                SiNo
                    Si monto > saldo Entonces
                        Escribir "Fondos insuficientes. Saldo disponible: $", saldo
                    SiNo
                        saldo <- saldo - monto
                        retiros <- retiros + 1
                        totalRetirado <- totalRetirado + monto
                        Escribir "Retiro exitoso. Saldo actual: $", saldo
                    FinSi
                FinSi

            Caso 4:
                Escribir "Depositos realizados: ", depositos
                Escribir "Retiros realizados: ", retiros
                Escribir "Total depositado: $", totalDepositado
                Escribir "Total retirado: $", totalRetirado

            Caso 5:
                Escribir "Saliendo del cajero..."

            De Otro Modo:
                Escribir "Opcion invalida. Elija una opcion entre 1 y 5"
        FinSegun
    Hasta Que opcion = 5

    Escribir "Depositos realizados: ", depositos
    Escribir "Retiros realizados: ", retiros
    Escribir "Total depositado: $", totalDepositado
    Escribir "Total retirado: $", totalRetirado
    Escribir "Saldo final: $", saldo
FinAlgoritmo
```

---

#### Casos de prueba

##### Prueba de escritorio — Ejercicio 4 (saldo inicial = 100)

| Paso | opcion | monto | Validación | saldo | depositos | retiros | totalDepositado | totalRetirado | Salida |
| :--- | :---: | :---: | :--- | :---: | :---: | :---: | :---: | :---: | :--- |
| **Inicio** | - | - | - | 100 | 0 | 0 | 0 | 0 | - |
| **Paso 1** | 2 | 50 | Válido (50 > 0) | 150 | 1 | 0 | 50 | 0 | Depósito exitoso |
| **Paso 2** | 3 | 30 | Válido (30 <= 150) | 120 | 1 | 1 | 50 | 30 | Retiro exitoso |
| **Paso 3** | 3 | 500 | Inválido (500 > 120) | 120 | 1 | 1 | 50 | 30 | Fondos insuficientes |
| **Paso 4** | 2 | -10 | Inválido (-10 <= 0) | 120 | 1 | 1 | 50 | 30 | Monto inválido |
| **Paso 5** | 7 | - | Opción inexistente | 120 | 1 | 1 | 50 | 30 | Opción inválida |
| **Paso 6** | 1 | - | - | 120 | 1 | 1 | 50 | 30 | Saldo actual: $120 |
| **Paso 7** | 5 | - | Salir | 120 | 1 | 1 | 50 | 30 | Muestra el resumen final |
| **Fin del ciclo** | - | - | - | 120 | 1 | 1 | 50 | 30 | Saldo final: $120 |

##### Casos de validación

| Caso | Entrada | Resultado esperado |
| :--- | :--- | :--- |
| **Depósito negativo** | `opcion = 2`, `monto = -20` | Muestra `"Monto invalido. Debe ser mayor que cero"`; el saldo y los contadores no cambian. |
| **Depósito igual a cero** | `opcion = 2`, `monto = 0` | Muestra `"Monto invalido. Debe ser mayor que cero"`. |
| **Retiro negativo** | `opcion = 3`, `monto = -15` | Muestra `"Monto invalido. Debe ser mayor que cero"`; el saldo no cambia. |
| **Retiro mayor al saldo** | `opcion = 3`, `monto = 150` (saldo = 100) | Muestra `"Fondos insuficientes"`; no se registra el retiro. |
| **Retiro igual al saldo (límite)** | `opcion = 3`, `monto = 100` (saldo = 100) | Retiro exitoso; el saldo queda en $0. |
| **Opción inexistente** | `opcion = 0`, `6` o `9` | Muestra `"Opcion invalida"` y vuelve a mostrar el menú. |
| **Mostrar movimientos** | `opcion = 4` | Muestra depósitos, retiros y totales acumulados hasta ese momento. |
| **Salir sin operaciones** | `opcion = 5` | Resumen final: 0 depósitos, 0 retiros, total depositado $0, total retirado $0 y saldo final $100. |

---
---

#### Capturas y evidencias

##### Ejecución del programa

<img width="1454" height="485" alt="image" src="https://github.com/user-attachments/assets/26e3a3cc-202b-488d-935d-855db0b846d4" />

---

#### Conclusiones

1. **Menú persistente con `do-while`:**
   El ciclo `do-while` garantizó que el menú se mostrara al menos una vez y se repitiera hasta que el usuario eligiera la opción Salir, permitiendo varias operaciones en una misma ejecución.

2. **Selección clara de opciones con `switch`:**
   La estructura `switch` organizó cada operación del cajero en su propio caso y, con `default`, permitió rechazar opciones inexistentes sin detener el programa.

3. **Control de operaciones con contadores y acumuladores:**
   Los contadores (`depositos`, `retiros`) y los acumuladores (`totalDepositado`, `totalRetirado`, `saldo`) permitieron llevar el registro de todas las transacciones y mostrar el resumen final de forma exacta.

4. **Validaciones que protegen el saldo:**
   Las condiciones sobre los montos y el saldo disponible evitaron depósitos o retiros inválidos y saldos negativos, manteniendo la integridad de los datos del cajero.S
---
# Ejercicio5: Control de Inventario y Ventas en Tienda Universitaria

## Descripción del Ejercicio
Desarrollar un sistema automatizado para una tienda universitaria que permita gestionar las transacciones de venta de diferentes productos (Libros, Esferos y Cuadernos). El programa debe solicitar la cantidad de artículos y el tipo de producto seleccionado por el cliente, calcular el subtotal aplicando descuentos basados en el volumen de compra, calcular el impuesto correspondiente y registrar el total acumulado de las ventas al finalizar la jornada laboral.

---

##  Tabla de Estructuras Utilizadas

| Estructura / Elemento | Tipo de Dato | Descripción |
| :--- | :--- | :--- |
| `opcion` | Entero | Almacena la categoría del producto seleccionado (1: Libro, 2: Esfero, 3: Cuaderno). |
| `cantidad` | Entero | Número de unidades que desea comprar el cliente (Debe ser mayor a 0). |
| `precioUnitario` | Real | Costo base por unidad según el producto seleccionado. |
| `subtotal` | Real | Resultado de multiplicar la cantidad por el precio unitario. |
| `descuento` | Real | Porcentaje o valor deducido del subtotal si cumple con los criterios de volumen. |
| `totalPagar` | Real | Monto final a cancelar por el cliente después de aplicar descuentos e impuestos. |
| `contLibros`, `contEsferos`, `contCuadernos` | Entero | Contadores independientes para llevar el registro de unidades vendidas por categoría. |
| `acumVentas` | Real | Acumulador financiero que suma el total de los ingresos obtenidos en el día. |
| `repetir` / `op` | Caracter | Bandera de control para mantener activo el ciclo de ventas (`S`/`N`). |

---

##  Análisis
* **Entradas:** 
  * `opcion`: Opción numérica que define el tipo de artículo.
  * `cantidad`: Cantidad de unidades a comprar.
  * `op`: Carácter de control para continuar o finalizar el sistema de ventas.
* **Procesos:**
  * Validar que la opción del producto se encuentre dentro del rango establecido (1 a 3).
  * Validar mediante un ciclo que la cantidad ingresada sea estrictamente mayor a cero.
  * Asignar el precio unitario correspondiente utilizando una estructura de selección múltiple (`Segun` / `switch`).
  * Aplicar un descuento condicional del 10% si el subtotal supera los $50.00.
  * Calcular el impuesto (IVA 15%) sobre el monto con descuento.
  * Actualizar los contadores de artículos y el acumulador financiero general de la tienda.
* **Salidas:** 
  * Ticket de cobro individual para cada cliente.
  * Reporte final de cierre de caja con la cantidad total de artículos vendidos y el ingreso económico acumulado.

---

##  Diagrama de Flujo

<img width="613" height="1600" alt="image" src="https://github.com/user-attachments/assets/33b6b18a-eda7-47d1-afd5-423c5f2cee2a" />

---

##  Pseudocódigo

```text
Proceso TiendaUniversitaria
    Definir opcion, cantidad, contLibros, contEsferos, contCuadernos Como Entero
    Definir precioUnitario, subtotal, descuento, iva, totalPagar, acumVentas Como Real
    Definir respuesta Como Caracter
    
    contLibros <- 0
    contEsferos <- 0
    contCuadernos <- 0
    acumVentas <- 0.0
    
    Repetir
        Escribir "========================================"
        Escribir "       SISTEMA DE VENTAS - TIENDA       "
        Escribir "========================================"
        Escribir "Seleccione el producto:"
        Escribir "1. Libro ($15.00 c/u)"
        Escribir "2. Esfero ($1.25 c/u)"
        Escribir "3. Cuaderno ($3.50 c/u)"
        Leer opcion
        
        Si opcion < 1 O opcion > 3 Entonces
            Escribir "¡Error! Producto no válido."
        Sino
            Repetir
                Escribir "Ingrese la cantidad a comprar:"
                Leer cantidad
                Si cantidad <= 0 Entonces
                    Escribir "¡Error! La cantidad debe ser mayor a cero."
                FinSi
            Hasta Que cantidad > 0
            
            Segun opcion Hacer
                1:
                    precioUnitario <- 15.00
                    contLibros <- contLibros + cantidad
                2:
                    precioUnitario <- 1.25
                    contEsferos <- contEsferos + cantidad
                3:
                    precioUnitario <- 3.50
                    contCuadernos <- contCuadernos + cantidad
            FinSegun
            
            subtotal <- cantidad * precioUnitario
            
            // Aplicar descuento del 10% si la compra supera los $50
            Si subtotal > 50.00 Entonces
                descuento <- subtotal * 0.10
            Sino
                descuento <- 0.0
            FinSi
            
            iva <- (subtotal - descuento) * 0.15
            totalPagar <- (subtotal - descuento) + 1va
            acumVentas <- acumVentas + totalPagar
            
            Escribir "----------------------------------"
            Escribir "Subtotal: $", subtotal
            Escribir "Descuento aplicado: $", descuento
            Escribir "IVA (15%): $", iva
            Escribir "Total a Pagar: $", totalPagar
            Escribir "----------------------------------"
        FinSi
        
        Escribir "¿Desea realizar otra venta? (S/N):"
        Leer respuesta
    Hasta Que respuesta = 'N' O respuesta = 'n'
    
    Escribir ""
    Escribir "===== REPORTE DE CIERRE DE CAJA ====="
    Escribir "Total Libros vendidos: ", contLibros
    Escribir "Total Esferos vendidos: ", contEsferos
    Escribir "Total Cuadernos vendidos: ", contCuadernos
    Escribir "Ingresos Totales Acumulados: $", acumVentas
    Escribir "====================================="
FinProceso
```
---
##  Prueba de Escritorio

| Paso | Opción Ingresada | Cantidad | Precio Unitario | Subtotal | Descuento | Total a Pagar | Acumulador Ventas |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **1** | 1 (Libro) | 4 | $15.00 | $60.00 | $6.00 | $62.10 | $62.10 |
| **2** | 2 (Esfero) | 10 | $1.25 | $12.50 | $0.00 | $14.38 | $76.48 |
| **3** | 3 (Cuaderno) | 20 | $3.50 | $70.00 | $7.00 | $72.45 | $148.93 |

---

##  Casos de Validación

* **Validación de Cantidad Negativa o Cero:**
  * *Entrada:* Opción = 1, Cantidad = `0` o `-5`.
  * *Comportamiento:* El sistema detecta el error mediante la estructura repetitiva auxiliar, muestra una advertencia en pantalla y bloquea el avance del cálculo hasta que se ingrese un valor positivo válido.
* **Validación de Opción Fuera de Rango:**
  * *Entrada:* Opción = `8`.
  * *Comportamiento:* El sistema intercepta el error con la estructura condicional simple, advierte al usuario sobre el código de producto inexistente y reinicia el flujo de selección sin alterar las estadísticas de caja.

---

##  Capturas y Evidencias

<img width="1600" height="922" alt="image" src="https://github.com/user-attachments/assets/e8084441-77c3-4678-859c-69d6e3860610" />

---

##  Conclusiones
* La implementación de ciclos interactivos condicionales (`Repetir-Hasta Que`) permite modelar con precisión sistemas de punto de venta comerciales donde el flujo operativo no tiene un límite fijo de transacciones previas.
* El uso correcto de estructuras de selección múltiple (`Segun`) facilita la modularización de costos unitarios y asegura la correcta contabilización independiente de los artículos comercializados.
* El manejo de acumuladores financieros y condicionales lógicos para descuentos e impuestos garantiza la precisión en la emisión de reportes gerenciales para el cierre de caja institucional.
---
### Ejercicio 6: Triángulo y patrones

#### Descripción del Ejercicio
El programa solicita al usuario un número entero $N$ que debe estar obligatoriamente comprendido entre 2 y 10. Una vez validada la entrada, el programa genera tres patrones gráficos consecutivos utilizando caracteres y números:

1. **Triángulo de asteriscos creciente:** Muestra $N$ filas donde la fila $i$ contiene $i$ asteriscos.
2. **Triángulo de asteriscos decreciente:** Muestra $N$ filas donde la primera fila contiene $N$ asteriscos y va disminuyendo hasta 1 asterisco.
3. **Triángulo numérico creciente:** Muestra $N$ filas donde la fila $i$ muestra una secuencia de números del 1 al $i$.

---

#### Análisis del Problema
- **Entrada:** Un número entero $N$.
- **Proceso:**
  1. Validar el ingreso de $N$ mediante un ciclo `while` para asegurar que $2 \le N \le 10$. Si la condición no se cumple, pedir la entrada nuevamente.
  2. **Patrón 1 (Asteriscos creciente):** Usar un ciclo exterior $i$ de 1 a $N$. Dentro, un ciclo interior $j$ de 1 a $i$ imprimiendo `*` sin salto de línea. Salto de línea al finalizar cada fila.
  3. **Patrón 2 (Asteriscos decreciente):** Usar un ciclo exterior $i$ de $N$ bajando hasta 1. Dentro, un ciclo interior $j$ de 1 a $i$ imprimiendo `*`. Salto de línea al terminar cada fila.
  4. **Patrón 3 (Números creciente):** Usar un ciclo exterior $i$ de 1 a $N$. Dentro, un ciclo interior $j$ de 1 a $i$ imprimiendo el valor de $j$. Salto de línea al terminar cada fila.
- **Salida:** Tres patrones impresos ordenadamente en la consola.

---

#### Estructuras utilizadas

| Estructura | Uso en el Ejercicio |
| :--- | :--- |
| `while` | Validar que el número ingresado por el usuario esté estrictamente dentro del rango $[2, 10]$. |
| `for` (Exterior) | Controlar el número de filas en cada uno de los tres patrones de triángulos. |
| `for` (Interior) | Controlar el número de columnas (caracteres `*` o números) que se imprimen en la fila actual. |
| Contadores de ciclos | Las variables de iteración (`i` y `j`) actúan como contadores para controlar la cantidad de caracteres por fila. |

---

#### Diagrama de Flujo

<img width="815" height="1600" alt="image" src="https://github.com/user-attachments/assets/c2d10792-ab61-472f-aeef-b7f8be0b0461" />


---

#### Pseudocódigo

```text
Algoritmo TrianguloYPatrones
    Definir N, i, j Como Entero

    // Validación del número N entre 2 y 10
    Escribir "Ingrese un numero entre 2 y 10: "
    Leer N

    Mientras N < 2 O N > 10 Hacer
        Escribir "El numero debe estar estrictamente entre 2 y 10."
        Escribir "Ingrese nuevamente el numero: "
        Leer N
    FinMientras

    // Patrón 1: Triángulo creciente de asteriscos
    Escribir "Patrón 1:"
    Para i <- 1 Hasta N Con Paso 1 Hacer
        Para j <- 1 Hasta i Con Paso 1 Hacer
            Escribir "*" Sin Bajar
        FinPara
        Escribir ""
    FinPara

    Escribir "" // Separador

    // Patrón 2: Triángulo decreciente de asteriscos
    Escribir "Patrón 2:"
    Para i <- N Hasta 1 Con Paso -1 Hacer
        Para j <- 1 Hasta i Con Paso 1 Hacer
            Escribir "*" Sin Bajar
        FinPara
        Escribir ""
    FinPara

    Escribir "" // Separador

    // Patrón 3: Triángulo numérico creciente
    Escribir "Patrón 3:"
    Para i <- 1 Hasta N Con Paso 1 Hacer
        Para j <- 1 Hasta i Con Paso 1 Hacer
            Escribir j Sin Bajar
        FinPara
        Escribir ""
    FinPara
FinAlgoritmo
```
---
#### Estructuras utilizadas

| Estructura | Uso en el Ejercicio |
| :--- | :--- |
| `while` | Validar que el número ingresado por el usuario esté estrictamente dentro del rango de $[2, 10]$. |
| `for` (Exterior) | Controlar el número de filas en cada uno de los tres patrones de triángulos. |
| `for` (Interior) | Controlar el número de columnas (caracteres `*` o números) que se imprimen en la fila actual. |
| Contadores de ciclos | Las variables de iteración (`i` y `j`) actúan como contadores para controlar la cantidad de caracteres por fila. |

---

#### Casos de prueba

##### Prueba de escritorio — Ejercicio 6 (Tabla de trazas de interacción entre ciclos para $N = 3$)

| Patrón | Fila (Ciclo Exterior $i$) | Columna (Ciclo Interior $j$) | Condición Interior ($j \le \text{límite}$) | Impresión / Salida en pantalla | Explicación de interacción |
| :--- | :---: | :---: | :---: | :--- | :--- |
| **Triángulo 1**<br>*(Asteriscos creciente)* | $i = 1$ | $j = 1$ | $1 \le 1$ (Verdadero) | `*` | El ciclo interior imprime 1 asterisco para la fila 1. |
| | $i = 2$ | $j = 1, 2$ | $1 \le 2, 2 \le 2$ (Verdadero) | `**` | El ciclo interior ejecuta 2 iteraciones para la fila 2. |
| | $i = 3$ | $j = 1, 2, 3$ | $1 \le 3, 2 \le 3, 3 \le 3$ | `***` | El ciclo interior ejecuta 3 iteraciones para la fila 3. |
| **Triángulo 2**<br>*(Asteriscos decreciente)* | $i = 3$ | $j = 1, 2, 3$ | $1 \le 3, 2 \le 3, 3 \le 3$ | `***` | El ciclo interior inicia con $N=3$ asteriscos. |
| | $i = 2$ | $j = 1, 2$ | $1 \le 2, 2 \le 2$ (Verdadero) | `**` | El ciclo exterior decrementa a 2; el interior imprime 2 asteriscos. |
| | $i = 1$ | $j = 1$ | $1 \le 1$ (Verdadero) | `*` | El ciclo exterior finaliza en 1; el interior imprime 1 asterisco. |
| **Triángulo 3**<br>*(Números creciente)* | $i = 1$ | $j = 1$ | $1 \le 1$ (Verdadero) | `1` | Imprime el valor de $j$ ($1$). |
| | $i = 2$ | $j = 1, 2$ | $1 \le 2, 2 \le 2$ (Verdadero) | `12` | Imprime de forma secuencial $j=1$ y luego $j=2$. |
| | $i = 3$ | $j = 1, 2, 3$ | $1 \le 3, 2 \le 3, 3 \le 3$ | `123` | Imprime la secuencia de $j$ de 1 a 3. |

##### Casos de validación

| Caso | Entrada | Resultado esperado |
| :--- | :--- | :--- |
| **Menor al rango** | $N = 1$ | Muestra error de rango y solicita ingresar $N$ nuevamente. |
| **Mayor al rango** | $N = 11$ | Muestra error de rango y solicita ingresar $N$ nuevamente. |
| **Negativo / Cero** | $N = 0$ o $N = -4$ | Muestra error de rango y solicita ingresar $N$ nuevamente. |
| **Límite inferior válido** | $N = 2$ | Genera los 3 patrones de 2 filas cada uno. |
| **Límite superior válido** | $N = 10$ | Genera los 3 patrones de 10 filas cada uno. |
| **Valor intermedio** | $N = 5$ | Genera los patrones de 5 filas mostrados en la guía. |

---
#### Capturas y evidencias
<img width="1503" height="708" alt="image" src="https://github.com/user-attachments/assets/c9f84752-2779-41ab-ab04-75370e5f3e1b" />

---
#### Conclusiones

1. **Uso de ciclos anidados para patrones bidimensionales:** 
   La combinación de un ciclo exterior (que gestiona las filas) y un ciclo interior (que gestiona las columnas) es la técnica fundamental para la construcción de patrones geométricos y tabulares en programación estructurada.

2. **Control dinámico de iteraciones del ciclo interior:** 
   Al hacer que el límite del ciclo interior dependa del contador del ciclo exterior ($j \le i$), se logra que la cantidad de elementos impresos por fila sea variable y proporcional a la fila actual, permitiendo la generación de triángulos crecientes y decrecientes.

3. **Validación estricta de rangos cerrados:** 
   El uso del ciclo `while` para restringir la entrada a la condición $N \ge 2 \land N \le 10$ garantiza que los patrones visuales tengan dimensiones legibles y coherentes, evitando impresiones vacías ($N < 1$) o salidas excesivamente extensas en la consola.
---
### Ejercicio 7: Control de ventas de cafetería

#### Descripción del Ejercicio
El programa interactivo implementa un menú principal de opciones para la gestión de ventas de una cafetería universitaria. Permite registrar transacciones de venta seleccionando productos con precios fijos (Café: $1.00, Sándwich: $2.50, Jugo: $1.50, Empanada: $1.25) y especificando cantidades.

El programa debe mantener el registro global para generar un reporte estadístico detallado que incluye:
- Número total de ventas realizadas.
- Cantidad total de productos vendidos.
- Total de dinero recaudado ($).
- Promedio de ingresos por venta.
- Producto con mayor cantidad vendida.

**Estructuras requeridas:** `do-while` para el menú interactivo, `switch` para la selección de productos/opciones, contadores, acumuladores y validaciones estrictas en todas las entradas[cite: 4].

---

#### Análisis del Problema
- **Entrada:** Opción del menú principal ($1-4$), selección de producto ($1-4$) y cantidad deseada ($>0$)[cite: 4].
- **Proceso:**
  1. Usar un bucle `do-while` para mantener activo el menú principal hasta que el usuario elija la opción 4 (Salir)[cite: 4].
  2. **Opción 1 (Registrar venta):**
     - Solicitar el tipo de producto (validar que esté entre 1 y 4 con `while`)[cite: 4].
     - Solicitar la cantidad (validar que sea $> 0$ con `while`)[cite: 4].
     - Mediante una estructura `switch`, determinar el precio unitario, calcular el subtotal y acumular las unidades en el contador específico de dicho producto[cite: 4].
     - Incrementar el contador general de ventas, el acumulador total de productos y la recaudación global[cite: 4].
  3. **Opción 2 (Mostrar estadísticas):**
     - Si el número de ventas es $0$, indicar que aún no hay registros[cite: 4].
     - Si hay ventas, calcular el promedio ($\text{Recaudación Total} / \text{Número de Ventas}$)[cite: 4].
     - Evaluar mediante condicionales `if / else` qué producto tiene el conteo de unidades acumuladas más alto[cite: 4].
  4. **Opción 3 (Mostrar tabla de productos):** Mostrar la lista fija de productos con sus respectivos precios[cite: 4].
  5. **Opción 4 (Salir):** Finalizar el ciclo del menú[cite: 4].
- **Salida:** Reporte estadístico completo e interfaz interactiva del menú[cite: 4].

---

#### Estructuras utilizadas

| Estructura | Uso en el Ejercicio |
| :--- | :--- |
| `do-while` | Mantener desplegado el menú principal de manera repetitiva hasta que el usuario elija la opción 4 (Salir)[cite: 4]. |
| `switch` | Evaluar la opción elegida en el menú principal y determinar el precio unitario del producto seleccionado[cite: 4]. |
| `while` | Validar que la opción del menú, la selección de productos ($1-4$) y la cantidad ingresada ($> 0$) sean válidas[cite: 4]. |
| `if / else` | Prevenir la división para el cálculo de promedio sin ventas y determinar el producto más vendido comparando acumuladores[cite: 4]. |
| Acumuladores | `totalRecaudado` (monto $), `totalProductos` (unidades) y acumuladores por producto (`cantCafe`, `cantSandwich`, etc.)[cite: 4]. |
| Contadores | `numeroVentas` contabiliza cada transacción efectuada correctamente[cite: 4]. |

---

#### Diagrama de Flujo

<img width="9732" height="14520" alt="image" src="https://github.com/user-attachments/assets/ed9e325c-b2cf-465f-8609-6d8e5582fe89" />


---

#### Pseudocódigo

```text
Algoritmo ControlVentasCafeteria
    Definir opcion, producto, cantidad, numeroVentas, totalProductos Como Entero
    Definir cantCafe, cantSandwich, cantJugo, cantEmpanada Como Entero
    Definir precioUnitario, subtotal, totalRecaudado, promedioVenta Como Real
    Definir mayorCantidad Como Entero
    Definir productoMasVendido Como Texto

    // Inicialización de variables globales
    numeroVentas <- 0
    totalProductos <- 0
    totalRecaudado <- 0.0
    cantCafe <- 0
    cantSandwich <- 0
    cantJugo <- 0
    cantEmpanada <- 0

    Hacer
        Escribir "===================================="
        Escribir "     CAFETERÍA UNIVERSITARIA        "
        Escribir "===================================="
        Escribir "1. Registrar venta"
        Escribir "2. Mostrar estadísticas"
        Escribir "3. Mostrar tabla de productos"
        Escribir "4. Salir"
        Escribir "===================================="
        Escribir "Seleccione una opción: "
        Leer opcion

        Mientras opcion < 1 O opcion > 4 Hacer
            Escribir "Opción inválida. Ingrese un valor entre 1 y 4: "
            Leer opcion
        FinMientras

        Segun opcion Hacer
            1:
                Escribir "--- REGISTRAR VENTA ---"
                Escribir "1. Café ($1.00)"
                Escribir "2. Sándwich ($2.50)"
                Escribir "3. Jugo ($1.50)"
                Escribir "4. Empanada ($1.25)"
                Escribir "Seleccione el producto (1-4): "
                Leer producto

                Mientras producto < 1 O producto > 4 Hacer
                    Escribir "Producto no válido. Seleccione (1-4): "
                    Leer producto
                FinMientras

                Escribir "Ingrese la cantidad: "
                Leer cantidad

                Mientras cantidad <= 0 Hacer
                    Escribir "La cantidad debe ser mayor que cero. Reintente: "
                    Leer cantidad
                FinMientras

                Segun producto Hacer
                    1:
                        precioUnitario <- 1.00
                        cantCafe <- cantCafe + cantidad
                    2:
                        precioUnitario <- 2.50
                        cantSandwich <- cantSandwich + cantidad
                    3:
                        precioUnitario <- 1.50
                        cantJugo <- cantJugo + cantidad
                    4:
                        precioUnitario <- 1.25
                        cantEmpanada <- cantEmpanada + cantidad
                FinSegun

                subtotal <- precioUnitario * cantidad
                totalRecaudado <- totalRecaudado + subtotal
                totalProductos <- totalProductos + cantidad
                numeroVentas <- numeroVentas + 1

                Escribir "Venta registrada con éxito. Subtotal: $", subtotal

            2:
                Escribir "--- REPORTES Y ESTADÍSTICAS ---"
                Si numeroVentas == 0 Entonces
                    Escribir "No hay ventas registradas en el sistema aún."
                SiNo
                    promedioVenta <- totalRecaudado / numeroVentas

                    // Determinar el producto con mayor cantidad vendida
                    mayorCantidad <- cantCafe
                    productoMasVendido <- "Café"

                    Si cantSandwich > mayorCantidad Entonces
                        mayorCantidad <- cantSandwich
                        productoMasVendido <- "Sándwich"
                    FinSi
                    Si cantJugo > mayorCantidad Entonces
                        mayorCantidad <- cantJugo
                        productoMasVendido <- "Jugo"
                    FinSi
                    Si cantEmpanada > mayorCantidad Entonces
                        mayorCantidad <- cantEmpanada
                        productoMasVendido <- "Empanada"
                    FinSi

                    Escribir "Número de ventas: ", numeroVentas
                    Escribir "Cantidad total de productos: ", totalProductos
                    Escribir "Total recaudado: $", totalRecaudado
                    Escribir "Promedio por venta: $", promedioVenta
                    Escribir "Producto más vendido: ", productoMasVendido, " (", mayorCantidad, " unidades)"
                FinSi

            3:
                Escribir "--- TABLA DE PRODUCTOS ---"
                Escribir "1. Café       $1.00"
                Escribir "2. Sándwich   $2.50"
                Escribir "3. Jugo       $1.50"
                Escribir "4. Empanada   $1.25"

            4:
                Escribir "Gracias por utilizar el sistema de la Cafetería Universitaria."
        FinSegun
    Hasta Que opcion == 4
FinAlgoritmo
```
---

#### Casos de prueba

##### Prueba de escritorio — Ejercicio 7 (Simulación de ventas)

| Transacción | Opción | Producto Seleccionado | Cantidad | Subtotal ($) | `numeroVentas` | `totalProductos` | `totalRecaudado` ($) | Promedio ($) | Producto más vendido |
| :--- | :---: | :--- | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **Inicio** | - | - | - | - | 0 | 0 | 0.00 | - | Ninguno |
| **Venta 1** | 1 | 2 (Sándwich $2.50) | 2 | 5.00 | 1 | 2 | 5.00 | 5.00 | Sándwich (2) |
| **Venta 2** | 1 | 1 (Café $1.00) | 3 | 3.00 | 2 | 5 | 8.00 | 4.00 | Café (3) |
| **Venta 3** | 1 | 4 (Empanada $1.25)| 1 | 1.25 | 3 | 6 | 9.25 | 3.08 | Café (3) |
| **Estadísticas**| 2 | - | - | - | 3 | 6 | 9.25 | 3.08 | Café (3 unidades) |

##### Casos de validación

| Caso | Entrada | Resultado esperado |
| :--- | :--- | :--- |
| **Opción menú inválida** | `opcion = 0` o `opcion = 5` | Muestra error de opción e insiste en pedir valor entre 1 y 4[cite: 4]. |
| **Producto no existente** | `producto = 8` | Muestra `"Producto no válido"` y solicita seleccionar entre 1 y 4[cite: 4]. |
| **Cantidad cero o negativa**| `cantidad = 0` o `cantidad = -3` | Muestra error y exige ingresar una cantidad mayor a cero[cite: 4]. |
| **Consulta vacía** | Seleccionar opción 2 al iniciar | Informa que no existen ventas registradas aún para evitar divisiones para cero[cite: 4]. |
| **Flujo regular completo** | Registrar ventas e ir a opción 2 | Presenta las 5 métricas requeridas actualizadas correctamente[cite: 4]. |

---
#### Capturas y evidencias
<img width="703" height="482" alt="Captura de pantalla 2026-09-24 122745" src="https://github.com/user-attachments/assets/de52064f-2657-4f8c-b1d6-98f0a1d4d9c1" />

---
#### Conclusiones

1. **Gestión de flujos mediante la estructura `do-while`:** 
   La implementación de un ciclo repetitivo `do-while` en la raíz del programa garantiza la persistencia del estado en memoria, permitiendo registrar múltiples compras consecutivas sin perder la acumulación global hasta que el usuario decida salir explícitamente[cite: 4].

2. **Modularidad mediante selección condicional (`switch`):** 
   El uso de la sentencia `switch` simplifica la toma de decisiones al bifurcar limpia y eficientemente los precios y acumuladores específicos por producto, evitando estructuras de decisiones anidadas complejas[cite: 4].

3. **Robustez mediante validación integral de entradas:** 
   La aplicación de bucles `while` de validación en cada nivel de interacción (menú, selección de producto y cantidad de unidades) protege al sistema frente a datos anómalos, previniendo incoherencias financieras o errores de ejecución[cite: 4].

   ---
   # Ejercicio 8 - Detector y Depurador de Errores

##  Enunciado

Analizar un código en Java que contiene un error relacionado con ciclos, identificar el problema, explicar la causa, corregirlo, elaborar una tabla de trazas y demostrar que la solución funciona correctamente.

---

##  Código original

```java
public class Main {
    public static void main(String[] args) {

        int numero = 1;

        while (numero <= 10) {
            System.out.println(numero);
        }
    }
}
```

---

##  Error encontrado

El error se encuentra dentro del ciclo `while`.

La variable `numero` inicia con el valor `1`, pero dentro del ciclo nunca se modifica.

La condición es:

```java
numero <= 10
```

Como `numero` siempre permanece en `1`, la condición siempre será verdadera.

Por esta razón se genera un **ciclo infinito** y el programa imprime continuamente:

```text
1
1
1
1
...
```

---

##  Causa

La causa del error es que falta incrementar la variable `numero`.

Dentro del ciclo debe agregarse:

```java
numero++;
```

Esta instrucción aumenta el valor de `numero` en uno después de cada iteración.

---

##  Solución

Código corregido:

```java
public class Main {
    public static void main(String[] args) {

        int numero = 1;

        while (numero <= 10) {
            System.out.println(numero);
            numero++;
        }
    }
}
```

---

##  Explicación de la solución

El programa comienza con:

```java
int numero = 1;
```

Luego se utiliza un ciclo `while`:

```java
while (numero <= 10)
```

El ciclo se ejecuta mientras `numero` sea menor o igual que 10.

En cada repetición se ejecutan dos instrucciones:

```java
System.out.println(numero);
numero++;
```

La primera muestra el número en pantalla y la segunda aumenta su valor en uno.

Cuando `numero` llega a 11, la condición:

```java
numero <= 10
```

se vuelve falsa y el ciclo termina.

---

##  Tabla de trazas

| Iteración | numero | Condición | Salida | Nuevo numero |
|-----------|--------|-----------|--------|--------------|
| 1 | 1 | Verdadero | 1 | 2 |
| 2 | 2 | Verdadero | 2 | 3 |
| 3 | 3 | Verdadero | 3 | 4 |
| 4 | 4 | Verdadero | 4 | 5 |
| 5 | 5 | Verdadero | 5 | 6 |
| 6 | 6 | Verdadero | 6 | 7 |
| 7 | 7 | Verdadero | 7 | 8 |
| 8 | 8 | Verdadero | 8 | 9 |
| 9 | 9 | Verdadero | 9 | 10 |
| 10 | 10 | Verdadero | 10 | 11 |
| 11 | 11 | Falso | - | Fin |

---

##  Resultado

Al ejecutar correctamente el programa se obtiene:

```text
1
2
3
4
5
6
7
8
9
10
```

El programa termina correctamente cuando `numero` llega a 11.

---

#  Segundo ejemplo creado voluntariamente

## Código con error

```java
public class EjemploError {
    public static void main(String[] args) {

        int contador = 1;

        while (contador <= 5) {
            System.out.println(contador);
            contador--;
        }
    }
}
```

## Error encontrado

El error está en:

```java
contador--;
```

En lugar de aumentar el contador, esta instrucción lo disminuye.

Los valores serían:

```text
1
0
-1
-2
-3
...
```

La condición:

```java
contador <= 5
```

continúa siendo verdadera, por lo que se produce un ciclo infinito.

---

##  Corrección del segundo ejemplo

Se debe cambiar:

```java
contador--;
```

por:

```java
contador++;
```

Código corregido:

```java
public class EjemploError {
    public static void main(String[] args) {

        int contador = 1;

        while (contador <= 5) {
            System.out.println(contador);
            contador++;
        }
    }
}
```

### Resultado

```text
1
2
3
4
5
```

---

##  Conclusión

El error principal del ejercicio se produce porque la variable utilizada para controlar el ciclo no cambia de valor. Esto provoca que la condición del `while` permanezca verdadera y genere un ciclo infinito.

La solución consiste en modificar correctamente la variable de control mediante `numero++`. De esta manera, el programa puede avanzar hasta que la condición sea falsa y finalizar correctamente.

Este ejercicio permite comprender la importancia de las variables de control en los ciclos `while` y la utilidad de las tablas de trazas para detectar errores de programación.

---
# Ejercicio 9: Estadísticas de una Encuesta Universitaria

## 1. Descripción del Ejercicio
El programa realiza un procesamiento de datos estadísticos recopilados a partir de una encuesta a $N$ estudiantes universitarios. Inicialmente solicita la cantidad total de participantes y por cada uno procesa tres datos clave con sus respectivas validaciones:

* **Edad:** Rango estricto de $16$ a $80$ años.
* **Semestre:** Rango estricto de $1$ a $10$.
* **Horas de Estudio por Día:** Rango estricto de $0$ a $24$ horas.

A partir de la información recopilada, el algoritmo calcula y determina:
1. **Edad promedio** del grupo encuestado.
2. **Horas promedio de estudio diario**.
3. **Estudiante con mayor cantidad de horas de estudio** (número de estudiante y cantidad de horas).
4. **Cantidad total de estudiantes que estudian menos de 2 horas al día**.
5. **Cantidad de estudiantes pertenecientes a cada semestre (del 1 al 10)** mediante el uso de **ciclos anidados**.

---

## 2. Tabla de Estructuras Utilizadas

| Variable / Control | Tipo de Dato | Función en el Algoritmo |
| :--- | :--- | :--- |
| `numEstudiantes` | Entero | Cantidad total de encuestados ($> 0$). |
| `i`, `sem` | Entero | Variables de control para los ciclos. |
| `edad`, `semestre` | Entero | Datos individuales ingresados por estudiante. |
| `horasEstudio` | Real / Entero | Horas diarias dedicadas al estudio por estudiante. |
| `sumaEdades`, `sumaHoras` | Real | Acumuladores para el cálculo de promedios. |
| `maxHoras` | Real | Registro de la mayor cantidad de horas ingresadas. |
| `estudianteMaxHoras` | Entero | Identificador (índice) del estudiante con mayor dedicación. |
| `menosDe2Horas` | Entero | Contador de alumnos con menos de 2 horas de estudio. |
| `conteoSemestre` | Entero | Contador temporal utilizado en el ciclo anidado por semestre. |
| `Repetir - Hasta Que` | Repetitiva | Estructura para la validación de entrada de cada variable. |
| `Para` Anidado | Repetitiva | Ciclo principal de lectura y ciclo anidado para contabilizar estudiantes por semestre. |

---

## 3. Análisis del Problema
* **Entrada:** `numEstudiantes`, y por cada alumno: `edad`, `semestre`, `horasEstudio`.
* **Restricciones de Ingreso:**
  * $numEstudiantes \ge 1$
  * $16 \le edad \le 80$
  * $1 \le semestre \le 10$
  * $0 \le horasEstudio \le 24$
* **Proceso Especial (Conteo por Semestre mediante Ciclos Anidados):**
  * Para determinar cuántos alumnos pertenecen a cada uno de los 10 semestres sin usar arreglos/vectores, se utiliza un ciclo externo `sem` de 1 a 10 y una evaluación iterativa anidada para graficar e imprimir la frecuencia de cada nivel.

---

## 4. Diagrama de Flujo

<img width="142" height="1742" alt="encuestaUniversitaria drawio" src="https://github.com/user-attachments/assets/aacd0acf-684a-412b-84e5-2b8abf35f729" />

---

## 5. Pseudocódigo (PSeInt)

```pseint
Algoritmo Estadisticas_Encuesta_Universitaria
	Definir numEstudiantes, i, sem Como Entero
	Definir edad, semestre Como Entero
	Definir horasEstudio, sumaEdades, sumaHoras Como Real
	Definir maxHoras Como Real
	Definir estudianteMaxHoras, menosDe2Horas Como Entero
	
	// Variables para conteo acumulado de cada semestre (1 al 10)
	Definir c1, c2, c3, c4, c5, c6, c7, c8, c9, c10 Como Entero
	c1 <- 0; c2 <- 0; c3 <- 0; c4 <- 0; c5 <- 0
	c6 <- 0; c7 <- 0; c8 <- 0; c9 <- 0; c10 <- 0
	
	// Validacion de cantidad de estudiantes
	Repetir
		Escribir "Ingrese la cantidad de estudiantes a encuestar (minimo 1): "
		Leer numEstudiantes
	Hasta Que numEstudiantes >= 1
	
	sumaEdades <- 0
	sumaHoras <- 0
	maxHoras <- -1
	estudianteMaxHoras <- 0
	menosDe2Horas <- 0
	
	// Ciclo Principal de Registro de Datos
	Para i <- 1 Hasta numEstudiantes Con Paso 1 Hacer
		Escribir ""
		Escribir "=== DATOS DEL ESTUDIANTE ", i, " ==="
		
		// Validacion de Edad (16 - 80)
		Repetir
			Escribir "Ingrese Edad (16 a 80): "
			Leer edad
			Si edad < 16 O edad > 80 Entonces
				Escribir "[ERROR] Edad fuera del rango permitido (16-80)."
			FinSi
		Hasta Que edad >= 16 Y edad <= 80
		
		// Validacion de Semestre (1 - 10)
		Repetir
			Escribir "Ingrese Semestre (1 a 10): "
			Leer semestre
			Si semestre < 1 O semestre > 10 Entonces
				Escribir "[ERROR] Semestre fuera del rango permitido (1-10)."
			FinSi
		Hasta Que semestre >= 1 Y semestre <= 10
		
		// Validacion de Horas de Estudio (0 - 24)
		Repetir
			Escribir "Ingrese Horas de estudio diarias (0 a 24): "
			Leer horasEstudio
			Si horasEstudio < 0 O horasEstudio > 24 Entonces
				Escribir "[ERROR] Horas fuera del rango permitido (0-24)."
			FinSi
		Hasta Que horasEstudio >= 0 Y horasEstudio <= 24
		
		// Acumuladores
		sumaEdades <- sumaEdades + edad
		sumaHoras <- sumaHoras + horasEstudio
		
		// Evaluacion de Estudiante con mayor horas de estudio
		Si horasEstudio > maxHoras Entonces
			maxHoras <- horasEstudio
			estudianteMaxHoras <- i
		FinSi
		
		// Evaluacion de Estudiantes que estudian menos de 2 horas
		Si horasEstudio < 2 Entonces
			menosDe2Horas <- menosDe2Horas + 1
		FinSi
		
		// Registro para el conteo por semestre
		Segun semestre Hacer
			1: c1 <- c1 + 1
			2: c2 <- c2 + 1
			3: c3 <- c3 + 1
			4: c4 <- c4 + 1
			5: c5 <- c5 + 1
			6: c6 <- c6 + 1
			7: c7 <- c7 + 1
			8: c8 <- c8 + 1
			9: c9 <- c9 + 1
			10: c10 <- c10 + 1
		FinSegun
	FinPara
	
	// Impresion de Resultados Generales
	Escribir ""
	Escribir "=================================================="
	Escribir "       RESULTADOS ESTADISTICOS DE LA ENCUESTA     "
	Escribir "=================================================="
	Escribir "1. Edad Promedio: ", (sumaEdades / numEstudiantes), " anos."
	Escribir "2. Horas Promedio de Estudio: ", (sumaHoras / numEstudiantes), " horas/dia."
	Escribir "3. Mayor dedicacion: Estudiante #", estudianteMaxHoras, " con ", maxHoras, " horas."
	Escribir "4. Estudiantes que estudian menos de 2 horas: ", menosDe2Horas
	Escribir ""
	Escribir "5. CANTIDAD DE ESTUDIANTES POR SEMESTRE:"
	
	// Uso de Ciclos Anidados para la muestra estructurada por Semestre (1 al 10)
	Para sem <- 1 Hasta 10 Con Paso 1 Hacer
		Escribir Sin Saltar "Semestre ", sem, ": "
		Definir conteoSemestre Como Entero
		conteoSemestre <- 0
		
		Segun sem Hacer
			1: conteoSemestre <- c1
			2: conteoSemestre <- c2
			3: conteoSemestre <- c3
			4: conteoSemestre <- c4
			5: conteoSemestre <- c5
			6: conteoSemestre <- c6
			7: conteoSemestre <- c7
			8: conteoSemestre <- c8
			9: conteoSemestre <- c9
			10: conteoSemestre <- c10
		FinSegun
		
		Escribir conteoSemestre, " estudiante(s) -> " Sin Saltar
		
		Si conteoSemestre = 0 Entonces
			Escribir "[Sin registros]"
		Sino
			Para i <- 1 Hasta conteoSemestre Con Paso 1 Hacer
				Escribir Sin Saltar "*"
			FinPara
			Escribir ""
		FinSi
	FinPara
FinAlgoritmo

---

## 6. Pruebas de Escritorio (Tabla de Traza Completa para N = 3)

### Datos de Entrada para la Prueba:
* **Estudiante 1:** Edad = `19`, Semestre = `1`, Horas = `1.5`
* **Estudiante 2:** Edad = `21`, Semestre = `3`, Horas = `5.0`
* **Estudiante 3:** Edad = `20`, Semestre = `1`, Horas = `0.5`

---

### Tabla 1: Registro de Estudiantes y Acumuladores

| Estudiante | Edad | Semestre | Horas | sumaEdades | sumaHoras | maxHoras | estMax | menos2h | Registro Semestres |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | -- | -- | -- | 0 | 0.0 | -1.0 | 0 | 0 | Todos en 0 |
| **i = 1** | 19 | 1 | 1.5 | 19 | 1.5 | 1.5 | 1 | 1 | c1 = 1 |
| **i = 2** | 21 | 3 | 5.0 | 40 | 6.5 | 5.0 | 2 | 1 | c3 = 1 |
| **i = 3** | 20 | 1 | 0.5 | 60 | 7.0 | 5.0 | 2 | 2 | c1 = 2 |
---

### Tabla 2: Traza del Ciclo Anidado (Reporte por Semestre)

| Semestre | Condicion | conteoSemestre | Evaluado | Sub-ciclo | Salida Impresa |
| :---: | :---: | :---: | :---: | :---: | :--- |
| **sem = 1** | 1 <= 10 (V) | 2 | Falso | 1, 2 | Semestre 1: 2 est. -> ** |
| **sem = 2** | 2 <= 10 (V) | 0 | Verdadero | -- | Semestre 2: 0 est. -> [Sin registros] |
| **sem = 3** | 3 <= 10 (V) | 1 | Falso | 1 | Semestre 3: 1 est. -> * |
| **sem = 4..10** | Varios (V) | 0 | Verdadero | -- | Semestre X: 0 est. -> [Sin registros] |
| **sem = 11** | 11 <= 10 (F) | -- | -- | -- | [Fin del Reporte] |

---

## 7. Casos de Validación de Entrada

| Campo Evaluado | Valor Ingresado | Condicion de Control | Resultado del Algoritmo | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **Edad** | `14` | 14 < 16 | Rechazado: Muestra error y pide reingreso. | Exitoso |
| **Edad** | `85` | 85 > 80 | Rechazado: Muestra error y pide reingreso. | Exitoso |
| **Edad** | `20` | 16 <= 20 <= 80 | Aceptado correctamente. | Exitoso |
| **Semestre** | `0` | 0 < 1 | Rechazado: Muestra error y pide reingreso. | Exitoso |
| **Semestre** | `12` | 12 > 10 | Rechazado: Muestra error y pide reingreso. | Exitoso |
| **Semestre** | `5` | 1 <= 5 <= 10 | Aceptado correctamente. | Exitoso |
| **Horas de Estudio** | `-3` | -3 < 0 | Rechazado: Muestra error y pide reingreso. | Exitoso |
| **Horas de Estudio** | `26` | 26 > 24 | Rechazado: Muestra error y pide reingreso. | Exitoso |
| **Horas de Estudio** | `4.5` | 0 <= 4.5 <= 24 | Aceptado correctamente. | Exitoso |

---

## 8. Capturas y Evidencias de Ejecución

<img width="1372" height="887" alt="image" src="https://github.com/user-attachments/assets/b81bb35c-b8bf-426a-87f4-e8b13241c69d" />

---

## 9. Conclusiones
* La implementación del ciclo `Repetir - Hasta Que` en cada parámetro asegura la integridad de los datos filtrando entradas fuera de rango.
* La simulación del histograma mediante ciclos anidados permite representar frecuencias por semestre sin usar arreglos dinámicos.
* La captura del máximo en tiempo de ejecución (`horasEstudio > maxHoras`) garantiza una complejidad de espacio $O(1)$.

---
