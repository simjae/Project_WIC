package kr.or.wic.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.ProductDAO;

public class ProductFileDeleteAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String filename = request.getParameter("filename");
		String uploadpath = request.getSession().getServletContext().getRealPath("upload");
		
		File deleteFile = new File(uploadpath+"/"+filename);
		
		if(deleteFile.exists()) {
			deleteFile.delete();
			ProductDAO dao = new ProductDAO();
			dao.deleteFile(filename);
		}
		return null;
	}

}
