package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CustomerServiceDAO;
import kr.or.wic.dto.CustomerServiceDTO;

public class CsDetailPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int cs_num = Integer.parseInt(request.getParameter("cs_num"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));			
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));

		CustomerServiceDTO dto = new CustomerServiceDTO();
		CustomerServiceDAO dao = new CustomerServiceDAO();
		
		return null;
	}

}
