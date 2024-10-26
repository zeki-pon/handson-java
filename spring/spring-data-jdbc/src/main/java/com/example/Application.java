package com.example;

import ch.qos.logback.classic.Logger;
import com.example.entity.Person;
import com.example.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

import java.util.Optional;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Application.class);

    @Autowired
    PersonRepository personRepository;
    @Autowired
    DatabaseSeeder databaseSeeder;

    public static void main(String[] args) {
        // アクティブなプロパティファイルを切り替えたい時に設定する
        // 以下の設定の場合、application-jdbcintro.properties(yml)がアクティブとなる
//        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "jdbcintro");

        // Spring Bootのアプリケーション起動
        // Application.classを指定することで、このクラスを起点にコンポーネントスキャンが走る
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        LOGGER.info("@@ Inserting data....");
        databaseSeeder.insertData();

        LOGGER.info("@@ findAll() call....");
        personRepository.findAll().forEach(person -> LOGGER.info(person.toString()));

        LOGGER.info("@@ findById() call....");
        Optional<Person> optionalPerson = personRepository.findById(1L);
        optionalPerson.ifPresent(person -> LOGGER.info(person.toString()));

        LOGGER.info("@@ save() call....");
        Person newPerson = new Person("yuichi", "takahashi");
        Person result = personRepository.save(newPerson);
        LOGGER.info(result.toString());

        LOGGER.info("@@ delete() call....");
        optionalPerson.ifPresent(person -> personRepository.delete(person));

        LOGGER.info("@@ findAll() call....");
        personRepository.findAll().forEach(person -> LOGGER.info(person.toString()));

        LOGGER.info("@@ findByFirstName() call....");
        personRepository.findByFirstName("yuichi").forEach(person -> LOGGER.info(person.toString()));

        LOGGER.info("@@ updateByFirstName() call....");
        personRepository.updateByFirstName(6L, "shouen");
        personRepository.findAll().forEach(person -> LOGGER.info(person.toString()));
    }
}
