package com.simplenetworkingapp.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Message {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String content;
    private LocalDateTime sentAt;
} 