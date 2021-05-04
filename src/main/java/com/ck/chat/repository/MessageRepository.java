package com.ck.chat.repository;

import com.ck.chat.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MessageRepository implements IMessageRepository {
    private final Map<String, Message> messages;

    public MessageRepository() {
        this.messages = new HashMap<>();
    }

    @Override
    public void addMessage(Message message) {
        messages.put(message.getId(), message);
    }

    @Override
    public void deleteMessage(String id) {
        messages.remove(id);
    }

    @Override
    public Message findMessageById(String id) {
        return messages.get(id);
    }

    @Override
    public List<Message> fetchMessages() {
        return new ArrayList<>(messages.values());
    }
}
