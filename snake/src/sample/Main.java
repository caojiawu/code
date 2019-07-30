package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Yard yard = new Yard(ConstantClass.CANVAS_WIDTH,ConstantClass.CANVAS_HEIGHT);
        yard.addBeans(ConstantClass.BEANS_COUNT);
        Snake snake = new Snake(yard);

        primaryStage.setTitle("Hello Snake");
        Group group = new Group();
        SnakeCanvas snakeCanvas = new SnakeCanvas(snake);
        group.getChildren().add(snakeCanvas);

        EventHandler<ActionEvent> eventHandler = e -> {
            snake.move();
            snakeCanvas.draw(snake);
        };

        Timeline animation=new Timeline(new KeyFrame(Duration.millis(350),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(group, ConstantClass.GRID_WIDTH*ConstantClass.CANVAS_WIDTH+ConstantClass.BASE_X,
                ConstantClass.GRID_WIDTH*ConstantClass.CANVAS_HEIGHT+ConstantClass.BASE_Y);
        primaryStage.setScene(scene);
        scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}