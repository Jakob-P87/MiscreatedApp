package miscapp.graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Background{
    public Shape background = new Rectangle();
    
    public void backgroundSettings(){
        background.setFill(Color.GRAY);
    }
}
