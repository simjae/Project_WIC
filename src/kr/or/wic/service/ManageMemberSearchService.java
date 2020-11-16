package kr.or.wic.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.MemberDAO;
import kr.or.wic.dto.MemberDTO;
import net.sf.json.JSONArray;

public class ManageMemberSearchService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8"); // 클라언트에게 전달한 페이지의 정보 구성
		
		String viewpage = "";
		ActionForward forward = new ActionForward();
		String userid = (String)request.getSession().getAttribute("id");

		if(userid == null || !userid.equals("admin@admin.com")) {
			viewpage = "Main.jsp";
			forward.setPath(viewpage);
			return forward;
		}
		
		//DAO, DTO 처리
		String id = request.getParameter("id");
		
		MemberDAO memberDao = new MemberDAO();
		List<MemberDTO> memberlist = memberDao.searchMemberById(id);
		System.out.println("before parsing:"+memberlist);
		JSONArray jsonArr = JSONArray.fromObject(memberlist);
		
		
		response.setContentType("application/x-json; charset=UTF-8");

		try {
			response.getWriter().print(jsonArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}