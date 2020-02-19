package miscapp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import miscapp.scenes.MapScene;



public class Main extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }
    
    //Instance variables
    private double winWidth = 1000;
    private double winHeight = 800;
    
    private Group root = new Group();
    private Scene scene = new Scene(root, winWidth, winHeight);
    
    //New objects
    private MapScene map = new MapScene();
    
    @Override
    public void start(Stage stage) {
        stage.setResizable(true);
        stage.setTitle("Miscreated");
    
        loadImages();
        
        new AnimationTimer(){
            @Override
            public void handle(long currentTime) {
                map.imageViewController(winWidth,winHeight);
            }
        }.start();
        
        //Add to scene
        root.getChildren().addAll(map.sp);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public void loadImages() {
        map.setImage("file:images/miscreatedMap.png");
    }
}
