package main;

import config.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
    MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
    MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);

    RegisterRequest registerRequest = new RegisterRequest();
    registerRequest.setEmail("qudtns1223@naver.com");
    registerRequest.setName("장병순");
    registerRequest.setPassword("1234");
    registerRequest.setConfirmPassword("1234");
    registerService.regist(registerRequest);

    infoPrinter.printMemberInfo("qudtns1223@naver.com");
  }
}
