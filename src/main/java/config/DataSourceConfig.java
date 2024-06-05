package config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceConfig{
    private static HikariDataSource dataSource;

    private DataSourceConfig() {

    }

    public static HikariDataSource getInstance() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mariadb://119.192.172.145:61003/boot_up");
            config.setUsername("beyond");
            config.setPassword("qwer1234");
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(5);
            dataSource = new HikariDataSource(config);
        }

        return dataSource;
    }
}