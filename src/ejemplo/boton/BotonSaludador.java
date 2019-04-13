package ejemplo.boton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




/**
 * @author Jaiem Feldman B.  10-04-2019
 *	
 *	Clase donde se estudia JavaFx para interfaces graficas modernas.
 *	Aqui se despiega una ventana con un titulo y un boton al medio de un layout que no hace nada.
 *
 */
public class BotonSaludador extends Application {

	Button botonSaludo;
	
	public static void main(String[] args) {
		launch(args);
	}	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Ventana Saludador");

		botonSaludo = new Button("Saludador");
		botonSaludo.setOnAction( e -> 
			System.out.println("has presionado el boton, usando una funcion tipo Lambda")
		);
		
		//Se crea el layout y se agrega el boton.
		StackPane layout = new StackPane();
		layout.getChildren().add(botonSaludo);

		Scene esena = new Scene(layout, 500, 200);
		
		primaryStage.setScene(esena);
		primaryStage.show();
		
	}
	
}
