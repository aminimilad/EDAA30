
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class SudokuViewer extends Application {
	static TextField[][] textField2;
	static Sudoku solution;
	private static Object[][] sudokutTiles;
	int[][] sq;

	@Override
	public void start(Stage stage) {
		sq = new int[9][9];
		textField2 = new  TextField[9][9];
		
		BorderPane root = new BorderPane();
		stage.setScene(new Scene(root, 375, 400));
		stage.setTitle("Sudoku");
		stage.show();

		HBox hbox = new HBox(); 

		TilePane root2 = new TilePane();
		root2.setPrefColumns(5);
		root2.setPrefRows(15);
		root2.setHgap(1);
		root2.setVgap(1);
		root2.setPadding(new Insets(3, 3, 3,3));

		final int SIZE = 40;
		
		
		for (int i = 0; i <= 8; i++) {
		   for (int k = 0; k <= 8; k++) {
			   Tfield textField = new Tfield();
				textField.setPrefSize(SIZE, SIZE);
			    textField2[i][k] = textField;
          	///	if ((i + k) % 2 != 0) {	textField.setStyle("-fx-background-color: white;");}
		
		   if ((i < 3 || i > 5) && k < 3) {
              textField2[i][k].setStyle("-fx-background-color: #05ffb0;");
          }
          if ((i < 3 || i > 5) && k > 5) {
              textField2[i][k].setStyle("-fx-background-color: #05ffb0;");
          }
          if (i > 2 && i < 6 && k > 2 && k < 6) {
              textField2[i][k].setStyle("-fx-background-color: #05ffb0;");
          }
		root2.getChildren().add(textField2[i][k]);

		}
		}
		stage.setResizable(false);
		
		
		root.setCenter(root2);
		root.setBottom(hbox);
	    Button solve = new Button("solve");
	    Button clear = new Button("clear");
	    hbox.getChildren().addAll(solve , clear);
		Sudoku SSS = new Sudoku(this.sq);

	    
	    
	    ///////////////////////////////////////////
	    solve.setOnAction(e -> {
	        String savedNumber; 
			/// build the int array
			for (int i = 0; i <= 8; i++) {
				
				for (int k = 0; k <= 8; k++) {
					
					
					//Om en bokstav skrivs
					savedNumber  = textField2[i][k].getText();
					
						if(savedNumber.equals("")) {
							sq[i][k] = 0;
						}
						else {
						sq[i][k]  = Integer.parseInt(savedNumber);
						}
				
				    
						
					
					
					}
				}
				
			if(SSS.solve() == true) {
				this.sq = SSS.getMx();
			}
			else {
				alert("","","");
				return;
			}
			solution = new Sudoku(sq);

			StringBuilder buffert = new StringBuilder();
			String Str;
			for (int i = 0; i <= 8; i++) 
			{
				//Har hand om utskriften
				for (int k = 0; k <= 8; k++) {	
					buffert.append(this.sq[i][k]);
					Str = buffert.toString();
					buffert.delete(0, buffert.length());
				}
			}

				//Solvar och fyller bordet
				if(solution.solve()) {
						fillBoard();		
						}
			
			    });
	    
	    
	    
	    /// Clear button	    
	      clear.setOnAction(e -> {
	            clear();
	        });
	    
	}

/////////////////////////// end of start(Stage stage)
	private static void clear() {
		for (int i = 0; i < textField2.length; i++) {
			for (int j = 0; j < textField2.length; j++) {
				textField2[i][j].setText("");
			}
		}
	}

	private static void fillBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int number = solution.getvaluefrom(i, j);
				textField2[i][j].setText(String.valueOf(number));
			}
		}
	}

	private void alert(String title, String headerText, String infoText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(infoText);
		alert.showAndWait();
	}

	public static void main(String[] args) {
		Application.launch(args);
		/*
		 * int[][] Sq = new int[9][9]; Sudoku SS = new Sudoku(Sq); SS.Solve();
		 */
	}

}
