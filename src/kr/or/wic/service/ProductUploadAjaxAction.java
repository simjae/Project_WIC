package kr.or.wic.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.wic.action.Action;
import kr.or.wic.action.ActionForward;
import kr.or.wic.dao.FilesDAO;
import kr.or.wic.dao.ProductDAO;
import kr.or.wic.dto.FilesDTO;

public class ProductUploadAjaxAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String uploadpath = request.getSession().getServletContext().getRealPath("upload");
		System.out.println(uploadpath);
		int size = 1024*1024*10;
		MultipartRequest multi=null;
		
		try {
			 multi = new MultipartRequest(
					request, //기존에 있는  request 객체의 주소값 
					uploadpath, //실 저장 경로 (배포경로)
					size, //10M
					"UTF-8",
					new DefaultFileRenamePolicy() //파일 중복(upload 폴더 안에:a.jpg -> a_1.jpg(업로드 파일 변경) )
					);
			 
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("여긴가?");
		} //파일 업로드 완료
		
		//filename
		Enumeration filenames = multi.getFileNames();	
		String file = (String)filenames.nextElement();
		String filename = multi.getFilesystemName(file);
		
		//filepath
		String filepath = uploadpath+"/"+filename;
		
		//id
		String id = (String)request.getSession().getAttribute("id");
		
		//filesDTO 객체에 정보 입력(prd_num 제외)
		FilesDTO uploadingFile = new FilesDTO();
		uploadingFile.setFiles_name(filename);
		uploadingFile.setFiles_path(filepath);
		uploadingFile.setId(id);
		
		FilesDAO fdao = new FilesDAO();
		fdao.insertFilePrdNull(uploadingFile);
		
		return null;
	}

}
