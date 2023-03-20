package com.example.zpo_lab3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField NickText;
    @FXML
    private TextField AnswerText;

    @FXML
    protected void onSendButtonClick() {
        NickText.setText("Welcome to JavaFX Application!");
    }
}