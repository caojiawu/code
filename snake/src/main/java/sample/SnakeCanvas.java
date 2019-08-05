package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.List;

public class SnakeCanvas extends Canvas {

    public SnakeCanvas(Snake snake){
        this.setWidth(ConstantClass.GRID_WIDTH*ConstantClass.CANVAS_WIDTH);//+2*ConstantClass.BASE_X);
        this.setHeight(ConstantClass.GRID_WIDTH*ConstantClass.CANVAS_WIDTH);//+2*ConstantClass.BASE_Y);
        this.setLayoutX(ConstantClass.BASE_X);
        this.setLayoutY(ConstantClass.BASE_Y);
        draw(snake);
    }

    public void draw(Snake snake){
        if(snake.status == 2){
            return;
        }

        GraphicsContext gc = this.getGraphicsContext2D();
        gc.clearRect(0,0,this.getWidth(),this.getHeight());

        for(Position p:snake.yard.beans){
            gc.setFill(Color.CHOCOLATE);
            gc.fillOval((p.x-1)*ConstantClass.GRID_WIDTH /*+ ConstantClass.BASE_X*/,
                    (p.y-1)*ConstantClass.GRID_WIDTH/*+ConstantClass.BASE_Y*/,
                    ConstantClass.GRID_WIDTH,ConstantClass.GRID_WIDTH);
        }

        List<Position> snakePosList = snake.getPositions();
        for(Position p:snakePosList){
            gc.setFill(Color.RED);
            gc.fillOval((p.x-1)*ConstantClass.GRID_WIDTH /*+ ConstantClass.BASE_X*/,
                    (p.y-1)*ConstantClass.GRID_WIDTH/*+ConstantClass.BASE_Y*/,
                    ConstantClass.GRID_WIDTH,ConstantClass.GRID_WIDTH);
            gc.strokeRect((p.x-1)*ConstantClass.GRID_WIDTH/*+ConstantClass.BASE_X*/,
                    (p.y-1)*ConstantClass.GRID_WIDTH/*+ConstantClass.BASE_Y*/,
                    ConstantClass.GRID_WIDTH,ConstantClass.GRID_WIDTH);
        }
    }
}
