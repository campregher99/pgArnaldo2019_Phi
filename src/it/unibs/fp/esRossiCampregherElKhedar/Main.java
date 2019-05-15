package it.unibs.fp.esRossiCampregherElKhedar;

public class Main {
	public static Interfaccia lettScrit = new Interfaccia();
	public static Funzione phi = new Funzione();

	public static void main(String[] args) {
		double n = lettScrit.letturaInt("Inserisci il numero: ");
		lettScrit.scriviC("phi( " + n + " ) = " + phi.funzione(n));

	}

}
