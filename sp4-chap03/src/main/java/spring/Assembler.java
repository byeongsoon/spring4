package spring;

public class Assembler {

  private MemberDao memberDao;
  private MemberRegisterService memberRegisterService;
  private ChangePasswordService changePasswordService;

  public Assembler() {
    memberDao = new MemberDao();
    memberRegisterService = new MemberRegisterService(memberDao);
    changePasswordService = new ChangePasswordService(memberDao);
  }

  public MemberDao getMemberDao() {
    return memberDao;
  }

  public ChangePasswordService getChangePasswordService() {
    return changePasswordService;
  }

  public MemberRegisterService getMemberRegisterService() {
    return memberRegisterService;
  }
}
