package com.alicegerman.animation;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class AnimatedShapesController {
	@FXML
	private Canvas can;
	private GraphicsContext gc;
	@FXML
	private RadioButton circle_button, square_button;
	
	@FXML
	public void initialize() {
		gc = can.getGraphicsContext2D();
	}
	int shape_select = 1;
	
	@FXML
	public void can_pressed(MouseEvent event) {
		int[] i = {1};
		double x = event.getX();
		double y = event.getY();
		Timeline timeline = new Timeline(
			    new KeyFrame(Duration.seconds(0.2), e -> {
			    	int rand = getRandomNumber();
			    	if (rand == 1) {
			    		gc.setFill(Color.BLUE);
			    	}
			    	if (rand == 2) {
			    		gc.setFill(Color.RED);
			    	}
			    	if (rand == 3) {
			    		gc.setFill(Color.YELLOW);
			    	}
			    	if (rand == 4) {
			    		gc.setFill(Color.GREEN);
			    	}
			    	if (rand == 5) {
			    		gc.setFill(Color.PURPLE);
			    	}
			    	if (rand == 6) {
			    		gc.setFill(Color.ORANGE);
			    	}
			    	if (shape_select == 1) {
			    		gc.fillOval(x,y, i[0], i[0]);
			    	}
			    	else {
			    		gc.fillRect(x, y, i[0], i[0]);
			    	}
			    	i[0]++;
			    	
			    	
			    })
			);

			timeline.setCycleCount(100);
			timeline.play();
	}
	
	public void r_pressed(ActionEvent e) {
		if(circle_button.isSelected()) {
			shape_select = 1;
		}
		if(square_button.isSelected()) {
			shape_select = 2;
		}
	}
	public static int getRandomNumber() {
		 Random random = new Random();
		 int diceRoll = random.nextInt(6) + 1; 
		 return diceRoll;
	}
}
