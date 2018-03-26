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
	public MemberVO viewMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub

	}

}
