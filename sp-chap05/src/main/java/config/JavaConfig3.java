package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration
public class JavaConfig3 {

  @Bean
  public MemberDao memberDao(){
    return new MemberDao();
  }

  @Bean
  public MemberRegisterService memberRegisterService(MemberDao memberDao){
    return new MemberRegisterService(memberDao);
  }

  @Bean
  public MemberPrinter memberPrinter() {
    return new MemberPrinter();
  }

  @Bean
  public MemberInfoPrinter memberInfoPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
    MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
    infoPrinter.setMemberDao(memberDao);
    infoPrinter.setMemberPrinter(memberPrinter);
    return infoPrinter;
  }
}
