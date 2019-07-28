package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Yard yard = new Yard(ConstantClass.CANVAS_WIDTH,ConstantClass.CANVAS_HEIGHT);
        yard.addBeans(30);
        Snake snake = new Snake(yard);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //FlowPane root = new FlowPane();

        primaryStage.setTitle("Hello Snake");

        Button btnUp = new Button("Up");
        btnUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                snake.changeDirection(DIRECTION.up);
            }
        });
        Button btnDown = new Button("Down");
        btnDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                snake.changeDirection(DIRECTION.down);
            }
        });
        Button btnLeft = new Button("Left");
        btnLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                snake.changeDirection(DIRECTION.left);
            }
        });
        Button btnRight = new Button("Right");
        btnRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                snake.changeDirection(DIRECTION.right);
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().add(btnUp);
        hBox.getChildren().add(btnDown);
        hBox.getChildren().add(btnLeft);
        hBox.getChildren().add(btnRight);

        Group group = new Group();
        group.getChildren().add(hBox);

        SnakePane snakePane = new SnakePane(snake);
        group.getChildren().add(snakePane);

        EventHandler<ActionEvent> eventHandler = e -> {
            snake.move();
            snakePane.draw(snake);
        };

        Timeline animation=new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        primaryStage.setScene(new Scene(group, ConstantClass.GRID_WIDTH*ConstantClass.CANVAS_WIDTH+2*ConstantClass.BASE_X,
                ConstantClass.GRID_WIDTH*ConstantClass.CANVAS_HEIGHT+2*ConstantClass.BASE_Y));


        group.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch(event.getCharacter()){
                    case "a":
                        snake.changeDirection(DIRECTION.left);
                        break;
                    case "s":
                        snake.changeDirection(DIRECTION.down);
                        break;
                    case "w":
                        snake.changeDirection(DIRECTION.up);
                        break;
                    case "d":
                        snake.changeDirection(DIRECTION.right);
                        break;
                }
            }
        });

        primaryStage.show();
        System.out.println("none");
    }

    public static void main(String[] args) {
        launch(args);
    }
}