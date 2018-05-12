package spring;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;

public class MemberRegisterService {

  @Resource(name = "memberDao")
  private MemberDao memberDao;

  //@Autowired(required = false)
  public MemberRegisterService(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  public MemberRegisterService() {}

  public void regist(RegisterRequest request) {
    Member member = memberDao.selectByEmail(request.getEmail());
    if (member != null) {
      throw new AlreadyExistingMemberException("dup email " + request.getEmail());
    }
    Member newMember = new Member(
        request.getEmail(), request.getPassword(), request.getName(),
        new Date());
    memberDao.insert(newMember);
  }
}
