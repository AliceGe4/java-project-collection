package com.alicegerman.targetclick;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class TargetClickController {

    @FXML
    private Canvas can;

    @FXML
    private Button start_button;

    private GraphicsContext gc;

    private final Random random = new Random();

    private final ArrayList<Target> targets = new ArrayList<>();

    private int missedClicks = 0;
    private int hitClicks = 0;

    private static final double SQUARE_SIZE = 10;
    private static final int NUMBER_OF_SQUARES = 10;

    /*
     * Represents one square on the Canvas.
     */
    private static class Target {
        private final double x;
        private final double y;

        public Target(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    @FXML
    public void initialize() {
        gc = can.getGraphicsContext2D();
    }

    /*
     * Called when the user clicks the Canvas.
     */
    @FXML
    private void clicked(MouseEvent event) {
        boolean squareWasHit = false;

        /*
         * Search backwards so removing an item is safe.
         */
        for (int i = targets.size() - 1; i >= 0; i--) {
            Target target = targets.get(i);

            boolean insideX =
                    event.getX() >= target.x
                    && event.getX() <= target.x + SQUARE_SIZE;

            boolean insideY =
                    event.getY() >= target.y
                    && event.getY() <= target.y + SQUARE_SIZE;

            if (insideX && insideY) {
                hitClicks++;
                targets.remove(i);
                squareWasHit = true;

                redrawCanvas();

                /*
                 * One click should hit only one square.
                 */
                break;
            }
        }

        if (!squareWasHit) {
            missedClicks++;
        }
    }

    /*
     * Called when the Start button is pressed.
     */
    @FXML
    private void game_start(ActionEvent event) {
        resetGame();

        /*
         * Prevent the user from starting multiple games simultaneously.
         */
        start_button.setDisable(true);

        Timeline squareTimeline = new Timeline(
            new KeyFrame(Duration.seconds(0.5), e -> {
                createSquare();
            })
        );

        squareTimeline.setCycleCount(NUMBER_OF_SQUARES);

        /*
         * The last square still needs one second before disappearing.
         */
        squareTimeline.setOnFinished(e -> {
            PauseTransition finalDelay =
                    new PauseTransition(Duration.seconds(2));

            finalDelay.setOnFinished(finishEvent -> {
                redrawCanvas();
                showScore();
                start_button.setDisable(false);
            });

            finalDelay.play();
        });

        squareTimeline.play();
    }

    /*
     * Creates and displays one square.
     */
    private void createSquare() {
        double x = getRandomX();
        double y = getRandomY();

        Target target = new Target(x, y);

        targets.add(target);
        redrawCanvas();

        /*
         * This specific square disappears after one second.
         */
        PauseTransition removalDelay =
                new PauseTransition(Duration.seconds(2));

        removalDelay.setOnFinished(event -> {
            targets.remove(target);
            redrawCanvas();
        });

        removalDelay.play();
    }

    /*
     * Clears the Canvas and redraws every square that is still active.
     */
    private void redrawCanvas() {
        gc.clearRect(0, 0, can.getWidth(), can.getHeight());

        for (Target target : targets) {
            gc.fillRect(
                target.x,
                target.y,
                SQUARE_SIZE,
                SQUARE_SIZE
            );
        }
    }

    private void showScore() {
        int score = 2 * hitClicks - missedClicks;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Finished");
        alert.setHeaderText(null);
        alert.setContentText(
            "Hits: " + hitClicks
            + "\nMisses: " + missedClicks
            + "\nScore: " + score
        );

        /*
         * show() is non-blocking, so it is safe here.
         */
        alert.show();
    }

    private void resetGame() {
        hitClicks = 0;
        missedClicks = 0;

        targets.clear();

        gc.clearRect(
            0,
            0,
            can.getWidth(),
            can.getHeight()
        );
    }

    private double getRandomX() {
        double availableWidth = can.getWidth() - SQUARE_SIZE;
        return random.nextDouble() * availableWidth;
    }

    private double getRandomY() {
        double availableHeight = can.getHeight() - SQUARE_SIZE;
        return random.nextDouble() * availableHeight;
    }
}
