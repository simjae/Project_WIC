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
import kr.or.wic.service.CsPageAction;
import kr.or.wic.service.CsWriteAction;
import kr.or.wic.service.CsWritePageAction;

/*
 * 고객센터 관련 컨트롤
 */

@WebServlet("*.cs")
public class CsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CsController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(url_Command.equals("/csPage.cs")) { //고객센터 페이지
    		System.out.println("csPage.cs 컨트롤러 탄다!");
    		action = new CsPageAction();
    		forward = action.execute(request, response);
    	
    	} else if (url_Command.equals("/csWritePage.cs")) { //고객센터 글쓰기 페이지
    		System.out.println("csWritePage.cs 컨트롤러 탄다!");
    		action = new CsWritePageAction();
    		System.out.println("csWritePage.cs 컨트롤러 끝!");
    		forward = action.execute(request, response);
    	
    	} else if (url_Command.equals("/csWrite.cs")) { //고객센터 글쓰기
    		System.out.println("csWrite.cs 컨트롤러 탄다!");
    		action = new CsWriteAction();
    		System.out.println("컨트롤러 실행완료");
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/csDetailPage.cs")) { //고객센터 글쓰기 취소
    		System.out.println("csWrite.cs 컨트롤러 탄다!");
    		action = new CsWriteAction();
    		System.out.println("컨트롤러 실행완료");
    		forward = action.execute(request, response);
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
