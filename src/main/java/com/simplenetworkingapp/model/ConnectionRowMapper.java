package com.simplenetworkingapp.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionRowMapper implements RowMapper<Connection> {
    @Override
    public Connection mapRow(ResultSet rs, int rowNum) throws SQLException {
        Connection c = new Connection();
        c.setId(rs.getLong("id"));
        c.setUserId(rs.getLong("user_id"));
        c.setConnectedUserId(rs.getLong("connected_user_id"));
        c.setStatus(rs.getString("status"));
        c.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        return c;
    }
} 