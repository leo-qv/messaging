package com.ck.chat;

import com.ck.chat.model.Message;
import com.ck.chat.service.IMessageService;
import com.ck.chat.utils.MessageMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@SpringBootApplication
public class ChatApplication {

	@Autowired
	private IMessageService iMessageService;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ChatApplication.class, args);
	}

	@EventListener(classes = { ContextRefreshedEvent.class })
	public void onContextRefresh() {
		MessageMapper messageMapper = new MessageMapper();
		iMessageService.addMessages(messageMapper.serializedMessages());
	}

}
