package kr.or.wic.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;

public class ProductFileDeleteAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String filename = request.getParameter("filename");
		System.out.println(filename);
		String uploadpath = request.getSession().getServletContext().getRealPath("upload");
		System.out.println(uploadpath);
		
		File deleteFile = new File(uploadpath+"/"+filename);
		
		if(deleteFile.exists()) {
			deleteFile.delete();
		}else {
			
		}
		
		
		return null;
	}

}
