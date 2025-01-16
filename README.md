## **Cálculo de factoriales**

En este problema, trabajaremos con números factoriales y un rango específico. Se te proporcionará un archivo de entrada 
(`input.txt`) que contendrá una lista de números enteros (uno por línea). Tu tarea es procesar estos números de la 
siguiente manera:

### **Reglas del Problema**

1. **Factorial de Números**:
    - El factorial de un número `n` se define como:
      ```
      n! = n x (n-1) x (n-2) x ... x 1
      ```
      Por ejemplo:
      ```
      4! = 4 x 3 x 2 x 1 = 24
      ```

2. **Casos Especiales**:
    - El factorial de `0` y `1` tiene un valor especial, y ambos se consideran iguales:
      ```
      0! = 1! = 1
      ```
      En el archivo de salida, deben representarse de manera detallada:
      ```
      1! -> 1 = 1
      0! -> 1 = 1
      ```

### **Entrada y Salida**

1. **Archivo de Entrada (`input.txt`)**:
    - Contendrá una lista de números enteros, uno por línea.

2. **Archivo de Salida (`output.txt`)**:
    - Para cada número, escribe su factorial de manera detallada.

---

### **Parte 1: Solución con Iteración (Bucle)**

Escribe un programa que procese un archivo de entrada (`input.txt`) que contiene números enteros (uno por línea). Para 
cada número, calcula su factorial utilizando un **bucle iterativo** y escribe el resultado en un archivo de salida 
(`output.txt`) en el formato:

```
n! -> n x (n-1) x ... x 1 = resultado
```

**Archivo de entrada (`input.txt`):**
```
1
4
6
0
```

**Archivo de salida (`output.txt`):**
```
1! -> 1 = 1
4! -> 4x3x2x1 = 24
6! -> 6x5x4x3x2x1 = 720
0! -> 1 = 1
```

---

### **Parte 2: Solución con Recursividad**

Modifica el programa anterior para calcular el factorial utilizando **recursividad** en lugar de un bucle. Asegúrate de 
que el formato de salida siga siendo el mismo.

---

#### **¿Qué es la Recursividad?**  

La recursividad es una técnica donde una función se llama a sí misma para resolver un problema dividiéndolo en subproblemas 
más pequeños. Es útil cuando un problema tiene una estructura repetitiva o puede definirse en términos de sí mismo.

#### **Estructura de una Función Recursiva**

1. **Caso Base**:
   - Es la condición donde la función termina.
   - Evita bucles infinitos y errores de pila.
   - Ejemplo: En un problema de contar, el caso base podría ser "cuando no hay más elementos".

2. **Llamada Recursiva**:
   - La función se llama a sí misma con un subproblema reducido.
   - Cada llamada debe acercar el problema al caso base.

#### **Ventajas**

- Solución más intuitiva para problemas como recorrer árboles, dividir listas, o resolver laberintos.
- Hace el código más claro y compacto para ciertos problemas.

#### **Desventajas**

- Puede consumir mucha memoria debido a las llamadas anidadas (StackOverFlow).
- Puede ser menos eficiente que un bucle iterativo.

El StackOverflow ocurre cuando una función recursiva (o llamada de funciones anidadas) no tiene un caso base adecuado o 
realiza demasiadas llamadas antes de completarse, llenando la pila de llamadas (stack) de la memoria. Esto provoca un 
error porque la memoria asignada a la pila se agota.

#### **Buenas Prácticas**

1. **Define el Caso Base** claramente para que la función termine.
2. **Reduce el Problema** en cada paso para acercarte al caso base.
3. **Evita Redundancias** resolviendo subproblemas innecesarios.

#### **Ejemplo de Recursividad: Contar hasta N**

Escribe una función recursiva que imprima los números del 1 al número `n` que se pasa como parámetro. La función debe 
detenerse cuando haya llegado al número `n`.

```java
public class CountToN {

    // Función recursiva para contar hasta n
    public static void countToN(int current, int n) {
        if (current > n) { // Caso base: detener cuando current supera a n
            return;
        }
        System.out.println(current); // Imprimir el número actual
        countToN(current + 1, n); // Llamada recursiva con el siguiente número
    }

    public static void main(String[] args) {
        int n = 5; // Número objetivo
        System.out.println("Contando del 1 al " + n + ":");
        countToN(1, n); // Llamar a la función desde 1 hasta n
    }
}
```

**Salida Esperada:**

```
Contando del 1 al 5:
1
2
3
4
5
```

#### **Explicación del Código**

1. **Caso Base**:
   - La función se detiene cuando `current > n`.

2. **Llamada Recursiva**:
   - En cada llamada, la función incrementa el valor actual (`current`) en 1 y se vuelve a llamar con este nuevo valor.

3. **Inicio del Proceso**:
   - En el `main`, la función comienza desde 1 y cuenta hasta el valor de `n`.

---

### **Parte 3: Incluir Total**

Amplía el programa para incluir una última línea en el archivo de salida que muestre la suma total de los resultados de 
todos los factoriales válidos dentro del rango [0, 25]. 

Si el archivo de entrada contiene:

**Archivo de entrada (`input.txt`):**
```
1
4
34
6
0
-2
```

**Archivo de salida (`output.txt`):**
```
1! -> 1 = 1
4! -> 4x3x2x1 = 24
34! -> fuera de rango
6! -> 6x5x4x3x2x1 = 720
0! -> 1 = 1
-2! -> fuera de rango
total = 746
```

---

### **Parte 4: Validación de Datos**

En esta parte, el archivo de entrada puede contener cualquier dato (no necesariamente números enteros). Tu programa debe 
procesar únicamente los datos que se puedan convertir a enteros, ignorando los demás y mostrando un mensaje de error en 
el archivo de salida. 

Una buena solución puede ser el uso de try-catch para controlar la conversión del valor de cada 
línea a un número entero.

Si el archivo de entrada contiene:

**Archivo de entrada (`input.txt`):**
```
abc
+8
30
-1
6.88
  10
1
6
```

El archivo de salida deberá ser:

**Archivo de salida (`output.txt`):**
```
abc -> error
8! -> 8x7x6x5x4x3x2x1 = 40320
30! -> fuera de rango
-1! -> fuera de rango
6.88 -> error
10! -> 10x9x8x7x6x5x4x3x2x1 = 3628800
1! -> 1 = 1
6! -> 6x5x4x3x2x1 = 720
total = 3669841
```

---

### **Parte 5: Líneas de salida ordenadas**

Modifica el programa para que el archivo de salida (output.txt) solo contenga las líneas que tienen una solución válida 
(es decir, números dentro del rango [0, 25]). Además, las líneas deben aparecer ordenadas de menor a mayor según el número 
del que se calculó el factorial.

En esta ocasión no puedes usar try-catch para la validación de la conversión a entero del valor de cada línea. Puedes usar
una función para comprobar que la cadena de caracteres podría convertirse sin problemas a un número entero (esta comprobación 
resulta muy simple con expresiones regulares, inténtalo con y sin ellas)

Si el archivo de entrada contiene:

**Archivo de entrada (`input.txt`):**
```
abc
+8
30
-1
6.88
  10
4
1
6
```

El archivo de salida deberá ser:

**Archivo de salida (`output.txt`):**
```
1! -> 1 = 1
6! -> 6x5x4x3x2x1 = 720
8! -> 8x7x6x5x4x3x2x1 = 40320
10! -> 10x9x8x7x6x5x4x3x2x1 = 3628800
total = 3669841
```
