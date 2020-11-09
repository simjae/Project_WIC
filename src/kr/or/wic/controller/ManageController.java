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
 * 관리자 관련 페이지 
 */

@WebServlet("*.Mg")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageController() {
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
    	
    	if(url_Command.equals("managePage.Mg")) { //관리자 페이지 
    		
    	} else if (url_Command.equals("manageMemberPage.Mg")) { //회원 리스트 페이지 
    		
    	} else if (url_Command.equals("manageMemeberDetailPage.Mg")) { //회원 상세페이지 
    		
    	} else if (url_Command.equals("manageMemberEditPage.Mg")) { //회원 정보 수정페이지 
    		
    	} else if (url_Command.equals("manageMemberEdit.Mg")) { //회원 정보 수정 
    		
    	} else if (url_Command.equals("manageMemberEditCancle.Mg")) { //회원 정보 수정 취소
    		
    	} else if (url_Command.equals("manageMemberDelete.Mg")) { //회원 삭제
    		
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
