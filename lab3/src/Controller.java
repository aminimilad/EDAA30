import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import textproc.GeneralWordCounter;
import textproc.TextProcessor;

public class Controller extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		Set<String> stopWords = new HashSet<String>();
		
		
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopWords.add(word);	
		}
		
	//i hjälpmetod kolla i map om sidan finns, annars använda
		GeneralWordCounter GWC = new GeneralWordCounter(stopWords);
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			GWC.process(word);
		}
		
		
		ObservableList<Map.Entry<String, Integer>> words = FXCollections.observableArrayList(GWC.getWords());
		ListView<Map.Entry<String, Integer>> listView = new ListView<>(words);
		
		ToggleGroup group = new ToggleGroup();
		
		RadioButton btn1 = new RadioButton("Alphabetical");
		btn1.setToggleGroup(group);
		
		RadioButton btn2 = new RadioButton("Frequency");
		btn2.setToggleGroup(group);
		
		
		HBox hbox = new HBox();
		root.setCenter(listView);
		root.setBottom(hbox);
		hbox.getChildren().addAll(btn1, btn2);
		
		btn1.setOnAction(event -> words.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey())));
		btn2.setOnAction(event -> words.sort((e1, e2) -> e2.getValue() - e1.getValue()));

		
		
		//btn1.setOnAction(event -> System.out.print("HEJ"));
		
		TextField TF = new TextField();
		hbox.getChildren().add(TF);
		HBox.setHgrow(TF, Priority.ALWAYS);
		
		Button btnTF = new Button("Go To");
		hbox.getChildren().add(btnTF);
	
		Alert alert = new Alert(AlertType.INFORMATION, "Ordet finns ej i boken");
		
		btnTF.setOnAction (e ->{
			String readWord = TF.getText();
			
			for(int i = 0; i<words.size(); i++) {
				if(words.get(i).getKey().compareTo(readWord)==0) {
					listView.scrollTo(i);
					return;
				}
				
			}
			
				alert.show();
			
		});
		//V2, V5, V6
		
		
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();
			
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
