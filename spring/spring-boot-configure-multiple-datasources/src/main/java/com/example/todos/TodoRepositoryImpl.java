package com.example.todos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryImpl implements TodosRepository {

    private final JdbcTemplate jdbcTemplate;

    public TodoRepositoryImpl(@Qualifier("todosJdbcTemplate")JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Todo selectById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM todos WHERE id=?",
                new DataClassRowMapper<>(Todo.class), id);
    }

    @Override
    public boolean insert(Todo todo) {
        int count = jdbcTemplate.update("INSERT INTO todos (id, title, completed) VALUES (?, ?, ?)",
                todo.getId(),
                todo.getTitle(),
                todo.isCompleted());
        return count > 0;
    }

    @Override
    public boolean update(Todo todo) {
        int count = jdbcTemplate.update("UPDATE todos SET title=?, completed=? WHERE id=?",
                todo.getTitle(),
                todo.isCompleted(),
                todo.getId());
        return count > 0;
    }
}
