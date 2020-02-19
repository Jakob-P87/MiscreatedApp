package miscapp.scenes;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent; //Don't remove this import
import javafx.scene.layout.StackPane;

public class MapScene{
    private Image image;
    private ImageView imageView = new ImageView();
    public ScrollPane sp = new ScrollPane(imageView);

    private StackPane mapImageView = new StackPane();
    
    public void setImage(String image) {
        this.image = new Image(image);
    }
    
    private void renderImage() {
        imageView.setImage(image);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
    }
    
    //Method to manipulate the view of the map.
    public void imageViewController(double winWidth, double winHeight) {
        renderImage();
        sp.setContent(imageView);
        sp.pannableProperty().set(true);
        sp.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        sp.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        //sp.setStyle("-fx-border-color: black;");
        
        /**=====Activate when you figured out how to drag to the edges of the map.=====*/
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
