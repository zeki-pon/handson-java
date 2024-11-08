package com.example;

import com.example.todos.Todo;
import com.example.todos.TodosRepository;
import com.example.topics.Topic;
import com.example.topics.TopicsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    TodosRepository todosRepository;
    @Autowired
    TopicsRepository topicsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("@@ Test Todo Data START.....");
        // select
        LOGGER.info(todosRepository.selectById(1L).toString());
        // insert
        Todo todoForInsert = new Todo("test-title-insert");
        todoForInsert.setId(99L);
        todosRepository.insert(todoForInsert);
        // select
        LOGGER.info(todosRepository.selectById(99L).toString());
        // update
        Todo todoForUpdate = new Todo("test-title-update");
        todoForUpdate.setId(99L);
        todoForUpdate.setCompleted(true);
        todosRepository.update(todoForUpdate);
        // select
        LOGGER.info(todosRepository.selectById(99L).toString());
        LOGGER.info("@@ Test Todo Data DONE.....");


        LOGGER.info("@@ Get Topic Data START.....");
        // select
        LOGGER.info(topicsRepository.selectById(1L).toString());
        // insert
        Topic topicForInsert = new Topic("test-topic-insert");
        topicForInsert.setId(100L);
        topicsRepository.insert(topicForInsert);
        // select
        LOGGER.info(topicsRepository.selectById(100L).toString());
        // update
        Topic topicForUpdate = new Topic("test-topic-update");
        topicForUpdate.setId(100L);
        topicsRepository.update(topicForUpdate);
        // select
        LOGGER.info(topicsRepository.selectById(100L).toString());
        LOGGER.info("@@ Get Topic Data DONE.....");
    }
}
