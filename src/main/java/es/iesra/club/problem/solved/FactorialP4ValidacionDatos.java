package es.iesra.club.problem.solved;

import es.iesra.club.problem.solver.ProblemSolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Resolver el problema del cálculo del factorial con salida detallada.
 */
public class FactorialP4ValidacionDatos extends ProblemSolver {

    @Override
    protected List<String> process(List<String> inputLines) {
        List<String> outputLines = new ArrayList<>();


        
        return outputLines;
    }



    public static void main(String[] args) {
        FactorialP4ValidacionDatos solver = new FactorialP4ValidacionDatos();
        try {
            solver.execute("inputPart4.txt", "outputPart4.txt");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
