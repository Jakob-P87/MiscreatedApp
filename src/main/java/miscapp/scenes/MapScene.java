package miscapp.scenes;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;

public class MapScene{
    private Image image;
    private ImageView imageView = new ImageView();
    public ScrollPane sp = new ScrollPane(imageView);
    
    
    
    public void setImage(String image) {
        this.image = new Image(image);
    }
    
    private void renderImage() {
        imageView.setImage(image);
        /*imageView.setScaleX(1);
        imageView.setScaleY(1);*/
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
    }
    
    //Method to change image view.
    public void imageViewController(double winWidth, double winHeight) {
        renderImage();
        sp.setContent(imageView);
        sp.pannableProperty().set(true);
        sp.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        sp.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setStyle("-fx-border-color: black;");
        
        /**=====Activate when needed.=====*/
        /*imageView.setOnScroll((ScrollEvent event) -> {
            // Adjust the zoom factor as per your requirement
            double zoomFactor = 1.1;
            double deltaY = event.getDeltaY();
    
            if(deltaY < 0) {
                zoomFactor = 2.0 - zoomFactor;
            }
    
            imageView.setScaleX(imageView.getScaleX() * zoomFactor);
            imageView.setScaleY(imageView.getScaleY() * zoomFactor);
        });*/
    }
}
