package com.mt.demo.multidata.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * DataSourceConfig
 *
 * @author MT.LUO
 * 2018/8/22 11:18
 * @Description:
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "aaadbDataSource")
    @Qualifier("aaadbDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.aaadb")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "catdbDataSource")
    @Qualifier("catdbDataSource")
    @ConfigurationProperties(prefix="spring.datasource.catdb")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}
