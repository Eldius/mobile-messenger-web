package net.eldiosantos.messenger.model;

import net.eldiosantos.messenger.model.auth.UserInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eldio.junior on 06/03/2015.
 */
@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private UserInfo from;

    @ManyToOne
    private UserInfo to;

    @Lob
    private String message;

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public UserInfo getFrom() {
        return from;
    }

    public Message setFrom(UserInfo from) {
        this.from = from;
        return this;
    }

    public UserInfo getTo() {
        return to;
    }

    public Message setTo(UserInfo to) {
        this.to = to;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
