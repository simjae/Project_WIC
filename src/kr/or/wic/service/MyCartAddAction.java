package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;

public class MyCartAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = (String)request.getSession().getAttribute("id");
		int prd_num = Integer.parseInt(request.getParameter("prd_num"));
		System.out.println("prd_num"+prd_num);
		
		return null;
	}

}
