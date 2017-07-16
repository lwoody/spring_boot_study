package com.example;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by LEE on 2017. 7. 16..
 */
@Entity
@Table(name = "myData")
public class MyData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 200, nullable = true)
    private String mail;

    @Column(nullable = true)
    private Integer age;

    @Column(nullable = true)
    private String memo;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<MsgData> msgdatas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<MsgData> getMsgdatas() {
        return msgdatas;
    }

    public void setMsgdatas(List<MsgData> msgdatas) {
        this.msgdatas = msgdatas;
    }
}
