package com.example.zpo_lab3;

import java.io.Serializable;

public class Answer2 implements Serializable {
    private String nick;
    private String answer;

    public String getNick() {
        return nick;
    }

    public String getAnswer() {
        return answer;
    }

    public Answer2(String nick, String answer) {
        this.nick = nick;
        this.answer = answer;
    }
}
