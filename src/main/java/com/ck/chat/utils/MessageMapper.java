package com.ck.chat.utils;

import com.ck.chat.model.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MessageMapper {

    public List<Message> serializedMessages(){
        String content = "";
        List<Message> messages = new ArrayList<>();
        try {
            content = Files.readString(Path.of("src/main/resources/messages.json"), StandardCharsets.US_ASCII);
           messages = new ObjectMapper().readValue(content, new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messages;
    }

}
