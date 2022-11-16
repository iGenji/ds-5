public class EnsembleVoituresAutorisees{

	private EnsembleTableHashing<Voiture> ensemblePlaques;

	public EnsembleVoituresAutorisees(){
//		ensemblePlaques = new EnsembleTableHashing<Voiture>(500);
//		 Pour tester le defi loadfactor :
		 ensemblePlaques = new EnsembleTableHashing<Voiture>(2, 0.75);
	}


	/**
	 * ajoute la voiture dans l ensemble des voitures autorisees
	 * @param voiture la voiture autorisee
	 * @return true si la voiture etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(Voiture voiture){
		return ensemblePlaques.ajouter(voiture); 	
	}

	/**
	 * retire la voiture de l ensemble des voitures autorisees
	 * @param voiture la voiture non autorisee
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(Voiture voiture){
		return ensemblePlaques.enlever(voiture);
	}
	
	/**
	 * verifie si la voiture est presente dans l ensemble des voitures autorisees
	 * @param voiture la voiture a verifier
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean voitureAutorisee(Voiture voiture){
		return ensemblePlaques.contient(voiture);
	}
}