package main;

import config.ConfigPart1;
import config.ConfigPart2;
import config.ConfigPartMain;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainTwoConfigs2 {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigPartMain.class);
    MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
    MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);

    RegisterRequest registerRequest = new RegisterRequest();
    registerRequest.setEmail("qudtns1223@naver.com");
    registerRequest.setName("configTwoWithImport");
    registerRequest.setPassword("1234");
    registerRequest.setConfirmPassword("1234");
    registerService.regist(registerRequest);

    infoPrinter.printMemberInfo("qudtns1223@naver.com");
  }
}
