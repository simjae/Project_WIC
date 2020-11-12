package kr.or.wic.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dao.MemberDAO_Test;
import kr.or.wic.dto.MemberDTO;

public class MyclosetEditAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
		String viewpage = "";
		ActionForward forward = new ActionForward();
		String id = (String)request.getSession().getAttribute("id");
		
		MemberDAO memberdao=new MemberDAO();
		MemberDTO member = memberdao.getMemberById(id);
		request.setAttribute("member", member);

		////////// 다시 경로 ~ 
		ActionForward forward = new ActionForward();
		forward.setPath("MyCloset.jsp");
		return forward;

	
		
	}
}
