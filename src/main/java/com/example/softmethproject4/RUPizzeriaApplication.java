package com.example.softmethproject4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class launches the MainView and starts the RU Pizzeria application which the user can interact with.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class RUPizzeriaApplication extends Application {

    /**
     * This method initialize the scene that the MainView will be displayed on and the user will interact with.
     * @param stage is the stage that will invoke the setScene() method to initialize the scene for the GUI.
     * @throws IOException if there is no .fxml file to read the XML input from.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RUPizzeriaApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 666);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method runs the entire program by calling the launch() method to launch the GUI for the user to interact with.
     * @param args is an array of String objects that is input in the command line from the user.
     */
    public static void main(String[] args) {
        launch();
    }
}