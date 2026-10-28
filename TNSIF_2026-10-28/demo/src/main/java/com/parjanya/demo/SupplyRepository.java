package com.parjanya.demo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SupplyRepository {

    private final JdbcTemplate jdbcTemplate;

    public SupplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Custom RowMapper: database row -> Supply object
    private final RowMapper<Supply> supplyRowMapper = (rs, rowNum) ->
        new Supply(
            rs.getLong("id"),
            rs.getString("item_name"),
            rs.getInt("quantity")
        );

    public List<Supply> findAll() {
        String sql =
            "SELECT id, item_name, quantity FROM supplies ORDER BY id";

        return jdbcTemplate.query(sql, supplyRowMapper);
    }

    // Locks an existing inventory row until the transaction finishes.
    public Supply findByNameForUpdate(String itemName) {
        String sql = """
            SELECT id, item_name, quantity
            FROM supplies
            WHERE LOWER(item_name) = LOWER(?)
            FOR UPDATE
            """;

        List<Supply> results =
            jdbcTemplate.query(sql, supplyRowMapper, itemName);

        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(String itemName, int quantity) {
        String sql =
            "INSERT INTO supplies (item_name, quantity) VALUES (?, ?)";

        jdbcTemplate.update(sql, itemName, quantity);
    }

    public void updateQuantity(long id, int quantity) {
        String sql = "UPDATE supplies SET quantity = ? WHERE id = ?";

        jdbcTemplate.update(sql, quantity, id);
    }
}