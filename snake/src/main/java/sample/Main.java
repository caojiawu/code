package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Yard yard = new Yard(ConstantClass.CANVAS_WIDTH,ConstantClass.CANVAS_HEIGHT);
        yard.addBeans(ConstantClass.BEANS_COUNT);
        Snake snake = new Snake(yard);
        primaryStage.setTitle("Hello Snake");
        Group group = new Group();

        final String imgFileName = "file:resources/ground.jpg";
        Image image = new Image(imgFileName);
        ImageView background = new ImageView(image);

        SnakeCanvas snakeCanvas = new SnakeCanvas(snake);

        MessagePane messagePane = new MessagePane();
        messagePane.setLayoutX((ConstantClass.GRID_WIDTH*ConstantClass.CANVAS_WIDTH+ConstantClass.BASE_X)-150);
        messagePane.setLayoutY(40);
        group.getChildren().addAll(background,snakeCanvas,messagePane);

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
                    case "p":
                        if(snake.status == 0) {
                            messagePane.add("Pause");
                        }else{
                            messagePane.getChildren().clear();
                        }
                        snake.pause();
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