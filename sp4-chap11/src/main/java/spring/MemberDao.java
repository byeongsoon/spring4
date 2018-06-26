package spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {

  private JdbcTemplate jdbcTemplate;

  public MemberDao(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public Member selectByEmail(String email) {
    List<Member> results = jdbcTemplate.query(
        "select * from MEMBER where EMAIL=?",
        new RowMapper<Member>() {
          @Override
          public Member mapRow(ResultSet resultSet, int i) throws SQLException {
            Member member = new Member(resultSet.getString("EMAIL"),
                resultSet.getString("PASSWORD"),
                resultSet.getString("NAME"),
                resultSet.getTimestamp("REGDATE"));
            member.setId(resultSet.getLong("ID"));
            return member;
          }
        },
        email);

    return results.isEmpty() ? null : results.get(0);
  }

  public void insert(Member member) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update((Connection connection) -> {
        PreparedStatement pstmt = connection.prepareStatement(
            "INSERT into MEMBER (EMAIL, PASSWORD, NAME, REGDATE)" +
                "VALUES (?,?,?,?)",
            new String[] {"ID"});
        pstmt.setString(1, member.getEmail());
        pstmt.setString(2, member.getPassword());
        pstmt.setString(3, member.getName());
        pstmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));

        return pstmt;

    },keyHolder);
    Number ketValue = keyHolder.getKey();
    member.setId(ketValue.longValue());
  }

  public void update(Member member) {
    jdbcTemplate.update(
        "update MEMBER set NAME = ?, PASSWORD = ? WHERE  EMAIL = ?",
        member.getName(), member.getPassword(), member.getEmail());
  }

  public List<Member> selectAll() {
    List<Member> results = jdbcTemplate.query(
        "select * from MEMBER",
        new RowMapper<Member>() {
          @Override
          public Member mapRow(ResultSet resultSet, int i) throws SQLException {
            Member member = new Member(resultSet.getString("EMAIL"),
                resultSet.getString("PASSWORD"),
                resultSet.getString("NAME"),
                resultSet.getTimestamp("REGDATE"));
            member.setId(resultSet.getLong("ID"));
            return member;
          }
        });

    return results;
  }

  public int count() {
    Integer count = jdbcTemplate.queryForObject(
        "select count(*) from MEMBER",Integer.class);
    return count;
  }
}
