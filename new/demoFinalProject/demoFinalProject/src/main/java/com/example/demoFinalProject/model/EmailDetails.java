package com.example.demoFinalProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "email")
public class EmailDetails {
    @Id
    private int id;
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public EmailDetails(int id, String recipient, String msgBody, String subject, String attachment) {
        this.id = id;
        this.recipient = recipient;
        this.msgBody = msgBody;
        this.subject = subject;
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "EmailDetails{" +
                "id=" + id +
                ", recipient='" + recipient + '\'' +
                ", msgBody='" + msgBody + '\'' +
                ", subject='" + subject + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
