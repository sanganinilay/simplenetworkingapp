package com.simplenetworkingapp.controller;

import com.simplenetworkingapp.model.Message;
import com.simplenetworkingapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam String content) {
        messageService.sendMessage(senderId, receiverId, content);
        return "Message sent";
    }

    @GetMapping("/between")
    public List<Message> getMessagesBetween(@RequestParam Long userId1, @RequestParam Long userId2) {
        return messageService.getMessagesBetween(userId1, userId2);
    }

    @GetMapping("/user/{userId}")
    public List<Message> getMessagesForUser(@PathVariable Long userId) {
        return messageService.getMessagesForUser(userId);
    }
} 