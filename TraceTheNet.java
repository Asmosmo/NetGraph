/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracethenet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        @Override public void handle(ActionEvent e) {
        System.out.println("Opening Database Connection...");
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
        
        Scene scene = new Scene(root, 400, 350);
        
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
