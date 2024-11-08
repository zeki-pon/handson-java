package com.example;

import com.example.todos.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
public class MultipleDataSourcesIntegrationTest {
    @Autowired
    TodosRepository todosRepository;
}
