package kr.or.wic.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.CartDAO;
import kr.or.wic.dao.ProductDAO;
import kr.or.wic.dto.CartDTO;
import kr.or.wic.dto.ProductDTO;

public class ProductListPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
		String id = (String) request.getSession().getAttribute("id");
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		
		/*
		 * 본 service에서 해당 회원과 관리자만 접근이 가능하게 하는 기능을 여기서 구현할지 결정해야
		String id = (String)request.getSession().getAttribute("id");
		if(id == null || !id.equals("admin")) {
			viewpage = "/WEB-INF/LoginRegister/Login.jsp";
			forward.setPath(viewpage);
			return forward;
		}
		*/
		
		//DAO, DTO 처리
		ProductDAO pdao = new ProductDAO();
		List<ProductDTO> productList = pdao.getProductNumTitleContentList();
		request.setAttribute("productList", productList);
		
		CartDAO cdao = new CartDAO();
		List<CartDTO> cartList = cdao.getCartList(id);
		request.setAttribute("cartList",cartList);
		
		//이동경로(viewpage)
		viewpage = "ProductListPage.jsp";
		forward.setPath(viewpage);
		
		return forward;
	}

}
