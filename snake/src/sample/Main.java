package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
    final public int CANVAS_WIDTH = 110;
    final public int CANVAS_HEIGHT = 90;
    final public int GRID_WIDTH = 5;
    final public int GRID_RADIUS = 3;
    final public int BASE_X = 10;
    final public int BASE_Y = 30;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Yard yard = new Yard(CANVAS_WIDTH,CANVAS_HEIGHT);
        yard.addBeans(30);
        Snake snake = new Snake(yard);


        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FlowPane root = new FlowPane();

        primaryStage.setTitle("Hello Snake");

        Button btnUp = new Button("Up");
        btnUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                snake.changeDirection(DIRECTION.up);
                System.out.println(snake.segmentList.get(0).direction);
            }
        });
        Button btnDown = new Button("Down");
        btnDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                snake.changeDirection(DIRECTION.down);
                System.out.println(snake.segmentList.get(0).direction);
            }
        });
        Button btnLeft = new Button("Left");
        btnLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                snake.changeDirection(DIRECTION.left);
                System.out.println(snake.segmentList.get(0).direction);
            }
        });
        Button btnRight = new Button("Right");
        btnRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                snake.changeDirection(DIRECTION.right);
                System.out.println(snake.segmentList.get(0).direction);
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().add(btnUp);
        hBox.getChildren().add(btnDown);
        hBox.getChildren().add(btnLeft);
        hBox.getChildren().add(btnRight);

        Group group = new Group();
        group.getChildren().add(hBox);

        Rectangle rect = new Rectangle(CANVAS_WIDTH*GRID_WIDTH,CANVAS_HEIGHT*5,Color.BLACK); //Yard width and height
        rect.setX(BASE_X);
        rect.setY(BASE_Y);
        group.getChildren().add(rect);

        for(Position p:yard.beans){
            Circle circle = new Circle(p.x*GRID_WIDTH-GRID_RADIUS + BASE_X,
                    p.y*GRID_WIDTH-GRID_RADIUS+BASE_Y,GRID_RADIUS,Color.RED);
            group.getChildren().add(circle);
        }

        java.util.List<Position> snakePosList = snake.getPositions();
        for(Position p:snakePosList){
            Rectangle r = new Rectangle(GRID_WIDTH,GRID_WIDTH,Color.GREEN);
            r.setX((p.x-1)*GRID_WIDTH);
            r.setY((p.y-1)*GRID_WIDTH);
            group.getChildren().add(r);
        }

        primaryStage.setScene(new Scene(group, 600, 500));
        primaryStage.show();
        System.out.println("none");
    }

    public static void main(String[] args) {
        launch(args);
    }
}