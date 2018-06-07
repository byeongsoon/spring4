package config;

import aspect.ExeTimeAspect2;
import chap07.Calculator;
import chap07.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
//@EnableAspectJAutoProxy(proxyTargetClass = true) // 인터페이스가 아닌 클래스로 프록시 생성할 때
public class JavaConfig {

  @Bean
  public ExeTimeAspect2 exeTimeAspect2() {
    return new ExeTimeAspect2();
  }

  @Bean
  public Calculator recCal() {
    return new RecCalculator();
  }
}
