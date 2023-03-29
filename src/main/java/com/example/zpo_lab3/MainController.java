package com.example.zpo_lab3;



import PackageAnswer.Answer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;



public class MainController {

    private Socket socket = null;
    private OutputStream output = null;

    ObjectOutputStream objectOutputStream = null;
    @FXML
    private void initialize(){
        String hostname = "localhost";
        int port = 4447;

        try{
            socket = new Socket(hostname, port);
            output = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(output);


        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    @FXML
    private TextField NickText;
    @FXML
    private TextField AnswerText;

    @FXML
    protected void onSendButtonClick() {
        try {
            Answer answer = new Answer(NickText.getText(),AnswerText.getText());
            objectOutputStream.writeObject(answer);
        }catch (IOException ex){
            System.out.println("I/O error: " + ex.getMessage());
        }


    }
}