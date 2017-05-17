package br.com.umc.biotalk.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DBConfiguration {
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.primaryDatasource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.secondDatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

}
