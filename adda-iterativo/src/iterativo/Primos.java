package iterativo;

import java.util.ArrayList;
import java.util.List;

public class Primos {
	
	public static Boolean esPrimo(Long n) {
		Long sqrt = (long) Math.sqrt((double) n);
		Long e = 2L;
		Boolean a = false;
		while (e <= sqrt && !a) {
			a = n % e == 0;
			e = e + 1;
		}
		return !a;
	}
	
	public static Long siguientePrimo(Long n) {
		Boolean a = false;
		Long r = null;
		Long e = n + 1;		
		if (e % 2 == 0) {
			e = e + 1;
		}
		while (!a) {
			if (esPrimo(e)) {
				a = true;
				r = e;
			}
			e = e + 2;
		}
		return r;
	}
	
	public static List<Long> primosMenores(Long n) {
		List<Long> a = new ArrayList<>();
		Long e = 1L;
		while (e < n) {
			e = siguientePrimo(e);
			if (e < n) {
				a.add(e);
			}
		}
		return a;
	}
	
	public static Long sumaPrimos(Long m, Long n) {
		Long a;
		Long e = m;
		if (esPrimo(m)) {
			a = m;
		} else {
			a = 0L;
		}
		while (e < n) {
			e = siguientePrimo(e);
			if (e < n) {
				a = a + e;
			}
		}
		return a;
	}

}
