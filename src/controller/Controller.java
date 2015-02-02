/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import view.View;

/**
 *
 * @author kevin
 */
public class Controller extends Application{
private View view;
private Model model;
@Override
public void start(Stage primaryStage) throws IOException, UnknownHostException, InterruptedException {
model=new Model();
view = new View(primaryStage);
model.createPng("google.com");
view.start(this);
}
public static void main(String[] args) {
launch(args);
}

    public void setScene(Scene scene) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTitle(String graph) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
