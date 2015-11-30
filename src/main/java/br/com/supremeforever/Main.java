package br.com.supremeforever;

import br.com.supremeforever.mdi.MDICanvas;
import br.com.supremeforever.mdi.MDIWindow;
import br.com.supremeforever.mdi.*;
import br.com.supremeforever.mdi.PlacementStrategy.PlacementStrategy;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by brisatc171.minto on 12/11/2015.
 */
public class Main extends Application {
    int count = 0;
    public static HostServices hostServices;

    @Override
    public void start(Stage primaryStage) throws Exception {
        hostServices = getHostServices();
        //Creat main Pane Layout
        AnchorPane mainPane = new AnchorPane();
        mainPane.setPrefSize(800, 600);
        //Creat MDI Canvas Container
        MDICanvas mdiCanvas = new MDICanvas(MDICanvas.Theme.DEFAULT);
        //Fit it to the main Pane
        AnchorPane.setBottomAnchor(mdiCanvas, 0d);
        AnchorPane.setLeftAnchor(mdiCanvas, 0d);
        AnchorPane.setTopAnchor(mdiCanvas, 25d);//Button place
        AnchorPane.setRightAnchor(mdiCanvas, 0d);
        //Put the container Into the main pane
        mainPane.getChildren().add(mdiCanvas);
        //Create a 'New MDI Window' Button
        Button btnDefaultMdi = new Button("New Window");
        //set the button action

        btnDefaultMdi.setOnAction(event -> {
            Node content = null;
            try {
                content = FXMLLoader.load(getClass().getResource("/MyContent.fxml"));
            } catch (Exception e) {
            }
            count++;
            //Create a Default MDI Withou Icon
            MDIWindow mdiWindow = new MDIWindow("UniqueID" + count,
                    new ImageView("/assets/WindowIcon.png"),
                    "Title " + count,
                    content);
            //Set MDI Size
            //Add it to the container
            mdiCanvas.addMDIWindow(mdiWindow);
        });
        
        
        //Buttons for placement strategies
        ToggleGroup strategies = new ToggleGroup();
        RadioButton defaultStrategy = new RadioButton("Default");
        // sorry ugly names because I thought Java like PHP can have aliased class names
        // so I will think of better names in next comits
        defaultStrategy.setUserData(new br.com.supremeforever.mdi.PlacementStrategy.Default(mdiCanvas));
        defaultStrategy.setToggleGroup(strategies);
        defaultStrategy.setSelected(true);
        
        RadioButton cascadingStrategy = new RadioButton("Cascading");
        cascadingStrategy.setUserData(new br.com.supremeforever.mdi.PlacementStrategy.Cascading(mdiCanvas));
        cascadingStrategy.setToggleGroup(strategies);
        
        strategies.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle previous, Toggle current) {
                if(strategies.getSelectedToggle() != null) {
                    PlacementStrategy strategy = (PlacementStrategy) strategies.getSelectedToggle().getUserData();
                    mdiCanvas.setPlacementStrategy(strategy);
                }
            }
        });
        
        //Put it into the main pane
        HBox hBox = new HBox(
                btnDefaultMdi,
                defaultStrategy,
                cascadingStrategy
        );
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(5);
        mainPane.getChildren().add(hBox);
        
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }
}
