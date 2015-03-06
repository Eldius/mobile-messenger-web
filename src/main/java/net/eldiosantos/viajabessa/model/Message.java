package net.eldiosantos.viajabessa.model;

import net.eldiosantos.viajabessa.model.auth.UserInfo;
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

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getFrom() {
        return from;
    }

    public void setFrom(UserInfo from) {
        this.from = from;
    }

    public UserInfo getTo() {
        return to;
    }

    public void setTo(UserInfo to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
