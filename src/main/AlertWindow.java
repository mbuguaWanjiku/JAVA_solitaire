package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Luís Bragança & John Wanjiku
 */
public class AlertWindow extends Stage {
    
    Label content;
    String title;
    
    /**
     * A window with a title, a String content and an ok button that closes the stage
     * @param title Title of the window
     * @param content Content of the window
     */
    public AlertWindow(String title, String content) {
        this.title = title;
        this.content = new Label(content);
        modifySpecs();

        final Button okButton = new Button("Ok");
        okButton.setPrefWidth(60);
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage)okButton.getScene().getWindow()).close();
            }
        });
        
        VBox main = VBoxBuilder.create().children(this.content, okButton).padding(new Insets(30)).spacing(20).build();
        main.setAlignment(Pos.CENTER);
        setScene(new Scene(main));
        show();
    }

    /**
     * modifies the Stage's specs
     */
    private void modifySpecs() {
        centerOnScreen();
        content.setAlignment(Pos.CENTER);
        setTitle(title);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setIconified(false);
        content.setStyle("-fx-font-wight: bold;");
    }
}
