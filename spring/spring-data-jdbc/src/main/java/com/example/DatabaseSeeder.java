package com.example;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(DatabaseSeeder.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertData() {
        LOGGER.info("> Inserting data.....");
        jdbcTemplate.execute("INSERT INTO PERSON(first_name, last_name) VALUES('henri', 'rousseau')");
        jdbcTemplate.execute("INSERT INTO PERSON(first_name, last_name) VALUES('shosei', 'imazeki')");
        jdbcTemplate.execute("INSERT INTO PERSON(first_name, last_name) VALUES('gennnai', 'hirakushi')");
        jdbcTemplate.execute("INSERT INTO PERSON(first_name, last_name) VALUES('oukokuy', 'konoshima')");
        jdbcTemplate.execute("INSERT INTO PERSON(first_name, last_name) VALUES('kourin', 'ogata')");
        LOGGER.info("< Complete Inserting data");
    }
}
