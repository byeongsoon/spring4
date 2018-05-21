package main;

import config.ConfigPart1;
import config.ConfigPart2;
import config.JavaConfig3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainTwoConfig {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigPart1.class, ConfigPart2.class);
    MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
    MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);

    RegisterRequest registerRequest = new RegisterRequest();
    registerRequest.setEmail("qudtns1223@naver.com");
    registerRequest.setName("configTwo");
    registerRequest.setPassword("1234");
    registerRequest.setConfirmPassword("1234");
    registerService.regist(registerRequest);

    infoPrinter.printMemberInfo("qudtns1223@naver.com");
  }
}
