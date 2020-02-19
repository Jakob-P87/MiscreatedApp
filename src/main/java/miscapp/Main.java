package miscapp;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import miscapp.gameObjects.Map;
import miscapp.options.WindowResolution;

import java.io.FileNotFoundException;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    //Instance variables
    private double winWidth = 800;
    private double winHeight = 600;
    
    //Pane canvas = new Pane();
    private Group root = new Group();
    
    //Get objects
    private MenuBar menu = new MenuBar();
    private WindowResolution winSettings = new WindowResolution();
    private Map mapObj;
    {
        try{
            mapObj = new Map(winHeight);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    } //Try catch for menu object to handle FileNotFoundException, if image cant be found
    
    private Scene scene = new Scene(root, winWidth, winHeight);
    
    //Stuff to test methods
    private Button resize = new Button("Change window size");

    Shape shape = new Rectangle(winWidth,winHeight);
    
    @Override
    public void start(Stage stage) throws Exception {

    mapObj.imageSettings(); //Get image settings method

    menu.menuView();
    //Add objects to scene here
    root.getChildren().add(shape);
    root.getChildren().add(menu.menuGrid);
    root.getChildren().add(mapObj.viewImg);

    
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
    }
    
    public void setResolution(){
        //Listener to change the height of the window
        scene.widthProperty().addListener((observableValue, winWidth, newSceneWidth) -> System.out.println("Width: " + newSceneWidth));
    
        //Listener to change the height of the window
        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> System.out.println("Height: " + newSceneHeight));
    }
}
