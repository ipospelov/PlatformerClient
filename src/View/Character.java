package View;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;


/**
 * Created by posiv on 26.12.16.
 */
public class Character extends Pane {
    Rectangle rect;
    public int x;
    public int y;
    public Character(String file){
        x = View.objectWidth;
        y = View.windowHeight - View.objectHeight;
        rect =
                RectangleBuilder.create()
                        .x(x)
                        .y(y)
                        .width(View.objectWidth)
                        .height(View.objectHeight)
                        .fill(
                                new ImagePattern(
                                        new Image("file:" + file), 0, 0, 1, 1, true
                                )
                        )
                        .build();
        getChildren().add(rect);
    }

    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
        rect.setX(x);
        rect.setY(y);
    }
}
