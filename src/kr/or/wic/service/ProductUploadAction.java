package kr.or.wic.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ProductDAO;
import kr.or.wic.dto.ProductDTO;

public class ProductUploadAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			
			String productName = request.getParameter("productName");
			String location = request.getParameter("location");
			int productPrice = Integer.parseInt(request.getParameter("productPrice"));
			String context = request.getParameter("context");
			String id = (String) request.getSession().getAttribute("id");
			System.out.println(id);
			
			ProductDTO pdto = new ProductDTO();
			pdto.setPrd_title(productName);
			pdto.setPrd_price(productPrice);
			pdto.setPrd_content(context);
			pdto.setPrd_date(time);
			
			ProductDAO pdao = new ProductDAO();
			int result = pdao.insertProduct(pdto, id);
			
			ActionForward forward = new ActionForward();
			
			if(result>0) {
				
				forward.setPath("/MyCloset.jsp");
			}
		
		
		return forward;
	}

}
