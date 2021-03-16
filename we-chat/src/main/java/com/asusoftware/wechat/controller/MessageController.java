package com.asusoftware.wechat.controller;

import com.asusoftware.wechat.model.Message;
import com.asusoftware.wechat.storage.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * we-chat Created by Antonio on 3/16/2021
 */
@RestController
@RequiredArgsConstructor
public class MessageController {

    private SimpMessagingTemplate simMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, Message message) {
        System.out.println("Handling send message: " + message + " to " + to);
        boolean isExist = UserStorage.getInstance().getUsers().contains(to);
        if(isExist) {
          simMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
}
