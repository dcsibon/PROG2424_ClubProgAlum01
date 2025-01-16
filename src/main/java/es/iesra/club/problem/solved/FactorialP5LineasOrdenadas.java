package es.iesra.club.problem.solved;

import es.iesra.club.problem.solver.ProblemSolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Resolver el problema del cálculo del factorial con salida detallada.
 */
public class FactorialP5LineasOrdenadas extends ProblemSolver {

    @Override
    protected List<String> process(List<String> inputLines) {

    
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
