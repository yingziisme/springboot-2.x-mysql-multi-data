package com.mt.demo.multidata.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * AaadbConfig
 *
 * @author MT.LUO
 * 2018/8/22 11:20
 * @Description:
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "catdbEntityManagerFactory",
                        transactionManagerRef ="catdbTransactionManager",
                        basePackages = {"com.mt.demo.multidata.catdb.repository"})
public class CatdbConfig {


    /**
     * 注入 sqlite数据源
     */
    @Resource(name = "catdbDataSource")
    private DataSource sqliteDataSource;

    /**
     * 注入JPA配置实体
     */
    @Autowired
    private JpaProperties jpaProperties;

    /**
     * 这里其实不需要配置数据库的方言.
     */
    private Map<String, Object> getVendorProperties() {
        HibernateSettings hibernateSettings = new HibernateSettings();
        return jpaProperties.getHibernateProperties(hibernateSettings);
    }

    /**
     * 配置EntityManagerFactory实体
     *
     * @param builder
     * @return 实体管理工厂
     * packages     扫描@Entity注释的软件包名称
     * persistenceUnit  持久性单元的名称。 如果只建立一个EntityManagerFactory，你可以省略这个，但是如果在同一个应用程序中有多个，你应该给它们不同的名字
     * properties       标准JPA或供应商特定配置的通用属性。 这些属性覆盖构造函数中提供的任何值。
     */
    @Bean(name = "catdbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySqlite(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(sqliteDataSource)
                .properties(getVendorProperties())
                .packages("com.mt.demo.multidata.catdb.entity")
                .persistenceUnit("catdbPersistenceUnit")
                .build();
    }

    /**
     * 配置EntityManager实体
     *
     * @param builder
     * @return 实体管理器
     */
    @Bean(name = "catdbEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySqlite(builder).getObject().createEntityManager();
    }


    /**
     * 配置事务transactionManager
     *
     * @param builder
     * @return 事务管理器
     */
    @Bean(name = "catdbTransactionManager")
    public PlatformTransactionManager transactionManagerSqlite(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySqlite(builder).getObject());
    }
}
