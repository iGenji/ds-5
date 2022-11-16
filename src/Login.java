public class Login {
   
 	private String login;
	
	public Login(String login) throws IllegalArgumentException {
		if (login == null || login.length() != 7 || (login.substring(0, 4).compareTo("info") != 0
				&& login.substring(0, 4).compareTo("mark") != 0 && login.substring(0, 4).compareTo("admi") != 0))
			throw new IllegalArgumentException("login incorrect");
		this.login = login;
	}

	public String toString(){
		return "/n"+login +"   "+login;
	}

	// renvoie un entier >= 0
	// cet entier represente de facon unique le login courant!
	public int hashCode() {
		if (login.substring(0, 4).compareTo("info") == 0) {
			return Integer.parseInt(login.substring(4, 7)) - 1;
		}
		if (login.substring(0, 4).compareTo("mark") == 0) {
			return Integer.parseInt(login.substring(4, 7)) + 136;
		}
		return Integer.parseInt(login.substring(4, 7)) + 209;
	}
}

