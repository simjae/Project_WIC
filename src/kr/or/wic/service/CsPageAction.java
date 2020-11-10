package kr.or.wic.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CustomerServiceDAO;
import kr.or.wic.dto.CustomerServiceDTO;

public class CsPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		CustomerServiceDAO dao = new CustomerServiceDAO();
		
		int currentPage = 1;
		int pageSize = 10;
		int pageCount = 0;
		int csListCount = dao.getCsListCount();
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		if(request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		if (csListCount % pageSize == 0) { 
			pageCount = csListCount / pageSize;
		} else {
			pageCount = (csListCount / pageSize) + 1;
		}
		
		List<CustomerServiceDTO> csList = dao.getCsList(currentPage, pageSize);
		
		request.setAttribute("csList", csList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageCount", pageCount);
		
		ActionForward forward = new ActionForward();
		forward.setPath("CsPage.jsp");
		System.out.println("CsPageAction실행 완료");
		return forward;
	}

}
