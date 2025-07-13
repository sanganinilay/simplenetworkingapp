package com.simplenetworkingapp.service;

import com.simplenetworkingapp.model.Connection;
import com.simplenetworkingapp.model.ConnectionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConnectionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int sendConnectionRequest(Long userId, Long targetUserId) {
        String sql = "INSERT INTO connections (user_id, connected_user_id, status) VALUES ("
            + userId + ", " + targetUserId + ", 'PENDING')";
        return jdbcTemplate.update(sql);
    }

    public int acceptConnection(Long connectionId) {
        String sql = "UPDATE connections SET status = 'ACCEPTED' WHERE id = " + connectionId;
        return jdbcTemplate.update(sql);
    }

    public int rejectConnection(Long connectionId) {
        String sql = "UPDATE connections SET status = 'REJECTED' WHERE id = " + connectionId;
        return jdbcTemplate.update(sql);
    }

    public List<Connection> listConnections(Long userId) {
        String sql = "SELECT * FROM connections WHERE user_id = " + userId;
        return jdbcTemplate.query(sql, new ConnectionRowMapper());
    }

    public List<Connection> listIncomingRequests(Long userId) {
        String sql = "SELECT * FROM connections WHERE connected_user_id = " + userId;
        return jdbcTemplate.query(sql, new ConnectionRowMapper());
    }
} 