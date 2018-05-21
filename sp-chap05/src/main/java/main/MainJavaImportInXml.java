package main;

import config.JavaMainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainJavaImportInXml {

  public static void main(String[] args) {
    ApplicationContext ctx = new GenericXmlApplicationContext("classpath:main-conf.xml");
    MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
    MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);

    RegisterRequest registerRequest = new RegisterRequest();
    registerRequest.setEmail("qudtns1223@naver.com");
    registerRequest.setName("Java Import In Xml");
    registerRequest.setPassword("1234");
    registerRequest.setConfirmPassword("1234");
    registerService.regist(registerRequest);

    infoPrinter.printMemberInfo("qudtns1223@naver.com");
  }
}
