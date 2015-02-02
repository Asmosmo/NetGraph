/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author kevin
 */
public class View {

    private final Stage primaryStage;

    private Controller ctrl;

    public View(Stage primaryStage) {
        this.primaryStage = primaryStage;

    }

    public void start(Controller controller) {

        this.ctrl = controller;
        BorderPane boot = new BorderPane();
        VBox topContainer = new VBox();  //Creates a container to hold all Menu Objects.
        MenuBar mainMenu;
        mainMenu = new MenuBar();
        ToolBar toolBar = new ToolBar();

        topContainer.getChildren().add(mainMenu);
        topContainer.getChildren().add(toolBar);

        boot.setTop(topContainer);

        Menu graph = new Menu("Display graph");
        MenuItem GO = new MenuItem("GO");

        graph.getItems().addAll(GO);

        Menu help = new Menu("Help");
        MenuItem visitWebsite = new MenuItem("Visit Website");
        help.getItems().add(visitWebsite);

        Menu exit = new Menu("Exit");
        MenuItem sure = new MenuItem("Sure ?");
        exit.getItems().add(sure);

        sure.setOnAction((ActionEvent e) -> {
            Platform.exit();
        });

        mainMenu.getMenus().addAll(graph, help, exit);

        Scene scene = new Scene(boot, 800, 600);

        primaryStage.setTitle("Welcome to TraceTheNet");
        primaryStage.setScene(scene);
        primaryStage.show();

        GO.setOnAction(new EventHandler<ActionEvent>() {
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

                final Label label = new Label();
                GridPane.setConstraints(label, 0, 3);
                GridPane.setColumnSpan(label, 2);
                grid.getChildren().add(label);

                submit.setOnAction((ActionEvent e1) -> {
                    if ((name.getText() != null && !name.getText().isEmpty())) {
                        label.setText(name.getText() + " " + " thank you");
                    } else {
                        label.setText("You have not enter an IP adress.");
                    }
                });

                clear.setOnAction((ActionEvent e1) -> {
                    name.clear();
                });

                Scene vb = new Scene(new VBox(), 800, 600);
                HBox hb1 = new HBox();
                HBox hb2 = new HBox();
                
                hb1.getChildren().addAll(mainMenu);
                hb2.getChildren().addAll(grid);
                ((VBox) vb.getRoot()).getChildren().addAll(mainMenu, hb1, hb2);

                primaryStage.setTitle("Graph");
                primaryStage.setScene(vb);
                primaryStage.show();

            }

        });

    }

}
