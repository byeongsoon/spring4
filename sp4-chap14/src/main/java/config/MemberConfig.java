package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableTransactionManagement
public class MemberConfig {

  @Bean
  public DataSource dataSource() {
    ComboPooledDataSource ds = new ComboPooledDataSource();
    try {
      ds.setDriverClass("com.mysql.jdbc.Driver");
    } catch (PropertyVetoException e) {
      throw new RuntimeException();
    }
    ds.setJdbcUrl("jdbc:mysql://203.230.100.198:3306/spring4fs?characterEncoding=utf8");
    ds.setUser("spring4");
    ds.setPassword("spring4");
    return ds;
  }

  @Bean
  public DataSourceTransactionManager dataSourceTransactionManager() {
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
    transactionManager.setDataSource(dataSource());
    return transactionManager;
  }

  @Bean
  public MemberDao memberDao() {
    return new MemberDao(dataSource());
  }

  @Bean
  public MemberRegisterService memberRegisterService() {
    return new MemberRegisterService(memberDao());
  }

  @Bean
  public ChangePasswordService changePasswordService() {
    return new ChangePasswordService(memberDao());
  }

  @Bean
  public AuthService authService() {
    AuthService authService = new AuthService();
    authService.setMemberDao(memberDao());
    return authService;
  }

}
