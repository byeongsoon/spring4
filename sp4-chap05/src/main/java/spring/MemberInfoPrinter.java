package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class MemberInfoPrinter{

  private MemberDao memberDao;
  private MemberPrinter memberPrinter;

  @Autowired
  public void setMemberDao(MemberDao memberDao){
    //System.out.println("MemberInfoPrinter 주입 " + memberDao);
    this.memberDao = memberDao;
  }

  @Autowired
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

  public void injectDependency(MemberDao memberDao, MemberPrinter printer) {
    this.memberDao = memberDao;
    this.memberPrinter = printer;
  }
}
