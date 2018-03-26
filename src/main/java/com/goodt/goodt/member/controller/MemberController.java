package com.goodt.goodt.member.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goodt.goodt.member.dto.MemberVO;
import com.goodt.goodt.member.service.MemberSerivce;

@Controller
public class MemberController {
	@Inject
	MemberSerivce memberService;
	
	@RequestMapping(value="member/list.do", method = RequestMethod.GET)
	public String memberList(Model model) {
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		model.addAttribute("msg", "메시지는 나오는건가?");
		return "member/member_list";
	}
	
	@RequestMapping("member/write.do")
	public String memberWrite() {
		return "member/member_write";
	}
	
	@RequestMapping("member/insert.do")
	public String memberInsert(@ModelAttribute MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:/member/list.do";
	}
}
