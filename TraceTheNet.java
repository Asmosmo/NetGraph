/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

/**
 *
 * @author thomas
 */
public class TraceTheNet extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        VBox topContainer = new VBox();  //Creates a container to hold all Menu Objects.
        MenuBar mainMenu = new MenuBar();  //Creates our main menu to hold our Sub-Menus.
        ToolBar toolBar = new ToolBar();

        topContainer.getChildren().add(mainMenu);
        topContainer.getChildren().add(toolBar);

        root.setTop(topContainer);

        Menu graph = new Menu("Display graph");
        MenuItem openFile = new MenuItem("Open File");

        openFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                Label label1 = new Label("Name:");
                TextField textField = new TextField();
                HBox hb = new HBox();
                hb.getChildren().addAll(label1, textField);
                hb.setSpacing(10);

                GridPane grid = new GridPane();
                grid.setPadding(new Insets(10, 10, 10, 10));
                grid.setVgap(5);
                grid.setHgap(5);

                final TextField name = new TextField();
                name.setPromptText("Adress IP");
                name.getText();
                GridPane.setConstraints(name, 0, 0);
                grid.getChildren().add(name);

                Button submit = new Button("Submit");
                GridPane.setConstraints(submit, 1, 0);
                grid.getChildren().add(submit);

                Button clear = new Button("Clear");
                GridPane.setConstraints(clear, 1, 1);
                grid.getChildren().add(clear);
                
                clear.setOnAction(new EventHandler<ActionEvent>(){
                    
                    @Override
                        public void handle(ActionEvent e)
                        {
                            name.clear();
                        }
                });

                Scene scene = new Scene(grid, 800,600);
                primaryStage.setTitle("Graph");
                primaryStage.setScene(scene);
                primaryStage.show();

            }

        });
        graph.getItems().addAll(openFile);

//Create and add the "Edit" sub-menu options.
        Menu edit = new Menu("Edit");
        MenuItem properties = new MenuItem("Properties");
        edit.getItems().add(properties);

//Create and add the "Help" sub-menu options.
        Menu help = new Menu("Help");
        MenuItem visitWebsite = new MenuItem("Visit Website");
        help.getItems().add(visitWebsite);

        Menu exit = new Menu("Exit");
        MenuItem sure = new MenuItem("Sure ?");
        exit.getItems().add(sure);

        sure.setOnAction((ActionEvent e) -> {
            Platform.exit();
        });

        mainMenu.getMenus().addAll(graph, edit, help, exit);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Welcome to TraceTheNet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
  
  
  
  
  
  
  
  
  
  
 
  
  
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   

   
   
   
   
   
   
   
   
 
   
   
   
   
 
   
   
   
      
  
      
      
      


      
      
      
 
        
        
  
    
}
