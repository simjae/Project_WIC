package kr.or.wic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;

/*
 * 상품관련 컨트롤러 (uploadPorduct 쪽도 포함)
 */

@WebServlet("*.Pd")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	String viewpage="";
    	

    	Action action = null;
    	ActionForward forward = null;
    	
    	if(url_Command.equals("uploadProductPage.Pd")) { //상품 등록 페이지 
    		
    	} else if (url_Command.equals("uploadProduct.Pd")) { //상품 등록  
    		
    	} else if (url_Command.equals("uploadProductCancle.Pd")) { //상품 등록 취소  
    		
    	} else if (url_Command.equals("ProductListPage.Pd")) { //상품 목록 페이지
    		
    	} else if (url_Command.equals("ProductDetailPage.Pd")) { //상품 상세 페이지 
    		
    	} else if (url_Command.equals("ProductAskPage.Pd")) { //상품 문의하기 페이지 
    		
    	} else if (url_Command.equals("ProductAsk.Pd")) { //상품 문의하기 
    		
    	} else if (url_Command.equals("ProductAskCancle.Pd")) { //상품 문의 취소하기
    		
    	} else if (url_Command.equals("ProductEditPage.Pd")) { //상품 수정 페이지
    		
    	} else if (url_Command.equals("ProductEdit.Pd")) { //상품 수정 
    		
    	} else if (url_Command.equals("ProductEditCancle.Pd")) { //상품 수정 취소 
    		
    	}   
    	
    	RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    	dis.forward(request, response);
    
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
