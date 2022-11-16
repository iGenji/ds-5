import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implementation de l'interface ListeSimple avec une liste simplement chainee et sentinelle
 * 
 */
public class ListeSimpleImpl<E> implements ListeSimple<E>, Iterable<E> {
	
	private Noeud tete;
	private int taille;
	private int numVersion; //pour l iterateur
	
	// construit une liste avec un noeud sentinelle
	public ListeSimpleImpl(){
		tete = new Noeud(null, null);  // sentinelle
		taille=0;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeSimpleImpl(Object[] table) {
		if(table==null)
			throw new IllegalArgumentException();
		this.taille = table.length;
		tete = new Noeud(null, null);
		for (int i = table.length-1; i>=0; i--) {
			E element = (E)table[i];
			this.tete.suivant=new Noeud(element,tete.suivant);
		}	
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=tete.suivant;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
			}
			aRenvoyer+=" "+baladeur.element;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}

	// nombre de noeuds en ne comptant pas le noeud sentinelle
	public int taille(){
		return taille;
	}

	// la liste ne cntient que le noeud sentinelle
	public boolean estVide(){
		return taille==0;
	}
	
	// renvoie l element contenu dans le noeud qui suit le noeud sentinelle
	public E premier()throws ListeVideException{
		//return null;
		// TODO
		if(this.estVide())
			throw new ListeVideException();
		return tete.suivant.element;
	}


	// insere un nouveau noeud  avec l element passe en parametre apres le noeud sentinelle
	public void insererEnTete(E element) {
		// TODO
		tete.suivant = new Noeud(element,tete.suivant);
		taille++;
		numVersion++;
	}
	

	// verifie la presence d un noeud contenant l element passe en parametre
	public boolean contient(E element){
		// TODO
		//return false;
		Noeud baladeur = tete.suivant;

		while(baladeur != null){
			if(baladeur.element.equals(element))return true;
			baladeur = baladeur.suivant;
		}		
		return false;
	}

	

	
	// insere un nouveaud noeud apres le noeud contenant la premiere occurrence de l'element passe en parametre
	public boolean insererApres(E element, E elementAInserer){
		// TODO
		//return false;
		Noeud baladeur = tete.suivant;
		while(baladeur != null){
			if(baladeur.element.equals(element)){
				Noeud nouveauNoeud = new Noeud(elementAInserer,baladeur.suivant);
				baladeur.suivant = nouveauNoeud;
				taille++;
				numVersion++;
				return true;
			}
			baladeur = baladeur.suivant;
		}
		return false;
	}
	
	//supprime le noeud contenant la premiere occurrence de l'element passe en parametre
	public boolean supprimer(E element){
		// TODO
		//return false;
		Noeud precedent = tete;
		Noeud baladeur = tete.suivant;
		while(baladeur != null){
			if(baladeur.element.equals(element)){
				precedent.suivant = baladeur.suivant;
				taille--;
				numVersion++;
				return true;
			}
			precedent = baladeur;
			baladeur = baladeur.suivant;
		}
		return false;
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO
		return new IterateurImpl<E>();
	}
	
	
	private class Noeud{
		private E element;
		private Noeud suivant;

		public Noeud(E element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}
	}
	
	
	private class IterateurImpl<E> implements Iterator<E>{
		
		private Noeud noeudCourant;
		private int version;
		
	
		// Au depart le noeud courant est le noeud qui suit le noeud sentinelle
		private IterateurImpl() {
			// TODO
			noeudCourant =   tete.suivant;
			version = numVersion;
		}
		
		@Override
		public boolean hasNext() {
			// TODO
			//return false;
			return noeudCourant!=null;
		}

		@Override
		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
		   if (!hasNext()) throw new NoSuchElementException();
		   if(version!=numVersion)
			   throw new ConcurrentModificationException();
		   E aRenvoyer = (E)noeudCourant.element;
		   noeudCourant = noeudCourant.suivant;
		   return aRenvoyer;
		   // TODO
		  //return null;
		}

		@Override
		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
		
	}

}
