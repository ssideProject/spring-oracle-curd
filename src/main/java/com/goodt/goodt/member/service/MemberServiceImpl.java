package com.goodt.goodt.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.goodt.goodt.member.dao.MemberDAOImpl;
import com.goodt.goodt.member.dto.MemberVO;


@Service
public class MemberServiceImpl implements MemberSerivce {
	
	@Inject
	MemberDAOImpl memberDao;

	@Override
	public List<MemberVO> memberList() {
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);
	}

	@Override
	public MemberVO viewMember(String id) {
		return memberDao.viewMember(id);
	}

	@Override
	public void deleteMember(String id) {
		memberDao.deleteMember(id);
	}

	@Override
	public void updateMember(MemberVO vo) {
        memberDao.updateMember(vo);
    }
	
	public boolean checkPasswd (String id, String passwd) {
		return memberDao.checkPasswd(id,passwd);
	}

}
