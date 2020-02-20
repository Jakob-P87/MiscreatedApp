package miscapp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import miscapp.scenes.MapScene;

public class Main extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }
    
    //Instance variables
    private double winWidth = 1000;
    private double winHeight = 800;
    
    //Scene settings
    private Group root = new Group();
    private Scene scene = new Scene(root, winWidth, winHeight);
    
    //Scene objects
    private MapScene map = new MapScene();
    private MenuBar menu = new MenuBar();
    
    private StackPane mapImageView = new StackPane();
    private StackPane backgroundPane = new StackPane();
    
    //Extra objects
    private Rectangle background = new Rectangle(5000,5000);
    
    @Override
    public void start(Stage stage) {
        stage.setResizable(true);
        stage.setTitle("Miscreated");
        
        //Methods for object settings
        loadImages();
        winObjectSettings();
        
        menu.mapButton(root, mapImageView);
        
        new AnimationTimer(){
            @Override
            public void handle(long currentTime) {
                map.imageViewController(winWidth,winHeight);
                

            }
        }.start();
        
        //Add objects to scene
        root.getChildren().add(backgroundPane);
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

        mapImageView.prefWidthProperty().bind(scene.widthProperty().subtract(210));
        mapImageView.prefHeightProperty().bind(scene.heightProperty().subtract(20));
        mapImageView.setStyle("-fx-border-color: black;" +
        "-fx-border-width: 10px;" + "-fx-border-radius: 5px;");
        mapImageView.getChildren().add(map.sp);
        
        //Just to get a darker background
        backgroundPane.prefWidthProperty().bind(scene.widthProperty());
        backgroundPane.prefHeightProperty().bind(scene.heightProperty());
        backgroundPane.getChildren().add(background);
        background.setFill(Color.grayRgb(25));
    }
    
    public void loadImages() {
        map.setImage("file:images/miscreatedMap.png");
    }
}