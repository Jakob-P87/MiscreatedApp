package miscapp.options;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WindowResolution{
    public WindowResolution() throws FileNotFoundException{
    
    }
    
    private Image fullScreenLogo = new Image(new FileInputStream("images/FullcreenLogo.jpg"));
    public ImageView showLogo = new ImageView(fullScreenLogo);
    
    public void imgSettings(){
        showLogo.setFitHeight(30);
        showLogo.setFitWidth(30);
    }
}
