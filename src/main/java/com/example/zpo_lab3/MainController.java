package com.example.zpo_lab3;



import PackageAnswer.Answer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;



public class MainController {

    private Socket socket = null;
    private ObjectOutputStream objectOutputStream = null;

    @FXML
    private Button ButtonSend;
    @FXML
    private Button ButtonConnect;
    @FXML
    private TextField NickText;
    @FXML
    private TextField AnswerText;

    @FXML
    private void initialize(){
        ButtonConnect.setDisable(false);
        ButtonSend.setDisable(true);
    }

    @FXML
    protected void onSendButtonClick() {
        try {
            Answer answer = new Answer(NickText.getText(),AnswerText.getText());
            objectOutputStream.writeObject(answer);
        }catch (IOException ex){
            ButtonConnect.setDisable(false);
            ButtonSend.setDisable(true);
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    private final String HOSTNAME = "localhost";
    private final int PORT = 4447;

    @FXML
    protected void onConnectButtonClick() {
        try{
            socket = new Socket(HOSTNAME, PORT);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ButtonConnect.setDisable(true);
            ButtonSend.setDisable(false);
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}