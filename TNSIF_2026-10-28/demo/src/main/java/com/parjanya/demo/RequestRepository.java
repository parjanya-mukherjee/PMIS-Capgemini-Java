package com.parjanya.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RequestRepository {

    private final JdbcTemplate jdbcTemplate;

    public RequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(
            String itemName,
            int quantity,
            String status,
            String requestedBy) {

        String sql = """
            INSERT INTO requests
                (item_name, quantity, status, requested_by)
            VALUES (?, ?, ?, ?)
            """;

        jdbcTemplate.update(
            sql, itemName, quantity, status, requestedBy
        );
    }
}