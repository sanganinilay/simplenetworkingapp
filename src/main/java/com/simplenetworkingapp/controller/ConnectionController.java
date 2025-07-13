package com.simplenetworkingapp.controller;

import com.simplenetworkingapp.model.Connection;
import com.simplenetworkingapp.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {
    @Autowired
    private ConnectionService connectionService;

    @PostMapping("/request")
    public String sendRequest(@RequestParam Long userId, @RequestParam Long targetUserId) {
        connectionService.sendConnectionRequest(userId, targetUserId);
        return "Request sent";
    }

    @PostMapping("/accept/{id}")
    public String accept(@PathVariable Long id) {
        connectionService.acceptConnection(id);
        return "Accepted";
    }

    @PostMapping("/reject/{id}")
    public String reject(@PathVariable Long id) {
        connectionService.rejectConnection(id);
        return "Rejected";
    }

    @GetMapping("/user/{userId}")
    public List<Connection> listConnections(@PathVariable Long userId) {
        return connectionService.listConnections(userId);
    }

    @GetMapping("/incoming/{userId}")
    public List<Connection> listIncoming(@PathVariable Long userId) {
        return connectionService.listIncomingRequests(userId);
    }
} 