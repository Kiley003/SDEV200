import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
//* adds more questions after they've all been answered*//

public class Module7Assignment(2) extends Application {

    private static final int NUM_QUESTIONS = 10;
    private int[] num1 = new int[NUM_QUESTIONS];
    private int[] num2 = new int[NUM_QUESTIONS];
    private TextField[] answerFields = new TextField[NUM_QUESTIONS];

    @Override
    public void start(Stage primaryStage) {
        Random rand = new Random();

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            num1[i] = rand.nextInt(10);
            num2[i] = rand.nextInt(10);
        }

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 10;");

        Label title = new Label("more questions");
        title.setStyle("-fx-font-size: 18px;);
        root.getChildren().add(title);

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            HBox row = new HBox(10);
            Label question = new Label(num1[i] + " + " + num2[i] + " = ");
            answerFields[i] = new TextField();
            answerFields[i].setPrefWidth(60);
            row.getChildren().addAll(question, answerFields[i]);
            root.getChildren().add(row);
        }

        Button submitBtn = new Button("Submit");
        Label resultLabel = new Label();
        root.getChildren().addAll(submitBtn, resultLabel);

        submitBtn.setOnAction(e -> {
            int correctCount = 0;
            StringBuilder feedback = new StringBuilder();

            for (int i = 0; i < NUM_QUESTIONS; i++) {
                int correctAnswer = num1[i] + num2[i];
                String userInput = answerFields[i].getText();
                try {
                    int userAnswer = Integer.parseInt(userInput);
                    if (userAnswer == correctAnswer) {
                        feedback.append(num1[i]).append(" + ").append(num2[i])
                                .append(" = ").append(userAnswer).append("right");
                        correctCount++;
                    } else {
                        feedback.append(num1[i]).append(" + ").append(num2[i])
                                .append(" = ").append(userAnswer).append("wrong");
                    }
                }
            }

            feedback.append("\nTotal correct: ").append(correctCount);
            resultLabel.setText(feedback.toString());
        });

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("more questions");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
