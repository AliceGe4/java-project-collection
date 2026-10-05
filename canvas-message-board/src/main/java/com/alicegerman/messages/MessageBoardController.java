package com.alicegerman.messages;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class MessageBoardController {
	@FXML
	private Canvas can;
	private GraphicsContext gc;
	
	
	ArrayList<Double> x_lst = new ArrayList<>();
	ArrayList<Double> y_lst = new ArrayList<>();
	ArrayList<String> textList = new ArrayList<>();
	
	@FXML
	public void initialize() {
		gc = can.getGraphicsContext2D();
	}
	@FXML
	public void clicked(MouseEvent event) {

	    // Search backwards so removing items does not disturb the loop
	    for (int i = x_lst.size() - 1; i >= 0; i--) {

	        double differenceX = Math.abs(x_lst.get(i) - event.getX());
	        double differenceY = Math.abs(y_lst.get(i) - event.getY());

	        if (differenceX <= 20 && differenceY <= 20) {
	            x_lst.remove(i);
	            y_lst.remove(i);
	            textList.remove(i);
	        }
	    }

	    redrawCanvas();

	    TextInputDialog dialog = new TextInputDialog();
	    dialog.setHeaderText("Please enter your input");

	    Optional<String> result = dialog.showAndWait();

	    if (result.isPresent()) {
	        x_lst.add(event.getX());
	        y_lst.add(event.getY());
	        textList.add(result.get());

	        redrawCanvas();
	    }
	}
	
	private void redrawCanvas() {
	    gc.clearRect(0, 0, can.getWidth(), can.getHeight());

	    for (int i = 0; i < textList.size(); i++) {
	        gc.strokeText(
	            textList.get(i),
	            x_lst.get(i),
	            y_lst.get(i)
	        );
	    }
	}
}
