package com.example.topics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TopicsRepositoryImpl implements TopicsRepository {

    private final JdbcTemplate jdbcTemplate;

    public TopicsRepositoryImpl(@Qualifier("topicsJdbcTemplate")JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Topic selectById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM topics WHERE id=?",
                new DataClassRowMapper<>(Topic.class), id);
    }

    @Override
    public boolean insert(Topic topic) {
        int count = jdbcTemplate.update("INSERT INTO topics (id, title) VALUES (?, ?)",
                topic.getId(),
                topic.getTitle());
        return count > 0;
    }

    @Override
    public boolean update(Topic topic) {
        int count = jdbcTemplate.update("UPDATE topics SET title=? WHERE id=?",
                topic.getTitle(),
                topic.getId());
        return count > 0;
    }
}
