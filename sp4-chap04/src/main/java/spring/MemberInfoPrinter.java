package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class MemberInfoPrinter{

  //@Autowired
  @Resource(name = "memberDao")
  private MemberDao memberDao;
  private MemberPrinter memberPrinter;

  public void setMemberDao(MemberDao memberDao){
    this.memberDao = memberDao;
  }

  @Autowired
  //@Qualifier("sysout")
  //@Resource(name = "memberPrinter")
  public void setMemberPrinter(MemberPrinter memberPrinter) {
    this.memberPrinter = memberPrinter;
  }

  public void printMemberInfo(String email) {
    Member member = memberDao.selectByEmail(email);
    if (member == null) {
      System.out.println("데이터 없음\n");
      return;
    }
    memberPrinter.print(member);
    System.out.println();
  }

  @Autowired
  public void injectDependency(MemberDao memberDao, @Qualifier("sysout") MemberPrinter printer) {
    this.memberDao = memberDao;
    this.memberPrinter = printer;
  }
}
