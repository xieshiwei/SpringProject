package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @ClassName JdbcConfig
 * <p>
 * 和spring连接数据库相关的配置类（用来吧一些非公共的配置转移出来）
 * @Author 萌琪琪爸爸
 * @Description //TODO
 * @Date 2020/1/5 16:15
 **/
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建ORM
     *
     * @param dataSource
     * @return
     */

    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner crateQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源
     *
     * @return
     */
    @Bean(name = "ds")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }


}
