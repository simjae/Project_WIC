package kr.or.wic.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dto.FilesDTO;
import kr.or.wic.dto.ProductDTO;

public class ProductUploadAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
			String productName = request.getParameter("productName");
			String location = request.getParameter("location");
			int productPrice = Integer.parseInt(request.getParameter("productPrice"));
			String context = request.getParameter("context");
			
			FilesDTO fdto = new FilesDTO();
			ProductDTO pdto = new ProductDTO();
			pdto.setPrd_title(productName);
			pdto.setPrd_price(productPrice);
			pdto.setPrd_content(context);
			
			ActionForward forward = new ActionForward();
			forward.setPath("/MyCloset.jsp");
		
		
		return forward;
	}

}
