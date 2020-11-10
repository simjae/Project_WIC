package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CustomerServiceDAO;

public class CsWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		//Request 객체 작업 내용 => CsWritePage.jsp값 받기
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		CustomerServiceDAO dao = new CustomerServiceDAO();
		boolean result = dao.writeCs(title, content, id);
		
		return null;
	}

}
