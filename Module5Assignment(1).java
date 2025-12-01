import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Module5Assignment(1) extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();

		pane.add(new ImageView(new Image("image/flag1.gif")), 0, 0);
		pane.add(new ImageView(new Image("image/flag2.gif")), 1, 0);
		pane.add(new ImageView(new Image("image/flag6.gif")), 0, 1);
		pane.add(new ImageView(new Image("image/flag7.gif")), 1, 1);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_01"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
}
