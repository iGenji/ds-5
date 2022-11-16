public class Grille9X9 {

	private int[][] table;

	public Grille9X9(int[][] tableARecopier) throws IllegalArgumentException {
		if (tableARecopier == null)
			throw new IllegalArgumentException();
		if (tableARecopier.length != 9)
			throw new IllegalArgumentException();
		for (int i = 0; i < 9; i++) {
			if (tableARecopier[i] == null || tableARecopier[i].length != 9)
				throw new IllegalArgumentException();
		}
		table = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (tableARecopier[i][j] < 1 || tableARecopier[i][j] > 9)
					throw new IllegalArgumentException();
				table[i][j] = tableARecopier[i][j];
			}
		}
	}

	private boolean ligneCorrecte(int ligne) {
		Ensemble1A9 ensemble = new Ensemble1A9();
		for (int i = 0; i < 9; i++) {
			if (!ensemble.ajouter(table[ligne][i]))
				return false;
		}
		return true;
	}

	private boolean colonneCorrecte(int colonne) {
		Ensemble1A9 ensemble = new Ensemble1A9();
		for (int i = 0; i < 9; i++) {
			if (!ensemble.ajouter(table[i][colonne]))
				return false;
		}
		return true;
	}

	private boolean blocCorrect(int ligne, int colonne) {
		Ensemble1A9 ensemble = new Ensemble1A9();
		for (int i = ligne; i < ligne + 3; i++) {
			for (int j = colonne; j < colonne + 3; j++) {
				if (!ensemble.ajouter(table[i][j]))
					return false;
			}
		}
		return true;
	}

	public boolean estUnSudoku() {
		for (int i = 0; i < 9; i++) {
			if (!ligneCorrecte(i) || !colonneCorrecte(i))
				return false;
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!blocCorrect(i, j))
					return false;
			}
		}
		return true;
	}
	
	// exercices defis
	public boolean estUnHyperSudoku() {
		for (int i = 1; i < 9; i += 4) {
			for (int j = 1; j < 9; j += 4) {
				if (!blocCorrect(i, j))
					return false;
			}
		}
		return estUnSudoku();
	}
	
	public boolean estUnSudokuDiagonal() {
		Ensemble1A9 ensembleDiag1 = new Ensemble1A9();
		Ensemble1A9 ensembleDiag2 = new Ensemble1A9();
		for (int i = 0; i < 9; i++) {
			if (!ensembleDiag1.ajouter(table[i][i]))
				return false;
			if (!ensembleDiag2.ajouter(table[i][8 - i]))
				return false;
		}
		return estUnSudoku();
	}
}
