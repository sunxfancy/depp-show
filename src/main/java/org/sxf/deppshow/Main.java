package org.sxf.deppshow;

/**
 * little tool
 * Created by sxf on 17-1-21.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent node = loader.load();
        Controller cont = loader.getController();
        List<String> list = getParameters().getUnnamed();
        Model model = new Model();
        if (list.isEmpty()) {
            model.load(getClass().getResource("/depp-show.dat"));
        } else {
            System.out.println(list.get(0));
            model.load(list.get(0));
        }
        cont.setModel(model);

        Scene scene = new Scene(node, 600, 400);

        primaryStage.setTitle("Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
