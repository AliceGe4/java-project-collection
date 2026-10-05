package com.alicegerman.bullseye;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class BullseyeController {

    @FXML
    private TextField guessField;

    @FXML
    private Label resultLabel;

    @FXML
    private TextArea historyArea;

    @FXML
    private Button newGameButton;

    private BullseyeGame game;
    private int attempts;

    @FXML
    public void initialize() {
        game = new BullseyeGame();
        attempts = 0;

        resultLabel.setText("Enter your first guess.");
        historyArea.clear();
        historyArea.setEditable(false);

        newGameButton.setVisible(false);
        newGameButton.setManaged(false);
    }

    @FXML
    private void handleGuess() {
        String guess = guessField.getText().trim();
        String error = game.validateGuess(guess);

        if (error != null) {
            resultLabel.setText(error);
            return;
        }

        attempts++;

        int bulls = game.countBulls(guess);
        int hits = game.countHits(guess);

        resultLabel.setText("Bulls: " + bulls + ", Hits: " + hits);
        historyArea.appendText(guess + " -> Bulls: " + bulls + ", Hits: " + hits + "\n");

        guessField.clear();

        if (bulls == 4) {
        	String correctGuess = game.getSecretNumber();
            resultLabel.setText("You won in " + attempts + " attempts!");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("You guessed the number in " + attempts + " attempts, the number was: " + correctGuess );
            alert.setContentText("What would you like to do?");

            ButtonType newGame = new ButtonType("New Game");
            ButtonType exitGame = new ButtonType("Exit");

            alert.getButtonTypes().setAll(newGame, exitGame);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == newGame) {
                handleNewGame();
            } else if (result.isPresent() && result.get() == exitGame) {
                System.exit(0);
            }
        }
    }

    @FXML
    private void handleNewGame() {
        game.startNewGame();
        attempts = 0;

        resultLabel.setText("Enter your first guess.");
        historyArea.clear();
        guessField.clear();

        newGameButton.setVisible(false);
        newGameButton.setManaged(false);
    }
}
