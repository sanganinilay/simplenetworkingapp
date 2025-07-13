package com.simplenetworkingapp.model;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Connection {
    private Long id;
    private Long userId;
    private Long connectedUserId;
    private String status;
    private LocalDateTime createdAt;
} 