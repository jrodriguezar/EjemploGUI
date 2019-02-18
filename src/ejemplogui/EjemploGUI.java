package ejemplogui;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jrodriguezar
 */
public class EjemploGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException{
        VBox vbox = new VBox();
        Button bt1 = new Button("Button 1");
        Button bt2 = new Button("Button 2");
        Button bt3 = new Button("Button 3");
        
        HBox filial = new HBox();
        
        TableView table = new TableView();
        table.setEditable(true);
        TableColumn firstname = new TableColumn("Saludo");
        TableColumn lastname = new TableColumn("Despedida");
        TableColumn emal = new TableColumn("Broma");
        table.getColumns().addAll(firstname, lastname, emal);
        
        FileInputStream input = 
                new FileInputStream("elvaino.png");
        Image image = new Image(input);
        Button label3 = new Button("Search", new ImageView(image));
        Label label1 = new Label("Search", new ImageView(image));
        
        //grid pane vrgs
        GridPane gridpane = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        gridpane.getColumnConstraints().addAll(col1,col2,col2,col1);
        
        Label text = new Label("Enter Address");
        gridpane.add(text, 0, 0, 4, 1); 
        GridPane.setHalignment(text, HPos.CENTER);
        Label direccion = new Label("Direccion");
        gridpane.add(direccion, 0, 1, 1, 1);
        GridPane.setHalignment(direccion, HPos.RIGHT);
        TextField txtDireccion = new TextField();
        gridpane.add(txtDireccion, 1, 1, 4, 1); 
        Label direccion2 = new Label("Direccion");
        TextField txtDireccion2 = new TextField();
        gridpane.add(direccion2, 0, 2, 1, 2); 
        gridpane.add(txtDireccion2, 1, 2, 4, 2);
        
        //gridpane sencillo, co lo basico en organizacion
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
        pane.add(new Label("First name"),0,0);
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("C.C"),0,1);
        pane.add(new TextField(), 1, 1);
        pane.add(new Label("Last Name:"), 0, 2);
        pane.add(new TextField(), 1, 2);
        Button btAdd = new Button("Add Name");
        pane.add(btAdd, 1, 3);
        GridPane.setHalignment(btAdd, HPos.RIGHT);
        
        filial.getChildren().add(label3);
        filial.getChildren().add(bt1);
        filial.getChildren().add(bt2);
        filial.getChildren().add(bt3);
        vbox.getChildren().add(filial);
        vbox.getChildren().add(label1);
        //vbox.getChildren().add(pane);
        vbox.getChildren().add(table);
        vbox.getChildren().add(gridpane);
        
        Scene scene = new Scene(vbox, 600, 600);//solo esta ingresando el gridpane
        primaryStage.setTitle("MyJavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}