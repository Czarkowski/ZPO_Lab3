package com.example.zpo_lab3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class MainController {

    private Socket socket = null;
    private OutputStream output = null;
    @FXML
    private void initialize(){
        String hostname = "localhost";
        int port = 4447;

        try{
            socket = new Socket(hostname, port);
            output = socket.getOutputStream();

            output.write("Client online".getBytes(StandardCharsets.UTF_8));


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
        NickText.setText("Welcome to JavaFX Application!");
    }
}