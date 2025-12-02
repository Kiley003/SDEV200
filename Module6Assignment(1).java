import java.sql.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class project12 extends Application{
	 private PreparedStatement preparedStatement;
	 private PreparedStatement preparedStatement2;
	  private TextField tfLastName = new TextField();
	  private TextField tfFirstName = new TextField();
	  private TextField tfMi = new TextField();
	  private TextField tfAddress = new TextField();
	  private TextField tfId = new TextField();
	  private TextField tfCity = new TextField();
	  private TextField tfState = new TextField();
	  private TextField tfPhone = new TextField();
    private TextField tfEmail = new TextField();
	  private TextArea infoDisplay = new TextArea();
	  
	  @Override
	  public void start(Stage primaryStage) {
	 
	    initializeDB();

	    BorderPane pane = new BorderPane();
	    GridPane paneForInfo = new GridPane();
	    Button btView = new Button("View");
	    Button btInsert = new Button("Insert");
	    Button btUpdate = new Button("Update");
	    Button btClear = new Button("Clear");
	    HBox hBox1 = new HBox(5);
	    HBox hBox2 = new HBox(5);
	    HBox hBox3 = new HBox(5);
	    HBox hBox4 = new HBox(5);
	    HBox hBox5 = new HBox(5);
	    HBox hBox6 = new HBox(5);
	    
	    
	    hBox1.getChildren().addAll(new Label("ID"), tfId);
	    hBox2.getChildren().addAll(new Label("Last Name"), tfLastName, new Label("First Name"), 
	  	      tfFirstName, new Label("mi"), tfMi);
	    hBox3.getChildren().addAll(new Label("Address"),tfAddress);
	    hBox4.getChildren().addAll(new Label("city"), tfCity, new Label("State"),
	    		tfState);
	    hBox5.getChildren().addAll(new Label("Telephone"), tfPhone);
	    hBox6.getChildren().addAll( btView, btInsert, btUpdate, btClear);
	       

	    VBox vBox= new VBox(10);
	    vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5, hBox6);
	    pane.setTop(vBox);
	    pane.setCenter(new ScrollPane(infoDisplay));
	    
	    
	    tfLastName.setPrefColumnCount(6);
	    tfFirstName.setPrefColumnCount(6);
	    tfMi.setPrefColumnCount(6);
	    tfAddress.setPrefColumnCount(6);
	    tfId.setPrefColumnCount(6);
	    tfCity.setPrefColumnCount(6);
	    tfState.setPrefColumnCount(6);
	    tfPhone.setPrefColumnCount(6);
	    tfemail.setOnAction(e -> show());
	    
	    Scene scene = new Scene(pane, 100, 200);
	    primaryStage.setScene(scene); 
	    primaryStage.show(); 
	  }

	      preparedStatement = connection.prepareStatement 
		      		("insert into Staff (id, firstName, lastName, mi, address, city,  state, telephone, email) " 
		      + "values (?, ?, ?, ?, ?, ?, ?, ?, email)");
	      preparedStatement2 = connection.prepareStatement 
		      		("SELECT id, firstName, lastName, mi, address, city,  state, telephone, email FROM staff WHERE id=?");
	    }
	    catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }

	  private void insert() {
		  
		  String lastName = tfLastName.getText();
		    String firstName = tfFirstName.getText();
		    char m = mi.charAt(0);
		    String address = tfAddress.getText();
		    String city = tfCity.getText();
		    String state = tfState.getText();
		    String telephone = tfPhone.getText();
		    String email = email.getText();
		    
		    
		    try {
		    	preparedStatement.setString(1, id);
		      	preparedStatement.setString(2, lastName);
		      	preparedStatement.setString(4, firstName);
		      	preparedStatement.setString(5, address);
		      	preparedStatement.setString(6, city);
		      	preparedStatement.setString(7, state);
		      	preparedStatement.setString(8, telephone);
          preparedStatement.setString(9, email);
		      	
		      	int rows = preparedStatement.executeUpdate();
		      	 
		      	if(rows > 0) {
		      		System.out.println("completed " + id);
		      	}else {
		      		System.out.println("failed");
		      	}
		      	
		      	
		      	} catch (Exception ex) {
		      		ex.printStackTrace();
		      	}
		      
		  
	  }
	    
	
	  private void show() {
		    String id = tfId.getText();
		    try {
		      preparedStatement2.setString(1, id);
		      ResultSet rset = preparedStatement2.executeQuery();

		      if (rset.next()) {
		    	  String lastName = rset.getString(2);
				    String firstName = rset.getString(4);
				    String mi = rset.getString(3);
				    String address = rset.getString(5);
				    String city = rset.getString(6);
				    String state = rset.getString(7);
				    String telephone = rset.getString(8);
	
		    	  

		       
		        infoDisplay.appendText(firstName + " " + mi +
				          " " + lastName +"\n" + " address: " + address + " " + city + ", " +
			        		state + " \n" + "telephone: " + telephone + "\n");
		      } else {
		        lblStatus.setText("Not used");
		      }
		    }
		    catch (SQLException ex) {
		      ex.printStackTrace();
		    }
		  }
	  public static void main(String[] args) {
		  launch(args);
	  }
	    
}
