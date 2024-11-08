package com.example.topics;

public interface TopicsRepository {
    Topic selectById(Long id);

    boolean insert(Topic topic);

    boolean update(Topic topic);
}
