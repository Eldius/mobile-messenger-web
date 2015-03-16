package net.eldiosantos.messenger.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by eldio.junior on 10/03/2015.
 */
public class MessageVO implements Serializable {
    private Long msgId;
    private Long from;
    private Long to;
    private String message;
    private String fromName;

    public MessageVO() {
    }

    public MessageVO(Long msgId, Long from, Long to, String message, String fromName) {
        this.msgId = msgId;
        this.from = from;
        this.to = to;
        this.message = message;
        this.fromName = fromName;
    }

    public Long getFrom() {
        return from;
    }

    public MessageVO setFrom(Long from) {
        this.from = from;
        return this;
    }

    public Long getTo() {
        return to;
    }

    public MessageVO setTo(Long to) {
        this.to = to;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessageVO setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public MessageVO setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public Long getMsgId() {
        return msgId;
    }

    public MessageVO setMsgId(Long msgId) {
        this.msgId = msgId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
