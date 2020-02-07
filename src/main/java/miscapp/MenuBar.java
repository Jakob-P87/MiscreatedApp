package miscapp;


import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MenuBar{
    GridPane menuGrid = new GridPane();
    //WindowSettings winResolution = new WindowSettings();
    
    private Button options = new Button("Options");
    private Button res800x600 = new Button("800x600");
    private Button res1080 = new Button("1920x1080");
    
    public void menuView(){
        menuGrid.addRow(0,options);
        menuGrid.addRow(1,res800x600);
        menuGrid.addRow(2,res1080);
    }
    
    public void buttonFunction(){
    
    }
}
