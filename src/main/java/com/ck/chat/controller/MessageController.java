package com.ck.chat.controller;

import com.ck.chat.model.Message;
import com.ck.chat.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("data")
public class MessageController {

    @Autowired
    private IMessageService iMessageService;

    @GetMapping("messages")
    public List<Message> messages() {
        return iMessageService.fetchMessages();
    }

    // TODO: 03.04.21  add auto generator for message id, change response to Map

    @PostMapping(path = "/messages/{id}", consumes = "application/json", produces = "application/json")
    public void addMessage(@RequestBody Message message) {
        iMessageService.addMessage(message);
        System.out.println("Message added");
    }

    @DeleteMapping(path = "/messages/{id}")
    public void deleteMessage(@PathVariable(value = "id") String messageId) {

        Message fetchedMessage = iMessageService.fetchMessages()
                .stream()
                .filter(fetchedMessages -> messageId.equals(fetchedMessages.getId()))
                .findFirst()
                .orElseThrow((() -> new ResourceNotFoundException("Message not found for this id :: " + messageId)));

        iMessageService.deleteMessage(messageId);
        System.out.println("Message deleted");
        Map<String, Boolean> response = new HashMap<>();
    }

    // TODO: 03.04.21 add put method
}
