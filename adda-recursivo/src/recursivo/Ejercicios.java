package recursivo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import iterativo.Primos;

public class Ejercicios {
	public static Integer factorial(Integer n) {
		return IntStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y);
	}
	
	public static <E> Boolean estaOrdenada(List<E> ls, Comparator<E> cmp) {
		int i = 0;
		Boolean a = true;
		while (i < ls.size()-1 && a) {
			a = cmp.compare(ls.get(i), ls.get(i + 1)) <= 0;
			i = i + 1;
		}	
		return a;
	}
	
	public static Boolean algunImparPrimo(List<Integer> ls) {
		return ls.stream().anyMatch(e -> (e % 2 != 0) && (Primos.esPrimo((long) e)));
	}
	
	public static Boolean algunImparPrimoR(List<Integer> ls) {
		return algunImparPrimoR(ls, 0, false);
	}
	
	private static Boolean algunImparPrimoR(List<Integer> ls, int n, Boolean b) {
		if (!b) {
			if (ls.size() == 0) {
				b = false;
			} else if (n == ls.size() - 1) {
				b = (ls.get(n) % 2 != 0) && Primos.esPrimo((long) ls.get(n));
			} else {
				b = algunImparPrimoR(ls, n + 1, (ls.get(n) % 2 != 0) && Primos.esPrimo((long) ls.get(n)));
			}
		}
		return b;
	}
	
	public static Integer buscarMayorA(List<Integer> ls, Integer n) {
		return ls.stream().filter(e -> e > n).findFirst().orElse(-1);
	}
	
	public static Integer buscarMayorAR(List<Integer> ls, Integer n) {
		return buscarMayorAR(ls, n, 0, false, null);
	}
	
	private static Integer buscarMayorAR(List<Integer> ls, Integer n, Integer i, Boolean b, Integer r) {
		if (!b) {
			if (i == ls.size() - 1 && ls.get(i) > n) {
				r = ls.get(i);
			} else if (i < ls.size()) {
				r = buscarMayorAR(ls, n, i + 1, ls.get(i) > n, ls.get(i));
			} else {
				r = -1;
			}
		}
		return r;
	}
}
