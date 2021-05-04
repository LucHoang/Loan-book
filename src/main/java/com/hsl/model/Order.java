package com.hsl.model;

import javax.persistence.*;

@Entity
@Table(name = "Oder")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long bookId;
    private String code;

    public Order() {
    }

    public Order(Long id, Long bookId, String code) {
        this.id = id;
        this.bookId = bookId;
        this.code = code;
    }

    public Order(Long bookId, String code) {
        this.bookId = bookId;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
