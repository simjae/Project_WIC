package kr.or.wic.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dto.FilesDTO;
import kr.or.wic.dto.MemberDTO;
import kr.or.wic.dto.ProductDTO;
import kr.or.wic.dao.FilesDAO;
import kr.or.wic.dao.Like_RecordDAO;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dao.ProductDAO;

public class ProductDetailPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달할 페이지의 정보 구성
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		
		//product 객체
		int prd_num = Integer.parseInt(request.getParameter("prd_num"));
		ProductDAO pdao = new ProductDAO();
		ProductDTO product = pdao.getProduct(prd_num);
	
		//해당 product에 대한 fileList 객체
		List<FilesDTO> fileList = new ArrayList<FilesDTO>();
		FilesDAO fdao = new FilesDAO();
		fileList = fdao.getFilesListByPrdNum(prd_num);
		
		//member 객체
		String id = (String)request.getSession().getAttribute("id");
		MemberDTO member = new MemberDTO();
		MemberDAO mdao = new MemberDAO();
		member = mdao.getMemberById(id);
		
		//좋아요 count
		Like_RecordDAO ldao = new Like_RecordDAO();
		int getLike = ldao.getGetLikeById(id);
		
		request.setAttribute("product", product);
		request.setAttribute("fileList", fileList);
		request.setAttribute("member", member);
		request.setAttribute("getLike", getLike);
		
		//이동경로(viewpage)
		viewpage = "ProductDetailPage.jsp";
		forward.setPath(viewpage);
		
		return forward;
	}

}
