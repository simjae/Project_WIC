package kr.or.wic.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ChatroomDAO;
import kr.or.wic.dao.ProductDAO;
import kr.or.wic.dto.ChatroomDTO;
import kr.or.wic.dto.ProductDTO;

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
		int prd_num = Integer.parseInt(request.getParameter("prd_num"));
		ProductDAO dao = new ProductDAO();
		ProductDTO product = dao.getProduct(prd_num);
		request.setAttribute("product", product);
		
		int currentPage =1; // 현재
		int pageSize = 2; // 한페이지 게시글갯수 
		int maxPage = 0; 
		int chatroomCount=0;
		
		ChatroomDAO chatRoomDAO = new ChatroomDAO();
		chatroomCount = chatRoomDAO.chatRoomCount(prd_num);
		
		if(request.getParameter("currentPage")!=null ) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		if(chatroomCount%pageSize==0) {
			maxPage = chatroomCount /pageSize;
		}else {
			maxPage = (chatroomCount /pageSize)+1;
		}
		
		
		int startPage = ((currentPage -1)/5)*5+1;
		int endPage = startPage + 5 -1;
		if(endPage > maxPage) {
			endPage = maxPage ; 
		}
		
		List<ChatroomDTO> chatRoomDTOs;
		chatRoomDTOs = chatRoomDAO.chatRoomList(prd_num, currentPage,pageSize);
		request.setAttribute("chatRoomDTOs", chatRoomDTOs);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("maxPage", maxPage);
		
		
		//이동경로(viewpage)
		viewpage = "ProductDetailPage.jsp";
		forward.setPath(viewpage);
		
		return forward;
	}

}
