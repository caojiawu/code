package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MessagePane extends Pane {
    public void add(String message){
        Font font = new Font("Tahoma", 48);
        Text text = new Text(message);
        text.setFont(font);
        text.setFill(Color.BLUE);
        getChildren().add(text);
    }
}
