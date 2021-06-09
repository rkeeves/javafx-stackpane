package com.rkeeves;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

    public static void main(String[] args) {
        Application.launch(App.class,args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageLayer(),animationLayer(),buttonLayer());
        stage.setScene(new Scene(stackPane));
        stage.show();
    }

    private Node imageLayer(){
        return new ImageView(new Image("/600.png"));
    }

    private Node buttonLayer(){
        var button = new Button("Button");
        button.setOnMouseClicked(evt->System.out.println("Hi"));
        var borderPane = new BorderPane();
        borderPane.setCenter(button);
        return borderPane;
    }

    private Node animationLayer(){
        var pane = new AnchorPane();
        var rect1 = new Rectangle(250, 250.0, 100, 100);
        rect1.setFill(Color.RED);
        pane.getChildren().addAll(rect1);
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setNode(rect1);
        scaleTransition.setByY(1.5);
        scaleTransition.setByX(1.5);
        scaleTransition.setCycleCount(50);
        scaleTransition.setAutoReverse(false);
        scaleTransition.play();
        return pane;
    }
}
