package es.iesra.club.problem.solved;

import es.iesra.club.problem.solver.ProblemSolver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Resolver el problema del cálculo del factorial con salida detallada.
 */
public class FactorialP1SolIterativa extends ProblemSolver {

    @Override
    protected List<String> process(List<String> inputLines) {
        List<String> outputLines = new ArrayList<>();

        for (String line : inputLines) {
            int n = Integer.parseInt(line.trim());

            if (n >= 0) {
                StringBuilder detail = new StringBuilder(n + "! -> ");
                long factorial = calculateFactorialIterative(n, detail);
                detail.append(" = ").append(factorial);
                outputLines.add(detail.toString());
            }
        }

        return outputLines;
    }

    /**
     * Calcula el factorial de un número utilizando un bucle iterativo para n > 1.
     *
     * @param n Número del que se calcula el factorial.
     * @param detail Cadena que acumula los detalles de la operación.
     * @return Factorial del número.
     */
    private long calculateFactorialIterative(int n, StringBuilder detail) {
        long result = 1;

        if (n == 0 || n == 1) {
            // Manejar los casos especiales de 0! y 1!
            detail.append("1");
        } else {
            // Cálculo del factorial y representación detallada para n > 1
            for (int i = n; i > 0; i--) {
                result *= i;

                detail.append(i);
                if (i > 1) {
                    detail.append("x");
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FactorialP1SolIterativa solver = new FactorialP1SolIterativa();
        try {
            solver.execute("inputPart1.txt", "outputPart1.txt");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
