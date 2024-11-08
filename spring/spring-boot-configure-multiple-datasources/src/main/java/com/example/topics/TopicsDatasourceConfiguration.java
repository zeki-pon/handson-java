package com.example.topics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class TopicsDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.topics")
    public DataSourceProperties topicsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource topicsDataSource() {
        return topicsDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public DataSourceInitializer topicsDataSourceInitializer(@Qualifier("topicsDataSource") DataSource dataSource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("schema-topics.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("data-topics.sql"));

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }

    @Bean
    public JdbcTemplate topicsJdbcTemplate(@Qualifier("topicsDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
