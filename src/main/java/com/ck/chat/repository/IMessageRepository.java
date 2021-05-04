package com.ck.chat.repository;

import com.ck.chat.model.Message;

import java.util.List;

public interface IMessageRepository {

   void addMessage(Message message);

   void deleteMessage(String id);

   Message findMessageById(String id);

   List<Message> fetchMessages();



}
