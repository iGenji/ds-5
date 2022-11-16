public class TestPlaqueDeVoiture {
	public static void main(String[] args) {
		int[] cpt = new int[500];
		for (char l = 'A'; l <= 'Z'; l++) {
			for (char m = 'A'; m <= 'Z'; m++) {
				for (char n = 'A'; n <= 'Z'; n++) {
					for (int i = 0; i <= 9; i++) {
						for (int j = 0; j <= 9; j++) {
							for (int k = 0; k <= 9; k++) {
								Voiture v = new Voiture('1' + "" + l + "" + m + "" + n + "" + i + "" + j + "" + k, "");
								cpt[Math.abs(v.hashCode()) % 500]++;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < cpt.length; i++) {
			System.out.println(cpt[i]);
		}
	}
}
