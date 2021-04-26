package dk.vitten.backendshop.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "shopTransactionManager",
        entityManagerFactoryRef = "shopentityManagerFactory",
        basePackages = { "dk.vitten.backendshop.repository.shop" }
)
public class ShopDBconfig {


  @Bean(name="ShopDSProps")
  @ConfigurationProperties("spring.shop.datasource")
  public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }


  @Bean(name = "shopDataSource")
  public DataSource weatherDataSource(@Qualifier("ShopDSProps") DataSourceProperties properties) {
    return properties.initializeDataSourceBuilder().build();
  }


  @Bean(name = "shopentityManagerFactory")
  public LocalContainerEntityManagerFactoryBean
  entityManagerFactory(
          EntityManagerFactoryBuilder builder,
          @Qualifier("shopDataSource") DataSource dataSource
  ) {
    return builder
            .dataSource(dataSource)
            .packages("dk.vitten.backendshop.repository.shop")
            .persistenceUnit("shop")
            .build();
  }


  @Bean(name = "shoptransactionManager")
  @ConfigurationProperties("shop.jpa")
  public PlatformTransactionManager transactionManager(
          @Qualifier("entityManagerFactory") EntityManagerFactory
                  entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
