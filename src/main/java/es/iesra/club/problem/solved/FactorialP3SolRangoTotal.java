package es.iesra.club.problem.solved;

import es.iesra.club.problem.solver.ProblemSolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Resolver el problema del cálculo del factorial con salida detallada.
 */
public class FactorialP3SolRangoTotal extends ProblemSolver {

    @Override
    protected List<String> process(List<String> inputLines) {
        List<String> outputLines = new ArrayList<>();

        long total = 0;

        for (String line : inputLines) {
            int n = Integer.parseInt(line.trim());

            if (n >= 0 && n <= 25) {
                StringBuilder detail = new StringBuilder(n + "! -> ");
                long factorial = calculateFactorialRecursive(n, detail);
                detail.append(" = ").append(factorial);
                total += factorial;

                outputLines.add(detail.toString());
            } else {
                outputLines.add(n + "! -> fuera de rango");
            }
        }

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
        if (n <= 1) {
            detail.append("1");
            return 1;
        } else {
            detail.append(n).append("x");
            return n * calculateFactorialRecursive(n - 1, detail);
        }
    }


    public static void main(String[] args) {
        FactorialP3SolRangoTotal solver = new FactorialP3SolRangoTotal();
        try {
            solver.execute("inputPart3.txt", "outputPart3.txt");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
