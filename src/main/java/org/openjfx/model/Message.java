package org.openjfx.model;

public class Message {

    public enum Status {
        UNKNOWN,
        DELIVERED,
        UNDELIVERED,
    }

    private Status status;
    private String text;
    private String time;

    public Message(String text, String time, Status status) {
        this.text = text;
        this.time = time;
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
