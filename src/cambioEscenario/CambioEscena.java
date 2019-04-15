package cambioEscenario;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioEscena extends Application {

	Scene escena1, escena2;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Button 	boton1;
		Button 	boton2;
		
		Label label1 = new Label("Esta es la Escena 1");
		boton1 = new Button("Cambiar a la escena 2");
		boton1.setOnAction( e -> primaryStage.setScene(escena2));
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, boton1);
		escena1 = new Scene(layout1, 500, 300);
		
		Label label2 = new Label("Esta es la Escena 2");
		boton2 = new Button("Cambiar a la escena 1");
		boton2.setOnAction(r -> primaryStage.setScene(escena1));
		
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(label2, boton2);
		escena2 = new Scene(layout2, 700, 400);
		
		primaryStage.setScene(escena1);
		primaryStage.setTitle("Cambiando escenas");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
