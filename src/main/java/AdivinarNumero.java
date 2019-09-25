
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class AdivinarNumero extends Application {

	private Label saludoLabel;
	private Button adivinButton;
	private TextField numText;
	private int numAleatorio = (int) Math.random() * 100;
	int nIntentos = 0;
	Alert malaMenor = new Alert(AlertType.WARNING);
	Alert malaMayor = new Alert(AlertType.WARNING);
	Alert buena = new Alert(AlertType.INFORMATION);

	@Override
	public void start(Stage primaryStage) throws Exception {

		numText = new TextField();
		numText.setPromptText("Introduce un número");// texto que sale en la caja de texto cuando no está enfocado
		numText.setMaxWidth(150);// maximo de ancho 150 px

		adivinButton = new Button("Comprobar");
		adivinButton.setDefaultButton(true);// Con esto es el botón por defecto, así cuando pulsas enter es como clicar
											// en él
		adivinButton.setOnAction(e -> onComprobarButtonAction(e));// lamda

		saludoLabel = new Label("Introduce un número del 1 al 100");
		saludoLabel.setWrapText(true);// Para que si hay demasiado texto se esriba para debajo en vez de tener que
										// agrandar la pantalla

		VBox root = new VBox();
		root.setSpacing(5);// espacio entre componentes
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(saludoLabel, numText, adivinButton);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Comprobador");
		primaryStage.setScene(scene);
		primaryStage.show();

		// hacer algo para que el dato introducido sea int para compararlo con el nº
		// aleatorio generado
		
		try {
			String numero = numText.getText();

			Integer num = Integer.parseInt(numero);
		}catch{
			
		}
		
		
		int nIntentos = 0;
		
		malaMenor.setTitle("Cuadro de información");
		malaMenor.setHeaderText("¡Has fallado!");
		malaMenor.setContentText("El número es menor que " + num);
		malaMenor.setContentText("Vuelve a intentarlo");

		
		malaMayor.setTitle("Cuadro de información");
		malaMayor.setHeaderText("¡Has fallado!");
		malaMayor.setContentText("El número es mayor que " + num);
		malaMayor.setContentText("Vuelve a intentarlo");

		
		buena.setTitle("Cuadro de información");
		buena.setHeaderText("¡Has ganado!");
		buena.setContentText("Sólo has necesitado " + nIntentos + "intentos");
		buena.setContentText("Vuelve a jugar y hazlo mejor");

	}

	private void onComprobarButtonAction(ActionEvent e) {
		String numero = numText.getText();

		Integer num = Integer.parseInt(numero);

		// hacer algo para que el dato introducido sea int para compararlo con el nº
		// aleatorio generado

		
		

		if (num == numAleatorio) {
			nIntentos++;
			buena.showAndWait();
			nIntentos = 0;
		}else if (numAleatorio < num) {
			nIntentos++;
			malaMenor.showAndWait();
		}else{
			nIntentos++;
			malaMayor.showAndWait();
		}
//		
//		try {
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("Error");
//			alert.setHeaderText("Error");
//			alert.setContentText("El número introducido no es válido.");
//
//			alert.showAndWait();
//		
//		}catch(Exception a) {
//			
//		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
