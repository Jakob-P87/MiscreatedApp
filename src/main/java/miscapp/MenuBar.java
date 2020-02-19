package miscapp;


import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuBar{
    public Label map = new Label("MAP");

    public void mapButton(Group group, StackPane mapObj){
        map.setTextFill(Color.BLACK);
        map.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,20));
        map.setOnMouseEntered(e -> map.setTextFill(Color.GREEN));
        map.setOnMouseExited(e -> map.setTextFill(Color.BLACK));
        map.setOnMouseClicked(e -> {
            if(group.getChildren().contains(mapObj))
            {
                group.getChildren().remove(mapObj);
            }else{
                group.getChildren().add(mapObj);
            }
        });
    }
}
