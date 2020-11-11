package kr.or.wic.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ClosetDAO;
import kr.or.wic.dto.MemberDTO;

public class MyclosetShowAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        
		ClosetDAO closet=new ClosetDAO();
		MemberDTO member=new MemberDTO();
		
		String id = request.getParameter("userid");
		System.out.println(id);
		
		
		member=closet.getMemberInfoForCloset(id);
	

		String name = member.getName();
		String addr = member.getAddr();
		String procile_pic = member.getProcile_pic();
		int closet_num = member.getCloset_num();

		

		
		
		request.setAttribute("id",id);
		request.setAttribute("name", name);
		request.setAttribute("addr",addr);
		request.setAttribute("procile_pic",procile_pic);
		request.setAttribute("closet_num", closet_num);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("MyCloset.jsp");
		return forward;

	
		
	}
}
