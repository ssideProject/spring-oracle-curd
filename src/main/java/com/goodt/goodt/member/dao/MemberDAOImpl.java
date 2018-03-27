package com.goodt.goodt.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.goodt.goodt.member.dto.MemberVO;

// DAO를 빈으로 등록시켰다.
@Repository	
public class MemberDAOImpl implements MemberDAO {
	//SqlSession 객체를 스프링에서 생성하여 주입.
	@Inject
	SqlSession sqlSession;
	//inject 어노테이션이 없으면 sqlSessoin은 null 상태이지만. 있다면 외부에서 객체를 주입 시켜주데 된다.
	
	@Override
	public List<MemberVO> memberList() {
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
	}

	@Override
	public MemberVO viewMember(String id) {
		return sqlSession.selectOne("member.viewMember", id);
	}

	@Override
	public void deleteMember(String id) {
		sqlSession.delete("member.deleteMember", id);

	}

	// 04. 회원 정보 수정 처리
    @Override
    public void updateMember(MemberVO vo) {
        sqlSession.update("member.updateMember", vo);
 
    }

    // 회원의 비밀번호가 맞는지를 보는것이다. 그런데
    // 요기능을 DAO에서 하는것이 맞는거겠지?? 다른법도 있을까? 기능구현이니까 DAO말고 SERVICE로 넘기게 된다면.
    // 음... MAP 변수를 하나 더 만들어서 전해줘야하니 번거롭기도 할꺼같군.
    public boolean checkPasswd(String id, String passwd) {
    	boolean result = false;
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("id", id);
    	map.put("passwd", passwd);
    	int count = sqlSession.selectOne("member.checkPasswd", map);
    	if(count ==1) result = true;
    	return result;
    }
    
}
