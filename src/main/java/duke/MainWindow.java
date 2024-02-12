package duke;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/sender.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/cookie.png"));

    /**
     * Initializes the controller after its root element has been completely processed.
     * Sets up scrolling functionality for the dialog container and displays the initial welcome message.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(DialogBox.getCookieDialog("Heyy! I'm cookie! :) \n" +
                "What can I do for your today?", dukeImage));
        scrollPane.setStyle("-fx-background: #C0C0C0;");

    }

    /**
     * Sets the Duke instance associated with this MainWindow.
     *
     * @param d The Duke instance to be set.
     */
    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Handles user input by processing it and displaying appropriate responses from Duke.
     * Clears the user input field after processing.
     *
     * @throws DukeException If an error occurs during the Duke's response processing.
     */
    @FXML
    private void handleUserInput() throws DukeException {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getCookieDialog(response, dukeImage)
        );
        userInput.clear();
        if (duke.isExit) {
            javafx.application.Platform.exit();
        }
    }
}
