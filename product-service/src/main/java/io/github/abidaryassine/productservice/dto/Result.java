package io.github.abidaryassine.productservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yassineabidar on 5/2/2023
 */
@Getter
@Setter
public class Result<T> {
    private List<Message> errors;
    private List<Message> warnings;
    private List<Message> infos;
    private int status;
    private T data;

    public boolean hasError() {
        return getErrors().isEmpty();
    }

    public void addErrorMessage(String message) {
        addMessage(message, MessageType.ERROR);
        this.status = 400;
    }

    public void addInfoMessage(String message, int status) {
        addMessage(message, MessageType.INFO);
        this.status = status;
    }

    public void addWarningMessage(String message) {
        addMessage(message, MessageType.WARN);
        this.status = 422;
    }

    private void addMessage(String messageText, MessageType type) {
        Message newMessage = new Message(messageText, type);
        if (type == MessageType.ERROR) {
            getErrors().add(newMessage);
        } else if (type == MessageType.WARN) {
            getWarnings().add(newMessage);
        } else if (type == MessageType.INFO) {
            getInfos().add(newMessage);
        }

    }
    
    public List<Message> getErrors() {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        return errors;
    }

    public List<Message> getWarnings() {
        if (warnings == null) {
            warnings = new ArrayList<>();
        }
        return warnings;
    }

    public List<Message> getInfos() {
        if (infos == null) {
            infos = new ArrayList<>();
        }
        return infos;
    }
}
