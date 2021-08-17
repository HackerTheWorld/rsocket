package com.rsocket.vo;

import java.io.Serializable;

public class MessageVo implements Serializable {

    private static final long serialVersionUID = 3786010263098567267L;
    private String from;
    private String to;
    private String message;

    public MessageVo() {
    }

    public MessageVo(final String from, final String to, final String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}

