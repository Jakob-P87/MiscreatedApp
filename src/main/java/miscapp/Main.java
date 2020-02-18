package miscapp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import miscapp.functions.Buttons;
import miscapp.scenes.Map;

public class Main extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }
    
    //Instance variables
    private double winWidth = 1000;
    private double winHeight = 800;
    
    //private GridPane root = new GridPane();
    private Group root = new Group();
    private Scene scene = new Scene(root, winWidth, winHeight);
    
    private GridPane menuLayout = new GridPane();
    private GridPane sceneItems = new GridPane();
    
    private Label mapLabel = new Label();
    private Label zoomIn = new Label();
    private Label zoomOut = new Label();
    
    //New objects
    private Map map = new Map();
    private Buttons btn = new Buttons(winWidth, winHeight);
    
    @Override
    public void start(Stage stage) {
        stage.setResizable(true);
        stage.setTitle("Miscreated");
        
        mapSceneSettings();
        
        new AnimationTimer(){
            @Override
            public void handle(long currentTime) {
                btn.map.setOnAction(e -> {
                    root. getChildren().add(map.showImage);
                    map.setPosition(winWidth - map.getSize(), 0);
                    root.getChildren().add(zoomIn);
                    root.getChildren().add(zoomOut);
                });
                map.renderImage();
                
                addMouseScrolling(map.showImage);
            }
        }.start();
    
        //Add to scene
        menuLayout.addRow(0, btn.map);
        root.getChildren().add(btn.map);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public void mapSceneSettings() {
        mapLabel.setText("MAP");
        mapLabel.setTextFill(Color.BLACK);
        mapLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 26));
        
        map.setImage("file:images/miscreatedMap.png");
        
    }
    
    //Method for scrolling in and out.
    public void addMouseScrolling(Node node) {
        node.setOnScroll((ScrollEvent event) -> {
            // Adjust the zoom factor as per your requirement
            double zoomFactor = 1.1;
            double deltaY = event.getDeltaY();
            if (deltaY < 0){
                zoomFactor = 2.0 - zoomFactor;
            }
            map.showImage.setScaleX(node.getScaleX() * zoomFactor);
            map.showImage.setScaleY(node.getScaleY() * zoomFactor);
        });
    }
}
