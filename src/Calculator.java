import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new CalculatorPane(), 700, 500);
		primaryStage.setTitle("Java-FX Function Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
