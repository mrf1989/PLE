import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class PruebaRepo {

	public static String getConstraints(double[][] arr) {
		int n = arr.length;
		String r = "";
		r = r + "min: ";
		
		// Función objetivo
		r = r + IntStream.range(0, n).boxed()
				.map(i -> IntStream.range(0, n).boxed().map(j -> String.format("%.2fx%d_%d ", arr[i][j], i, j)).collect(Collectors.joining("+", "", "")))
				.collect(Collectors.joining("+"));
		r = r + ";\n\n";
		
		// Restricciones: cada agente realiza una sola tarea
		r = r + IntStream.range(0, n).boxed()
				.map(i -> IntStream.range(0, n).boxed().map(j -> String.format("x%d_%d", i, j)).collect(Collectors.joining("+", "", " = 1;\n")))
				.collect(Collectors.joining(""));
		r = r + "\n";
		
		// Restricciones: todas las tareas se realizan
		r = r + IntStream.range(0, n).boxed()
				.map(j -> IntStream.range(0, n).boxed().map(i -> String.format("x%d_%d", i, j)).collect(Collectors.joining("+", "", " = 1;\n")))
				.collect(Collectors.joining(""));
		r = r + "\n";
		
		// Variables de tipo binario
		r = r + "bin ";
		r = r + IntStream.range(0, n).boxed()
				.map(i -> IntStream.range(0, n).boxed().map(j -> String.format("x%d_%d", i, j)).collect(Collectors.joining(",", "", "")))
				.collect(Collectors.joining(","));
		r = r + ";\n\n\n";
		
		return r;
	}
	
	public static void main(String[] args) {
		double[][] costes = {
				{2.3, 0.5, 1.1, 4.2},
				{1.1, 1.0, 0.9, 1.2},
				{5.2, 6.3, 1.1, 8.2},
				{1.2, 1.1, 2.3, 1.3}
		};
		
		System.out.println(getConstraints(costes));
		SolutionPLI s = AlgoritmoPLI.getSolution(getConstraints(costes));
		System.out.println("-------------------------------------------\n");
		System.out.println("Solución: " + s.getGoal());
		
	}

}
