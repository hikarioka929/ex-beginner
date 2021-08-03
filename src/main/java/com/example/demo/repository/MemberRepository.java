package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;

@Repository
public class MemberRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
		
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setDepId(rs.getInt("dep_id"));
		
		return member;
	};
	
	public List<Member> findByName(String name) {
		String sql = "SELECT id, name, dep_id FROM members WHERE name LIKE :name ORDER BY id;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");
	
		List<Member> memberList = template.query(sql, param, MEMBER_ROW_MAPPER);
		
		return memberList;
	}

}
