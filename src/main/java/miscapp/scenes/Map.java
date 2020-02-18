package miscapp.scenes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Map{
    private Image image;
    public ImageView showImage = new ImageView();
    public double posX;
    public double posY;
    private double imgSizeX = 800;
    private double imgSizeY = 800;
    
    public void setImage(String image) {
        this.image = new Image(image);
    }
    
    public void renderImage() {
        showImage.setImage(image);
        showImage.setFitHeight(imgSizeY);
        showImage.setFitWidth(imgSizeX);
        showImage.setX(this.posX);
        showImage.setY(this.posY);
    }
    
    public void setPosition(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public double getSize(){
        return imgSizeX;
    }
    
    public void imageZoomIn() {
        imgSizeX += 100;
        imgSizeY += 100;
    }
    
    public void imageZoomOut() {
        imgSizeX -= 100;
        imgSizeY -= 100;
    }
}
