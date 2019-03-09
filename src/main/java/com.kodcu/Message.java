package com.kodcu;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
