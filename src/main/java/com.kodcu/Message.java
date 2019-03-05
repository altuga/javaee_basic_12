package com.kodcu;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private long id;

    private String content;

    public Message() {

    }

    public Message(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{}";
    }
}
