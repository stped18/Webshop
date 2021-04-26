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
        entityManagerFactoryRef = "entityManagerFactory",
        basePackages = { "dk.vitten.backendshop.repository.product" }
)
public class ProductDBconfig {

  @Primary
  @Bean(name="ProductDSProps")
  @ConfigurationProperties("spring.product.datasource")
  public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }

  @Primary
  @Bean(name = "productDataSource")
  public DataSource weatherDataSource(@Qualifier("ProductDSProps") DataSourceProperties properties) {
    return properties.initializeDataSourceBuilder().build();
  }

  @Primary
  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean
  entityManagerFactory(
          EntityManagerFactoryBuilder builder,
          @Qualifier("productDataSource") DataSource dataSource
  ) {
    return builder
            .dataSource(dataSource)
            .packages("dk.vitten.backendshop.repository.product")
            .persistenceUnit("product")
            .build();
  }

  @Primary
  @Bean(name = "transactionManager")
  @ConfigurationProperties("product.jpa")
  public PlatformTransactionManager transactionManager(
          @Qualifier("entityManagerFactory") EntityManagerFactory
                  entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
