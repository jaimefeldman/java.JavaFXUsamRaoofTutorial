package ejemplo.boton;

import java.awt.Toolkit;
import java.beans.EventHandler;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;




/**
 * @author Jaiem Feldman B.  10-04-2019
 *	
 *	Clase donde se estudia JavaFx para interfaces graficas modernas.
 *	Aqui se despiega una ventana con un titulo y un boton al medio de un layout que no hace nada.
 *
 */
public class BotonSaludador extends Application {

	Button botonSaludo, botonMensajes;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Cancela la salida automatica de la app, al cerrar la app con la cruz de la ventana.
		Platform.setImplicitExit(false);
		
		primaryStage.setTitle("Ventana Saludador");
		
		//Se establecen minimos y maximos para la ventana.
		primaryStage.setMinHeight(200);
		primaryStage.setMinWidth(300);
		//primaryStage.setMaxHeight(600);
		//primaryStage.setMaxWidth(400);
		
		//Inicia en su maximo..
		//primaryStage.setMaximized(true);
		
		//primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.resizableProperty().setValue(Boolean.FALSE);


		
		botonSaludo = new Button("Saludador");
		botonSaludo.setOnAction( e -> {
			System.out.println("llamando a la instancia de la ventana saludador.");
			VentanaSaludador ventanaSaludador = VentanaSaludador.getInstance(primaryStage);
			ventanaSaludador.requestFocus();
			
		});
		
		botonMensajes = new Button("Mensajes");
		botonMensajes.setOnAction( e -> {
			System.out.println("Boton mensajes presionado!");
		});
		
		
		botonSaludo.setDefaultButton(true);
		//botonMensajes.setDefaultButton(true);
		
		//botonMensajes.defaultButtonProperty().bind(botonMensajes.focusedProperty());
		
		//Se crea el layout y se agrega el boton.
		VBox vboxLayout = new VBox(10);
		vboxLayout.getChildren().addAll(botonSaludo, botonMensajes);
		Scene esena = new Scene(vboxLayout, 500, 200);
		
		//Detectando cuando se cierra la ventana.
		primaryStage.setOnCloseRequest(new javafx.event.EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				System.out.println("Intenando cerrar la ventana..");
				//Impide la salida consumiendo el evento y enviando a la alerta de salida.
				event.consume();
				AlertaSalidaApp();
			}
		});
		
		//Creando Aceleradores para detectar comninaciones de teclas.
		//Ref: https://medium.com/@zoha131/handling-keyboard-shortcuts-in-javafx-2972ba950a48
		KeyCombination kc = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
		//Runnable run = () -> System.out.println("Accelerador key worked.");
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				AlertaSalidaApp();
			}
		};
		esena.getAccelerators().put(kc, run);
		
		primaryStage.setScene(esena);
		primaryStage.show();
	}
	
	//Alerta salida de la app
	//Modificando la alerta para poner el foco en el boton desaeado.
	private void AlertaSalidaApp() {
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Cerrando la Aplicación");
		alert.setHeaderText("Desea salir de la aplicación?");
		alert.setContentText("No se guardaran los cambios.");
		
		alert.getButtonTypes().clear();
		alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
		
		Button yesButton = (Button) alert.getDialogPane().lookupButton(ButtonType.YES);
		yesButton.setText("Si");
		yesButton.setDefaultButton(false);
		
		Button noButton = (Button) alert.getDialogPane().lookupButton(ButtonType.NO);
		noButton.setText("No");
		noButton.setDefaultButton(true);
		
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ButtonType.YES) {
			Platform.exit();
			System.exit(0);
		}else {
			System.out.println("Salida Cancelada.");
		}
	}

	//Metodo main.
	public static void main(String[] args) {
		launch(args); }
	
}
