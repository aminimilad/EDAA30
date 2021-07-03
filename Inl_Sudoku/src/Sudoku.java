import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Sudoku {
	int mx[][];
	int box[][];
	// Alert alert = new Alert(AlertType.INFORMATION);

	/*
	 * Initierar sudokubordet Konstruktorn
	 */
	public Sudoku(int mx[][]) {
		this.mx = mx;
		int[][] box = new int[9][9];
		int x = 1;
		int boxnb = 3;

		for (int i = 0; i < 9; i++) {// lång for-loop för att numrera alla positioner efter boxnummer
			x = boxnb - 2;
			for (int k = 0; k < 9; k++) {
				box[i][k] = x;
				if (i == 2 && (k == 8) || i == 5 && (k == 8)) {
					boxnb += 3;
				}
				if (k == 2 || k == 5) {
					x++;
				}
			}
			x++;
			x = x % boxnb;
		}
		this.box = box;
	}

	boolean check(int row, int colonn, int nbr) {
		// Respektive check returnerar true om det finns dubblett
		return (checkBox(row, colonn, nbr) || checkRow(row, colonn, nbr) || checkColonn(row, colonn, nbr)) == true;
	}

	/**
	 * Solves the sudoku by backtracking. Uses check to ensure there's no dubblet.
	 * Solves by calling itself in if statement. If Solve() returns false, the
	 * current number is set to 0 and the solver goes one step back
	 * 
	 * @return true if solve done
	 * @return
	 * 
	 */

	boolean solve() {

		return solve(0, 0);
	}

	boolean solve(int i, int k) {

		if (k == 9) {
			k = 0;
			i++;
			if (i == 9) {
				System.out.print("KLAR");
				return true;
			}
		}

		if (mx[i][k] == 0) {
			for (int number = 1; number <= 9; number++) {
				// om den inte hittar dubblett
				if (!check(i, k, number)) {
					/*
					 * 
					 */
					mx[i][k] = number;
					if (solve(i, k+ 1)) {
						return true;
					} else {
						mx[i][k] = 0;
					}

				}
			}
		}
		else {
			
			return solve(i, k+1);
			
		}
		return false;

	}

	/*
	 * @Param nb, värdet som ska kontrolleras om dess dubblet existerar per BOX
	 * 
	 * @return true om det finns dubblet
	 * 
	 * @Return false om det inte finns någon dubblet
	 */
	boolean checkBox(int row, int colonn, int nb) {
		int boxNb = box[row][colonn];

		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (box[x][y] == boxNb) {

					if (mx[x][y] == nb && x != row && y != colonn) {
						return true;// nummer finns redan
					}
				}
			}
		}

		return false;
	}

	/*
	 * @Param nb, värdet som ska kontrolleras om dess dubblet existerar per RAD
	 * 
	 * @return true om det finns dubblet
	 * 
	 * @Return false om det inte finns någon dubblet
	 */

	boolean checkRow(int row, int colonn, int nb) {

		// om inte ifylld ruta
		for (int i = 0; i < 9; i++) { // gå igenom kolumnen
			int Sqx = mx[row][i];// innehållet i rutan
			if (Sqx == nb && colonn != i) { // om innehåll i ruta x == nummer vi prövar
				return true; // nummer finns redan
			}
		}

		return false;
	}

	/*
	 * @Param nb, värdet som ska kontrolleras om dess dubblet existerar per KOLUMN
	 * 
	 * @return true om det finns dubblet
	 * 
	 * @Return false om det inte finns någon dubblet
	 */
	boolean checkColonn(int row, int colonn, int nb) {

		for (int i = 0; i < 9; i++) { // gå igenom kolumnen
			int Sqx = mx[i][colonn];// innehållet i rutan
			if (Sqx == nb && row != i) { // om innehåll i ruta x == nummer vi prövar
				return true; // nummer finns redan
			}
		}

		return false;
	}

	/*
	 * 
	 * @Return returnerar matrisen
	 */
	public int[][] getMx() {
		return mx;
	}

	private void alert(String title, String headerText, String infoText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(infoText);
		alert.showAndWait();
	}

	public void setValuein(int x, int y, int value) {
		mx[x][y] = value;
	}

	public int getvaluefrom(int x, int y) {
		int valueToReturn;
		valueToReturn = mx[x][y];
		return valueToReturn;
	}

}