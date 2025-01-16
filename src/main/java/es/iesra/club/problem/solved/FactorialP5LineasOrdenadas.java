package es.iesra.club.problem.solved;

import es.iesra.club.problem.solver.ProblemSolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Resolver el problema del cálculo del factorial con salida detallada.
 */
public class FactorialP5LineasOrdenadas extends ProblemSolver {

    @Override
    protected List<String> process(List<String> inputLines) {
        Map<Integer, String> resultados = new TreeMap<>();

        long total = 0;

        for (String line : inputLines) {
            String trimmedLine = line.trim();

            // Validar si la línea puede convertirse a entero
            if (isInt(trimmedLine)) {
                int n = Integer.parseInt(trimmedLine);

                if (n >= 0 && n <= 25) {
                    StringBuilder detail = new StringBuilder(n + "! -> ");
                    long factorial = calculateFactorialRecursive(n, detail);
                    detail.append(" = ").append(factorial);
                    total += factorial;

                    resultados.put(n, detail.toString());
                }
            }
        }

        List<String> outputLines = new ArrayList<>(resultados.values());
        outputLines.add("total = " + total);
        return outputLines;
    }

    /**
     * Calcula el factorial de un número utilizando recursividad para n > 1.
     *
     * @param n Número del que se calcula el factorial.
     * @param detail Cadena que acumula los detalles de la operación.
     * @return Factorial del número.
     */
    private long calculateFactorialRecursive(int n, StringBuilder detail) {
        if (n == 1) {
            detail.append("1");
            return 1;
        } else {
            detail.append(n).append("x");
            return n * calculateFactorialRecursive(n - 1, detail);
        }
    }


    /**
     * Verifica si una cadena representa un número entero válido, considerando
     * opcionalmente los signos '+' o '-' en la primera posición de la cadena.
     * Solo se aceptan números enteros, no valores con decimales ni otros caracteres.
     *
     * @param str La cadena a verificar.
     * @return true si la cadena representa un número entero válido; false en caso contrario.
     *
     * Ejemplos:
     *     "  7" -> true
     *     "-7" -> true
     *     "+7" -> true
     *     "007" -> true
     *     "7.0" -> false
     *     "abc" -> false
     */
    private boolean isIntRegEx(String str) {
        return str.trim().matches("[+-]?\\d+"); // Acepta números con signo '+' o '-' opcional
        /*
        matches: Verifica si toda la cadena cumple con este patrón.
        [+-]?: El signo + o - es opcional.
        \\d+: Coincide con uno o más dígitos consecutivos.
        */
    }


    /**
     * Verifica si una cadena representa un número entero válido, considerando
     * opcionalmente los signos '+' o '-'. Solo se aceptan números enteros,
     * no valores con decimales ni otros caracteres.
     *
     * @param str La cadena a verificar.
     * @return true si la cadena representa un número entero válido; false en caso contrario.
     *
     * Ejemplos:
     *     "  7" -> true
     *     "-7" -> true
     *     "+7" -> true
     *     "007" -> true
     *     "7.0" -> false
     *     "abc" -> false
     */
    private boolean isInt(String str) {
        if (str == null || str.isEmpty()) {
            return false; // No puede ser un número
        }

        str = str.trim();
        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.length() == 1) {
                return false; // Solo un signo no es un número
            }
            i = 1; // Comenzar después del signo
        }

        for (; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false; // Si no es un dígito, no es un número
            }
        }

        return true;
    }


    public static void main(String[] args) {
        FactorialP5LineasOrdenadas solver = new FactorialP5LineasOrdenadas();
        try {
            solver.execute("inputPart5.txt", "outputPart5.txt");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
