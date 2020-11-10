package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dto.ProductDTO;
import kr.or.wic.dao.ProductDAO;

public class ProductDetailPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		String id = (String)request.getSession().getAttribute("id");
		
		/*
		 * 본 service에서 해당 회원과 관리자만 접근이 가능하게 하는 기능을 여기서 구현할지 결정해야
		if(id == null || !id.equals("admin")) {
			viewpage = "/WEB-INF/LoginRegister/Login.jsp";
			forward.setPath(viewpage);
			return forward;
		}
		*/
		
		//DAO, DTO 처리
		//*상품을 클릭하여 상품 상세 페이지로 이동 시 상품 객체를 이미 받은 상태라면 service 처리가 필요 없음
		int prd_num = Integer.parseInt(request.getParameter("prd_num"));
		
		ProductDAO dao = new ProductDAO();
		ProductDTO product = dao.getProduct(prd_num);
		
		request.setAttribute("product", product);
		
		//이동경로(viewpage)
		viewpage = "ProductEditPage.jsp";
		forward.setPath(viewpage);
		
		return forward;
	}

}
