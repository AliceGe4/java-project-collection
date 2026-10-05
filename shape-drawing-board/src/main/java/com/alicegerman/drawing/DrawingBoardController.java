package com.alicegerman.drawing;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;





public class DrawingBoardController {
	
	@FXML
	private Canvas can;
	private GraphicsContext gc;
	@FXML
	private RadioButton LineButton, RectButton;
	@FXML
	private TextField LineField, RectWidthField, RectHeightField;
	@FXML
	private Button ClearButton;
	
	private int shape_select = 1;
	
	@FXML
	public void initialize() {
		gc = can.getGraphicsContext2D();
	}
	
	@FXML
	public void can_pressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		if (shape_select == 1) {
			double line_length = Double.parseDouble(LineField.getText());
			gc.setStroke(Color.RED);
			gc.strokeLine(x, y, x+line_length, y);
		}
		else {
			double width = Double.parseDouble(RectWidthField.getText());
			double height = Double.parseDouble(RectHeightField.getText());
			gc.setStroke(Color.BLUE);
			gc.strokeRect(x, y, width, height);
		}
	}
	@FXML
	public void r_pressed(ActionEvent e) {
		if(LineButton.isSelected()) {
			shape_select = 1;
		}
		if(RectButton.isSelected()) {
			shape_select = 2;
		}
	}
	@FXML
	private void clear(ActionEvent e) {
		gc.clearRect(0, 0, can.getWidth(), can.getHeight());
	}
}
