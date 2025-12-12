
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Module7Assignment(1) extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label lblAmount = new Label("Complete Loan Amount:");
        TextField tfAmount = new TextField();

        Label lblRate = new Label("Interest Rate (%):");
        TextField tfRate = new TextField();

        Label lblYears = new Label("Number of years:");
        TextField tfYears = new TextField();

        Button btnCompute = new Button("Compute Loan Payment");

        Label lblMonthly = new Label("Monthly Payment:");
        Label lblTotal = new Label("Total Payment:");

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(lblAmount, 0, 0);
        pane.add(tfAmount, 1, 0);
        pane.add(lblRate, 0, 1);
        pane.add(tfRate, 1, 1);
        pane.add(lblYears, 0, 2);
        pane.add(tfYears, 1, 2);
        pane.add(btnCompute, 1, 3);
        pane.add(lblMonthly, 0, 4);
        pane.add(lblTotal, 0, 5);

        btnCompute.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(tfAmount.getText());
                double rate = Double.parseDouble(tfRate.getText());
                int years = Integer.parseInt(tfYears.getText());

                Loan loan = new Loan(amount, rate, years);

                lblMonthly.setText("Monthly Payment: $" +
                        String.format("%.2f", loan.getMonthlyPayment()));
                lblTotal.setText("Total Payment: $" +
                        String.format("%.2f", loan.getTotalPayment()));
            } catch (NumberFormatException ex) {
                lblMonthly.setText("Invalid input.");
                lblTotal.setText("");
            }});

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
