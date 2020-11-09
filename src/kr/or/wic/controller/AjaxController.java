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
 * 비동기 관련 컨트롤러 
 * 컨트롤러는 미관상 주석을 if(){ //여기에 적겠음 
 */

@WebServlet("*.Ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AjaxController() {
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
    	
    	if(url_Command.equals("idCheck.ajax")) { //아이디 중복체크
    		
    	} else if (url_Command.equals("myCartPage.ajax")) { //찜 내역(상품)
    		
    	} else if (url_Command.equals("mySale.ajax")) { //판매내역
    		
    	} else if (url_Command.equals("csNoticeList.ajax")) { //고객센터 분류(공지사항)
    		
    	} else if (url_Command.equals("csQNAList.ajax")) { //고객센터 분류(QnA)
    		
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
