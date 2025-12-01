//*Colors are red,green,blue and opacity*//

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Module5Assignment(3) extends Application {
	protected Text text = new Text("show Colors");
	protected Slider slred = new Slider();
	protected Slider slgreen = new Slider();
	protected Slider slblue = new Slider();
	protected Slider slopacity = new Slider();
	
	public void start(Stage primaryStage) {
		StackPane paneForText = new StackPane(text);
		paneForText.setPadding(new Insets(20, 10, 5, 10));

		slRed.valueProperty().addListener(ov -> setColor());
		slGreen.valueProperty().addListener(ov -> setColor());
		slBlue.valueProperty().addListener(ov -> setColor());
		slOpacity.valueProperty().addListener(ov -> setColor());
		slOpacity.setValue(1);

		GridPane paneForSliders = new GridPane();
		paneForSliders.setAlignment(Pos.CENTER);
		paneForSliders.setHgap(5);
		paneForSliders.add(new Label("red"), 0, 0);
		paneForSliders.add(slRed, 1, 0);
		paneForSliders.add(new Label("green"), 0, 1);
		paneForSliders.add(slGreen, 1, 1);
		paneForSliders.add(new Label("blue"), 0, 2);
		paneForSliders.add(slBlue, 1, 2);
		paneForSliders.add(new Label("opacity"), 0, 3);
		paneForSliders.add(slOpacity, 1, 3);

		Scene scene = new Scene(pane, 100, 100);
		primaryStage.setScene(scene); 
		primaryStage.show();
	}

	private void setColor() {
		text.setFill(new Color(slRed.getValue(), slGreen.getValue(), 
				slBlue.getValue(), slOpacity.getValue()));
	}
}
