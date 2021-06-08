package org.tom_v_squad.soiwenttoaconcert.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeting {

    @Id
    @GeneratedValue
    private int greetingId;
//    private long id;

    private String content;

    public Greeting(int greetingId) {
        this.greetingId = greetingId;
    }

    public Greeting() {

    }

    public int getId() {
        return greetingId;
    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
