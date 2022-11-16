public class EnsembleTableHashing<E> implements Ensemble<E>{
	private double loadFactor;
	int taille;
	private ListeSimpleImpl<E>[] tableListes;


	// taille : taille logique - capacite : taille physique
	public EnsembleTableHashing(int capacite) {
		tableListes = new ListeSimpleImpl[capacite];
		for (int i = 0; i < capacite; i++) {
			tableListes[i] = new ListeSimpleImpl<>();
		}
	}

	// constructeur defi - loadfactor
	public EnsembleTableHashing(int capacite, double loadFactor) {
		this(capacite);
		this.loadFactor = loadFactor;
	}


	public boolean estVide(){
		return taille == 0;
	}

	
	public int taille(){
		return taille;
	}

	
	public boolean contient(E element) {
		if (element == null)
			throw new IllegalArgumentException();
		return tableListes[Math.abs(element.hashCode()) % tableListes.length].contient(element);
	}

	
	public boolean ajouter(E element) {
		if (element == null)
			throw new IllegalArgumentException();
		if (contient(element)) {
			return false;
		}
		tableListes[Math.abs(element.hashCode()) % tableListes.length].insererEnTete(element);
		taille++;
		if (loadFactor != 0 && taille / tableListes.length > loadFactor) {
			doubleTaille();
		}
		return true;
	}

	public boolean enlever(E element) {
		if (element == null)
			throw new IllegalArgumentException();
		if (!contient(element))
			return false;
		taille--;
		return tableListes[Math.abs(element.hashCode()) % tableListes.length].supprimer(element);
	}

	// defis
	private void doubleTaille() {
		taille = tableListes.length * 2;
		ListeSimpleImpl<E>[] temp = new ListeSimpleImpl[taille];
		for (int i = 0; i < taille ;i++) {
			temp[i] = new ListeSimpleImpl<>();
		}
		for (int i = 0; i < tableListes.length; i++) {
			for (E elem : tableListes[i]) {
				int indice = Math.abs(elem.hashCode()) % taille;
				temp[indice].insererEnTete(elem);
			}
		}
		tableListes = temp;
	}
}

