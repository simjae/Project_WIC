package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CustomerServiceDAO;
import kr.or.wic.dto.CustomerServiceDTO;

public class CsWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		CustomerServiceDAO dao = new CustomerServiceDAO();
		CustomerServiceDTO dto = new CustomerServiceDTO();
		
		
//		dto.setId(request.getParameter("id"));
		dto.setCs_title(request.getParameter("title"));
		dto.setCs_content(request.getParameter("content"));
		System.out.println(dto.getCs_content());
		
		dao.writeCs("minchan", dto.getCs_title(), dto.getCs_content());
		
		ActionForward forward = new ActionForward();
		forward.setPath("Redirect.jsp");
		System.out.println("CsWriteAction실행 완료");
		
		return forward;
	}

}
