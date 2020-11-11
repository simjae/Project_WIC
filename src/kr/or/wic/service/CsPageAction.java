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
		
		int currentPage = 1;	//현재페이지
		int pageSize = 10;		//페이지 사이즈
		int maxPageCount = 0;		//총 페이지 수
		int csListCount = dao.getCsListCount();	//총 게시글 수 
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		if(request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		
		if (csListCount % pageSize == 0) { 
			maxPageCount = csListCount / pageSize;
		} else {
			maxPageCount = (csListCount / pageSize) + 1;
		}
		int startPage =  (((int)((double)currentPage / pageSize + 0.9))-1)*pageSize +1;
		int endPage = maxPageCount;
		if(endPage>(startPage+pageSize-1)){
			endPage = startPage+pageSize-1;
		}

		List<CustomerServiceDTO> csList = dao.getCsList(currentPage, pageSize);
		
		request.setAttribute("csList", csList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("maxPageCount", maxPageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("CsPage.jsp");
		System.out.println("CsPageAction실행 완료");
		return forward;
	}

}
