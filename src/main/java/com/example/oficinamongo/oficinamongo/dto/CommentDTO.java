package com.example.oficinamongo.oficinamongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    private String texto;
    private Date date;
    private AuthorDTO author;

    public CommentDTO() {
        
    }

    public CommentDTO(AuthorDTO author, Date date, String texto) {
        this.author = author;
        this.date = date;
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
