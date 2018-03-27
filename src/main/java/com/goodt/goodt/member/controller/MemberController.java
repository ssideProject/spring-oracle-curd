package com.goodt.goodt.member.controller;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodt.goodt.member.dto.MemberVO;
import com.goodt.goodt.member.service.MemberSerivce;

@Controller //현재 클래스를 controller에 등록시킴
public class MemberController {
	//이것저것 삽질을 해보니 로그가 얼마나 중요한지 도움이 되는지를 알았다.
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject // MemberService 객체를 스프링에서 샌성하여 주입시킴.
	MemberSerivce memberService;
	
	//회원 목록을 보여주는 컴트롤
	//url매핑을 하였다.
	@RequestMapping(value="member/list.do", method = RequestMethod.GET)
	public String memberList(Model model) {
		//contorller -> service -> dao 요청. 그래서 코드도 ctl짜고 srv짜고 dao 순으로 작성했던거 같다.
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		model.addAttribute("msg", "메시지는 나오는건가?");
		return "member/member_list";
	}
	
	//회원등록 페이지.
	//jsp에서 <form name="form1" method="post" action="${path}/member/insert.do"> 를 사용해서 insert로 넘어간다.
	@RequestMapping("member/write.do")
	public String memberWrite() {
		return "member/member_write";
	}
	
	//회원등록 처리후 -> 회원목록으로 리다이렉트
	//ModelAttribute에서 폼에서 입력한 데이터가 저장된다.
	@RequestMapping("member/insert.do")
	//** 폼에서 입력한 데이터를 받아오는 법 3가지?
	//public String memberInsert(HttpServlet request){}
	//publit String memberInsert(String userId, String userPw, String userName, STring userEmail){}
	public String memberInsert(@ModelAttribute MemberVO vo) {
		//테이블엥 레코드 입력
		memberService.insertMember(vo);
		// * (/)의 차이가 있다.
		//    /member/list.do 루트 디렉토리 기준
		//    member/lsit.do 현재 디렉토리 기준
		//   member_list.jsp로 다이렉트
		return "redirect:/member/list.do";
	}
	
	
	//회원 정보 상세조회!! 흠 드디어 해보게 되는건가.!!! 따라라라
	@RequestMapping("member/view.do")
	public String memberView(String id, Model model) {
		model.addAttribute("dto" , memberService.viewMember(id));
		//System.out.println("클릭한 아이디 확인:" + id);
		logger.info("클릭한 아이디는 : "+ id);
		return "member/member_view";
		
	}
	// 04. 회원 정보 수정 처리
    @RequestMapping("member/update.do")
    public String memberUpdate(@ModelAttribute MemberVO vo){
        memberService.updateMember(vo);
        return "redirect:/member/list.do";
    }
    
    
    
    //회원의 삭제
    // @RequestMapping: url mapping
    // @RequestParam : get or post방식으로 전달된 변수값.
    @RequestMapping("member/delete.do")
    public String memberDelete(@RequestParam String id, @RequestParam String passwd, Model model) {
    	//비밀번호 체크
    	boolean result = memberService.checkPasswd(id, passwd);
    	if(result) {
    		memberService.deleteMember(id);
    		return "redirect:/member/list.do";
    	}else {
    		model.addAttribute("message", "비밀번호가 틀리다.");
    		model.addAttribute("dto", memberService.viewMember(id));
    		return "member/member_view";
    	}
    }
}
