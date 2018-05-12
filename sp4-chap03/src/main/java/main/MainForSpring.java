package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpring {

  private static ApplicationContext applicationContext = null;

  public static void main(String[] args) throws IOException {
    //applicationContext = new GenericXmlApplicationContext("classpath:conf1.xml", "classpath:conf2.xml");
    applicationContext = new GenericXmlApplicationContext("classpath:configImport.xml");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      System.out.println("명령어를 입력하세요: ");
      String command = reader.readLine();
      if (command.equalsIgnoreCase("exit")) {
        System.out.println("종료합니다");
        break;
      }
      if (command.startsWith("new")) {
        processNewCommad(command.split(" "));
        continue;
      } else if (command.startsWith("change")) {
        processChangeCommand(command.split(" "));
        continue;
      } else if ("list".equals(command)) {
        processListCommand();
        continue;
      } else if (command.startsWith("info")) {
        processInfoCommand(command.split(" "));
        continue;
      } else if ("version".equals(command)) {
        processVersionCommand();
        continue;
      }

      printHelp();
    }
  }

  private static void processVersionCommand() {
    VersionPrinter versionPrinter = applicationContext.getBean("versionPrinter", VersionPrinter.class);
    versionPrinter.print();
  }

  private static void processInfoCommand(String[] arg) {
    if (arg.length != 2){
      printHelp();
      return;
    }

    MemberInfoPrinter infoPrinter = applicationContext.getBean("infoPrinter", MemberInfoPrinter.class);
    infoPrinter.printMemberInfo(arg[1]);
  }

  private static void processChangeCommand(String[] arg) {
    if (arg.length != 4) {
      printHelp();
      return;
    }
    ChangePasswordService changePasswordService = applicationContext.getBean("changePasswordService", ChangePasswordService.class);
    try {
      changePasswordService.changePassword(arg[1], arg[2], arg[3]);
      System.out.println("암호를 변경했습니다.\n");
    } catch (MemberNotFoundException e) {
      System.out.println("존재하지 않는 이메일입니다.\n");
    } catch (IdPasswordNotMatchingException e) {
      System.out.println("이메일과 암호가 일치하지 않습니다.\n");
    }
  }

  private static void printHelp() {
    System.out.println();
    System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
    System.out.println("new 이메일 이름 암호 암호확인");
    System.out.println("change 이메일 현재비밀번호 변경비밀번호");
  }

  private static void processNewCommad(String[] arg) {

    if (arg.length != 5) {
      printHelp();
      return;
    }

    MemberRegisterService memberRegisterService = applicationContext.getBean("memberRegisterService",MemberRegisterService.class);
    RegisterRequest registerRequest = new RegisterRequest();
    registerRequest.setEmail(arg[1]);
    registerRequest.setName(arg[2]);
    registerRequest.setPassword(arg[3]);
    registerRequest.setConfirmPassword(arg[4]);

    if (!registerRequest.isPasswordEqualToConfirmPassword()) {
      System.out.println("암호와 확인이 일치하지 않습니다.\n");
      return;
    }
    try {
      memberRegisterService.regist(registerRequest);
      System.out.println("등록했습니다.\n");
    } catch (AlreadyExistingMemberException e) {
      System.out.println("이미 존재하는 이메일입니다. \n");
    }
  }

  private static void processListCommand() {
    MemberListPrinter memberListPrinter = applicationContext.getBean("listPrinter", MemberListPrinter.class);
    memberListPrinter.printAll();
  }
}
