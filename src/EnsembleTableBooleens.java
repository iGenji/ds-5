// implementation de l'interface Ensemble via un tableau de booleens

public class EnsembleTableBooleens<E> implements Ensemble<E> {

	private boolean[] table;
	private int taille;

	// capacite = nombre d'elements de l'univers
	public EnsembleTableBooleens(int capacite) {
		table = new boolean[capacite];
		taille = 0;
	}

	public boolean estVide() {
		return taille == 0;
	}

	public boolean contient(E element) {
		if (element.hashCode() < 0 || element.hashCode() >= table.length)
			return false;
		return table[element.hashCode()];
	}

	public boolean ajouter(E element) {
		if (element.hashCode() < 0 || element.hashCode() >= table.length)
			return false;
		if (contient(element))
			return false;
		table[element.hashCode()] = true;
		taille++;
		return true;
	}

	public boolean enlever(E element) {
		if (element.hashCode() < 0 || element.hashCode() >= table.length)
			return false;
		if (!contient(element))
			return false;
		table[element.hashCode()] = false;
		taille--;
		return true;
	}

	public int taille() {
		return taille;
	}
}