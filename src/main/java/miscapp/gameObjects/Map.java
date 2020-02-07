package miscapp.gameObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Map{
    private double imgSize;
    
    public Map(double imgSize) throws FileNotFoundException{
        this.imgSize = imgSize;
    }
    
    private FileInputStream fileInput = new FileInputStream("images/miscreated_map.jpg");
    private Image image = new Image(fileInput);
    public ImageView viewImg = new ImageView(image);
    
    public void imageSettings(){
        viewImg.setPreserveRatio(true);
        viewImg.setFitWidth(imgSize);
        viewImg.setX(200);
    }
}
