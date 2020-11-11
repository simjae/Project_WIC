package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dto.MemberDTO;

public class CsWritePageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id="";
		int currentPage = 1;
		int pageSize = 10;
		
		if(request.getSession().getAttribute("id") != null) {
			id = (String)request.getSession().getAttribute("id");			
		}
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));			
		}
		if(request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));			
		}
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMemberInfoForCs(id);
		
		request.setAttribute("dto", dto);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		
		System.out.println("CsWritePageAction");
		ActionForward forward = new ActionForward();
		forward.setPath("CsWritePage.jsp");
		System.out.println("csWritePageAction 실행 완료");
		return forward;
	}

}
