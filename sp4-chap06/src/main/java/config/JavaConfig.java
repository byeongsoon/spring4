package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.Client2;

@Configuration
public class JavaConfig {

  @Bean(initMethod = "connect", destroyMethod = "close")
  @Scope("prototype")
  public Client2 client2() {
    Client2 client2 = new Client2();
    client2.setHost("서버2");
    return client2;
  }
}
