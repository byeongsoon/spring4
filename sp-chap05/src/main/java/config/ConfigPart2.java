package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;

@Configuration
public class ConfigPart2 {

//  @Autowired
//  private MemberDao memberDao; // 두 개의 설정파일을 사용할 때 의존 주입을 위한 MemberDao의 객체
  @Autowired
  private ConfigPart1 configPart1; // ConfigPart1 클래스를 사용하기 위한 인스턴스

  @Bean
  public MemberPrinter memberPrinter(){
    return new MemberPrinter();
  }

  @Bean
  public MemberInfoPrinter memberInfoPrinter(){
    MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
    infoPrinter.setMemberDao(configPart1.memberDao());
    infoPrinter.setMemberPrinter(memberPrinter());
    return infoPrinter;
  }
}
