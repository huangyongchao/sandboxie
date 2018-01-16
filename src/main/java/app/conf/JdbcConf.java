package app.conf;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcConf {

	/**
	 * Create bsDatasource (default) DataSource.
	 */
	@Bean("bsDatasource")
	@ConfigurationProperties(prefix = "spring.datasource.dbcp2")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
}
