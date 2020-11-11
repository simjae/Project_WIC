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

import kr.or.wic.dto.CustomerServiceDTO;

public class CustomerServiceDAO {
	
	static DataSource ds;
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
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
	
	//1.Cspage(공지사항) 전체 목록 출력
	public List<CustomerServiceDTO> getCsList(int currentPage ,int pageSize){
		
		List<CustomerServiceDTO> csList = new ArrayList<CustomerServiceDTO>();
		int startRow = (currentPage - 1) * pageSize + 1; //읽기 시작할 row 번호.
		int endRow = startRow + pageSize - 1;
		System.out.println(startRow);
		System.out.println(endRow);
		
		
		try {
			conn = ds.getConnection();
			String sql = "select * \r\n" + 
					"from (select ROWNUM as rnum, A.*\r\n" + 
					"    from (select * from customerservice order by cs_notice desc, cs_refer desc, cs_depth) A)\r\n" + 
					"where rnum>=? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow); 
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerServiceDTO dto = new CustomerServiceDTO();
				dto.setCs_num(rs.getInt("CS_NUM"));	//글번호
				dto.setCs_title(rs.getString("CS_TITLE"));	 //글제목
//				dto.setCs_content(rs.getString("CS_CONTENT"));	//글내용
//				dto.setCs_reffer(rs.getInt("CS_REFFER"));	//그룹번호
//				dto.setCs_depth(rs.getInt("CS_DEPTH"));	//그룹 내 순서
//				dto.setCs_step(rs.getInt("CS_STEP"));	//들여쓰기
				dto.setCs_count(rs.getInt("CS_COUNT"));	//조회수
				dto.setCs_date(rs.getDate("CS_DATE"));	//작성일자
//				dto.setCs_notice(rs.getInt("CS_NOTICE"));	//공지사항여부
				dto.setId(rs.getString("id"));	//작성자 아이디
				csList.add(dto);
			}
		}catch(SQLException e){
			System.out.println("getCsList Error");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return csList;
	}
	
	//2. CsListCount(총 게시물 수)
	public int getCsListCount() {
		int result = 0;
		try {
			conn  = ds.getConnection();
			String sql = "select count(*) from customerservice";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				System.out.println(result);
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
		return result;
	}
	
	//3. writeCs(고객센터 글 작성하기)
	public void writeCs(String id, String title, String content) {
		System.out.println("DAO 진입");
		try {
			conn  = ds.getConnection();
			System.out.println("연결완료");
			String sql = "insert into CUSTOMERSERVICE(CS_NUM, CS_REFER, CS_DEPTH, CS_STEP, CS_NOTICE, ID, CS_TITLE, CS_CONTENT, CS_COUNT, CS_DATE)\r\n" + 
					"values(CUSTOMERSERVICE_CS_NUM.nextval,CUSTOMERSERVICE_CS_REFFER.nextval,0,0,0,?,?,?,0,SYSDATE)";
//			pstmt.setString(1, dto.getId());
			pstmt = conn.prepareStatement(sql);
			System.out.println("쿼리문올리기 성공");
			pstmt.setString(1, "minchan");			
			pstmt.setString(2, title); 
			pstmt.setString(3, content); 
			System.out.println("쿼리문 실행 전");			
			rs = pstmt.executeQuery();
			System.out.println("쿼리문 실행");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("writeCs() 오류 발생");
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		return;
	}
}
