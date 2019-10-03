
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
import java.lang.NumberFormatException;

public class AdivinarNumero extends Application {

	private Label saludoLabel;
	private Button adivinButton;
	private TextField numText;
	private int numAleatorio = (int) Math.random() * 100 + 1;
	int nIntentos = 0;
	Alert malaMenor = new Alert(AlertType.WARNING);
	Alert malaMayor = new Alert(AlertType.WARNING);
	Alert buena = new Alert(AlertType.INFORMATION);
	Alert alert = new Alert(AlertType.ERROR);

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

		int nIntentos = 0;

	}

	private void onComprobarButtonAction(ActionEvent e) {

		// hacer algo para que el dato introducido sea int para compararlo con el nº
		// aleatorio generado

		malaMenor.setTitle("¡Fallaste!");
		malaMenor.setHeaderText("¡Has fallado!");

		malaMayor.setTitle("¡Fallaste!");
		malaMayor.setHeaderText("¡Has fallado!");

		buena.setTitle("¡Enhorabuena!");
		buena.setHeaderText("¡Has ganado!");

		try {
			int num = Integer.parseInt(numText.getText());

			if (num == numAleatorio) {
				buena.setContentText(
						"Sólo has necesitado " + nIntentos + " intento/os" + "\n" + "Vuelve a jugar y hazlo mejor");
				buena.showAndWait();
				nIntentos++;

			} else if (num < 1 || num > 100) {
				alert.setContentText("El número introducido no es válido.");
				alert.showAndWait();
				nIntentos++;
			} else if (numAleatorio < num) {
				malaMenor.setContentText("El número es menor que " + num + "\n" + "Vuelve a intentarlo");
				malaMenor.showAndWait();
				nIntentos++;
			} else {
				malaMayor.setContentText("El número es mayor que " + num + "\n" + "Vuelve a intentarlo");
				malaMayor.showAndWait();
				nIntentos++;
			}

		} catch (NumberFormatException a) {
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido.");
			alert.showAndWait();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
