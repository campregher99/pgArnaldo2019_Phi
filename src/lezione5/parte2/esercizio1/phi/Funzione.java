package lezione5.parte2.esercizio1.phi;

import java.util.ArrayList;

public class Funzione {
	/**
	 * il numero primo che nelle slide è nominato come p
	 */
	private double primo;
	/**
	 * il numero che nelle slide è nominato come a
	 */
	private double a;
	/**
	 * il numero che nelle slide è nominato come b
	 */
	private double b;

	/**
	 * funzione ricorsiva che calcola il <b>phi di Eulero</b> del numero n secondo
	 * la sua legge matematica
	 * 
	 * @param n (numero del quale si vuole trovare il phi)
	 * @return ritorna il <b>phi di Eulero</b> del numero n
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
	 * metodo che verifica se il numero a è primo
	 * 
	 * @param a (numero da controllare)
	 * @return boolean (true se a è primo, false se non lo è)
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
	 * funzinoe per capire se esiste il numero p tale che (n=p^k), dove: _a = n; _p
	 * = primo; Se è stato possibile calcolarlo il valore di p è salvato
	 * nell'attributo "primo" della classe;
	 * 
	 * @param a (il numero n)
	 * @return boolean (true se esiste il numero p tale che (n=p^k), false se non
	 *         esiste)
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
	 * funzione per calcolare se esistono a e b tali che n=a*b con MCD(a,b)=1, dove
	 * n è il parametro a; Se è stato possibile calcolarli i valori di a e b vengono
	 * salvati nei rispettivi attributi "a" e "b" della classe;
	 * 
	 * @param a (il numero n)
	 * @return boolean (true se i valori di a e b vengono trovati, false se non è
	 *         stato possibile trovarli)
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
