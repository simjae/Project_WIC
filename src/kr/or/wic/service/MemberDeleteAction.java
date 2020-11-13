package kr.or.wic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MemberDAO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
			String id = request.getParameter("id");

			MemberDAO memberDao = new MemberDAO();
			
			int result = memberDao.deleteMember(id);
			System.out.println("deleted Id:"+id);
			
			if(result!=0) {
				System.out.println("Deleted");
			}else {
				System.out.println("Failed");
			}
			
			ActionForward forward = new ActionForward();
			forward.setPath("/managePage.Mg");
			return forward;
		}
}