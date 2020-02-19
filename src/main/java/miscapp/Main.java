package miscapp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    
    private StackPane mapImageView = new StackPane();
    
    //New objects
    private MapScene map = new MapScene();
    private MenuBar menu = new MenuBar();
    
    @Override
    public void start(Stage stage) {
        stage.setResizable(true);
        stage.setTitle("Miscreated");
    
        loadImages();
        winObjectSettings();
        menu.mapButton(root, mapImageView);
        
        new AnimationTimer(){
            @Override
            public void handle(long currentTime) {
                map.imageViewController(winWidth,winHeight);
                

            }
        }.start();
        
        //Add to scene
        mapImageView.getChildren().add(map.sp);
        root.getChildren().addAll(mapImageView);
        root.getChildren().add(menu.map);

        stage.setScene(scene);
        stage.show();
    }
    
    public void winObjectSettings(){
        mapImageView.setLayoutX(200);
        mapImageView.setLayoutY(10);

        map.sp.prefWidthProperty().bind(mapImageView.widthProperty());
        map.sp.prefHeightProperty().bind(mapImageView.heightProperty());

        mapImageView.prefWidthProperty().bind(scene.widthProperty().subtract(200));
        mapImageView.prefHeightProperty().bind(scene.heightProperty().subtract(10));
        mapImageView.setStyle("-fx-border-color: black;" +
        "-fx-border-width: 10px;" + "-fx-border-radius: 5px;" + "-fx-border-color: transparent;");
    }
    
    public void loadImages() {
        map.setImage("file:images/miscreatedMap.png");
    }
}
