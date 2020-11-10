package kr.or.wic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.wic.dto.FilesDTO;
import kr.or.wic.dto.ProductDTO;

public class FilesDAO {
	static DataSource ds;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	static {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			Context envctx = (Context)ctx.lookup("java:comp/env");
			ds = (DataSource)envctx.lookup("/jdbc/oracle");
		} catch (Exception e) {
			System.out.println("look up Fail: " + e.getMessage());
		}
	}
	
	//1.파일정보 조회(return the file list)
	public List<FilesDTO> getAllFileList(){
		List<FilesDTO> filesList = new ArrayList<FilesDTO>();
		
		try {
			conn = ds.getConnection();
			
			String sql = "select files_num, files_name, files_path, prd_num from files";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FilesDTO file = new FilesDTO();
				
				file.setFiles_num(rs.getInt("files_num"));
				file.setFiles_name(rs.getString("files_name"));
				file.setFiles_path(rs.getString("files_path"));
				file.setPrd_num(rs.getInt("prd_num"));
				
				filesList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filesList;
	}
	
	//1-1.파일정보 조회(ProductListPage 정보만 조회(files_name, prd_num)
	//(굳이 두개만 조회해야 하나? 이게 효율이 좋나, 아니면 그냥 정보 조회 모두 한 다음에 files객체에서 해당 정보만 뽑아 오는 것이 좋나?)
	public List<FilesDTO> getFilesNamePrdNumList(){
		List<FilesDTO> filesList = new ArrayList<FilesDTO>();
		
		try {
			conn = ds.getConnection();
			
			String sql = "select files_name, prd_num from files";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FilesDTO file = new FilesDTO();
				
				file.setFiles_name(rs.getString("files_name"));
				file.setPrd_num(rs.getInt("prd_num"));
				filesList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filesList;
	}
	
	//2.회원별 파일 조회(return the filesList by ID)
	public List<FilesDTO> getFilesListById(String id) {
		List<FilesDTO> filesList = new ArrayList<FilesDTO>();
		
		try {
			conn = ds.getConnection();
			String sql = "select f.files_num, f.files_name, f.files_path, f.prd_num"
						+ "files f, product p, member m"
						+ "where p.closet_num = m.closet_num and f.prd_num = p.prd_num and m.id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FilesDTO file = new FilesDTO();
				
				file.setFiles_num(rs.getInt("files_num"));
				file.setFiles_name(rs.getString("files_name"));
				file.setFiles_path(rs.getString("files_path"));
				file.setPrd_num(rs.getInt("prd_num"));
				
				filesList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filesList;
	}
	
	//2-1.상품별 파일 조회(return the files by prd_num)
	public List<FilesDTO> getFilesListByPrdNum(int prd_num) {
		List<FilesDTO> filesList = new ArrayList<FilesDTO>();
		try {
			conn = ds.getConnection();
			String sql = "select f.files_num, f.files_name, f.files_path, p.prd_num"
						+ "from files f, product p where f.prd_num = p.prd_num and p.prd_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prd_num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FilesDTO file = new FilesDTO();
				
				file.setFiles_num(rs.getInt("files_num"));
				file.setFiles_name(rs.getString("files_name"));
				file.setFiles_path(rs.getString("files_path"));
				file.setPrd_num(rs.getInt("prd_num"));
				
				filesList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filesList;
	}
	
	//3.파일 정보 등록(insert the new file)
	public int insertFile(FilesDTO file) {
		int result = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into files(files_num, files_name, files_path, prd_num)"
						+ "values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, file.getFiles_num());
			pstmt.setString(2, file.getFiles_name());
			pstmt.setString(3, file.getFiles_path());
			pstmt.setInt(4, file.getPrd_num());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//4.파일 정보 수정(update the information of a file)
	public int updateFile(int files_num, String files_name, String files_path, int prd_num) {
		int row =0;
		
		try {
			conn = ds.getConnection(); 
			String sql = "update files set files_name=?, files_path=?, prd_num=? where files_num=?";
			pstmt = conn.prepareStatement(sql);
			/* 샘플
			pstmt.setString(1, files_name);
			pstmt.setString(2, files_path);
			pstmt.setInt(3, prd_num);
			pstmt.setInt(4, files_num);
			*/
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	//5.파일 정보 삭제(delete the file)
	public int deleteFile(int files_num) {
		int row = 0;
		
		try {
			conn = ds.getConnection();
			String sql = "delete from product where files_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, files_num);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
}
