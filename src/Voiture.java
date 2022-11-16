public class Voiture{
	
	public String numPlaque; // de type 1-AAA-999
	public String nomDuProprietaire;


	public Voiture(String numPlaque, String nomDuProprietaire){
		if(numPlaque==null)
			throw new IllegalArgumentException();
		if(nomDuProprietaire==null)
			throw new IllegalArgumentException();
		if(numPlaque.length()!=7)
			throw new IllegalArgumentException("plaque pas du type 1AAA999");
		this.numPlaque = numPlaque.toUpperCase();
		if(numPlaque.charAt(0)!='1')
			throw new IllegalArgumentException("plaque pas du type 1AAA999");
		for(int i=1; i<4; i++){
			if(this.numPlaque.charAt(i)<'A'||this.numPlaque.charAt(i)>'Z')
				throw new IllegalArgumentException("plaque pas du type 1AAA999");
		}
		for(int i=4; i<7; i++){
			if(this.numPlaque.charAt(i)<'0'||this.numPlaque.charAt(i)>'9')
				throw new IllegalArgumentException("plaque pas du type 1AAA999");
		}
		this.nomDuProprietaire = nomDuProprietaire; 
	}


	public String getNumPlaque() {
		return numPlaque;
	}


	public String getNomDuProprietaire() {
		return nomDuProprietaire;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		if (numPlaque == null) {
			if (other.numPlaque != null)
				return false;
		} else if (!numPlaque.equals(other.numPlaque))
			return false;
		return true;
	}

//	ex a
//	public int hashCode(){
//		int resultat = 0;
//		for(int i = 0 ; i < 7 ; i++){
//			resultat +=(int) this.numPlaque.charAt(i);
//		}
//		return resultat;		
//	}


//	 ex b
//	public int hashCode(){
//		return Math.abs(numPlaque.hashCode());
//	}


//	ex c
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((numPlaque == null) ? 0 : numPlaque.hashCode());
//		return result;
//	}

//	ex d
//	public int hashCode() {
//		return Integer.parseInt(numPlaque.substring(4, 7))/2;
//	}
	
	public int hashCode() {
		return numPlaque.hashCode();
	}
}

