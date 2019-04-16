package ejemplo.boton;

import java.awt.Toolkit;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaSaludador extends Stage {

	private static VentanaSaludador ventanaSaludadorInsance = null;
	
	private VentanaSaludador(Stage fatherStage) {

		this.setTitle("Ventana Saludador");
		
		//Esta lina se una en caso que no se permita interactuar con la ventana padre una vez abirta esta.
		//show() permiete que al cerra la ventana la mata.. showAndWait() solo la esconde al ser cerrada.
		//this.initModality(Modality.APPLICATION_MODAL);
		
		this.setOnCloseRequest(e -> {
			ventanaSaludadorInsance = null;
		});
		
		
		
		
		StackPane layout = new StackPane();
		Scene escena1 = new Scene(layout, 400, 600);
		this.setScene(escena1);
		this.setX(fatherStage.getX() + fatherStage.getWidth() + 50);
		this.setY(fatherStage.getY());
		//this.showAndWait();
		this.show();
		
	}
	
	public static VentanaSaludador getInstance(Stage fatherStage) {
		
		if(ventanaSaludadorInsance == null) {
			ventanaSaludadorInsance = new VentanaSaludador(fatherStage);
		}else {
			final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
			if(runnable != null) runnable.run();
		}
		return ventanaSaludadorInsance;
	}

}
