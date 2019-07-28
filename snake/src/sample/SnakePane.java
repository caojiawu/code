package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SnakePane extends Pane {

    public SnakePane(Snake snake){
        draw(snake);
    }

    public void draw(Snake snake){
        getChildren().clear();
        for(Position p:snake.yard.beans){
            Circle circle = new Circle(p.x*ConstantClass.GRID_WIDTH-ConstantClass.GRID_RADIUS + ConstantClass.BASE_X,
                    p.y*ConstantClass.GRID_WIDTH-ConstantClass.GRID_RADIUS+ConstantClass.BASE_Y,ConstantClass.GRID_RADIUS, Color.RED);
            getChildren().add(circle);
        }

        java.util.List<Position> snakePosList = snake.getPositions();
        for(Position p:snakePosList){
            Rectangle r = new Rectangle(ConstantClass.GRID_WIDTH,ConstantClass.GRID_WIDTH,Color.GREEN);
            r.setX((p.x-1)*ConstantClass.GRID_WIDTH+ConstantClass.BASE_X);
            r.setY((p.y-1)*ConstantClass.GRID_WIDTH+ConstantClass.BASE_Y);
            getChildren().add(r);
        }
    }
}
