package com.simplenetworkingapp.service;

import com.simplenetworkingapp.model.Message;
import com.simplenetworkingapp.model.MessageRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int sendMessage(String senderId, String receiverId, String content) {
        String sql = "INSERT INTO messages (sender_id, receiver_id, content) VALUES ("
            + senderId + ", " + receiverId + ", '" + content + "')";
        return jdbcTemplate.update(sql);
    }

    public List<Message> getMessagesBetween(String userId1, String userId2) {
        String sql = "SELECT * FROM messages WHERE (sender_id = " + userId1 + " AND receiver_id = " + userId2 + ") OR (sender_id = " + userId2 + " AND receiver_id = " + userId1 + ")";
        return jdbcTemplate.query(sql, new MessageRowMapper());
    }

    public List<Message> getMessagesForUser(String userId) {
        String sql = "SELECT * FROM messages WHERE sender_id = " + userId + " OR receiver_id = " + userId;
        return jdbcTemplate.query(sql, new MessageRowMapper());
    }
} 