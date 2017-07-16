package com.example;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by LEE on 2017. 7. 16..
 */
@Entity
@Table(name="msgdata")
public class MsgData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @NotNull
    private long id;

    @Column
    private String title;

    @Column(nullable = false)
    @NotEmpty
    private String message;

    @ManyToOne
    private MyData mydata;

    public MsgData(){
        super();
        mydata = new MyData();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyData getMydata() {
        return mydata;
    }

    public void setMydata(MyData mydata) {
        this.mydata = mydata;
    }
}
