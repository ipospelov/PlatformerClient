package View;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

/**
 * Created by posiv on 26.12.16.
 */
public class Block extends Pane {
    Rectangle rect;
    public int x;
    public int y;
    public Block(int x, int y, String file){
        rect =
                RectangleBuilder.create()
                        .x(x)
                        .y(View.windowHeight - View.objectHeight - y)
                        .width(View.objectWidth)
                        .height(View.objectHeight)
                        .fill(
                                new ImagePattern(
                                        new Image("file:" + file), 0, 0, 1, 1, true
                                )
                        )
                        .build();
        //rect = new Rectangle(x, 290 - y,10,10);
        //rect.setFill(new ImagePattern(new Image("file:" + file), 0, 0, 1, 1, true));
        //rect.setFill(Color.BLACK);
        getChildren().add(rect);
    }
    public Rectangle getPaneObject(){
        return rect;
    }
}
