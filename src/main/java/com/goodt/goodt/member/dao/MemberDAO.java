package com.goodt.goodt.member.dao;

import java.util.List;

import com.goodt.goodt.member.dto.MemberVO;

public interface MemberDAO {
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public MemberVO viewMember(String id);
	public void deleteMember(String id);
	public void updateMember(MemberVO vo);
	public boolean checkPasswd(String id, String passwd);
}
