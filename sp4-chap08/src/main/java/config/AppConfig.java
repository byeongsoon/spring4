package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.ChangePasswordService;
import spring.MemberDao;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableTransactionManagement
public class AppConfig {

  @Bean(destroyMethod = "close")
  public DataSource dataSource() {
    ComboPooledDataSource ds = new ComboPooledDataSource();
    try {
      ds.setDriverClass("com.mysql.jdbc.Driver");
    } catch (PropertyVetoException e) {
      throw new RuntimeException(e);
    }

    ds.setJdbcUrl("jdbc:mysql://203.230.100.198:3306/spring4fs");
    ds.setUser("spring4");
    ds.setPassword("srping4");
    return ds;
  }

  @Bean
  public MemberDao memberDao() {
    return new MemberDao(dataSource());
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    DataSourceTransactionManager tm = new DataSourceTransactionManager();
    tm.setDataSource(dataSource());
    return tm;
  }

  @Bean
  public ChangePasswordService changePasswordService() {
    return new ChangePasswordService(memberDao());
  }
}
