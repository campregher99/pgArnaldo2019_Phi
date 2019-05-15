package it.unibs.fp.esRossiCampregherElKhedar;

import java.util.ArrayList;

public class Funzione {
	/**
	 * 
	 */
	private double primo;
	/**
	 * 
	 */
	private double a;
	/**
	 * 
	 */
	private double b;

	/**
	 * 
	 * @param n
	 * @return
	 */
	public int funzione(double n) {
		if (isPotenza(n)) {
			return (int) ((primo - 1) * (n / primo));
		} else if (isMCD(n)) {
			return (int) funzione(a) * funzione(b);
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	private boolean isPrimo(double a) {
		int divisori = 0;

		for (int i = 1; i <= a; i++) {

			if (a % i == 0)
				divisori++;
		}
		if (divisori > 2)
			return false;
		return true;
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	private boolean isPotenza(double a) {
		ArrayList<Integer> listaPrimi = new ArrayList<Integer>();
		for (int i = 2; i <= a; i++) {
			if (isPrimo(i))
				listaPrimi.add(i);
		}

		for (int i = 0; i < listaPrimi.size(); i++) {
			double resto = a;
			do {
				resto = (double) resto / listaPrimi.get(i);

			} while (resto > 1);

			if (resto == 1) {
				primo = listaPrimi.get(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	private boolean isMCD(double a) {
		for (int i = 1; i <= a; i++) {
			if (a % (a - i) == 0) {
				this.a = a - i;
				this.b = a / (a - i);
				double divisore = this.a - 1;
				do {
					if (this.a % divisore == 0 && this.b % divisore == 0)
						break;
					divisore--;
				} while (divisore > 1);
				if (divisore == 1)
					return true;
			}

		}
		return false;
	}
}
