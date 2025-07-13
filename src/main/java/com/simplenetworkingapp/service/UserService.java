package com.simplenetworkingapp.service;

import com.simplenetworkingapp.model.User;
import com.simplenetworkingapp.model.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createUser(User user) {
        String sql = "INSERT INTO users (username, email, password_hash, full_name) VALUES ('"
            + user.getUsername() + "', '"
            + user.getEmail() + "', '"
            + user.getPasswordHash() + "', '"
            + user.getFullName() + "')";
        return jdbcTemplate.update(sql);
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = '" + username + "'";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper());
    }

    public User getUserById(Long id) {
        String sql = "SELECT * FROM users WHERE id = " + id;
        return jdbcTemplate.queryForObject(sql, new UserRowMapper());
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
} 