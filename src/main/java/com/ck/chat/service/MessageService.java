package com.ck.chat.service;

import com.ck.chat.model.Message;
import com.ck.chat.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService implements IMessageService {

    @Autowired
    private IMessageRepository iMessageRepository;

    @Override
    public void addMessage(Message message) {
        iMessageRepository.addMessage(message);
    }

    @Override
    public void addMessages(List<Message> messages) {
        messages.forEach(this::addMessage);
    }

    @Override
    public void deleteMessage(String id) {
      iMessageRepository.deleteMessage(id);
    }

    @Override
    public Message findMessageById(String id) {
        return iMessageRepository.findMessageById(id);
    }

    @Override
    public List<Message> fetchMessages() {
        return iMessageRepository.fetchMessages();
    }
}
