package com.ck.chat.service;

import com.ck.chat.model.Message;

import java.util.List;

public interface IMessageService {

    void addMessage(Message message);

    void addMessages(List<Message> message);

    void deleteMessage(String id);

    Message findMessageById(String id);

    List<Message> fetchMessages();

}
