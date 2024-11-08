package com.example.todos;

public interface TodosRepository {
    Todo selectById(Long id);

    boolean insert(Todo todo);

    boolean update(Todo todo);
}
