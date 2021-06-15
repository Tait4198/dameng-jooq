package org.example.dm;

import dm.jdbc.driver.DmdbDataSource;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean("defaultDataSource")
    public DataSource defaultDataSource(@Value("${spring.datasource.url}") String url,
                                        @Value("${spring.datasource.username}") String user,
                                        @Value("${spring.datasource.password}") String password) {
        DmdbDataSource dataSource = new DmdbDataSource();
        dataSource.setURL(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DSLContext dslContext(@Qualifier("defaultDataSource") DataSource dataSource) {
        return DSL.using(new DefaultConfiguration()
                .set(new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource)))
                .set(new SpringTransactionProvider(new DataSourceTransactionManager(dataSource))));
    }
}
