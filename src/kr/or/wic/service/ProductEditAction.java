package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dto.ProductDTO;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dao.ProductDAO;

public class ProductEditAction implements Action{
/*
 * 
 * 수정예정!!!!!
 * 
 */
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
		int prd_num = Integer.parseInt(request.getParameter("prd_num"));
		
		//product 정보
		ProductDAO dao = new ProductDAO();
		ProductDTO product = dao.getProduct(prd_num);
		request.setAttribute("product", product);
		
		//member 정보
		MemberDAO mdao = new MemberDAO();
		
		//이동경로(viewpage)
		viewpage = "ProductEditPage.jsp";
		forward.setPath(viewpage);
		
		return forward;
	}

}
